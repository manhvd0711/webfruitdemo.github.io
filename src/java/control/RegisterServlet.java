/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author boybe
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        String fullname = request.getParameter("FullName");
        String email = request.getParameter("Email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("repassword");


        request.setAttribute("fullname", fullname);
        request.setAttribute("email", email);
        request.setAttribute("username", username);


        if (dao.findUserName(username)) {
            request.setAttribute("userName_error", "userName_error");
        }
        if (dao.findEmail(email)) {
            request.setAttribute("email_error", "email_error");
        }
        if (!password.equals(rePassword)) {
            request.setAttribute("rePass_error", "rePass_error");
        }
        if (request.getParameter("agree") == null) {
            request.setAttribute("agree_error", "agree_error");
        }

        if (!password.equals(rePassword) || request.getParameter("agree") == null
                || dao.findUserName(username) || dao.findEmail(email)) {
            System.out.println("Register: 1 of 4 if error");
        } else {
            dao.registerAccount(fullname, email, username, password);
            request.setAttribute("success", "success");
        }
        
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
