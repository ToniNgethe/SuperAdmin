/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlla;

import dao.AdminOperations;
import model.Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toni
 */
public class AddPharmacist extends HttpServlet {
    
    AdminOperations adminOperations ;
    
    public AddPharmacist(){
       adminOperations = new AdminOperations();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        String id = request.getParameter("p_ID");
        String fName = request.getParameter("p_fName");
        String sName = request.getParameter("p_lName");
        String pass = request.getParameter("p_pass");

        String dob = request.getParameter("p_dob");

        PrintWriter out = response.getWriter();

        if (id.isEmpty() || fName.isEmpty() || sName.isEmpty() || pass.isEmpty() || dob.isEmpty()) {
            
            out.print("  <div id='err' class='alert alert-danger' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Error !Fields are empty </div>");
            
        } else {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            try {
                //convert string input to date
                java.util.Date result = format.parse(dob);

                //add details to model
                Model doctorModel = new Model(0, fName, sName, pass, id, result);

                //check if doc exists
                if (!adminOperations.checkPharmacist(doctorModel)) {

                    //if does not exist,,,add him/her
                    if (adminOperations.addPharmacist(doctorModel)) {
                        
                        out.print("  <div id='err' class='alert alert-success' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Pharmacist added successfully.... </div>");
                        
                    } else {
                        out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >Error in adding the Pharmacist </div>");
                    }

                } else {
                    out.print("  <div id='err' class='alert alert-danger' role='alert' style='margin-right: 20px; margin-left: 20px; margin-top: 10px;' >A Pharmacist with that id already exists.. </div>");
                }

            } catch (ParseException ex) {
                Logger.getLogger(AddDoctorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
