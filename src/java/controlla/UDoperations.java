/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlla;

import dao.AdminOperations;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Model;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toni
 */

public class UDoperations extends HttpServlet {

    AdminOperations adminOperations;

    public UDoperations() {
        adminOperations = new AdminOperations();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        String id = request.getParameter("did");
        String fName = request.getParameter("fName");
        String sName = request.getParameter("sName");
        String dob = request.getParameter("dob");
        String pass = request.getParameter("pass");

        if (!id.isEmpty()) {
            //getActions from ajax
            if (action.equals("deleteDoctor")) {

                if (adminOperations.deleteDoc(id)) {
                    out.print("  <div id='err' class='alert alert-success' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Doctor deleted successfully.... </div>");
                } else {
                    out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Error in deleting the doctor </div>");
                }

            } else if (action.equals("saveDoctor")) {

                try {

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date rDate = format.parse(dob);

                    Model model = new Model(0, fName, sName, pass, id, rDate);

                    if (adminOperations.updateDoc(model)) {
                        out.print("  <div id='err' class='alert alert-success' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Doctor updated successfully.... </div>");

                    } else {
                        out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Error in updating the doctor </div>");
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(UDoperations.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (action.equals("deleteReceptionist")) {

                if (adminOperations.deleteRec(id)) {

                    out.print("  <div id='err' class='alert alert-success' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Receptionist deleted successfully.... </div>");

                } else {

                    out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Error in deleting the receptionist </div>");
                }

            } else if (action.equals("saveReceptionist")) {

                try {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date rDate = format.parse(dob);

                    Model model = new Model(0, fName, sName, pass, id, rDate);

                    if (adminOperations.updateRec(model)) {

                        out.print("  <div id='err' class='alert alert-success' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Receptionist updated successfully.... </div>");
                    } else {
                        
                        out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Error in updating the receptionist </div>");
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(UDoperations.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (action.equals("deletePharmacist")) {

                if (adminOperations.deleteP(id)) {

                    out.print("  <div id='err' class='alert alert-success' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Pharmacist deleted successfully.... </div>");

                } else {

                    out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Error in deleting the pharmacist </div>");
                }

            } else if (action.equals("deleteTec")) {

                if (adminOperations.deleteTec(id)) {

                    out.print("  <div id='err' class='alert alert-success' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Tecnician deleted successfully.... </div>");

                } else {

                    out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Error in deleting tecnician </div>");
                }

            } else if (action.equals("saveTec")) {
                
                
                try {
                    
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date rDate = format.parse(dob);

                    Model model = new Model(0, fName, sName, pass, id, rDate);

                    if (adminOperations.updateTec(model)) {

                        out.print("  <div id='err' class='alert alert-success' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Tecnician updated successfully.... </div>");
                    } else {
                        out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Error in updating the tecnician </div>");
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(UDoperations.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            }

        } else {
            out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Field Empty</div>");
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
