package com.auth;

import com.DBUtils.DBsingletone;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "librarian", urlPatterns = {"/librarian"})
public class librarian extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            HttpSession session = request.getSession();
            if (request.getParameter("login") != null) {
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                String libcode = request.getParameter("libcode");

                String sql = "SELECT * FROM librarian l, assignedlibs a, library lb WHERE l.`lid`=a.`librnidfk` AND lb.`libid`=a.`libidfk` and email='" + email + "' and pswd='" + pass + "' and lb.libcode='" + libcode + "'";

                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    session.setAttribute("librnid", rs.getString("lid"));
                    session.setAttribute("librnname", rs.getString("name"));
                    session.setAttribute("libid", rs.getString("libid"));                    
                    response.sendRedirect("librarian/librnHome.jsp");
                } else {
                    out.print("<script> alert('Invalid Email / Password / Code..Please Try Again'); window.history.back(); </script>");
                }
            }

            if (request.getParameter("register") != null) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                String dob = request.getParameter("dob");
                String mob = request.getParameter("mob");                
                String place = request.getParameter("place");
                String sql = "insert into librarian(name,email,pswd,dob,mob,place,pin,pic) values (?,?,?,?,?,?)";
                PreparedStatement psmt = con.prepareStatement(sql);

                    psmt = con.prepareStatement(sql);
                    psmt.setString(1, name);
                    psmt.setString(2, email);
                    psmt.setString(3, pass);
                    psmt.setString(4, dob);
                    psmt.setString(5, mob);
                    psmt.setString(6, place);
                    int i = psmt.executeUpdate();
                    if (i > 0) {
                        out.print("<script> alert('Registration Successfull'); window.location.href='user/index.jsp'; </script>");
                    } else {
                        out.print("<script> alert('Registration Failed'); window.location.href='user/index.jsp'; </script>");
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
