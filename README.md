# ATM-Interface
- [Run the project](#run-the-project)
- [Project Structure](#project-structure)
- [Project](#project)

### Project Structure

  #### 1. Class Diagram

  ![](/resources/Class_diagram.png)
  
  #### 2. Entity Relationship Diagram

  ![](/resources/ER_diagram.png)
  
  ### Project
  
    This is a menu-driven applictaion based on developing an ATM 
    (Automated Teller Machine) using “Java Programming Language".   
    
    To use into the system user need to enter his registered user ID. 
    If he is registered then the program will ask him to enter his card 
    number followed by his PIN number.
 
    After entering the correct credentials, user will be provided with various choices such as
 
    1. Change PIN
    2. Show Account Balance
    3. Perform Transaction
    4. Show Account Transaction History
    5. Quit
    
### Run the Project

  1. In base/Connect.java and base/Database.java replace with following

  > static final String user = "root"

  > static final String password = "your_root_sql_password"

    or *add user* with given specifiactions


  2. On Linux/Unix environments use given commands from within
  the project's directory.

  > chmod +x ./run.sh

  > ./run.sh
