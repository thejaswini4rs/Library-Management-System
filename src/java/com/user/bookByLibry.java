/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

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

/**
 *
 * @author SHIV
 */
@WebServlet(name = "bookByLibry", urlPatterns = {"/bookByLibry"})
public class bookByLibry extends HttpServlet {

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
        
        try {
            String libname = request.getParameter("libname");
            System.out.println("libname: "+libname);
            
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
                        
            String query = "SELECT * FROM library l, books b WHERE l.libid=b.libryidfk AND l.libname='"+libname+"' AND b.qty>0";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            JSONObject res = new JSONObject();
            JSONArray json = new JSONArray();
            
            while(rs.next()){
                JSONObject obj = new JSONObject();
                
                obj.put("bkid", rs.getString("bkid"));
                obj.put("bkname", rs.getString("bkname"));
                obj.put("bauthr", rs.getString("bauthr"));
                obj.put("isbn", rs.getString("isbn"));
                obj.put("price", rs.getString("price"));
                obj.put("qty", rs.getString("qty"));
                obj.put("bkimg", rs.getString("bkimg"));
                obj.put("librnidfk", rs.getString("librnidfk"));
                obj.put("libryidfk", rs.getString("libryidfk"));
                obj.put("libcode", rs.getString("libcode"));
                obj.put("libname", rs.getString("libname"));
                
                json.put(obj);
            }
            res.put("books", json);
            JSONArray result = res.getJSONArray("books");
            System.out.println("Books: "+result);
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
