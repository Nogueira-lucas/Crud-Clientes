/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lucas
 */
public class ClienteTableModel extends AbstractTableModel{
    
    private List<Cliente> clientes = new ArrayList<>();
    private String[] colunas = {"Nome", "E-mail", "Cpf"};

    @Override
    public String getColumnName(int c) {
        return colunas[c]; 
    }
    
    @Override
    public int getRowCount() {
       return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public Cliente getValueAll(int linha, int coluna){
        return (clientes.get(linha));
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return clientes.get(linha).getNome();
            case 1:
                return clientes.get(linha).getEmail();
            case 2:
                return clientes.get(linha).getCpf();
                
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 0:
                clientes.get(linha).setNome((String)valor);
                break;
            case 1:
                clientes.get(linha).setEmail((String)valor);
                break;
            case 2:
                clientes.get(linha).setCpf((String)valor);
                break;
        }
        
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addRow(Cliente c){
        this.clientes.add(c);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.clientes.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
