# -electronic-student-directory
Based on Java ,java swing, java awt ,JDBC and MYSQL, the electronic student directory allows the owner of the directory to log in with an account and password. They can view the relevant information and contact details of past classmates, add or delete classmates' information, and also update the information of the classmates.

# tech stack
1.JAVASE

2.java swing

3.java awt

4.MYSQL

5.JDBC

# Description of the system frame
1. DAO : (Database-related operations)
   
      1) studentDAO : SQL statements such as querying, obtaining student information, total, and adding students
   
      2) userDAO : SQL statements to obtain the ID and password of the logon user for login
   
2. entity :
   
      Attributes of logged-in users and students, as well as the get and set methods
   
3. image :
   
      background images for graphical interfaces, etc
   
4. JFrame :
   
       1) Login JF
   
       2) The main interface where classmates' information is displayed
   
       3) The interface to add information
   
5. utils :
   
       1) JDBCutil: Database connection and shutdown operations
   
       2) pageModel: update the information of students displayed on the main JF, and it is easy to switch between pages
   
       3) studentTableModel: make the  table easy to generate information about your classmates
   
