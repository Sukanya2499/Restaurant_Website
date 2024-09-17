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


![Screenshot (87)](https://github.com/user-attachments/assets/fbe110b5-913e-4df2-89d2-85297498c39c)




![Screenshot (83)](https://github.com/user-attachments/assets/c2684955-ada6-452d-aee5-a780f8769564)





![Screenshot (85)](https://github.com/user-attachments/assets/c02edfaa-fa29-455c-8e64-97ceab8825d7)






![Screenshot (89)](https://github.com/user-attachments/assets/82c28b81-57d4-4ae2-ab13-c45eefb1cf3d)







![Screenshot (88)](https://github.com/user-attachments/assets/48b09c3a-b770-4247-b1ed-d4fcc3cfe616)





![Screenshot (93)](https://github.com/user-attachments/assets/b0f0a74f-41fa-4162-ac0f-f2e8b92f11e4)




![Screenshot (92)](https://github.com/user-attachments/assets/625e53ed-32a2-4d99-ad12-6a80f427d1b1)




![Screenshot (91)](https://github.com/user-attachments/assets/4f9e0961-0e4d-4a2d-ae4f-a901af37bac6)





![Screenshot (90)](https://github.com/user-attachments/assets/65a86c98-ef64-4cf5-b0f6-5b13a9c4c220)




![Screenshot (86)](https://github.com/user-attachments/assets/770aafdd-2eed-404f-8f22-8026321035c3)

