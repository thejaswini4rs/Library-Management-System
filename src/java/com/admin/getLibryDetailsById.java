
package com.admin;

import com.DBUtils.DBsingletone;
import com.google.gson.Gson;
import com.pojo.getLibraries;
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

@WebServlet(name = "getLibryDetailsById", urlPatterns = {"/getLibryDetailsById"})
public class getLibryDetailsById extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String libid = request.getParameter("libid");
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            List<getLibraries> libs = new ArrayList<getLibraries>();

            String query = "select * from library where libid='"+libid+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                getLibraries lib = new getLibraries();

                lib.setLibid(rs.getInt("libid"));
                lib.setLibcode(rs.getString("libcode"));
                lib.setName(rs.getString("libname"));
                lib.setArea(rs.getString("libarea"));
                lib.setPlace(rs.getString("libplace"));

                libs.add(lib);
            }
            JSONObject res = new JSONObject();

            System.out.println("Size: " + libs.size());
            String jsonorderlist = new Gson().toJson(libs);

            System.out.println("The json String of order is :" + jsonorderlist);

            res.put("libraries", jsonorderlist);
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
