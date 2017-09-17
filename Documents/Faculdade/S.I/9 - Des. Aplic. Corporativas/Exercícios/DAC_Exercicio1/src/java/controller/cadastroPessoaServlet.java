/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

/**
 *
 * @author leo_c
 */
public class cadastroPessoaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Entrou no servlet");
        try{
            Pessoa pessoa = new Pessoa();
            String nomeInformado = request.getParameter("nome");
            pessoa.setNome(nomeInformado);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesteJPAPU");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();

            em.close();
            emf.close();
            
            request.setAttribute("mensagemRetorno", "Pessoa Cadastrada");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }catch(Exception e){
            request.setAttribute("mensagemRetorno", "Erro ao cadastrar");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
