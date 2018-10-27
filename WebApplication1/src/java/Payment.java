import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Payment extends HttpServlet {
 
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
            int num = 0;
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected!"); 
            String jbusid = req.getParameter("busid");
            int reqs = Integer.parseInt(req.getParameter("reqnum"));
            
            String query = "SELECT * FROM Untitled where busid='"+jbusid+"'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                num = rs.getInt("Totalseats");
                
            
            }
            if(reqs>6){
                out.println("You can only book 5 seats at a time!");
            }
            else if(reqs>num){
                out.println("No seats available!");
            }
            else if(num == 0){
                out.println("Sorry, No seats available!");
            }
            else {
                String query2 = "update Untitled set Totalseats = Totalseats - '"+ reqs +"'";
                out.println("Success");
                st.executeUpdate(query2);
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