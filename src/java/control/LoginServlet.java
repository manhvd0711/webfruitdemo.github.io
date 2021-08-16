/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author boybe
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        
        AccountDAO dao = new AccountDAO();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        request.setAttribute("low_priority", "low_priority");
        request.setAttribute("username", username);
        
        if (request.getParameter("password") != null) {    //avoid bootstrap
            if (request.getParameter("rememberLogin") != null) {
                System.out.println("create");
                Cookie userCookie = new Cookie("user", username);
                Cookie passCookie = new Cookie("pass", password);
                userCookie.setMaxAge(60 * 60 * 24);
                passCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            } else {
                System.out.println("remove");
                Cookie userCookie = new Cookie("user", username);
                Cookie passCookie = new Cookie("pass", password);
                userCookie.setMaxAge(0);
                passCookie.setMaxAge(0);
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }
        }

        if (!dao.findAccount(username, password)) {
            request.setAttribute("account_not_found_error", "account_not_found_error");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            session.setAttribute("userTarget", username);
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
