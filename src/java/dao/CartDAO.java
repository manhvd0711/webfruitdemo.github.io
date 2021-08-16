/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DBContext.DBContext;
import entity.Category;
import entity.Fruit;
import entity.Order;
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
public class CartDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public void InsertInCart(Order ord){
        con = DBContext.open();
        try {
            ps = con.prepareStatement("insert into Cart(userid,productid,quantity) VALUES (?,?,?)");
            ps.setString(1, ord.getUserid());
            ps.setString(2, ord.getProductid());
            ps.setInt(3, ord.getQuantity());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            DBContext.close(con, ps, rs);
        }
        
    }
    public List<Order> getListOrder(String userid){
        List<Order> orders = new ArrayList<>();
        con = DBContext.open();
        try {
            ps = con.prepareStatement("select * from Cart where userid like ?");
            ps.setString(1, "%"+userid+"%");            
            rs = ps.executeQuery();
            while(rs.next()){
                Order Ord = new Order(rs.getString("userid"),rs.getString("productid"),rs.getInt("quantity"));
                orders.add(Ord);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FruitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return orders;
    }
    public List<Fruit> getListFruit(String userid){
        List<Fruit> fruits = new ArrayList<>();
        con = DBContext.open();
        try {
            ps = con.prepareStatement("select c.userid,c.productid,p.ProductName,p.[Number of products],p.Price,p.Image,c.quantity from Cart c, Products p where c.productid=p.ProductId and c.userid like ?");
            ps.setString(1, "%"+userid+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                Fruit fruit = new Fruit();
                fruit.setProductid(rs.getString("productid"));
                fruit.setProductname(rs.getString("ProductName"));
                fruit.setNumberofporducts(rs.getInt("Number of products"));
                fruit.setPrice(rs.getFloat("Price"));
                fruit.setImage(rs.getString("Image"));
                fruits.add(fruit);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FruitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fruits;
    }
}
