/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.loja.controller;

import br.senac.es.loja.dao.EnderecoDAO;
import br.senac.es.loja.model.Categoria;
import br.senac.es.loja.model.Endereco;
import br.senac.es.loja.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EnderecoController {

    @RequestMapping("/")
    public ModelAndView iniciar(HttpSession session) {
        ArrayList<Categoria> categorias = new ArrayList<>();
        Categoria c = new Categoria();
        c.setCodigo(5);
        c.setDescricao("brinquedos");
        
        Categoria c2 = new Categoria();
        c2.setCodigo(8);
        c2.setDescricao("cozinha");
        categorias.add(c);
        categorias.add(c2);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("lista", categorias);
        return mv;
    }

    @RequestMapping(value = "/buscar")
    @ResponseBody
    public Endereco buscar(String cep){
        EnderecoDAO dao = new EnderecoDAO();
        Endereco endereco = new Endereco();
        try {
            endereco = dao.buscar(cep);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return endereco;
    }
    
        @RequestMapping("/cadastrar")
    public String iniciar(Usuario usuario) {
        usuario.getCodigo();
        return "form";
    }

}
