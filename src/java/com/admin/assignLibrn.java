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

@WebServlet(name = "assignLibrn", urlPatterns = {"/assignLibrn"})
public class assignLibrn extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        boolean res = false;
        try {
            String libryid = request.getParameter("libryid");
            String libcode = request.getParameter("libcode");
            String librnid = request.getParameter("librnid");

            System.out.println("libryid: " + libryid + " libcode: " + libcode + " librnid: " + librnid);
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            //            SendMail sm = new SendMail();

            String query = "update librarian set isActive=1 where lid='" + librnid + "'";
            PreparedStatement ps = con.prepareStatement(query);
            int k = ps.executeUpdate();

            if (k > 0) {
                String query1 = "insert into assignedlibs(libidfk, librnidfk) values(?,?)";
                PreparedStatement ps1 = con.prepareStatement(query1);
                ps1.setString(1, libryid);
                ps1.setString(2, librnid);

                int i = ps1.executeUpdate();

                if (i > 0) {
                    String query2 = "update library set isAssign=1 where libid='" + libryid + "'";
                    PreparedStatement psmt = con.prepareStatement(query2);
                    int j = psmt.executeUpdate();
                    if (j > 0) {
                        String query3 = "SELECT * FROM librarian l, library lb, `assignedlibs` a WHERE l.lid=a.librnidfk AND a.libidfk=lb.libid AND lid='" + librnid + "'";
                        PreparedStatement psm = con.prepareStatement(query3);
                        ResultSet rs2 = psm.executeQuery();
                        if (rs2.next()) {
                            String email = rs2.getString("email");
                            String libname = rs2.getString("libname");
                            System.out.println("here123--------" + email + " Libcode: 123 " + libcode + " libname: " + libname);
//                        sm.SendTo(rs2.getString("email"), rs2.getString("libcode"), rs2.getString("libname"), "You are successfully assigned to " + rs2.getString("libname") + " Library..\nUse the below provided library code login your account \n\nLibrary Code: " + rs2.getString("libcode") + "\nLibrary Name: " + rs2.getString("libname"));
                            res = true;
                        } else {
                            res = false;
                        }
                    }
                    out.print(res);
                }
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
