
package com.admin;

import com.DBUtils.DBsingletone;
import com.google.gson.Gson;
import com.pojo.getLibrnDetails;
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

@WebServlet(name = "getLibDetailsById", urlPatterns = {"/getLibDetailsById"})
public class getLibDetailsById extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String librnid = request.getParameter("id");
            System.out.println("Libid: "+librnid);
            List<getLibrnDetails> listdet = new ArrayList<getLibrnDetails>();
            
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            
            String query = "select * from librarian where lid='"+librnid+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            JSONObject res = new JSONObject();
            
             while (rs.next()) {
//                JSONObject obj = new JSONObject();
                  getLibrnDetails libdata = new getLibrnDetails();
//                obj.put("email", rs.getString("email"));
//                obj.put("dob", rs.getString("dob"));
//                obj.put("mob", rs.getString("mob"));
//                obj.put("place", rs.getString("place"));
//                obj.put("pic", rs.getString("pic"));
                  
                  libdata.setName(rs.getString("name"));
                  libdata.setEmail(rs.getString("email"));
                  libdata.setDob(rs.getString("dob"));
                  libdata.setMob(rs.getString("mob"));
                  libdata.setPlace(rs.getString("place"));
                  libdata.setPic(rs.getString("pic"));
                            
                  listdet.add(libdata);                  
            }
             JSONObject json = new JSONObject();
//            res.put("res", json);
//            JSONArray output = res.getJSONArray("res");
//            System.out.println("outut: "+output);
//            out.print(output);
                System.out.println("Size of order Connecter :" + listdet.size());
                String josnorderlist = new Gson().toJson(listdet);
                
                System.out.println("The json String of order is :" + josnorderlist);
                
                json.put("order", josnorderlist);
                out.print(json);
                
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
