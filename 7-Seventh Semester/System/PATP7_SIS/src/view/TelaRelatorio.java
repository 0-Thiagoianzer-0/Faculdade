package view;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaRelatorio extends javax.swing.JFrame {
    String idpessoa;
    public TelaRelatorio() {
        initComponents();
        FillComboPessoa();
    }
    

    private void FillComboPessoa() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                cbNome.addItem(nome);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro com os dados! " + e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
}    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbSexo = new javax.swing.JLabel();
        lbIdade = new javax.swing.JLabel();
        lbPeso = new javax.swing.JLabel();
        lbAltura = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbCadastro = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbAtivFisica = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbAtivFrequencia = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbBebida = new javax.swing.JLabel();
        lbBebFrequencia = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbAlimentacao = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbAlimTipo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbFumante = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbDoenca = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbDoencaNome = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbMedicamentos = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbJornadaTrab = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbFormaTrab = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbAtivDiaria = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        cbNome = new javax.swing.JComboBox<>();
        btQuestionarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Cadastro");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório"));

        jLabel2.setText("Idade");

        jLabel3.setText("Sexo");

        jLabel4.setText("Peso");

        lbSexo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbIdade.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbPeso.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbAltura.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Altura");

        lbCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Cadastro");

        lbAtivFisica.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("A.Fisica");

        jLabel9.setText("A.Frequencia");

        lbAtivFrequencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Bebida");

        lbBebida.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbBebFrequencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("B.Frequencia");

        jLabel12.setText("Alimentação");

        lbAlimentacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("A.Tipo");

        lbAlimTipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("Fumante");

        lbFumante.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setText("Doença");

        lbDoenca.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("D.Nome");

        lbDoencaNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("Medicamentos");

        lbMedicamentos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setText("J.Trabalho");

        lbJornadaTrab.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setText("F.Trabalho");

        lbFormaTrab.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("A.Diaria");

        lbAtivDiaria.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAtivDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFormaTrab, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbJornadaTrab, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDoencaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFumante, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAlimTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAlimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbBebFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAtivFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAtivFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIdade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lbAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lbCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lbAtivFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lbAtivFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lbBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(lbBebFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(lbAlimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(lbAlimTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(lbFumante, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(lbDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(lbDoencaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(lbMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(lbJornadaTrab, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(lbFormaTrab, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(lbAtivDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTitulo.setText("Relatório de Cadastros");

        cbNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o cadastro" }));
        cbNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNomeItemStateChanged(evt);
            }
        });

        btQuestionarios.setText("Questionários");
        btQuestionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuestionariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(cbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btQuestionarios)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btQuestionarios))
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNomeItemStateChanged
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sp =cbNome.getSelectedItem().toString();                

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE nome ='"+sp+"'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                lbIdade.setText(rs.getString("data_nascimento"));
                lbSexo.setText(rs.getString("sexo"));
                lbPeso.setText(rs.getString("peso")+("kg"));
                lbAltura.setText(rs.getString("altura")+("m"));
                lbCadastro.setText(rs.getString("data_cadastro")); 
                switch (rs.getString("ativ_fisica")) {
                    case "A" -> lbAtivFisica.setText("Não pratica");
                    case "B" -> lbAtivFisica.setText("Aeróbico");
                    case "C" -> lbAtivFisica.setText("Anaeróbico");
                    case "D" -> lbAtivFisica.setText("Aeróbico e Anaeróbico");
                }
                switch (rs.getString("ativ_frequencia")) {
                    case "A" -> lbAtivFrequencia.setText("-");
                    case "B" -> lbAtivFrequencia.setText("1 a 2 dias por semana");
                    case "C" -> lbAtivFrequencia.setText("3 a 5 dias por semana");
                    case "D" -> lbAtivFrequencia.setText("Todos os dias");
                }
                switch (rs.getString("bebidas_alcool")) {
                    case "A" -> lbBebida.setText("Não");
                    case "B" -> lbBebida.setText("Sim");
                }
                switch (rs.getString("bebidas_frequencia")) {
                    case "A" -> lbBebFrequencia.setText("-");
                    case "B" -> lbBebFrequencia.setText("2 a 3 dias por semana");
                    case "C" -> lbBebFrequencia.setText("Finais de semana");
                    case "D" -> lbBebFrequencia.setText("Todos os dias");
                }
                switch (rs.getString("alimentacao")) {
                    case "A" -> lbAlimentacao.setText("Carnívoro");
                    case "B" -> lbAlimentacao.setText("Vegano");
                    case "C" -> lbAlimentacao.setText("Vegetariano");
                }
                switch (rs.getString("alimentacao_tipo")) {
                    case "A" -> lbAlimTipo.setText("Balanceada");
                    case "B" -> lbAlimTipo.setText("Moderada");
                    case "C" -> lbAlimTipo.setText("Não balanceada");
                }
                switch (rs.getString("fumante")) {
                    case "A" -> lbFumante.setText("Não");
                    case "B" -> lbFumante.setText("Sim");
                }
                switch (rs.getString("doenca")) {
                    case "A" -> lbDoenca.setText("Não");
                    case "B" -> lbDoenca.setText("Sim");
                }
                switch (rs.getString("doenca_nome")) {
                    case "A" -> lbDoencaNome.setText("-");
                    case "B" -> lbDoencaNome.setText("Hipotiroidismo");
                    case "C" -> lbDoencaNome.setText("Diabetes");
                    case "D" -> lbDoencaNome.setText("Outros disturbios hormonais");
                    case "E" -> lbDoencaNome.setText("Outras");
                }
                switch (rs.getString("medicamentos")) {
                    case "A" -> lbMedicamentos.setText("Não");
                    case "B" -> lbMedicamentos.setText("Sim");
                }
                switch (rs.getString("jornada_trabalho")) {
                    case "A" -> lbJornadaTrab.setText("Não trabalha");
                    case "B" -> lbJornadaTrab.setText("Jornada normal");
                    case "C" -> lbJornadaTrab.setText("Jornada reduzida");
                    case "D" -> lbJornadaTrab.setText("Jornada noturna");
                }
                switch (rs.getString("forma_trabalho")) {
                    case "A" -> lbFormaTrab.setText("-");
                    case "B" -> lbFormaTrab.setText("Nivel baixo de atividade");
                    case "C" -> lbFormaTrab.setText("Nivel moderado de atividade");
                    case "D" -> lbFormaTrab.setText("Nivel intenso de atividade");
                }
                switch (rs.getString("ativ_diaria")) {
                    case "A" -> lbAtivDiaria.setText("Nenhuma");
                    case "B" -> lbAtivDiaria.setText("Estuda");
                    case "C" -> lbAtivDiaria.setText("Trabalha");
                    case "D" -> lbAtivDiaria.setText("Estuda e trabalha");
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }//GEN-LAST:event_cbNomeItemStateChanged

    private void btQuestionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuestionariosActionPerformed
        if (cbNome.getSelectedIndex()!= 0){
        TelaRelatorioQuestionario relaque = new TelaRelatorioQuestionario(String.valueOf(cbNome.getSelectedIndex()));
        relaque.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cadastro para mostrar relatórios de questionários!");
        }
                
    }//GEN-LAST:event_btQuestionariosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btQuestionarios;
    private javax.swing.JComboBox<String> cbNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlimTipo;
    private javax.swing.JLabel lbAlimentacao;
    private javax.swing.JLabel lbAltura;
    private javax.swing.JLabel lbAtivDiaria;
    private javax.swing.JLabel lbAtivFisica;
    private javax.swing.JLabel lbAtivFrequencia;
    private javax.swing.JLabel lbBebFrequencia;
    private javax.swing.JLabel lbBebida;
    private javax.swing.JLabel lbCadastro;
    private javax.swing.JLabel lbDoenca;
    private javax.swing.JLabel lbDoencaNome;
    private javax.swing.JLabel lbFormaTrab;
    private javax.swing.JLabel lbFumante;
    private javax.swing.JLabel lbIdade;
    private javax.swing.JLabel lbJornadaTrab;
    private javax.swing.JLabel lbMedicamentos;
    private javax.swing.JLabel lbPeso;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
