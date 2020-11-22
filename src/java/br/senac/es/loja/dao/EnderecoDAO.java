/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.loja.dao;

// Essa classe utiliza o padrao de projetos DAO (Data Access Object)

import br.senac.es.loja.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class EnderecoDAO {
    
    public Endereco buscar(String cep) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  ps = null;
        ResultSet rs = null;
        String SQL = "";
        Endereco endereco = null;
                
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "SELECT * from enderecos where cep=?";        

        ps = conn.prepareStatement(SQL);
        
        ps.setString(1, cep);

        // Para buscar informações
        rs = ps.executeQuery();   

        // Verifica se possui dados
        if (rs.next()) {
            
            endereco = new Endereco();           

            endereco.setRua(rs.getString("rua"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setUf(rs.getString("uf"));

         } 
        
        ps.close();
        rs.close();
        conn.close();
        
        return endereco;
    }
    
}
     
