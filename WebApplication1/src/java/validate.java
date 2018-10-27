import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class validate extends HttpServlet {
 
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
        boolean login = false;
 
        Statement st;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected!"); 
            String jname = req.getParameter("user");
            String jpass = req.getParameter("pwd");
            String query = "SELECT name, password FROM register";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                String u_name = rs.getString("name");
                String pass_wd = rs.getString("password");

                if(u_name.equals(jname) && pass_wd.equals(jpass)){
                    login = true;
                    out.print("suc");
                }
                System.out.println("Success");
                
            }
            
            if(login){
                RequestDispatcher view = req.getRequestDispatcher("/enquiry.html");
                view.forward(req, res);
                conn.close();
            }
            else {
                out.println("<h>Incorrect Password or Username</h>");
        }
            
            
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            out.print(e);
            System.out.print("ff");
            e.printStackTrace();
        }
    }
    
@Override
    public String getServletInfo() {
        return "Short description";
    }
}