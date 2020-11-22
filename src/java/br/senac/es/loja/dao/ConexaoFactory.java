/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


// Essa Classe usa o padrão de projeto Factory (Fabrica)
public class ConexaoFactory {

    //  Database credentials
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException{
        
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/bd_produto", "root", "123456");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return conexao;
        
       
    }
    
}
