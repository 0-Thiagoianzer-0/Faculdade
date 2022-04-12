package model.dao;

import connection.ConnectionFactory;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pessoa;

public class PessoaDAO {

    public void create (Pessoa p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pessoa (nome,data_nascimento,sexo,altura,peso,data_cadastro,ativ_fisica,ativ_frequencia,bebidas_alcool,bebidas_frequencia,alimentacao,alimentacao_tipo,fumante,doenca,doenca_nome,medicamentos,jornada_trabalho,forma_trabalho,ativ_diaria) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getData_nascimento());
            stmt.setString(3, p.getSexo());
            stmt.setString(4, p.getAltura());
            stmt.setString(5, p.getPeso());
            stmt.setString(6, p.getData_cadastro());
            stmt.setString(7, p.getAtiv_fisica());
            stmt.setString(8, p.getAtiv_frequencia());
            stmt.setString(9, p.getBebidas_alcool());
            stmt.setString(10, p.getBebidas_frequencia());
            stmt.setString(11, p.getAlimentacao());
            stmt.setString(12, p.getAlimentacao_tipo());
            stmt.setString(13, p.getFumante());
            stmt.setString(14, p.getDoenca());
            stmt.setString(15, p.getDoenca_nome());
            stmt.setString(16, p.getMedicamentos());
            stmt.setString(17, p.getJornada_trabalho());
            stmt.setString(18, p.getForma_trabalho());
            stmt.setString(19, p.getAtiv_diaria());
                    
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Pessoa> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pessoa> listapessoa = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();
                       
            while (rs.next()) {
                Pessoa p = new Pessoa();
                
                p.setCod_pessoa(rs.getInt("cod_pessoa"));
                p.setNome(rs.getString("nome"));
                p.setData_nascimento(rs.getString("data_nascimento"));
                p.setSexo(rs.getString("sexo"));
                p.setAltura(rs.getString("altura"));
                p.setPeso(rs.getString("peso"));
                p.setData_cadastro(rs.getString("data_cadastro"));
                p.setAtiv_fisica(rs.getString("ativ_fisica"));
                p.setAtiv_frequencia(rs.getString("ativ_frequencia"));
                p.setBebidas_alcool(rs.getString("bebidas_alcool"));
                p.setBebidas_frequencia(rs.getString("bebidas_frequencia"));
                p.setAlimentacao(rs.getString("alimentacao"));
                p.setDoenca(rs.getString("doenca"));
                p.setDoenca_nome(rs.getString("doenca_nome"));
                p.setMedicamentos(rs.getString("medicamentos"));
                p.setJornada_trabalho(rs.getString("jornada_trabalho"));
                p.setForma_trabalho(rs.getString("forma_trabalho"));
                p.setAtiv_diaria(rs.getString("ativ_diaria"));
                p.setAtivo(rs.getString("ativo"));
                listapessoa.add(p);           
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return listapessoa;
}
    
   
    public void update (Pessoa p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pessoa SET nome=?,data_nascimento=?,sexo=?,altura=?,peso=?,data_cadastro=?,ativ_fisica=?,ativ_frequencia=?,bebidas_alcool=?,bebidas_frequencia=?,alimentacao=?,alimentacao_tipo=?,fumante=?,doenca=?,doenca_nome=?,medicamentos=?,jornada_trabalho=?,forma_trabalho=?,ativ_diaria=? WHERE cod_pessoa=?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getData_nascimento());
            stmt.setString(3, p.getSexo());
            stmt.setString(4, p.getAltura());
            stmt.setString(5, p.getPeso());
            stmt.setString(6, p.getData_cadastro());
            stmt.setString(7, p.getAtiv_fisica());
            stmt.setString(8, p.getAtiv_frequencia());
            stmt.setString(9, p.getBebidas_alcool());
            stmt.setString(10, p.getBebidas_frequencia());
            stmt.setString(11, p.getAlimentacao());
            stmt.setString(12, p.getAlimentacao_tipo());
            stmt.setString(13, p.getFumante());
            stmt.setString(14, p.getDoenca());
            stmt.setString(15, p.getDoenca_nome());
            stmt.setString(16, p.getMedicamentos());
            stmt.setString(17, p.getJornada_trabalho());
            stmt.setString(18, p.getForma_trabalho());
            stmt.setString(19, p.getAtiv_diaria());
            stmt.setInt(20, p.getCod_pessoa());
        /*
            
            */
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!\n"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void update2 (Pessoa p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pessoa SET ativo=? WHERE cod_pessoa=?");
            stmt.setString(1, p.getAtivo());
            stmt.setInt(2, p.getCod_pessoa());
        
            stmt.executeUpdate();
            if (Integer.parseInt(p.getAtivo())==0) {                
            JOptionPane.showMessageDialog(null, "Inativado com sucesso!");
            } else {
            JOptionPane.showMessageDialog(null, "Ativado com sucesso!");                
            }       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inativar!\n"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete (Pessoa p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM pessoa WHERE cod_pessoa=?");
            stmt.setInt(1, p.getCod_pessoa());
        
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso! ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!\n"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    

}
