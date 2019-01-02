/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author lucas
 */
public class ClienteDAO {
    
    private Connection conn = null;

    public ClienteDAO() {
        conn = FabricaConexao.getConexao();
    }
    
    public boolean salvar(Cliente cliente){
        String sql = "INSERT INTO tb_cliente(nome, email, cpf) VALUES(?,?,?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar :"+ex);
            return false;
        }finally{
            FabricaConexao.fecharConexao(conn);
        }
    }
    
    public boolean atualizar(Cliente cliente){
        
        String sql = "UPDATE tb_cliente "
                    + "SET nome=?, email=?, cpf=?"
                    + "WHERE(id=?)";
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome()  );
            stmt.setString(2, cliente.getEmail() );
            stmt.setString(3, cliente.getCpf()   );
            stmt.setInt(4,cliente.getId()        );
            
            stmt.execute();
            return true;
        }catch(Exception ex){
            System.err.println("Erro ao atualizar"+ex);
            return false;
        }finally{
            FabricaConexao.fecharConexao(conn);
        }
    }
    
    public void excluir(Cliente cliente){
        String sql = "DELETE FROM tb_cliente WHERE(nome = ? and email = ? and cpf = ?)";
        PreparedStatement stmt;
        
        try{
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            
            stmt.executeUpdate();
        }catch(Exception ex){
            System.err.println("Erro ao excluir: "+ex);
        }finally{
            FabricaConexao.fecharConexao(conn);
        }
    }
    
    public ArrayList<Cliente> listarTodos(){
        String sql = "SELECT * FROM tb_cliente";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf(rs.getString("cpf"));
                
                clientes.add(cliente);   
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao listar dados: "+ex);
        }finally{
            FabricaConexao.fecharConexao(conn, stmt, rs);
        }
        return clientes;
    }
    
}
