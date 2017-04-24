/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DBUtill.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toni
 */
public class AdminDAO {

    private Connection conn;
    private PreparedStatement pst = null;
    private ResultSet rs;

    public AdminDAO() {
        conn = DBUtil.getConnection();
    }

    public int checkLogin(String username, String pass) {

        int valid = 0;
        try {
            String query = "SELECT * FROM admin WHERE username = ? AND pass = ?";

            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, pass);

            rs = pst.executeQuery();

            if (rs.next()) {
                valid = rs.getInt(1);
            } else {
                valid = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return valid;
    }

    public int getDoctorsTotal() {
        int number = 0;
        try {

            String query = "SELECT COUNT(*) FROM `users` WHERE role = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, "Doctor");
            rs = pst.executeQuery();

            while (rs.next()) {
                number = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return number;

    }

    public int getPharmacistTotal() {
        int number = 0;
        try {

            String query = "SELECT COUNT(*) FROM `users` WHERE role = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1,"pharmacist");
            
            rs = pst.executeQuery();

            while (rs.next()) {
                number = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return number;

    }

    public int getTechnicianTotal() {
        int number = 0;
        try {

            String query = "SELECT COUNT(*) FROM `users` WHERE role = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, "Tecnician");
            rs = pst.executeQuery();

            while (rs.next()) {
                number = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return number;

    }
    
      public int getReceptionistTotal() {
        int number = 0;
        try {

            String query = "SELECT COUNT(*) FROM `users` WHERE role = ? ";
            pst = conn.prepareStatement(query);
            pst.setString(1, "Receptionist");
            
            rs = pst.executeQuery();

            while (rs.next()) {
                number = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return number;

    }

}
