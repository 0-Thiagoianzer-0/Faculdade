package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Pessoa;
import model.dao.PessoaDAO;

public class TelaInativos extends javax.swing.JFrame {

    public TelaInativos() {
        initComponents();
        jtPessoa.getColumnModel().getColumn(0).setPreferredWidth(30);
        jtPessoa.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtPessoa.getColumnModel().getColumn(2).setPreferredWidth(90);
        jtPessoa.getColumnModel().getColumn(3).setPreferredWidth(90);
        jtPessoa.getColumnModel().getColumn(4).setPreferredWidth(80);
        jtPessoa.getColumnModel().getColumn(5).setPreferredWidth(80);
        jtPessoa.getColumnModel().getColumn(6).setPreferredWidth(90);

        DefaultTableModel modelo = (DefaultTableModel) jtPessoa.getModel();
        jtPessoa.setRowSorter(new TableRowSorter(modelo));
        readJTable();
    }

    public final void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jtPessoa.getModel();
        PessoaDAO pdao = new PessoaDAO();
        modelo.setNumRows(0);

        for (Pessoa p : pdao.read()) {
            if ("0".equals(p.getAtivo())) {
                modelo.addRow(new Object[]{
                p.getCod_pessoa(),
                p.getNome(),
                p.getData_nascimento(),
                p.getSexo(),
                p.getAltura(),
                p.getPeso(),
                p.getData_cadastro()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        btAtivar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPessoa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Peso Corporal");
        setResizable(false);

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTitulo.setText("Pessoas Inativas");

        btAtivar.setText("Ativar");
        btAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtivarActionPerformed(evt);
            }
        });

        jtPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Nascimento", "Sexo", "Altura", "Peso", "Data Cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPessoa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtPessoa.setColumnSelectionAllowed(true);
        jtPessoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jtPessoa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtivarActionPerformed
        if (jtPessoa.getSelectedRow() != -1) {
            //botão inativar
            Pessoa p = new Pessoa();
            PessoaDAO dao = new PessoaDAO();
            p.setAtivo("1");
            p.setCod_pessoa((int) jtPessoa.getValueAt(jtPessoa.getSelectedRow(), 0));
            

            dao.update2(p);

            readJTable();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma pessoa para ativar!");
        }
        //Source botão excluir
        /*if (jtPessoa.getSelectedRow() != -1) {
            Pessoa p = new Pessoa();
            PessoaDAO dao = new PessoaDAO();

            p.setCod_pessoa((int) jtPessoa.getValueAt(jtPessoa.getSelectedRow(), 0));

            dao.delete(p);

            readJTable();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir!");
        }*/
    }//GEN-LAST:event_btAtivarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInativos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtivar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPessoa;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
