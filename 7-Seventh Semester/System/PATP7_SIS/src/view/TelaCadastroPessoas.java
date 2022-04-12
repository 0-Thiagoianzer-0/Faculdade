package view;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bean.Pessoa;
import model.dao.PessoaDAO;

public class TelaCadastroPessoas extends javax.swing.JFrame {

    String id;

    public TelaCadastroPessoas() {
        initComponents();
        EditaDados();
    }

    public TelaCadastroPessoas(String id) {
        this.id = id;
        initComponents();
        EditaDados();
    }

    public final void EditaDados() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE cod_pessoa = " + this.id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                txtId.setText(rs.getString(1));
                txtNome.setText(rs.getString(2));
                txtNascimento.setDate(rs.getDate(3));
                cbSexo.setSelectedItem(rs.getString(4));
                txtPeso.setText(rs.getString(5));
                txtAltura.setText(rs.getString(6));
                cbAtivFisica.setSelectedItem(rs.getString(7));
                cbAtivFrequencia.setSelectedItem(rs.getString(8));
                cbBebAlcool.setSelectedItem(rs.getString(9));
                cbBebFrequencia.setSelectedItem(rs.getString(10));
                cbAlimenta.setSelectedItem(rs.getString(11));
                cbAlimentaTipo.setSelectedItem(rs.getString(12));
                cbFuma.setSelectedItem(rs.getString(13));
                cbDoenc.setSelectedItem(rs.getString(14));
                cbDoencNome.setSelectedItem(rs.getString(15));
                cbMedica.setSelectedItem(rs.getString(16));
                cbJornaTrab.setSelectedItem(rs.getString(17));
                cbFormTrab.setSelectedItem(rs.getString(18));
                cbAtivDia.setSelectedItem(rs.getString(19));

            }

        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroPessoas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        jpIdentificacao = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        jpAtividades = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbAtivFisica = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbAtivFrequencia = new javax.swing.JComboBox<>();
        cbBebAlcool = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbBebFrequencia = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbAlimenta = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbAlimentaTipo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbFuma = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbDoenc = new javax.swing.JComboBox<>();
        cbDoencNome = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbMedica = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbJornaTrab = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbFormTrab = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbAtivDia = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Peso Corporal");
        setResizable(false);

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTitulo.setText("Cadastro de Pessoas");

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jpIdentificacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação Básica"));

        jLabel3.setText("Nome");

        jLabel4.setText("Sexo");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel5.setText("Nascimento");

        jLabel6.setText("Peso");

        jLabel1.setText("Altura");

        jLabel11.setText("ID");

        txtId.setEditable(false);

        javax.swing.GroupLayout jpIdentificacaoLayout = new javax.swing.GroupLayout(jpIdentificacao);
        jpIdentificacao.setLayout(jpIdentificacaoLayout);
        jpIdentificacaoLayout.setHorizontalGroup(
            jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIdentificacaoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpIdentificacaoLayout.createSequentialGroup()
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jpIdentificacaoLayout.createSequentialGroup()
                        .addGroup(jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpIdentificacaoLayout.createSequentialGroup()
                                .addComponent(cbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5)
                                .addGap(168, 168, 168))
                            .addGroup(jpIdentificacaoLayout.createSequentialGroup()
                                .addComponent(txtNome)
                                .addGap(48, 48, 48))))))
        );
        jpIdentificacaoLayout.setVerticalGroup(
            jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIdentificacaoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpIdentificacaoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpIdentificacaoLayout.createSequentialGroup()
                        .addGroup(jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(6, 6, 6)
                        .addGroup(jpIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6))))
        );

        jpAtividades.setBorder(javax.swing.BorderFactory.createTitledBorder("Atividades"));

        jLabel7.setText("Atividade física");

        jLabel8.setText("Frequência atividade");

        cbAtivFisica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não pratica", "Aeróbico", "Anaeróbico", "Aeróbico e Anaeróbico" }));

        jLabel10.setText("Bebida alcoólica");

        cbAtivFrequencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1 a 2 dias/sem", "3 a 5 dias/sem", "Todos os dias" }));

        cbBebAlcool.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        jLabel13.setText("Frequência bebida");

        cbBebFrequencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2 a 3 dias/sem", "Fim de semana", "Todos os dias" }));

        jLabel14.setText("Alimentação");

        cbAlimenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carnívoro", "Vegano", "Vegetariano" }));

        jLabel15.setText("Alimentação tipo");

        cbAlimentaTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Balanceada", "Moderada", "Não balanceada" }));

        jLabel9.setText("Fumante");

        jLabel16.setText("Doença crônica");

        cbFuma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        jLabel17.setText("Doença nome");

        cbDoenc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        cbDoencNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Hipotiroidismo", "Diabetes", "Outros disturbios hormonais", "Outras" }));

        jLabel18.setText("Medicamentos");

        cbMedica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        jLabel19.setText("Jornada trabalho");

        cbJornaTrab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não trabalha", "Jornada normal", "Jornada reduzida", "Jornada noturna" }));

        jLabel20.setText("Forma trabalho");

        cbFormTrab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Nivel baixo de atividade", "Nivel moderado de atividade", "Nivel intenso de atividade" }));

        jLabel21.setText("Atividade diária");

        cbAtivDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhuma", "Estuda", "Trabalha", "Estuda e trabalha" }));

        javax.swing.GroupLayout jpAtividadesLayout = new javax.swing.GroupLayout(jpAtividades);
        jpAtividades.setLayout(jpAtividadesLayout);
        jpAtividadesLayout.setHorizontalGroup(
            jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtividadesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpAtividadesLayout.createSequentialGroup()
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbAtivFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAtivFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpAtividadesLayout.createSequentialGroup()
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBebAlcool, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBebFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAlimenta, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAlimentaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAtividadesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel16)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAtividadesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)))
                .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAtivDia, 0, 1, Short.MAX_VALUE)
                    .addComponent(cbFuma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDoenc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDoencNome, 0, 1, Short.MAX_VALUE)
                    .addComponent(cbMedica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFormTrab, 0, 1, Short.MAX_VALUE)
                    .addComponent(cbJornaTrab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        jpAtividadesLayout.setVerticalGroup(
            jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtividadesLayout.createSequentialGroup()
                .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAtividadesLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbAtivFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbAtivFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBebAlcool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbBebFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbAlimenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cbAlimentaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpAtividadesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(6, 6, 6)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbDoenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDoencNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(cbMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbJornaTrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFormTrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addGap(2, 2, 2)
                .addGroup(jpAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAtivDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTitulo)
                            .addComponent(jpAtividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpIdentificacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpAtividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        //botão cadastrar 
        //Hora e data do cadastro
        LocalDateTime agora = LocalDateTime.now();
        //Formatar data e hora
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = formatterData.format(agora);
        
        System.out.println(dataFormatada);        
        
        if ((txtNome.getText().isEmpty()) || (cbSexo.getSelectedIndex() < 0) || (txtNascimento.getDateFormatString().isEmpty()) || (txtPeso.getText().isEmpty()) || (txtAltura.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos");
        }

        Pessoa p = new Pessoa();
        PessoaDAO dao = new PessoaDAO();

        if ("".equals(txtId.getText())) {
            p.setNome(txtNome.getText());
            p.setData_nascimento(((JTextField) txtNascimento.getDateEditor().getUiComponent()).getText());
            switch (cbSexo.getSelectedIndex()) {
                case 0 ->
                    p.setSexo("M"); //Masculino
                case 1 ->
                    p.setSexo("F"); //Feminino
            }
            p.setAltura(txtAltura.getText());
            p.setPeso(txtPeso.getText());
            p.setData_cadastro(dataFormatada);
            switch (cbAtivFisica.getSelectedIndex()) {
                case 0 ->
                    p.setAtiv_fisica("A");
                case 1 ->
                    p.setAtiv_fisica("B");
                case 2 ->
                    p.setAtiv_fisica("C");
                case 3 ->
                    p.setAtiv_fisica("D");
            }
            switch (cbAtivFrequencia.getSelectedIndex()) {
                case 0 ->
                    p.setAtiv_frequencia("A");
                case 1 ->
                    p.setAtiv_frequencia("B");
                case 2 ->
                    p.setAtiv_frequencia("C");
                case 3 ->
                    p.setAtiv_frequencia("D");
            }
            switch (cbBebAlcool.getSelectedIndex()) {
                case 0 ->
                    p.setBebidas_alcool("A");
                case 1 ->
                    p.setBebidas_alcool("B");
            }
            switch (cbBebFrequencia.getSelectedIndex()) {
                case 0 ->
                    p.setBebidas_frequencia("A");
                case 1 ->
                    p.setBebidas_frequencia("B");
                case 2 ->
                    p.setBebidas_frequencia("C");
                case 3 ->
                    p.setBebidas_frequencia("D");
            }
            switch (cbAlimenta.getSelectedIndex()) {
                case 0 ->
                    p.setAlimentacao("A");
                case 1 ->
                    p.setAlimentacao("B");
                case 2 ->
                    p.setAlimentacao("C");
            }
            switch (cbAlimentaTipo.getSelectedIndex()) {
                case 0 ->
                    p.setAlimentacao_tipo("A");
                case 1 ->
                    p.setAlimentacao_tipo("B");
                case 2 ->
                    p.setAlimentacao_tipo("C");
            }
            switch (cbFuma.getSelectedIndex()) {
                case 0 ->
                    p.setFumante("A");
                case 1 ->
                    p.setFumante("B");
            }
            switch (cbDoenc.getSelectedIndex()) {
                case 0 ->
                    p.setDoenca("A");
                case 1 ->
                    p.setDoenca("B");
            }
            switch (cbDoencNome.getSelectedIndex()) {
                 case 0 ->
                    p.setDoenca_nome("A");
                case 1 ->
                    p.setDoenca_nome("B");
                case 2 ->
                    p.setDoenca_nome("C");
                case 3 ->
                    p.setDoenca_nome("D");
            }
            switch (cbMedica.getSelectedIndex()) {
                 case 0 ->
                    p.setMedicamentos("A");
                case 1 ->
                    p.setMedicamentos("B");
            }
            switch (cbJornaTrab.getSelectedIndex()) {
                 case 0 ->
                    p.setJornada_trabalho("A");
                case 1 ->
                    p.setJornada_trabalho("B");
                case 2 ->
                    p.setJornada_trabalho("C");
                case 3 ->
                    p.setJornada_trabalho("D");
            }
            switch (cbFormTrab.getSelectedIndex()) {
                 case 0 ->
                    p.setForma_trabalho("A");
                case 1 ->
                    p.setForma_trabalho("B");
                case 2 ->
                    p.setForma_trabalho("C");
                case 3 ->
                    p.setForma_trabalho("D");
            }
            switch (cbAtivDia.getSelectedIndex()) {
                 case 0 ->
                    p.setAtiv_diaria("A");
                case 1 ->
                    p.setAtiv_diaria("B");
                case 2 ->
                    p.setAtiv_diaria("C");
                case 3 ->
                    p.setAtiv_diaria("D");
            }
            dao.create(p);
            
        this.dispose();
        TelaPessoas edicao = new TelaPessoas();
        edicao.setVisible(true);

        } else {
            p.setCod_pessoa(Integer.parseInt(txtId.getText()));
            p.setNome(txtNome.getText());
            p.setData_nascimento(((JTextField) txtNascimento.getDateEditor().getUiComponent()).getText());
            switch (cbSexo.getSelectedIndex()) {
                case 0 ->
                    p.setSexo("M"); //Masculino
                case 1 ->
                    p.setSexo("F"); //Feminino
            }
            p.setAltura(txtAltura.getText());
            p.setPeso(txtPeso.getText());
                        switch (cbAtivFisica.getSelectedIndex()) {
                case 0 ->
                    p.setAtiv_fisica("A");
                case 1 ->
                    p.setAtiv_fisica("B");
                case 2 ->
                    p.setAtiv_fisica("C");
                case 3 ->
                    p.setAtiv_fisica("D");
            }
            switch (cbAtivFrequencia.getSelectedIndex()) {
                case 0 ->
                    p.setAtiv_frequencia("A");
                case 1 ->
                    p.setAtiv_frequencia("B");
                case 2 ->
                    p.setAtiv_frequencia("C");
                case 3 ->
                    p.setAtiv_frequencia("D");
            }
            switch (cbBebAlcool.getSelectedIndex()) {
                case 0 ->
                    p.setBebidas_alcool("A");
                case 1 ->
                    p.setBebidas_alcool("B");
            }
            switch (cbBebFrequencia.getSelectedIndex()) {
                case 0 ->
                    p.setBebidas_frequencia("A");
                case 1 ->
                    p.setBebidas_frequencia("B");
                case 2 ->
                    p.setBebidas_frequencia("C");
                case 3 ->
                    p.setBebidas_frequencia("D");
            }
            switch (cbAlimenta.getSelectedIndex()) {
                case 0 ->
                    p.setAlimentacao("A");
                case 1 ->
                    p.setAlimentacao("B");
                case 2 ->
                    p.setAlimentacao("C");
            }
            switch (cbAlimentaTipo.getSelectedIndex()) {
                case 0 ->
                    p.setAlimentacao_tipo("A");
                case 1 ->
                    p.setAlimentacao_tipo("B");
                case 2 ->
                    p.setAlimentacao_tipo("C");
            }
            switch (cbFuma.getSelectedIndex()) {
                case 0 ->
                    p.setFumante("A");
                case 1 ->
                    p.setFumante("B");
            }
            switch (cbDoenc.getSelectedIndex()) {
                case 0 ->
                    p.setDoenca("A");
                case 1 ->
                    p.setDoenca("B");
            }
            switch (cbDoencNome.getSelectedIndex()) {
                 case 0 ->
                    p.setDoenca_nome("A");
                case 1 ->
                    p.setDoenca_nome("B");
                case 2 ->
                    p.setDoenca_nome("C");
                case 3 ->
                    p.setDoenca_nome("D");
            }
            switch (cbMedica.getSelectedIndex()) {
                 case 0 ->
                    p.setMedicamentos("A");
                case 1 ->
                    p.setMedicamentos("B");
            }
            switch (cbJornaTrab.getSelectedIndex()) {
                 case 0 ->
                    p.setJornada_trabalho("A");
                case 1 ->
                    p.setJornada_trabalho("B");
                case 2 ->
                    p.setJornada_trabalho("C");
                case 3 ->
                    p.setJornada_trabalho("D");
            }
            switch (cbFormTrab.getSelectedIndex()) {
                 case 0 ->
                    p.setForma_trabalho("A");
                case 1 ->
                    p.setForma_trabalho("B");
                case 2 ->
                    p.setForma_trabalho("C");
                case 3 ->
                    p.setForma_trabalho("D");
            }
            switch (cbAtivDia.getSelectedIndex()) {
                 case 0 ->
                    p.setAtiv_diaria("A");
                case 1 ->
                    p.setAtiv_diaria("B");
                case 2 ->
                    p.setAtiv_diaria("C");
                case 3 ->
                    p.setAtiv_diaria("D");
            }
            dao.update(p);            

        this.dispose();
        TelaPessoas edicao = new TelaPessoas();
        edicao.setVisible(true);

        }

    }//GEN-LAST:event_btCadastrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroPessoas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JComboBox<String> cbAlimenta;
    private javax.swing.JComboBox<String> cbAlimentaTipo;
    private javax.swing.JComboBox<String> cbAtivDia;
    private javax.swing.JComboBox<String> cbAtivFisica;
    private javax.swing.JComboBox<String> cbAtivFrequencia;
    private javax.swing.JComboBox<String> cbBebAlcool;
    private javax.swing.JComboBox<String> cbBebFrequencia;
    private javax.swing.JComboBox<String> cbDoenc;
    private javax.swing.JComboBox<String> cbDoencNome;
    private javax.swing.JComboBox<String> cbFormTrab;
    private javax.swing.JComboBox<String> cbFuma;
    private javax.swing.JComboBox<String> cbJornaTrab;
    private javax.swing.JComboBox<String> cbMedica;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpAtividades;
    private javax.swing.JPanel jpIdentificacao;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
