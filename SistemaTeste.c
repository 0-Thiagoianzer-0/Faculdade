#include<stdio.h>
#include<stdlib.h>  //para poder converter uma string para um float
#include<stdbool.h>
#include<mysql/mysql.h>
#include<gtk/gtk.h>

//Dados do banco de dados da aplicação
static char *host = "localhost";
static char *user = "root";
static char *pass = "12meurex";
static char *db_name = "trabalho_lp1"; 
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

//interface cadastro de pessoas
GtkEntry *nome_pessoa;
GtkEntry *idade_pessoa;
GtkEntry *status_pessoa;

//Modelo de armazenamento, consultar pessoas cadastradas, list store(tree view)
GtkListStore *modelo_armazenamento;
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
    
    gtk_stack_set_visible_child_name(stack, "cadastro_usuario_view");

}

void bt_consultar_cadastro_menu_clicked_cb(GtkWidget *widget, gpointer data){
    
    gtk_stack_set_visible_child_name(stack, "consultar_cadastro_usuario_view");
    
}

void bt_sair_menu_clicked_cb(GtkWidget *widget, gpointer data){
    //esse comando permite alternar entre as telas do sistemas pelo click dos botões
    gtk_stack_set_visible_child_name(stack, "login_view");
    
}

void bt_cadastrar_voltar_clicked_cb(GtkWidget *widget, gpointer data){
    
    gtk_stack_set_visible_child_name(stack, "menu_view");
    
}

void bt_consultar_voltar_clicked_cb(GtkWidget *widget, gpointer data){
    
    gtk_stack_set_visible_child_name(stack, "menu_view");

}

//--CADASTRAR-- cadastro de pessoas (nome, idade, status)
void bt_cadastrar_pessoa_clicked_cb(GtkWidget *widget, gpointer data){
   
  //variaveis do MYSQL
    MYSQL conexao;
    int res;
    
    char query[200];
    
    const gchar *nome_str = gtk_entry_get_text(nome_pessoa);
    const gchar *idade_int = gtk_entry_get_text(idade_pessoa);
    const gchar *status_int = gtk_entry_get_text(status_pessoa);
      
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
        sprintf(query,"INSERT INTO trab_aluno(nome_aluno, idade_aluno, status_aluno) VALUES ('%s', '%s', '%s');", nome_str, idade_int, status_int);
        
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
void bt_consultar_pessoa_clicked_cb(GtkWidget *widget, gpointer data){
    
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
    char query[]="SELECT id_aluno, nome_aluno, idade_aluno, status_aluno FROM trab_aluno;";
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
	builder = gtk_builder_new_from_file("SistemaTeste.glade");
	
	
	//Chamadas de sinais dos botoes
	gtk_builder_add_callback_symbols(
	builder,  
	"main_window_destroy_cb", G_CALLBACK(main_window_destroy_cb), 
	"bt_logar_clicked_cb", G_CALLBACK(bt_logar_clicked_cb),
	"bt_cadastrar_pessoa_menu_clicked_cb", G_CALLBACK(bt_cadastrar_pessoa_menu_clicked_cb),
	"bt_consultar_cadastro_menu_clicked_cb", G_CALLBACK(bt_consultar_cadastro_menu_clicked_cb),
	"bt_sair_menu_clicked_cb", G_CALLBACK(bt_sair_menu_clicked_cb),
	"bt_cadastrar_voltar_clicked_cb", G_CALLBACK(bt_cadastrar_voltar_clicked_cb),
	"bt_cadastrar_pessoa_clicked_cb", G_CALLBACK(bt_cadastrar_pessoa_clicked_cb),
	"bt_consultar_voltar_clicked_cb", G_CALLBACK(bt_consultar_voltar_clicked_cb),
	"bt_consultar_pessoa_clicked_cb", G_CALLBACK(bt_consultar_pessoa_clicked_cb),
	NULL);

    
    //liga os sinais as funções
    gtk_builder_connect_signals(builder, NULL);


    //ponteiros para os objetos da interface gtk, informe as IDs dos objetos definidos no XML gerado pelo Glade
    stack = GTK_STACK(gtk_builder_get_object(builder, "telas_stack"));
    window = GTK_WIDGET(gtk_builder_get_object(builder, "main_window"));
    
    //ponteiros para o cadastro de usuários
    nome_pessoa = GTK_ENTRY(gtk_builder_get_object(builder, "nome_entry"));
    idade_pessoa = GTK_ENTRY(gtk_builder_get_object(builder, "idade_entry"));
    status_pessoa = GTK_ENTRY(gtk_builder_get_object(builder, "status_entry"));
    modelo_armazenamento = GTK_LIST_STORE(gtk_builder_get_object(builder, "pessoas_cadastradas_treeview"));

    //mostrar a janela do programa
    gtk_widget_show_all(window);
	gtk_main(); //função principal do GTK
	
	return 0;
}
