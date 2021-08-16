/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DBContext.DBContext;
import entity.Fruit;
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
public class FruitDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<Fruit> getListFruit(String id, int index){
        List<Fruit> fruits = new ArrayList<>();
        con = DBContext.open();
        try {
            ps = con.prepareStatement("select * from Products\n" +
            "where CategoryId like ?\n" +
            "order by ProductId\n" +
            "OFFSET ? rows fetch next 5 ROWS only;");
            ps.setString(1, "%"+id+"%");
            ps.setInt(2,(index-1)*5);
            rs = ps.executeQuery();
            while(rs.next()){
                Fruit fruit = new Fruit(rs.getString("ProductId"),
                        rs.getString("ProductName"),
                        rs.getString("CategoryId"),
                        rs.getInt("Number of products"),
                        rs.getString("Detail"),
                        rs.getFloat("Price"),
                        rs.getString("Image"));
                fruits.add(fruit);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FruitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fruits;
    }
    
    
    public int getNumberOfPage(String CategoriesId){
        con = DBContext.open();
        try {
            ps = con.prepareStatement("SELECT * FROM Products WHERE CategoryId like ?");
            ps.setString(1, "%"+CategoriesId+"%");
            rs = ps.executeQuery();
            int page_size = 5;
            int count=0;
            int number_page;
            while(rs.next()){
                count++;
            }
            if(count%page_size==0){
                number_page = count/page_size;
            }else number_page = count/page_size +1;
            return  number_page;
        } catch (SQLException ex) {
            Logger.getLogger(FruitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public List<Fruit> GetListSearchFruit(String name){
        List<Fruit>fruitsSearch = new ArrayList();
        con = DBContext.open();
        try {
            ps = con.prepareStatement("select * from Products where ProductName like ?");
            ps.setString(1, name+"%");
            rs= ps.executeQuery();
            while(rs.next()){
                Fruit fruit = new Fruit(rs.getString("ProductId"),
                        rs.getString("ProductName"),
                        rs.getString("CategoryId"),
                        rs.getInt("Number of products"),
                        rs.getString("Detail"),
                        rs.getFloat("Price"),
                        rs.getString("Image"));
                fruitsSearch.add(fruit);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FruitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fruitsSearch;
    }
    
    public static void main(String[] args) {
        FruitDAO fruitDAO = new FruitDAO();
        ArrayList<Fruit> fruitlist = (ArrayList<Fruit>)fruitDAO.GetListSearchFruit("a");
        int n = fruitDAO.getNumberOfPage("");
        for (Fruit fruit : fruitlist) {
            System.out.println(fruit.getProductid());
        }
        System.out.println(n);
    }
}
