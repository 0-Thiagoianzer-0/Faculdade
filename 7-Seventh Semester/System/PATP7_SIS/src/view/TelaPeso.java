package view;

import connection.ConnectionFactory;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Questionario;
import model.dao.QuestionarioDAO;

public class TelaPeso extends javax.swing.JFrame {

    String idpessoa;

    public TelaPeso() {
        initComponents();
        jtQuestionario.getColumnModel().getColumn(0).setPreferredWidth(110);
        jtQuestionario.getColumnModel().getColumn(1).setPreferredWidth(110);
        jtQuestionario.getColumnModel().getColumn(2).setPreferredWidth(170);
        FillLabel();
        CarregaPeso();
        DefaultTableModel modelo = (DefaultTableModel) jtQuestionario.getModel();
        jtQuestionario.setRowSorter(new TableRowSorter(modelo));

    }

    public TelaPeso(String id) {
        this.idpessoa = id;
        initComponents();
        jtQuestionario.getColumnModel().getColumn(0).setPreferredWidth(110);
        jtQuestionario.getColumnModel().getColumn(1).setPreferredWidth(110);
        jtQuestionario.getColumnModel().getColumn(2).setPreferredWidth(170);
        FillLabel();
        CarregaPeso();

        DefaultTableModel modelo = (DefaultTableModel) jtQuestionario.getModel();
        jtQuestionario.setRowSorter(new TableRowSorter(modelo));

    }

    public final void CarregaPeso() {
        DefaultTableModel model = (DefaultTableModel) jtQuestionario.getModel();
        model.setNumRows(0);

        DefaultTableCellRenderer rendererCenter = new DefaultTableCellRenderer(); //criei um renderer para alinhamento das célucas ao centro
        rendererCenter.setHorizontalAlignment(JLabel.CENTER);

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM questionario WHERE questionario_cod_pessoa = " + this.idpessoa + " ORDER BY data_medicao DESC");
            rs = stmt.executeQuery();

            /*Connection con = new ConnectionFactory().getConnection();
            Statement s = con.createStatement();
            ResultSet rsmedicao = s.executeQuery("SELECT * FROM medicao WHERE idpessoa = "+this.idpessoa+" order by datamedicao desc" );
             */
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("peso"),
                    rs.getString("status"),
                    rs.getString("data_medicao")
                });
            }

            jtQuestionario.getColumnModel().getColumn(0).setCellRenderer(rendererCenter);
            jtQuestionario.getColumnModel().getColumn(1).setCellRenderer(rendererCenter);
            jtQuestionario.getColumnModel().getColumn(2).setCellRenderer(rendererCenter);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPeso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

    private void FillLabel() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE cod_pessoa =" + this.idpessoa);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                lbNome.setText(nome);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro com os dados! " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

    /*public final void ReadJTable(){
    DefaultTableModel modelo = (DefaultTableModel) jtMedicao.getModel();
    MedicaoDAO mdao = new MedicaoDAO();
    modelo.setNumRows(0);
    Pessoas p = new Pessoas();
 
    for (Medicao m : mdao.read()) {
        if (p.getId()==(int)cbNome.getSelectedItem()) {
                
        modelo.addRow(new Object[]{
        m.getId(),
        m.getPeso(),
        m.getAltura(),
        m.getDatamedicao(),
        m.getIdpessoa()                
        });
        }
    }
    
}*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtQuestionario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        txtDataMedicao = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        cbOcorrencia = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        btCadastrar = new javax.swing.JButton();
        lbNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Peso Corporal");
        setResizable(false);

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTitulo.setText("Controle de Peso Corporal");

        jtQuestionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Peso", "Status", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtQuestionario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtQuestionario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jtQuestionario);

        jLabel1.setText("Cadastro:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nova Medição"));

        jLabel2.setText("Data Medição");

        jLabel3.setText("Peso");

        txtDataMedicao.setDateFormatString("yyyy-MM-dd");

        jLabel5.setText("Status");

        jLabel6.setText("Ocorrência");

        jLabel7.setText("Comentário");

        cbOcorrencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Doença", "Viagem", "Não justificado" }));

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Respondido", "Não respondido" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbOcorrencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPeso)
                    .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataMedicao, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDataMedicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtComentario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        lbNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTitulo)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbTitulo)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        //botão cadastrar
        Questionario m = new Questionario();
        m.setQuestionario_cod_pessoa(Integer.parseInt(this.idpessoa));
        m.setPeso(txtPeso.getText());
        m.setData_medicao(((JTextField) txtDataMedicao.getDateEditor().getUiComponent()).getText());
        switch (cbStatus.getSelectedIndex()) {
            case 0 ->
                m.setStatus("A");
            case 1 ->
                m.setStatus("B");
        }
        switch (cbOcorrencia.getSelectedIndex()) {
            case 0 ->
                m.setOcorrencia("A");
            case 1 ->
                m.setOcorrencia("B");
            case 2 ->
                m.setOcorrencia("C");
            case 3 ->
                m.setOcorrencia("D");
        }
        m.setComentario(txtComentario.getText());

        QuestionarioDAO dao = new QuestionarioDAO();
        dao.create(m);

        txtPeso.setText("");
        txtDataMedicao.setDate(null);
        CarregaPeso();
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
            java.util.logging.Logger.getLogger(TelaPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPeso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JComboBox<String> cbOcorrencia;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtQuestionario;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField txtComentario;
    private com.toedter.calendar.JDateChooser txtDataMedicao;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
