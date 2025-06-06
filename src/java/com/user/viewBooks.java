
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


@WebServlet(name = "viewBooks", urlPatterns = {"/viewBooks"})
public class viewBooks extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            List<Book> allbooks = new ArrayList<Book>();
            
            String query = "select * from books";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Book bk = new Book();

                bk.setBookname(rs.getString("bkname"));
                bk.setAuthor(rs.getString("bauthr"));
                bk.setIsbn(rs.getString("isbn"));
                bk.setPrice(rs.getString("price"));
                bk.setQty(rs.getString("qty"));
                bk.setBookimg(rs.getString("bkimg"));                
                
                allbooks.add(bk);
            }
            JSONObject res = new JSONObject();
            
            System.out.println("Size: " + allbooks.size());
            String jsonorderlist = new Gson().toJson(allbooks);

            System.out.println("The json String of order is :" + jsonorderlist);

            res.put("books", jsonorderlist);
            System.out.println("res=" + res);
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
