/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlla;

import dao.AdminDAO;
import model.AdminModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toni
 */
public class LoginServlet extends HttpServlet {

    AdminDAO adminDAO = new AdminDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user_name = request.getParameter("user_id");
        String password = request.getParameter("password");

        String message = "";
        
        

        if (user_name.isEmpty() || password.isEmpty()) {
            message = "<div class='alert alert-danger' style='margin-top: 10px; margin-bottom: 20px;'> Fields cannot be empty </div>";
            request.setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            
            int result = adminDAO.checkLogin(user_name, password);

            if (result == 0) {
                message = "<div class='alert alert-danger alert-dismissible' role='alert' style='margin-top: 10px;'>"
                        + "  <button type= 'button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>"
                        + "  Error! Wrong credentials entered"
                        + "</div>";
                request.setAttribute("message", message);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                
            }else{
                
                int number = adminDAO.getDoctorsTotal();
                int p_Number  = adminDAO.getPharmacistTotal();
                int t_Number = adminDAO.getTechnicianTotal();
                int r_Number = adminDAO.getReceptionistTotal();
                
                
                AdminModel adminModel = new AdminModel(result, user_name, password,number,p_Number,t_Number,r_Number);
              
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("admin", adminModel);
//                httpSession.setMaxInactiveInterval(30*60);
                
                response.sendRedirect("MainPanel.jsp");
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

