package view;

import model.dao.LoginDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.bean.LoginModel;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        field_login = new javax.swing.JTextField();
        bt_acessar = new javax.swing.JButton();
        field_senha = new javax.swing.JPasswordField();
        lbTitulo = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Peso Corporal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Login");

        jLabel2.setText("Senha");

        field_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_loginActionPerformed(evt);
            }
        });

        bt_acessar.setText("Acessar");
        bt_acessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_acessarActionPerformed(evt);
            }
        });

        field_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_senhaActionPerformed(evt);
            }
        });

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTitulo.setText("Controle de Peso Corporal");

        lbLogo.setText("Imagem");
        lbLogo.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_login)
                            .addComponent(field_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lbTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(bt_acessar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTitulo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(field_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bt_acessar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_acessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_acessarActionPerformed
        try {
            String nome_usuario, senha;

            nome_usuario = field_login.getText();
            senha = field_senha.getText();

            LoginModel objloginmodel = new LoginModel();
            objloginmodel.setNome_usuario(nome_usuario.trim());
            objloginmodel.setSenha(senha);

            LoginDAO objlogindao = new LoginDAO();
            ResultSet rslogindao = objlogindao.Autenticacaologin(objloginmodel);

            if (rslogindao.next()) {
                // chamar a tela que quero abrir
                TelaPrincipal tela = new TelaPrincipal();
                tela.setVisible(true);
                //tela.carregaRegistros();
                
                
                this.dispose();

            } else {
                // envirar mensagem dizendo incorreto 
                JOptionPane.showMessageDialog(null, "Usuário ou senha Inválidos!");
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "frmlogin " + erro);
        }
    }//GEN-LAST:event_bt_acessarActionPerformed

    private void field_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_loginActionPerformed

    private void field_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_senhaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Ação feita ao abrir janela principal
        ImageIcon icon = new ImageIcon("src/imagens/logosi.png");
        icon.setImage(icon.getImage().getScaledInstance(lbLogo.getWidth(),
                lbLogo.getHeight(),
                1));
        lbLogo.setIcon(icon);
    }//GEN-LAST:event_formWindowOpened

    private void field_senhaActionPerformed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            bt_acessar.doClick();
        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_acessar;
    private javax.swing.JTextField field_login;
    private javax.swing.JPasswordField field_senha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
