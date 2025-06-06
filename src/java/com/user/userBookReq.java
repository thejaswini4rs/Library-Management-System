package com.user;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author SHIV
 */
@WebServlet(name = "userBookReq", urlPatterns = {"/userBookReq"})
public class userBookReq extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            String bookid = request.getParameter("bookid");
            String libryfk = request.getParameter("libryfk");
            String qty = request.getParameter("qty");
            boolean res = false;
            String uid = (String)session.getAttribute("uid");
            System.out.println(uid+" "+bookid + " " + libryfk + " " + qty);

            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();

            int finlqty = 0;

            finlqty = Integer.parseInt(qty) - 1;
            System.out.println("finlqty: " + finlqty);

            String up = "update books set qty='" + finlqty + "' where bkid='" + bookid + "'";
            PreparedStatement ps = con.prepareStatement(up);
            ps.executeUpdate();

            String ins = "insert into bokreq(rbkidfk,rlibryifk,ruidfk) values(?,?,?)";
            PreparedStatement psmt = con.prepareStatement(ins);
            psmt.setString(1, bookid);
            psmt.setString(2, libryfk);
            psmt.setString(3, uid);

            int i = psmt.executeUpdate();

            if (i > 0) {
                res=true;
            } else {
                res=false;
            }
            out.print(res);

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
