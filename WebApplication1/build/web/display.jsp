<%@ page import="java.util.*" %>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
<head>
<title>MyLib</title>

<!--////////////////////////////////////////////////////////////////-->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <!--Custom CSS-->
<link href="styles/style.css" rel="stylesheet" type="text/css"/>
<!--////////////////////////////////////////////////////////////////-->


</head>

<body>
  <div class="mainscreen">

   
</div>

<div style="padding-left:20px">
  <h1></h1></div>
  <!----------------------------------------------------------------------------->

 <table width="700px" align="center"
        style="border:1px solid #000000;" class="table table-bordered">
            <tr>
                <td colspan=7 align="center"
                    style="background-color:#FA2379">
                    <b>Available Buses</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Source</b></td>
                <td><b>Destination</b></td>
                <td><b>Date</b></td>
                <td><b>Departure Time</b></td>
                <td><b>Arrival Time</b></td>
                <td><b>Bus Name</b></td>
                <td><b>Action</b></td>
            </tr>
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (request.getAttribute("bslist") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("bslist");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
                        count ++;
                        ArrayList bus = (ArrayList) itr.next();
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=bus.get(0)%></td>
                <td><%=bus.get(1)%></td>
                <td><%=bus.get(2)%></td>
                <td><%=bus.get(3)%></td>
                <td><%=bus.get(4)%></td>
                <td><%=bus.get(5)%></td>
            <form action="Book" method="post">
                <input type="hidden" name="busid" value="<%=bus.get(6)%>" >
                <td><input type="submit" value="Book"></td>
            </tr>
            <%
                    }
                }
                if (count == 0) {
            %>
            <tr>
                <td colspan=4 align="center"
                    style="background-color:#eeffee"><b>Sorry no bus available!</b></td>
            </tr>
            <%            }
            %>
        </table>
  
  
  
  

</div>
</body>
</html>