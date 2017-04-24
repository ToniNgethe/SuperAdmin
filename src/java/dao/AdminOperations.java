/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Model;
import DBUtill.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toni
 */
public class AdminOperations {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    public AdminOperations() {
        conn = DBUtil.getConnection();
    }

    //add new doctor
    public Boolean addDoctor(Model dm) {

        boolean inserted = false;

        try {

            java.util.Date today = new java.util.Date();
            java.sql.Date t = new java.sql.Date(today.getTime());

            //INSERT INTO `users`(`id`, `empID`, `fName`, `lName`, `dob`, `pass`, `dateCreated`, `role`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])
            String query = "INSERT INTO `users`(`empid`, `fName`, `lName`, `dob`, `pass`, `dateCreated`,`role`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(query);
            pst.setString(1, dm.getDocID());
            pst.setString(2, dm.getfName());
            pst.setString(3, dm.getsName());
            pst.setDate(4, new java.sql.Date(dm.getDob().getTime()));
            pst.setString(5, dm.getPass());
            pst.setDate(6, t);
            pst.setString(7, "doctor");

            int a = pst.executeUpdate();

            if (a > 0) {
                inserted = true;
            } else {
                inserted = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return inserted;
    }

    //check if doctor exists
    public Boolean checkDoctor(Model dm) {
        boolean exists = false;

        String query = "SELECT users.empID FROM users WHERE empID = ? AND role = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, dm.getDocID());
            pst.setString(2, "doctor");

            rs = pst.executeQuery();

            if (rs.next()) {
                exists = true;
            } else {
                exists = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return exists;
    }

    //get all doctors
    public List<Model> getDocs() {

       // INSERT INTO `users`(`id`, `empID`, `fName`, `lName`, `dob`, `pass`, `dateCreated`, `role`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])
        List<Model> docs = new ArrayList<>();

        String query = "SELECT * FROM users WHERE role = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, "doctor");
            
            rs = pst.executeQuery();

            while (rs.next()) {
                Model model = new Model();
                model.setDocID(rs.getString("empID"));
                model.setfName(rs.getString("fName"));
                model.setsName(rs.getString("lName"));
                model.setDob(rs.getDate("dob"));
                model.setPass(rs.getString("pass"));
                model.setDateCreated(rs.getDate("dateCreated"));

                docs.add(model);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return docs;

    }

    //check if pharmacist exists
    public Boolean checkPharmacist(Model dm) {
        boolean exists = false;
//NSERT INTO `users`(`id`, `empID`, `fName`, `lName`, `dob`, `pass`, `dateCreated`, `role`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])
        String query = "SELECT users.empID FROM users WHERE empID = ? AND role = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, dm.getDocID());

            pst.setString(2, "pharmacist");
            
            rs = pst.executeQuery();

            if (rs.next()) {
                exists = true;
            } else {
                exists = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return exists;
    }

    //add new Pharmacity
    public Boolean addPharmacist(Model dm) {

        boolean inserted = false;

        try {

            java.util.Date today = new java.util.Date();
            java.sql.Date t = new java.sql.Date(today.getTime());
            String query = "INSERT INTO `users`(`empID`, `fName`, `lName`, `dob`, `pass`, `dateCreated`,`role`) "
                    + "VALUES (?, ?, ?, ?, ?, ?,?)";

            pst = conn.prepareStatement(query);
            pst.setString(1, dm.getDocID());
            pst.setString(2, dm.getfName());
            pst.setString(3, dm.getsName());
            pst.setDate(4, new java.sql.Date(dm.getDob().getTime()));
            pst.setString(5, dm.getPass());
            pst.setDate(6, t);
            pst.setString(7, "pharmacist");
            int a = pst.executeUpdate();

            if (a > 0) {
                inserted = true;
            } else {
                inserted = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return inserted;
    }
    //get all recs

    public List<Model> getReceptionists() {

        List<Model> recs = new ArrayList<>();

        //NSERT INTO `users`(`id`, `empID`, `fName`, `lName`, `dob`, `pass`, `dateCreated`, `role`) 
        String query = "SELECT * FROM users WHERE role = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, "Receptionist");
            
            rs = pst.executeQuery();

            while (rs.next()) {
                Model model = new Model();

                model.setDocID(rs.getString("empID"));
                model.setfName(rs.getString("fName"));
                model.setsName(rs.getString("lName"));
                model.setDob(rs.getDate("dob"));
                model.setPass(rs.getString("pass"));
                model.setDateCreated(rs.getDate("dateCreated"));

                recs.add(model);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return recs;

    }

   
    public List<Model> getPharmacists() {

        List<Model> ps = new ArrayList<>();

        String query = "SELECT * FROM users WHERE role = ?";
//`id`, `p_id`, `fName`, `lName`, `dob`, `pass`, `dateCreated`
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, "pharmacist");
            
            rs = pst.executeQuery();

            while (rs.next()) {
                Model model = new Model();

                model.setDocID(rs.getString("empID"));
                model.setfName(rs.getString("fName"));
                model.setsName(rs.getString("lName"));
                model.setDob(rs.getDate("dob"));
                model.setPass(rs.getString("pass"));
                model.setDateCreated(rs.getDate("dateCreated"));

                ps.add(model);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return ps;

    }

    //check if tecnician exists
    public Boolean checkTecnician(Model dm) {
        boolean exists = false;
 //NSERT INTO `users`(`id`, `empID`, `fName`, `lName`, `dob`, `pass`, `dateCreated`, `role`) 
        String query = "SELECT users.empID FROM users WHERE empID = ? AND role = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, dm.getDocID());
            pst.setString(2, "Tecnician");

            rs = pst.executeQuery();

            if (rs.next()) {
                exists = true;
            } else {
                exists = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return exists;
    }

    //add new tec
    public Boolean addTechnician(Model dm) {

        boolean inserted = false;

        try {

            java.util.Date today = new java.util.Date();
            java.sql.Date t = new java.sql.Date(today.getTime());
            
 //NSERT INTO `users`(`id`, `empID`, `fName`, `lName`, `dob`, `pass`, `dateCreated`, `role`) 
 
            String query = "INSERT INTO `users`(`empID`, `fName`, `LName`, `dob`, `pass`, `dateCreated`, `role`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(query);
            pst.setString(1, dm.getDocID());
            pst.setString(2, dm.getfName());
            pst.setString(3, dm.getsName());
            pst.setDate(4, new java.sql.Date(dm.getDob().getTime()));
            pst.setString(5, dm.getPass());
            pst.setDate(6, t);
            pst.setString(7, "Tecnician");

            int a = pst.executeUpdate();

            if (a > 0) {
                inserted = true;
            } else {
                inserted = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return inserted;
    }

    //check if tecnician exists
    public Boolean checkRec(Model dm) {
        boolean exists = false;

        String query = "SELECT users.empID FROM users WHERE empID = ? AND role = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, dm.getDocID());
            pst.setString(2, "Receptionist");

            rs = pst.executeQuery();

            if (rs.next()) {
                exists = true;
            } else {
                exists = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return exists;
    }

    //add new tec
    public Boolean addReceptionist(Model dm) {
//NSERT INTO `users`(`id`, `empID`, `fName`, `lName`, `dob`, `pass`, `dateCreated`, `role`) 
        boolean inserted = false;

        try {

            java.util.Date today = new java.util.Date();
            java.sql.Date t = new java.sql.Date(today.getTime());

            String query = "INSERT INTO `users`(`empID`, `fName`, `lName`, `dob`, `pass`, `dateCreated`, `role`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(query);
            pst.setString(1, dm.getDocID());
            pst.setString(2, dm.getfName());
            pst.setString(3, dm.getsName());
            pst.setDate(4, new java.sql.Date(dm.getDob().getTime()));
            pst.setString(5, dm.getPass());
            pst.setDate(6, t);
            pst.setString(7, "Receptionist");

            int a = pst.executeUpdate();

            if (a > 0) {
                inserted = true;
            } else {
                inserted = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return inserted;
    }

    //get all recs
    public List<Model> getTecgnicians() {

        List<Model> tecs = new ArrayList<>();

        String query = "SELECT * FROM users WHERE role = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, "Tecnician");
            rs = pst.executeQuery();

            while (rs.next()) {
                Model model = new Model();

                model.setDocID(rs.getString("empID"));
                model.setfName(rs.getString("fName"));
                model.setsName(rs.getString("lName"));
                model.setDob(rs.getDate("dob"));
                model.setPass(rs.getString("pass"));
                model.setDateCreated(rs.getDate("dateCreated"));
                
                tecs.add(model);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return tecs;

    }

    //deleting doctor
    public Boolean deleteDoc(String docID) {
        boolean deleted = false;

        String query = "DELETE FROM users WHERE empID = ? AND role = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, docID);
            pst.setString(2, "doctor");

            int a = pst.executeUpdate();

            if (a > 0) {
                deleted = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return deleted;
    }

    public Boolean updateDoc(Model model) {
        boolean updated = false;

        String query = "UPDATE users SET fName = ?, lName = ?, dob = ?, pass = ? WHERE  empID = ? AND role = ?";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, model.getfName());
            pst.setString(2, model.getsName());
            pst.setDate(3, new java.sql.Date(model.getDob().getTime()));
            pst.setString(4, model.getPass());
            pst.setString(5, model.getDocID());
            pst.setString(6, "doctor");

            int a = pst.executeUpdate();
            if (a > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return updated;
    }

    public Boolean deleteRec(String recID) {

        boolean deleted = false;

        String query = "DELETE FROM users WHERE empID = ? AND role = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, recID);
            pst.setString(2, "Receptionist");

            int a = pst.executeUpdate();

            if (a > 0) {
                deleted = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return deleted;
    }

    public Boolean updateRec(Model model) {
        boolean updated = false;

        String query = "UPDATE users SET fName = ?, lName = ?, dob = ?, pass = ? WHERE  empID = ? AND role = ?";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, model.getfName());
            pst.setString(2, model.getsName());
            pst.setDate(3, new java.sql.Date(model.getDob().getTime()));
            pst.setString(4, model.getPass());
            pst.setString(5, model.getDocID());
            pst.setString(6, "Receptionist");

            int a = pst.executeUpdate();
            if (a > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return updated;
    }

    public Boolean deleteP(String ph) {

        boolean deleted = false;

        String query = "DELETE FROM users WHERE empID = ? AND role = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ph);
            pst.setString(2, "pharmacist");

            int a = pst.executeUpdate();

            if (a > 0) {
                deleted = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return deleted;
    }

    public Boolean deleteTec(String ph) {

        boolean deleted = false;

        String query = "DELETE FROM users WHERE empID = ? AND role = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ph);
            pst.setString(2, "Tecnician");

            int a = pst.executeUpdate();

            if (a > 0) {
                deleted = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closeConnection(conn);
        }

        return deleted;
    }

    
    public Boolean updateTec(Model model) {
        
        boolean updated = false;

        String query = "UPDATE users SET fName = ?, lName = ?, dob = ?, pass = ? WHERE  empID = ? AND role = ?";
        try {

            pst = conn.prepareStatement(query);
            
            pst.setString(1, model.getfName());
            pst.setString(2, model.getsName());
            pst.setDate(3, new java.sql.Date(model.getDob().getTime()));
            pst.setString(4, model.getPass());
            pst.setString(5, model.getDocID());
            pst.setString(6, "Tecnician");

            int a = pst.executeUpdate();
            
            if (a > 0) {
                updated = true;
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            DBUtil.closeConnection(conn);
        }

        return updated;
    }
    
}
