package model.dao;

import connection.ConnectionFactory;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Questionario;

public class QuestionarioDAO {
    
    public void create (Questionario m) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt= con.prepareStatement("INSERT INTO questionario (questionario_cod_pessoa,peso,data_medicao,status,ocorrencia,comentario)VALUES(?,?,?,?,?,?)");        
            stmt.setInt(1,m.getQuestionario_cod_pessoa());
            stmt.setString(2,m.getPeso());
            stmt.setString(3,m.getData_medicao());
            stmt.setString(4,m.getStatus());
            stmt.setString(5,m.getOcorrencia());
            stmt.setString(6,m.getComentario());
                        
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Medição salva com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar medição!\n"+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
    
    public List<Questionario> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Questionario> listamedicao = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM questionario");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Questionario m = new Questionario();
                
                m.setCod_questionario(rs.getInt("cod_qustionario"));
                m.setData_medicao(rs.getString("data_medicao"));
                m.setPeso(rs.getString("peso"));
                m.setStatus(rs.getString("status"));
                m.setOcorrencia(rs.getString("ocorrencia"));
                m.setComentario(rs.getString("comentario"));
                m.setQuestionario_cod_pessoa(rs.getInt("questionario_cod_pessoa"));
                listamedicao.add(m);                
            }            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }return listamedicao;           
    
    } 
}
