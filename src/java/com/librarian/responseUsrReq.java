/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.librarian;

import com.DBUtils.DBsingletone;
import com.action.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "responseUsrReq", urlPatterns = {"/responseUsrReq"})
public class responseUsrReq extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        boolean res = false;
        try {
            String bookid = request.getParameter("bkid");
            String uid = request.getParameter("uid");
            System.out.println("Bookid: " + bookid + " uid: " + uid);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            String librnid = (String) session.getAttribute("librnid");
            System.out.println("Librarian Id: " + librnid);
            Calendar c = Calendar.getInstance();
            Date now = new Date();
            Date date = new Date();
            c.setTime(now);
            c.add(Calendar.DATE, 5);
            now = c.getTime();
            String givendate = formatter.format(date);
            String duedate = formatter.format(now);
            SendMail sm = new SendMail();

            System.out.println("givendate: " + givendate + " duedate: " + duedate);

            String query = "update bokreq set isReq=0, curntdate='" + givendate + "', duedate='" + duedate + "' where rbkidfk='" + bookid + "'";
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            if (i > 0) {                
                System.out.println("inside i");
                String query1 = "SELECT * FROM USER u, books b, bokreq br WHERE u.uid=br.ruidfk AND br.rlibryifk=b.libryidfk AND br.rbkidfk=b.bkid AND isReq=0 AND b.librnidfk='" + librnid + "' AND u.uid='" + uid + "'";
                PreparedStatement ps1 = con.prepareStatement(query1);
                ResultSet rslt = ps1.executeQuery();
                if (rslt.next()) {
                    res = true;
                    String uemail = rslt.getString("uemail");
                    String bkname = rslt.getString("bkname");
                    String due = rslt.getString("duedate");
                    System.out.println("EMAIL: " + uemail+" bkname: "+bkname+" duedate: "+due);
                    sm.SendTo(rslt.getString("uemail"), rslt.getString("bkname"), rslt.getString("duedate"), "Thank you for your's interest...\nThe Book Details requested by is provided below\n\nBook Name: " + rslt.getString("bkname") + "\nDue Date: " + rslt.getString("duedate"));
                } else {
                    res = false;
                }
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
