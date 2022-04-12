package view;

import javax.swing.ImageIcon;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miEditarCadastro = new javax.swing.JMenuItem();
        miInativas = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miRelatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Peso Corporal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbLogo.setBorder(new javax.swing.border.MatteBorder(null));
        lbLogo.setMaximumSize(getMaximumSize());

        jMenu1.setText("Arquivo");

        miEditarCadastro.setText("Cadastro de Pessoas");
        miEditarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditarCadastroActionPerformed(evt);
            }
        });
        jMenu1.add(miEditarCadastro);

        miInativas.setText("Pessoas Inativas");
        miInativas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInativasActionPerformed(evt);
            }
        });
        jMenu1.add(miInativas);

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        jMenu1.add(miSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatório");

        miRelatorio.setText("Gerar Relatório");
        miRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatorioActionPerformed(evt);
            }
        });
        jMenu2.add(miRelatorio);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        // acao da opção do menu Arquivo/Sair
        System.exit(0);
    }//GEN-LAST:event_miSairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Ação feita ao abrir janela principal
        ImageIcon icon = new ImageIcon("src/imagens/logoideau.png");
        icon.setImage(icon.getImage().getScaledInstance(lbLogo.getWidth(),
                lbLogo.getHeight(),
                1));
        lbLogo.setIcon(icon);
    }//GEN-LAST:event_formWindowOpened

    private void miEditarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditarCadastroActionPerformed
        TelaPessoas edicao = new TelaPessoas();
        edicao.setVisible(true);
    }//GEN-LAST:event_miEditarCadastroActionPerformed

    private void miInativasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInativasActionPerformed
        TelaInativos inativo = new TelaInativos();
        inativo.setVisible(true);
    }//GEN-LAST:event_miInativasActionPerformed

    private void miRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatorioActionPerformed
        TelaRelatorio relatorio = new TelaRelatorio();
        relatorio.setVisible(true);
    }//GEN-LAST:event_miRelatorioActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JMenuItem miEditarCadastro;
    private javax.swing.JMenuItem miInativas;
    private javax.swing.JMenuItem miRelatorio;
    private javax.swing.JMenuItem miSair;
    // End of variables declaration//GEN-END:variables
}
