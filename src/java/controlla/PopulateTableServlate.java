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

/**
 *
 * @author toni
 */
public class PopulateTableServlate extends HttpServlet {

    private AdminOperations adminOperations;

    public PopulateTableServlate() {
        adminOperations = new AdminOperations();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equals("populateDoctors")) {
            
            //System.out.println(adminOperations.getDocs());
            request.setAttribute("docs", adminOperations.getDocs());
            request.getRequestDispatcher("Doctor.jsp").forward(request, response);

        } else if (action.equals("populateReceptionists")) {

            request.setAttribute("recs", adminOperations.getReceptionists());
            request.getRequestDispatcher("Receptionist.jsp").forward(request, response);

        } else if (action.equals("populatePharmacist")) {

            request.setAttribute("ps", adminOperations.getPharmacists());
            request.getRequestDispatcher("Pharmacist.jsp").forward(request, response);

        } else if (action.equals("populateTec")) {
            
            request.setAttribute("tecs", adminOperations.getTecgnicians());
            request.getRequestDispatcher("Technician.jsp").forward(request, response);
        } else if(action.equals("populateDocView")){
        
     
            request.setAttribute("docs", adminOperations.getDocs());
            request.getRequestDispatcher("viewDoctor.jsp").forward(request, response);
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
