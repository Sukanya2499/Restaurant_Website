# Restaurant Website README

Welcome to the Restaurant Website! This project provides a comprehensive solution for managing restaurant operations, including menu display, table booking, and user authentication. Below you will find details about the technologies used, features, and how to set up the project.

## Features

- **Menu Display**: Check out the menu to order food
- **Table Booking**: Reserve a table at your preferred time and date.
- **Download Booking Details**: Receive and download a summary of your booking.
- **User Authentication**: Secure login and registration for users.

## Technologies Used

- **HTML**: Structure of the website.
- **CSS**: Styling of the website to ensure a pleasant user experience.
- **Servlet**: Server-side processing for handling requests and responses.
- **MySQL**: Database management for storing user data, bookings, and menu information.
- **JDBC**: Java Database Connectivity for communication between the servlet and the MySQL database.

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or above
- Apache Tomcat or any other servlet container
- MySQL Server
- MySQL Workbench (optional, for database management)

### Setting Up the Database

1. **Create the Database**: 
   ```sql
   CREATE DATABASE restaurant;
   ```
2. **Create the Tables**:
   ```sql
   USE restaurant;

   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) NOT NULL,
       password VARCHAR(50) NOT NULL
   );

   CREATE TABLE bookings (
       id INT AUTO_INCREMENT PRIMARY KEY,
       user_id INT,
       date_time DATETIME,
       guests INT,
       FOREIGN KEY (user_id) REFERENCES users(id)
   );
   ```

### Configuring JDBC

1. **Download the MySQL JDBC Driver**: Obtain the driver from the MySQL website or Maven repository.
2. **Add the JDBC Driver to Your Project**: Place the driver `.jar` file in the `WEB-INF/lib` directory of your web application.

3. **Edit the `web.xml` Configuration File**: Add the necessary servlet and JSP configurations.

4. **Edit the `db.properties` File**: Configure your database connection settings. 

   ```properties
   db.url=jdbc:mysql://localhost:3306/restaurant
   db.username=root
   db.password=Tuku24@#
   ```

### Running the Project

1. **Deploy the Application**: Copy the WAR file to the `webapps` directory of your Apache Tomcat server.
2. **Start the Server**: Launch Apache Tomcat and navigate to `http://localhost:8080/your-web-app` in your browser.
3. **Access the Website**: You should see the home page of the restaurant website.

## Usage

1. **Browse the Menu**: Visit the menu page to view all available dishes.
2. **Book a Table**: Go to the booking page, select your preferred time and number of guests, and submit the form.
3. **Download Booking Details**: After booking, a summary of your reservation will be available for download.
4. **Register/Login**: Use the authentication features to create an account or log in.

## Troubleshooting

- **Database Connection Issues**: Verify the `db.properties` file for correct settings and ensure the MySQL server is running.
- **Servlet Errors**: Check server logs for specific errors and ensure all servlet mappings in `web.xml` are correct.

## Contribution

Feel free to fork this repository and submit pull requests. Any suggestions or improvements are welcome!

Thank you for using the Restaurant Website. We hope it meets your needs and provides a great user experience!

## ScreenShots

