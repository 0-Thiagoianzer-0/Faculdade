#include<stdio.h>
#include<stdlib.h>  //para poder converter uma string para um float
#include<stdbool.h>
#include<mysql/mysql.h>
#include<gtk/gtk.h>

//Dados do banco de dados da aplicação
static char *host = "localhost";
static char *user = "root";
static char *pass = "12meurex";
static char *db_name = "sistema_agendamento"; 
unsigned int port = 3306; //ou 3132 para postgres


//objetos da interface declarados de acordo com o seu tipo 
GtkBuilder *builder;
GtkWidget *window;
GtkStack *stack;

//interface login
GtkEntry *usuario;
GtkEntry *senha;
GtkWidget *mensagem_dialogo;
GtkDialog *mensagem_aviso;

//interface cadastro de pacientes entrys
GtkEntry *nome_paciente;
GtkEntry *data_nascimento;
GtkEntry *genero;
GtkEntry *estado_civil;
GtkEntry *cidade;
GtkEntry *cep;
GtkEntry *telefone;
GtkEntry *email;

//interface marcar consultas entrys
GtkEntry *nome_paciente_consulta;
GtkEntry *data_consulta;
GtkEntry *horario_consulta;


//Modelo de armazenamento, consultar pessoas e consultas cadastradas, list stores(tree view)
GtkListStore *modelo_armazenamento;
GtkListStore *modelo_armazenamento2;
//GtkTreeSelection *selection; //--Atenção verificar


//funções do programa (todas as funções vão receber um ponteiro para um widget e um gpointer data)
void main_window_destroy_cb(GtkWidget *widget, gpointer data){
    
    gtk_main_quit();

}

//função mensagem exibir mensagens de aviso no sistema
void mensagem(char text[100], char secondary_text[100], char icon_name[100]){
    
    mensagem_dialogo = GTK_WIDGET(gtk_builder_get_object(builder, "mensagem_aviso"));
    mensagem_aviso = GTK_DIALOG(gtk_builder_get_object(builder, "mensagem_aviso"));

    g_object_set(mensagem_dialogo, "text", text, NULL);
    g_object_set(mensagem_dialogo, "secondary_text", secondary_text, NULL);
    g_object_set(mensagem_dialogo, "icon_name", icon_name, NULL);   
    
    gtk_widget_show_all(mensagem_dialogo);
    gtk_dialog_run(mensagem_aviso); //verificar warning: do compilador
    gtk_widget_hide(mensagem_dialogo);
}

//função do login do sistema
void login(const gchar *usuario_str, const gchar *senha_str){
    
    //verifica se o login e a senha do usuário estão corretos
    if((strcmp(usuario_str, "amincar") == 0) && (strcmp(senha_str, "12meurex")== 0))
    {
        mensagem("Bem vindo!", "Usuário logado com sucesso!", "emblem-default");
        //permite mostrar um tela do sistema, o nome das telas é definido no empacotamento do glade
        gtk_stack_set_visible_child_name(stack, "menu_view");
    } 
    else
    {
        mensagem("Falha no login!", "Usuário ou Senha incorretos!", "dialog-error");
        //permite mostrar um tela do sistema, o nome das telas é definido no empacotamento do glade
        gtk_stack_set_visible_child_name(stack, "login_view");
    }
    
}

//função do botão da tela de login
void bt_logar_clicked_cb(GtkWidget *widget, gpointer data){
    
    //captura o que o usuário digitou no entry e converte para uma string normal
    usuario = GTK_ENTRY(gtk_builder_get_object(builder, "usuario_entry"));
    const gchar *usuario_str = gtk_entry_get_text(usuario);
    
    senha = GTK_ENTRY(gtk_builder_get_object(builder, "senha_entry"));
    const gchar *senha_str = gtk_entry_get_text(senha);
    
    //chama a função responsável pelo login do sistema
    login(usuario_str, senha_str);
}

//Botões do menu
void bt_cadastrar_pessoa_menu_clicked_cb(GtkWidget *widget, gpointer data){
    
    gtk_stack_set_visible_child_name(stack, "cadastro_paciente_view");

}

void bt_consultar_cadastro_menu_clicked_cb(GtkWidget *widget, gpointer data){
    
    gtk_stack_set_visible_child_name(stack, "consultar_cadastro_paciente_view");
    
}

void bt_marcar_consulta_menu_clicked_cb(GtkWidget *widget, gpointer data){
    
    gtk_stack_set_visible_child_name(stack, "marcar_consulta_view");

}

void bt_consultas_marcadas_menu_clicked_cb(GtkWidget *widget, gpointer data){
    
    gtk_stack_set_visible_child_name(stack, "consultas_marcadas_view");
    
}

void bt_sair_menu_clicked_cb(GtkWidget *widget, gpointer data){
    //esse comando permite alternar entre as telas do sistemas pelo click dos botões
    gtk_stack_set_visible_child_name(stack, "login_view");
    
} //--FIM-- botões do menu

void bt_cadastrar_voltar_clicked_cb(GtkWidget *widget, gpointer data){
    
    gtk_stack_set_visible_child_name(stack, "menu_view");
    
}

void bt_consultar_voltar_clicked_cb(GtkWidget *widget, gpointer data){
    
    gtk_stack_set_visible_child_name(stack, "menu_view");

}

//--CADASTRAR-- cadastrar paciente
void bt_cadastrar_paciente_clicked_cb(GtkWidget *widget, gpointer data){
   
  //variaveis do MYSQL
    MYSQL conexao;
    int res;
    
    char query[200];
    
    //verificar os tipos de dados (ficam iguais aos do BD)
    const gchar *nome_str = gtk_entry_get_text(nome_paciente);
    const gchar *data_nascimento_str = gtk_entry_get_text(data_nascimento);
    const gchar *genero_str = gtk_entry_get_text(genero);
    const gchar *estado_civil_str = gtk_entry_get_text(estado_civil);
    const gchar *cidade_str = gtk_entry_get_text(cidade);
    const gchar *cep_str = gtk_entry_get_text(cep);
    const gchar *telefone_str = gtk_entry_get_text(telefone);
    const gchar *email_str = gtk_entry_get_text(email);
    

    //evita que o usuário deixe um campo de cadastro em branco
   if(strcmp(nome_str, "") == 0)
   {
        mensagem("Aviso", "Campo 'nome' obrigatório!", "dialog-error");
   }
   else
   {

       //Cadastra os dados fornecidos pelo usuário no banco
      mysql_init(&conexao);
      if (mysql_real_connect(&conexao, host, user, pass, db_name, port, NULL, 0))
      {
                
        //inserir os registros no banco de dados //trocar %c devolta por %s
        sprintf(query,"INSERT INTO paciente(nome, data_nascimento, genero, estado_civil, cidade, cep, telefone, email) VALUES ('%s', '%s' , '%s', '%s', '%s', '%s', '%s', '%s');", nome_str, data_nascimento_str, genero_str, estado_civil_str, cidade_str, cep_str, telefone_str, email_str); //verificar
        
        res = mysql_query(&conexao,query);
        //Informa os registros inseridos ou se houve erro na inserção
        if (!res) printf("Cadastro efetuado com sucesso! %ld\n", mysql_affected_rows(&conexao));
        else printf("Erro no cadastro! %d : %s\n", mysql_errno(&conexao), mysql_error(&conexao));


        mysql_close(&conexao);
      }
      else
      {
        printf("Falha de conexao\n");
        printf("Erro %d : %s\n", mysql_errno(&conexao), mysql_error(&conexao));
      }

      //verifica e avisa que a pessoa foi cadastrada
      char texto[100];
      g_snprintf(texto, 100, "%s%s%s", "Paciente ", nome_str, " cadastrado!");
      mensagem("Aviso", texto, "dialog-emblem-default");
   }
    
} //--Fim-- função cadastrar usuário

//--CONSULTAR-- cadastro de pessoas (nome, idade, status)
void bt_consultar_pacientes_clicked_cb(GtkWidget *widget, gpointer data){
    
    //Mostra na interface gráfica os registros
    GtkTreeIter iter; //para trabalhar com list store(interface gráfica)
    gtk_list_store_clear(modelo_armazenamento); //limpa a list store, para nao escrever embaixo
    
    
    //--TESTE-- Consulta no banco de dados
    system("clear");
            
    //inicio-teste consulta
    MYSQL conexao;
    MYSQL_RES *resp;
    MYSQL_ROW linhas;
    MYSQL_FIELD *campos;
    char query[]="SELECT codigo_paciente, nome, genero, cidade, telefone FROM paciente;";
    int conta; //Contador comum

    mysql_init(&conexao);
    if (mysql_real_connect(&conexao, host, user, pass, db_name, port, NULL, 0))
    {
               
    if (mysql_query(&conexao,query))
                    printf("Erro: %s\n", mysql_error(&conexao));
    else
    {
        resp = mysql_store_result(&conexao);//recebe a consulta
    if (resp) //se houver consulta
    {
        //passa os dados dos campos para a variável campos
        //escreve na tela os nomes dos campos dando
        //um tab somente
        campos = mysql_fetch_fields(resp);

        for (conta=0;conta<mysql_num_fields(resp);conta++){
            printf("%s",(campos[conta]).name);
            if (mysql_num_fields(resp)>1)
            printf("\t");
        }
        
        printf("\n");  

        //enquanto retornar registros, conta até o
        //número de colunas que a tabela tem e escreve na
        //tela com um tab, depois pula a linha e tenta
        //pegar outro registro
        while ((linhas=mysql_fetch_row(resp)) != NULL)
        {
            
            gtk_list_store_append(modelo_armazenamento, &iter); //adiciona nova linha para visualização
            gtk_list_store_set(modelo_armazenamento, &iter,
                            0, linhas[0],
                            1, linhas[1],
                            2, linhas[2],
                            3, linhas[3],
                            4, linhas[4],
                            5, linhas[5],
                            -1); //verificar pela ordem do banco
        }
        }
            mysql_free_result(resp);//limpa a variável do resultado: resp
        }
            mysql_close(&conexao);
        }
        else
        {
            printf("Conexao Falhou\n");
            if (mysql_errno(&conexao))
            printf("Erro %d : %s\n", mysql_errno(&conexao), mysql_error(&conexao));
        } //fim-teste consulta
        
}

//--MARCAR CONSULTA-- marcar consultas no sistema
void bt_marcar_consulta_clicked_cb(GtkWidget *widget, gpointer data){
   
  //variaveis do MYSQL
    MYSQL conexao;
    int res;
    
    char query[200];
    
    //verificar os tipos de dados (ficam iguais aos do BD)
    const gchar *nome_consulta_str = gtk_entry_get_text(nome_paciente_consulta);
    const gchar *data_consulta_str = gtk_entry_get_text(data_consulta);
    const gchar *hoario_consulta_str = gtk_entry_get_text(horario_consulta);


    //evita que o usuário deixe um campo de cadastro em branco
   if(strcmp(nome_consulta_str, "") == 0)
   {
        mensagem("Aviso", "Campo 'nome' obrigatório!", "dialog-error");
   }
   else
   {

       //Cadastra os dados fornecidos pelo usuário no banco
      mysql_init(&conexao);
      if (mysql_real_connect(&conexao, host, user, pass, db_name, port, NULL, 0))
      {
                
        //inserir os registros no banco de dados //trocar %c devolta por %s
        sprintf(query,"INSERT INTO consulta(paciente, data_consulta, horario) VALUES ('%s', '%s', '%s');", nome_consulta_str, data_consulta_str, hoario_consulta_str);
        
        res = mysql_query(&conexao,query);
        //Informa os registros inseridos ou se houve erro na inserção
        if (!res) printf("Cadastro efetuado com sucesso! %ld\n", mysql_affected_rows(&conexao));
        else printf("Erro no cadastro! %d : %s\n", mysql_errno(&conexao), mysql_error(&conexao));


        mysql_close(&conexao);
      }
      else
      {
        printf("Falha de conexao\n");
        printf("Erro %d : %s\n", mysql_errno(&conexao), mysql_error(&conexao));
      }

      //verifica e avisa que a pessoa foi cadastrada
      char texto[100];
      g_snprintf(texto, 100, "%s%s%s", "Paciente ", nome_consulta_str, " cadastrado!");
      mensagem("Aviso", texto, "dialog-emblem-default");
   }
    
} //--Fim-- função marcar consulta

//--CONSULTAR CONSULTAS-- consultar consultas marcadas no sistema
void bt_consultar_consultas_clicked_cb(GtkWidget *widget, gpointer data){
    
    //Mostra na interface gráfica os registros
    GtkTreeIter iter; //para trabalhar com list store(interface gráfica)
    gtk_list_store_clear(modelo_armazenamento2); //limpa a list store, para nao escrever embaixo
    
    
    //--TESTE-- Consulta no banco de dados
    system("clear");
            
    //inicio-teste consulta
    MYSQL conexao;
    MYSQL_RES *resp;
    MYSQL_ROW linhas;
    MYSQL_FIELD *campos;
    char query[]="SELECT codigo_consulta, paciente, data_consulta, horario FROM consulta;";
    int conta; //Contador comum

    mysql_init(&conexao);
    if (mysql_real_connect(&conexao, host, user, pass, db_name, port, NULL, 0))
    {
               
    if (mysql_query(&conexao,query))
                    printf("Erro: %s\n", mysql_error(&conexao));
    else
    {
        resp = mysql_store_result(&conexao);//recebe a consulta
    if (resp) //se houver consulta
    {
        //passa os dados dos campos para a variável campos
        //escreve na tela os nomes dos campos dando
        //um tab somente
        campos = mysql_fetch_fields(resp);

        for (conta=0;conta<mysql_num_fields(resp);conta++){
            printf("%s",(campos[conta]).name);
            if (mysql_num_fields(resp)>1)
            printf("\t");
        }
        
        printf("\n");  

        //enquanto retornar registros, conta até o
        //número de colunas que a tabela tem e escreve na
        //tela com um tab, depois pula a linha e tenta
        //pegar outro registro
        while ((linhas=mysql_fetch_row(resp)) != NULL)
        {
            
            gtk_list_store_append(modelo_armazenamento2, &iter); //adiciona nova linha para visualização
            gtk_list_store_set(modelo_armazenamento2, &iter,
                            0, linhas[0],
                            1, linhas[1],
                            2, linhas[2],
                            3, linhas[3],
                            4, linhas[4],
                            -1);
        }
        }
            mysql_free_result(resp);//limpa a variável do resultado: resp
        }
            mysql_close(&conexao);
        }
        else
        {
            printf("Conexao Falhou\n");
            if (mysql_errno(&conexao))
            printf("Erro %d : %s\n", mysql_errno(&conexao), mysql_error(&conexao));
        } //fim-teste consulta
        
}
//Fim-funções do programa

int main(int argc, char *argv[]) {
    
    //inicializa a biblioteca gtk
    gtk_init(&argc, &argv);
	
	//carrega a sua user interface
	builder = gtk_builder_new_from_file("ProjetoFinal.glade");
	
	
	//Chamadas de sinais dos botoes
	gtk_builder_add_callback_symbols(
	builder,  
	"main_window_destroy_cb", G_CALLBACK(main_window_destroy_cb), 
	"bt_logar_clicked_cb", G_CALLBACK(bt_logar_clicked_cb),
	"bt_cadastrar_paciente_menu_clicked_cb", G_CALLBACK(bt_cadastrar_pessoa_menu_clicked_cb),
	"bt_consultar_cadastro_menu_clicked_cb", G_CALLBACK(bt_consultar_cadastro_menu_clicked_cb),
    "bt_marcar_consulta_menu_clicked_cb", G_CALLBACK(bt_marcar_consulta_menu_clicked_cb),
    "bt_consultas_marcadas_menu_clicked_cb", G_CALLBACK(bt_consultas_marcadas_menu_clicked_cb),
	"bt_sair_menu_clicked_cb", G_CALLBACK(bt_sair_menu_clicked_cb),
	"bt_cadastrar_voltar_clicked_cb", G_CALLBACK(bt_cadastrar_voltar_clicked_cb),
	"bt_cadastrar_paciente_clicked_cb", G_CALLBACK(bt_cadastrar_paciente_clicked_cb),
	"bt_consultar_voltar_clicked_cb", G_CALLBACK(bt_consultar_voltar_clicked_cb),
	"bt_consultar_pacientes_clicked_cb", G_CALLBACK(bt_consultar_pacientes_clicked_cb),
    "bt_marcar_consulta_clicked_cb", G_CALLBACK(bt_marcar_consulta_clicked_cb),
    "bt_consultar_consultas_clicked_cb", G_CALLBACK(bt_consultar_consultas_clicked_cb),
	NULL);

    //liga os sinais as funções
    gtk_builder_connect_signals(builder, NULL);


    //ponteiros para os objetos da interface gtk, informe as IDs dos objetos definidos no XML gerado pelo Glade
    stack = GTK_STACK(gtk_builder_get_object(builder, "telas_stack"));
    window = GTK_WIDGET(gtk_builder_get_object(builder, "main_window"));
    
    //ponteiros para o cadastro de usuários
    nome_paciente = GTK_ENTRY(gtk_builder_get_object(builder, "nome_entry"));
    data_nascimento = GTK_ENTRY(gtk_builder_get_object(builder, "data_nascimento_entry"));
    genero = GTK_ENTRY(gtk_builder_get_object(builder, "genero_entry"));
    estado_civil = GTK_ENTRY(gtk_builder_get_object(builder, "estado_civil_entry"));
    cidade = GTK_ENTRY(gtk_builder_get_object(builder, "cidade_entry"));
    cep = GTK_ENTRY(gtk_builder_get_object(builder, "cep_entry"));
    telefone = GTK_ENTRY(gtk_builder_get_object(builder, "telefone_entry"));
    email = GTK_ENTRY(gtk_builder_get_object(builder, "email_entry"));
    //carrega a treeview dos pacientes
    modelo_armazenamento = GTK_LIST_STORE(gtk_builder_get_object(builder, "pacientes_cadastradas_treeview"));


    //ponteiros para marcar consultas
    nome_paciente_consulta = GTK_ENTRY(gtk_builder_get_object(builder, "paciente_consulta_entry"));
    data_consulta = GTK_ENTRY(gtk_builder_get_object(builder, "data_consulta_entry"));
    horario_consulta = GTK_ENTRY(gtk_builder_get_object(builder, "horario_consulta_entry"));
    //carrega a treeview das consultas
    modelo_armazenamento2 = GTK_LIST_STORE(gtk_builder_get_object(builder, "consultas_cadastradas_treeview"));
    

    //mostrar a janela do programa
    gtk_widget_show_all(window);
	gtk_main(); //função principal do GTK
	
	return 0;
}
