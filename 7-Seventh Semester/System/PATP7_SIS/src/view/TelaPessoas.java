package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Pessoa;
import model.dao.PessoaDAO;

public class TelaPessoas extends javax.swing.JFrame {

    public TelaPessoas() {
        initComponents();
        jtPessoas.getColumnModel().getColumn(0).setPreferredWidth(30);
        jtPessoas.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtPessoas.getColumnModel().getColumn(2).setPreferredWidth(90);
        jtPessoas.getColumnModel().getColumn(3).setPreferredWidth(90);
        jtPessoas.getColumnModel().getColumn(4).setPreferredWidth(80);
        jtPessoas.getColumnModel().getColumn(5).setPreferredWidth(80);
        jtPessoas.getColumnModel().getColumn(6).setPreferredWidth(130);

        DefaultTableModel modelo = (DefaultTableModel) jtPessoas.getModel();
        jtPessoas.setRowSorter(new TableRowSorter(modelo));
        readJTable();
    }

    public final void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jtPessoas.getModel();
        PessoaDAO pdao = new PessoaDAO();
        modelo.setNumRows(0);

        DefaultTableCellRenderer rendererCenter = new DefaultTableCellRenderer(); //criei um renderer para alinhamento das célucas ao centro
        rendererCenter.setHorizontalAlignment(JLabel.CENTER);

        for (Pessoa p : pdao.read()) {
            if ("1".equals(p.getAtivo())) {

                modelo.addRow(new Object[]{
                    p.getCod_pessoa(),
                    p.getNome(),
                    p.getData_nascimento(),
                    p.getSexo(),
                    (p.getAltura()) + ("m"),
                    (p.getPeso()) + ("kg"),
                    p.getData_cadastro()
                });
            }
        }
        jtPessoas.getColumnModel().getColumn(0).setCellRenderer(rendererCenter);
        jtPessoas.getColumnModel().getColumn(1).setCellRenderer(rendererCenter);
        jtPessoas.getColumnModel().getColumn(2).setCellRenderer(rendererCenter);
        jtPessoas.getColumnModel().getColumn(3).setCellRenderer(rendererCenter);
        jtPessoas.getColumnModel().getColumn(4).setCellRenderer(rendererCenter);
        jtPessoas.getColumnModel().getColumn(5).setCellRenderer(rendererCenter);
        jtPessoas.getColumnModel().getColumn(6).setCellRenderer(rendererCenter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPessoas = new javax.swing.JTable();
        btInativar = new javax.swing.JButton();
        btAtualizar1 = new javax.swing.JButton();
        btPeso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Peso Corporal");
        setResizable(false);

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTitulo.setText("Cadastro de Pessoas");

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        jtPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Nascimento", "Sexo", "Altura", "Peso", "Data Cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPessoas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtPessoas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jtPessoas);

        btInativar.setText("Inativar");
        btInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInativarActionPerformed(evt);
            }
        });

        btAtualizar1.setText("Editar");
        btAtualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizar1ActionPerformed(evt);
            }
        });

        btPeso.setText("Peso");
        btPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAtualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInativarActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que quer inativar o cadastro?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {

            if (jtPessoas.getSelectedRow() != -1) {
                //botão inativar
                Pessoa p = new Pessoa();
                PessoaDAO dao = new PessoaDAO();
                p.setAtivo("0");
                p.setCod_pessoa((int) jtPessoas.getValueAt(jtPessoas.getSelectedRow(), 0));

                dao.update2(p);

                readJTable();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um cadastro para inativar!");
            }
        }
    }//GEN-LAST:event_btInativarActionPerformed

    private void btAtualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizar1ActionPerformed
        if (jtPessoas.getSelectedRow() != -1) {
            TelaCadastroPessoas editar = new TelaCadastroPessoas(jtPessoas.getValueAt(jtPessoas.getSelectedRow(), 0).toString());
            editar.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cadastro para editar!");
        }
    }//GEN-LAST:event_btAtualizar1ActionPerformed

    private void btPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesoActionPerformed
        if (jtPessoas.getSelectedRow() != -1) {
            TelaPeso peso = new TelaPeso(jtPessoas.getValueAt(jtPessoas.getSelectedRow(), 0).toString());
            peso.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cadastro para adicionar medição de peso!");
        }
    }//GEN-LAST:event_btPesoActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        TelaCadastroPessoas cadastro = new TelaCadastroPessoas();
        cadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btNovoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPessoas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar1;
    private javax.swing.JButton btInativar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPeso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPessoas;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
