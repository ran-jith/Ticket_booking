import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class register extends HttpServlet {
 
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "db";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
 
        Statement st;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected!");
            String jname = req.getParameter("name");
            String jaddress = req.getParameter("add");
            String jgender = req.getParameter("gg");
            String jage = req.getParameter("age");
            String jcontact = req.getParameter("cn");
            String jmail = req.getParameter("em");
            String jpass = req.getParameter("pw");
            String query = "Insert into register(name,address,gender,age,contact,email,password) values('"+jname+"','"+jaddress+"','"+jgender+"','"+jage+"','"+jcontact+"','"+jmail+"','"+jpass+"')";
            st = conn.createStatement();
            st.executeUpdate(query);
            
           
       
           out.println("Successfully registered");
            conn.close();
            System.out.println("Disconnected!");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            out.print(e);
            e.printStackTrace();
        }
}    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}