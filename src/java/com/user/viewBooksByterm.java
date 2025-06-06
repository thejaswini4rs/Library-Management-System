package com.user;

import com.DBUtils.DBsingletone;
import com.google.gson.Gson;
import com.pojo.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet(name = "viewBooksByterm", urlPatterns = {"/viewBooksByterm"})
public class viewBooksByterm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            ArrayList<String> list = new ArrayList<String>();
            String data;
            String term = request.getParameter("term");

            System.out.println("term: " + term);

            PreparedStatement ps = con.prepareStatement("SELECT * FROM books  WHERE bkname  LIKE ?");
            ps.setString(1, term + "%");
            ResultSet rs = ps.executeQuery();

//            while (rs.next()) {
////                JSONObject obj = new JSONObject();
//                Book bk = new Book();
//
//                bk.setBookid(rs.getString("bkid"));
//                bk.setBookname(rs.getString("bkname"));
//
////                data = rs.getString("bkname");
////                data = rs.getString("bkid");
//                list.add(bk);
//            }
            while (rs.next()) {
                data = rs.getString("bkname");
                list.add(data);
            }
            String searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);
//            JSONObject json = new JSONObject();
//
//            System.out.println("Size of order Connecter :" + list.size());
//            String josnorderlist = new Gson().toJson(list);
//
//            System.out.println("The json String of order is :" + josnorderlist);
//
//            json.put("order", josnorderlist);
//            out.print(json);            

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
