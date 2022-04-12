package model.dao;

//@author ustop
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.LoginModel;
import java.sql.ResultSet;

public class LoginDAO {

    Connection connection;

    public ResultSet Autenticacaologin(LoginModel objloginmodel) {
        connection = new ConnectionFactory().getConnection();

        try {
            String sql = "select * from login where nome_usuario = ? and senha = ? ";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, objloginmodel.getNome_usuario());
            stmt.setString(2, objloginmodel.getSenha());

            ResultSet rs = stmt.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LoginDao" + erro);
            return null;
        }
    }

}
