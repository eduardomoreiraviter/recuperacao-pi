/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.LivrosDAO;
import dao.UsuarioDAO;
import entidade.Livros;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */
public class acao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        System.out.println("estou no GET.");

        String a = request.getParameter("a");
        
        if (a.equals("editarCateg")) {
            String id = request.getParameter("id");
            int codigo = Integer.parseInt(id);

            Livros livros = new LivrosDAO().consultar(codigo);

            request.setAttribute("livros", livros);

            encaminharPagina("livros.jsp", request, response);
        }
        
        if (a.equals("excluirCateg")){
            String id = request.getParameter("id");
            int codigo = Integer.parseInt(id);
            if (new LivrosDAO().excluir(codigo)){
                encaminharPagina("sucesso.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        System.out.println("estou no POST.");
        //
        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String descricao = request.getParameter("descricao");
        String publicacao = request.getParameter("publicacao");
        String avaliacao = request.getParameter("avaliacao");
        //
        System.out.println("id: " + id);
        System.out.println("titulo: " + titulo);
        System.out.println("autor: " + autor);
        System.out.println("descrcao: " + descricao);
        System.out.println("publicacao: " + publicacao);
        System.out.println("avaliacao: " + avaliacao);
        //
        if (new UsuarioDAO().autenticar(descricao, autor)) {
            //avisa que deu certo
            //response.sendRedirect("sucesso.jsp");
            request.setAttribute("xxx", 1); //nao vou usar, isso é um exemplo
            encaminharPagina("sucesso.jsp", request, response);
        } else {
            //avisa que deu errado
            encaminharPagina("erro.jsp", request, response);
        }

        //----------------------------------------------------------------
        String a = request.getParameter("a");
        if (a.equals("salvarCateg")) {
            String ID = request.getParameter("id");
            String Titulo = request.getParameter("titulo");
            String Autor = request.getParameter("autor");
            String Descricao = request.getParameter("descricao");
            String Publicacao = request.getParameter("publicacao");
            String Avaliacao = request.getParameter("avaliacao");

            Livros livros = new Livros();
            int codigo = Integer.parseInt(ID);
            livros.setId(codigo);
            livros.setTitulo(titulo);
            livros.setAutor(autor);
            livros.setDescricao(descricao);
            livros.setPublicacai(publicacao);
            livros.setAvaliacao(avaliacao);

            if (codigo == 0) {
                if (new LivrosDAO().salvar(livros)) {
                    encaminharPagina("livros.jsp", request, response);
                } else {
                    encaminharPagina("erro.jsp", request, response);
                }
            } else {
                if (new LivrosDAO().atualizar(livros)) {
                    encaminharPagina("livros.jsp", request, response);
                } else {
                    encaminharPagina("erro.jsp", request, response);
                }
            }
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

    private void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("erro no encaminhamento: " + e);
        }

    }
}
