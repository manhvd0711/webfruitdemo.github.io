/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DBContext.DBContext;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CategoryDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<Category> getAllCategory(){
        List<Category>categorys = new ArrayList<>();
        con = DBContext.open();
        try {
            ps = con.prepareStatement("SELECT * FROM Categories");
            rs = ps.executeQuery();
            while(rs.next()){
                Category category = new Category(rs.getString("CategoryId"), rs.getString("CategoryName"), rs.getString("Image"));
                categorys.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorys;
    }
    
    public static void main(String[] args) {
        CategoryDAO dAO = new CategoryDAO();
        List<Category> categorys = dAO.getAllCategory();
        for (Category category : categorys) {
            System.out.print(category.getImage());
        }
    }
    
}
