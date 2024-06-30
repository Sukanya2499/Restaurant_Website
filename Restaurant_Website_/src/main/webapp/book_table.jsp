<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Confirmation</title>
</head>
<body>
  <div class="main">
    <% 
      String name = request.getParameter("name1");
      String email = request.getParameter("email1");
      String date = request.getParameter("date1");
      String time = request.getParameter("time1");
      Random rand = new Random();
      int bookingId = rand.nextInt(90000) + 10000;

      // JDBC code to insert booking information into the database
      Connection conn = null;
      PreparedStatement ps = null;
      
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details_db", "root", "Tuku24@#");
          String sql = "INSERT INTO table_booking_info (name, date, time, booking_id) VALUES (?, ?, ?, ?)";
          ps = conn.prepareStatement(sql);
          
          ps.setString(1, name);
          ps.setDate(2, java.sql.Date.valueOf(date));
          ps.setTime(3, java.sql.Time.valueOf(time + ":00"));
          ps.setInt(4, bookingId);
          ps.executeUpdate();
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          if (ps!= null) {
              try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
          }
          if (conn != null) {
              try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
          }
      }
    %>
    
    <h2 id="welcome">Hi, <%= name %></h2>
    <h2>Your reservation at Calcutta 64 is confirmed!</h2>
    
    <h3 id="info">Where: Sector 5, Salt Lake<br><br>
                  Time: <%= time %><br><br>
                  Date: <%= date %><br><br>
                  Booking Id: <%= bookingId %>
    </h3>
    
    <form action="download" method="get">
      <input type="hidden" name="name" value="<%= name %>">
      <input type="hidden" name="email" value="<%= email %>">
      <input type="hidden" name="date" value="<%= date %>">
      <input type="hidden" name="time" value="<%= time %>">
      <input type="hidden" name="bookingId" value="<%= bookingId %>">
      <button type="submit">Download</button>
    </form>
  </div>
</body>
</html>
