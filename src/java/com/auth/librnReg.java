
package com.auth;

import com.DBUtils.DBsingletone;
import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(name = "librnReg", urlPatterns = {"/librnReg"})
@MultipartConfig(maxFileSize = 16177215)
public class librnReg extends HttpServlet {
  private static double kilobytes;
    private static String extension = "";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            
            String uname = request.getParameter("name");
            String uemail = request.getParameter("email");
            String upass = request.getParameter("pass");
            String umob = request.getParameter("mob");
            String uplace = request.getParameter("place");
            String upin = request.getParameter("pin");
            
            String des = "";
            
            String lang = "";
            Part filePart = request.getPart("file");
            String filename = getFileName(filePart);
            des = lang + filename;

            final String UPLOAD_DIRECTORY = "LibrnImgs";
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
            String upload = uploadPath.replace("build\\", "");

            System.out.println("Your dir details :" + upload + "\\" + filename);

            File fileSaveDir = new File(upload);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdirs();
            }
            if (fileSaveDir.exists()) {
                double bytes = fileSaveDir.length();
                kilobytes = (bytes / 1024);
                System.out.println("bytes=" + bytes + "kilobytes=" + kilobytes);
            }
            int i = des.lastIndexOf('.');
            int p = Math.max(des.lastIndexOf('/'), des.lastIndexOf('\\'));

            if (i > p) {
                extension = des.substring(i + 1);
                System.out.println("extention of the file=" + extension);
            }

            FilePermission permission;
            permission = new FilePermission(upload, "read");

            for (Part part : request.getParts()) {
                part.write(upload + "\\" + des);
            }
            System.out.println("FileName: " + filename);
            
            try {
                String query = "select email from librarian where email='" + uemail + "'";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs = psmt.executeQuery();
                
                if (rs.next()) {
                    out.print("<script> alert('Email Already Exists'); window.history.back(); </script>");
                } else {
                    String sql = "insert into librarian(name,email,pswd,mob,place,pin,pic) values (?,?,?,?,?,?,?)";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, uname);
                    ps.setString(2, uemail);
                    ps.setString(3, upass);
                    ps.setString(4, umob);
                    ps.setString(5, uplace);
                    ps.setString(6, upin);
                    ps.setString(7, lang + filename);

                    int j = ps.executeUpdate();

                    if (j > 0) {
                        out.print("<script> alert('Registration Successfully'); window.location.href='librarian.jsp'; </script>");
                    } else {
                        out.print("<script> alert('Registration Failed'); window.location.href='librarian.jsp'; </script>");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("file")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
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
