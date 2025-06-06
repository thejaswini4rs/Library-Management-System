
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
import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet(name = "getNotifictn", urlPatterns = {"/getNotifictn"})
public class getNotifictn extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String bookid  = request.getParameter("bkid");            
            String uid  = request.getParameter("uid"); 
            System.out.println("bookid : "+bookid+" uid: "+uid);
            
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
                        
            String query = "SELECT * FROM USER u, bokreq br, books b WHERE u.uid=br.ruidfk AND uid='"+uid+"' AND bkid='"+bookid+"' AND br.rbkidfk=b.bkid AND isReq=0";
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
                obj.put("author", rs.getString("bauthr"));
                obj.put("price", rs.getString("price"));
                obj.put("bkimg", rs.getString("bkimg"));
                obj.put("duedate", rs.getString("duedate"));
                
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
