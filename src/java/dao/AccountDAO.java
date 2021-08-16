/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DBContext.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shado
 */
public class AccountDAO {

    public void registerAccount(String fullname, String email, String username, String password) {
        String sql = "INSERT INTO account (full_name, email, user_name ,pass_word) "
                + "VALUES (?, ?, ? , ?);";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBContext.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }

    public boolean findAccount(String user_name, String password) {
        String sql = "SELECT * FROM account    "
                + "where user_name = ? and pass_word = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return false;
    }

    public boolean findUserName(String user_name) {
        String sql = "SELECT * FROM account    "
                + "where user_name = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, user_name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return false;
    }

    public boolean findEmail(String email) {
        String sql = "SELECT * FROM account    "
                + "where email = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return false;
    }

    public String getCustomerName(String userName) {
        String sql = "select full_name from account where user_name = ? ";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("full_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return null;
    }

    public int editAccount(String pass, String full_name, String phone, String address, String email) {
        String sql = "UPDATE account SET  pass_word = ? , full_name = ? , phone_number = ? , address = ? WHERE email = ? ";
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, full_name);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, email);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return 0;
    }

    public int resetPassword(String pass, String email) {
        String sql = "UPDATE account "
                + "SET pass_word = ? "
                + "WHERE email = ? ";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, email);

            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return 0;
    }

    public Account getAccountByEmail(String email) {
        String sql = "select * from account where email = ? ";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString("full_name"), rs.getString("email"),
                        rs.getString("user_name"), rs.getString("pass_word"), rs.getString("phone_number"),
                        rs.getString("address"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return null;
    }

    public Account getAccountByUserName(String username) {
        String sql = "select * from account where user_name = ? ";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString("full_name"), rs.getString("email"),
                        rs.getString("user_name"), rs.getString("pass_word"), rs.getString("phone_number"),
                        rs.getString("address"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return null;
    }

}
