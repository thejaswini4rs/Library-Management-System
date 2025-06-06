package com.librarian;

import com.DBUtils.DBsingletone;
import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "addBook", urlPatterns = {"/addBook"})
@MultipartConfig(maxFileSize = 16177215)
public class addBook extends HttpServlet {

    private static double kilobytes;
    private static String extension = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();

            String bkname = request.getParameter("bkname");
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            String price = request.getParameter("price");
            String qty = request.getParameter("qty");
            String librnid = (String)session.getAttribute("librnid");
            String libryid = (String)session.getAttribute("libid");
            String des = "";

            System.out.println("librnid: "+librnid+" libryid:"+libryid+" bkname: " + bkname + " author: " + author + " isbn: " + isbn + " price: " + price + " qty: " + qty);

            String lang = "";
            Part filePart = request.getPart("file");
            String filename = getFileName(filePart);
            des = lang + filename;

            final String UPLOAD_DIRECTORY = "BookImgs";
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
                String query = "insert into books(bkname,bauthr,isbn,price,qty,bkimg,librnidfk,libryidfk) values(?,?,?,?,?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, bkname);
                ps.setString(2, author);
                ps.setString(3, isbn);
                ps.setString(4, price);
                ps.setString(5, qty);
                ps.setString(6, lang + filename);
                ps.setString(7, librnid);
                ps.setString(8, libryid);                

                int j = ps.executeUpdate();

                if (j > 0) {
                    String txt = "Book Added";
                    response.sendRedirect("librarian/confirm.jsp?id=addBook&txt=" + txt + "");
                } else {
                    out.print("<script>alert(\"Failed to add Book\");window.location.href='librarian/addLib.jsp'</script>");
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
