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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shado
 */
@WebServlet(name = "editAccount", urlPatterns = {"/editAccount"})
public class editAccount extends HttpServlet {

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
        
        final String PHONE_VALID = "^\\d{10,11}$";

        String fullname = request.getParameter("FullName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("repassword");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        
        String emailTarget = request.getParameter("Email");

    
        System.out.println(emailTarget);

  
         
        if(!phone.matches(PHONE_VALID)){
            request.setAttribute("phone_error", "phone_error");
        }

        if (!password.equals(rePassword)) {
            request.setAttribute("rePass_error", "rePass_error");
        }

        if (!password.equals(rePassword) || !phone.matches(PHONE_VALID)) {
            System.out.println("edit_account: if error");
        } else {
            if (dao.editAccount(password, fullname, phone, address, emailTarget) == 0) {
                System.out.println("error sql");
            } else {
                request.setAttribute("success", "success");
            }
        }

        request.getRequestDispatcher("edit_account.jsp").forward(request, response);
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
