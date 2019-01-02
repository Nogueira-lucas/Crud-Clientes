/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Cliente;
import model.ClienteDAO;
import model.ClienteTableModel;

/**
 *
 * @author lucas
 */
public class Tela extends JFrame implements ActionListener{

    private JButton         btnExcluir;
    private JButton         btnInserir;
    private JButton         btnEditar; 
    
    private JLabel          lblNome;
    private JLabel          lblEmail;
    private JLabel          lblCpf;
    
    private JTextField      txtNome;
    private JTextField      txtEmail;
    private JTextField      txtCpf; 
   
    private JTable          tblTabela;
    
            
            
    public Tela(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Crud Clientes");
        setLocation(750, 100);
        setSize(500, 500);
        setLayout(null);
        init();
        setVisible(true);
    }
    
    public void limparCampos(){
        txtNome.setText(null);
        txtEmail.setText(null);
        txtCpf.setText(null);
    }
    
    
    public void init(){
        lblNome = new JLabel("Nome:");
        lblNome.setSize(100, 20);
        lblNome.setLocation(30, 0);
        lblNome.setVisible(true);
        add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setSize(400, 25);
        txtNome.setLocation(lblNome.getX(), lblNome.getY()+30);
        add(txtNome);
        
        lblEmail = new JLabel("Email:");
        lblEmail.setSize(100, 20);
        lblEmail.setLocation(txtNome.getX(), txtNome.getY()+30);
        lblEmail.setVisible(true);
        add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setSize(400, 25);
        txtEmail.setLocation(lblEmail.getX(), lblEmail.getY()+30);
        add(txtEmail);
        
        lblCpf = new JLabel("CPF:");
        lblCpf.setSize(100, 20);
        lblCpf.setLocation(txtEmail.getX(), txtEmail.getY()+30);
        lblCpf.setVisible(true);
        add(lblCpf);
        
        txtCpf = new JTextField();
        txtCpf.setSize(400, 25);
        txtCpf.setLocation(lblCpf.getX(), lblCpf.getY()+30);
        add(txtCpf);
        
        btnInserir = new JButton();
        btnInserir.setSize(100, 50);
        btnInserir.setLocation(txtCpf.getX(), txtCpf.getY()+30+30);
        btnInserir.setText("Inserir");
        btnInserir.setVisible(true);
        add(btnInserir);
        btnInserir.addActionListener(this);
        
        btnExcluir = new JButton();
        btnExcluir.setSize(120, 50);
        btnExcluir.setLocation(txtCpf.getX()+120, txtCpf.getY()+60);
        btnExcluir.setText("Excluir");
        btnExcluir.setVisible(true);
        add(btnExcluir);
        btnExcluir.addActionListener(this);
        
        btnEditar = new JButton("Editar");
        btnEditar.setSize(120, 50);
        btnEditar.setLocation(btnExcluir.getX()+140, btnExcluir.getY());
        btnEditar.setVisible(true);
        add(btnEditar);
        btnEditar.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnInserir){
            Cliente cliente = new Cliente(
                    txtNome.getText(),
                    txtEmail.getText(),
                    txtCpf.getText()
            );
            ClienteDAO cDAO = new ClienteDAO();
            if(cDAO.salvar(cliente)){
               JOptionPane.showMessageDialog(this,"Cliente salvo com sucesso!");
               limparCampos();
               
            }else{
                JOptionPane.showMessageDialog(this,"Erro ao salvar");
            }
            
        }
        if(evento.getSource() == btnExcluir ){
            System.out.println("excluir");
        }
    }
    
    /*public JTable construirTabela(){
        
        ClienteTableModel tabelaModelo = new ClienteTableModel();
        
        JTable tabela = new JTable(tabelaModelo);
        tabela.setPreferredSize(new Dimension(400, 180));
        
        ScrollPane scroll = new ScrollPane();
        scroll.add(tabela);
        
        return tabela;
    }*/
}
