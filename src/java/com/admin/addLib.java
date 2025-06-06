package com.admin;

import com.DBUtils.DBsingletone;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addLib", urlPatterns = {"/addLib"})
public class addLib extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            System.out.println("here");
            String libcode = request.getParameter("libcode");
            String libname = request.getParameter("libname");
            String area = request.getParameter("area");
            String place = request.getParameter("place");
            System.out.println("libcode: "+libcode+" libname: "+libname+" area: "+area+" place: "+place);
            boolean res = false;

            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();

            PreparedStatement ps = con.prepareStatement("select libcode from library where libcode='" + libcode + "' and isAssign=1");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Exisits");
                out.print(false);
            } else {
                PreparedStatement ps1 = con.prepareStatement("insert into library(libcode,libname,libarea,libplace) values(?,?,?,?)");
                ps1.setString(1, libcode);
                ps1.setString(2, libname);
                ps1.setString(3, area);
                ps1.setString(4, place);

                int i = ps1.executeUpdate();

                if (i == 1) {
                    res = true;
                }
                out.print(res);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
