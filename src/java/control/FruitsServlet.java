/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.CategoryDAO;
import dao.FruitDAO;
import entity.Category;
import entity.Fruit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class FruitsServlet extends HttpServlet {

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

        String tag = request.getParameter("cid");

        int index_page = 1;
        if(request.getParameter("ci")!=null && request.getParameter("ci")!=""){
        index_page = Integer.parseInt(request.getParameter("ci"));
        }
        if(tag == null) tag="";
        FruitDAO fruitDAO = new FruitDAO();
        List<Fruit> fruits = fruitDAO.getListFruit(tag,index_page);
        request.setAttribute("fruits", fruits);
        
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categorys = categoryDAO.getAllCategory();
        request.setAttribute("categorys", categorys);
        request.setAttribute("tag", tag);
        
        int number_page = fruitDAO.getNumberOfPage(tag);
        request.setAttribute("number_page", number_page);
        request.setAttribute("tag_indexpage", index_page);
        
        
        request.setAttribute("re_tag", tag);
        request.setAttribute("re_indexpage", index_page);
        
        request.getRequestDispatcher("ourfruit.jsp").forward(request, response);
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
