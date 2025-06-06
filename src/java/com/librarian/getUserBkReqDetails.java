
package com.librarian;

import com.DBUtils.DBsingletone;
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
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "getUserBkReqDetails", urlPatterns = {"/getUserBkReqDetails"})
public class getUserBkReqDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String bookid  = request.getParameter("bkid");            
            System.out.println("bookid : "+bookid);
            
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
                        
            String query = "SELECT * FROM USER u, books b, bokreq br WHERE u.uid=br.ruidfk AND br.rlibryifk=b.libryidfk AND br.rbkidfk=b.bkid AND bkid='"+bookid+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            JSONObject res = new JSONObject();
            JSONArray json = new JSONArray();
            
            while(rs.next()) {
                JSONObject obj = new JSONObject();
                
                obj.put("uname", rs.getString("uname"));
                obj.put("uemail", rs.getString("uemail"));
                obj.put("umob", rs.getString("umob"));
                obj.put("bkname", rs.getString("bkname"));
                obj.put("price", rs.getString("price"));
                obj.put("bkimg", rs.getString("bkimg"));
                obj.put("place", rs.getString("uplace"));
                
                json.put(obj);
            }
            res.put("details", json);
            JSONArray result = res.getJSONArray("details");
            System.out.println("details: "+result);
            out.print(result);
            
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
