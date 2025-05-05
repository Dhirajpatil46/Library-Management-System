
Library Management System (Spring Boot + Thymeleaf)

A web-based Library Management System built using Spring Boot MVC, Thymeleaf, and Oracle 19c. This system includes two user roles: Admin and User, with different access and functionality.

=====================================================
Prerequisites
=====================================================

System Requirements:
- JDK 17
- Apache Tomcat 11
- Oracle Database 19c
- Maven 3.6+
- Spring Boot 3.x

-----------------------------------------------------
Database Tables (Oracle 19c)
-----------------------------------------------------

user11 Table:
-------------
DESC user11;

ID         NUMBER(10)     NOT NULL  - Primary key
MAIL       VARCHAR2(255)  NULL      - User email
NAME       VARCHAR2(255)  NULL      - User name
PASSWORD   VARCHAR2(255)  NULL      - User password
PHONENO    VARCHAR2(255)  NULL      - User phone number

books Table:
-------------
DESC books;

BOOK_ID        VARCHAR2(255)  NOT NULL - Book ID (Primary)
TITLE          VARCHAR2(255)  NOT NULL - Book title
AUTHOR         VARCHAR2(255)  NOT NULL - Author name
PUBLISHED_YEAR VARCHAR2(255)  NULL     - Year of publication
QUANTITY       VARCHAR2(255)  NULL     - Available stock
PRICE          VARCHAR2(255)  NULL     - Book price

admin1 Table:
-------------
DESC admin1;

ID        NUMBER(10)    NOT NULL - Primary key
AEMAIL    VARCHAR2(25)  NULL     - Admin email
PASSWORD  VARCHAR2(25)  NULL     - Admin password
ANAME     VARCHAR2(25)  NULL     - Admin name
ADDRESS   VARCHAR2(25)  NULL     - Admin address
APHONENO  VARCHAR2(25)  NULL     - Admin phone number

=====================================================
Login Roles
=====================================================

Admin Panel:
- Login
- Add Book
- View Books
  - Edit Book Info
  - Delete Book
- Logout

User Panel:
- Login
- View Books
  - Buy Book (reduces quantity)
- Logout

=====================================================
Tech Stack
=====================================================

- Java 17
- Spring Boot (MVC)
- Thymeleaf
- Spring Data JPA
- Oracle 19c
- Apache Tomcat 11
- Maven

=====================================================
How to Run
=====================================================

1. Clone the Repository:
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system

2. Configure application.properties:
   ----------------------------------
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
   spring.datasource.username=your_db_user
   spring.datasource.password=your_db_password
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect

3. Build & Run:
   ./mvnw spring-boot:run

4. Access in Browser:
   http://localhost:8080/

=====================================================
Default Credentials (Optional)
=====================================================

| Role  | Username | Password |
|-------|----------|----------|
| Admin | admin    | admin123 |
| User  | user     | user123  |

