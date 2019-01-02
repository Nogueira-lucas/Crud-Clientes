/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import model.ClienteDAO;
import model.Cliente;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    
    }

    @Test
    public void salvar() {
        Cliente cliente = new Cliente("LUCAS", "lucas@gmail.com", "11234323343");
        ClienteDAO cDAO = new ClienteDAO();
        
        if(cDAO.salvar(cliente)){
               System.out.println("Função salvar ta funcionando!");
        }else{
            fail("Erro ao salvar!");
        }
    }
    
    @Test
    public void listarTodos(){
        ClienteDAO cDAO = new ClienteDAO();
        
        if(cDAO.listarTodos()!= null){
               System.out.println("Função listarTodos ta funcionando!");
        }else{
            fail("Erro ao listar!");
        }
    }
    
    @Test
    public void atualizar(){
        ClienteDAO cDAO = new ClienteDAO();
        Cliente cliente = new Cliente("LUCAO", "lukas@bol.com", "2134323533");
        cliente.setId(17);
        
        if(cDAO.atualizar(cliente)){
               System.out.println("Função atualizar ta funcionando!");
        }else{
            fail("Erro ao atualizar: ");
        }
    }
}
