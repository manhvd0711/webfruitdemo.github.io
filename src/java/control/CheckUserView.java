/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.CartDAO;
import dao.FruitDAO;
import entity.Fruit;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CheckUserView", urlPatterns = {"/CheckUserView"})
public class CheckUserView extends HttpServlet {

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

        HttpSession session = request.getSession();
        String btnid = request.getParameter("btnid");
        session.setAttribute("btnid", btnid);
        String q = request.getParameter("numberofporducts");
        int numberofporducts = Integer.parseInt(q);
        String re_tag = request.getParameter("cid");
        String re_indexpage = request.getParameter("ci");
        request.setAttribute("cid", re_tag);
        request.setAttribute("ci", re_indexpage);
        
        if (request.getParameter("name_search") != "") {
            String name_Search = request.getParameter("name_search");
            FruitDAO fruitDAO = new FruitDAO();
            List<Fruit> fruits_Search = fruitDAO.GetListSearchFruit(name_Search);
            request.setAttribute("fruits", fruits_Search);
            request.setAttribute("search", name_Search);
            
            if(numberofporducts <= 0){
                request.setAttribute("checkmessage", "Sold out!!!");
                request.getRequestDispatcher("ourfruit.jsp").forward(request, response);
            }else if(numberofporducts > 0){
                if (session.getAttribute("userTarget") == null) {
                    request.setAttribute("checkmessage", "Login to continue buy!");
                    request.getRequestDispatcher("ourfruit.jsp").forward(request, response);
                } else if (session.getAttribute("userTarget") != null) {
                    CartDAO dao = new CartDAO();
                    String userid = (String) session.getAttribute("userTarget");
                    String productid = btnid;
                    int quantity = 1;
                    Order orders = new Order(userid, productid, quantity);
                    dao.InsertInCart(orders);
                    request.setAttribute("checkmessage", "Success add product to cart");
                    request.getRequestDispatcher("ourfruit.jsp").forward(request, response);
                }
            }
            
        } else if (request.getParameter("name_search") == "") {
            if (numberofporducts <= 0) {
                request.setAttribute("checkmessage", "Sold out!!!");
                request.getRequestDispatcher("FruitsServlet").forward(request, response);
            } else if (numberofporducts > 0) {
                if (session.getAttribute("userTarget") == null) {
                    request.setAttribute("checkmessage", "Login to continue buy!");
                    request.getRequestDispatcher("FruitsServlet").forward(request, response);
                } else if (session.getAttribute("userTarget") != null) {
                    CartDAO dao = new CartDAO();
                    String userid = (String) session.getAttribute("userTarget");
                    String productid = btnid;
                    int quantity = 1;
                    Order orders = new Order(userid, productid, quantity);
                    dao.InsertInCart(orders);
                    request.setAttribute("checkmessage", "Success add product to cart");
                    request.getRequestDispatcher("FruitsServlet").forward(request, response);
                }
            }
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
