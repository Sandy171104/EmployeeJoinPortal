package main_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeJoin_dbms {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        int choice;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employee_db";
            String user = "root";
            String pass ="9361";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to Database!");
        do {                                          
            System.out.println("============ Employee Job Portal ===========");
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Report/Analytics");
            System.out.println("6. Update Employee");
            System.out.println("7. Exit");

            String input;
            int count;
            do {
            System.out.print("\nEnter your choice: ");
            input = sc.nextLine();
            
            
            if(!input.matches("\\d+")){
            	System.err.println("Invalid input! Please enter numbers only.");
            }
            }
            while(!input.matches("\\d+"));
        	choice=Integer.parseInt(input);
   
            if (choice == 1) {    
            	do {
            		System.out.print("How may employees do you want to enter? ");
                    input = sc.nextLine();
                    if(!input.matches("\\d+")){
                    	System.err.println("Invalid input! Please enter numbers only.");
                    }
            	}
            	while(!input.matches("\\d+"));
            	count=Integer.parseInt(input);

 
                int i = 0;
                for (i = 0; i < count; i++) {         
                    System.out.println("\n====== Enter details of Employee " + (i + 1) + " ======");
                    
                    String name;
                    do {                              
                        System.out.print("\nEnter name: ");
                        name = sc.nextLine();
                        if (!name.matches("[a-zA-Z. ]+")) {
                            System.err.println("Invalid name! Only letters and spaces allowed.");
                        } else {
                            break;
                        }
                    } while (true);   
                    int age;
                    do {
                    	System.out.print("Enter age (18 to 60): ");
                        String ageInput=sc.nextLine();
                    try {
                    	age=Integer.parseInt(ageInput);
                    	if(age<18||age>60) {
                    		System.err.println("Invalid age! Age must be between 18 to 60.");
                    		age=0;
                    	}else {
                    		break;
                    	}
                    }catch(Exception e) {
                    	System.err.println("Invalid input please enter numbers only.");
                       age=0;
                    }
                    }while(age==0);
                    String dob;
                    do {
                    System.out.print("Enter Date Of Birth(YYYY-MM-DD): ");
                    dob = sc.nextLine();
                    if(!(dob.length()==10&&dob.charAt(4)=='-'&&dob.charAt(7)=='-')) {
                    	System.err.println("Invalid! Please enter in YYYY-MM-DD format.");
                    }else {
                    	break;
                    }
                    }while(true);
                    String gender;
                    do {                             
                        System.out.println("Select Gender:");
                        System.out.println("1.Male");
                        System.out.println("2.Female");
                        System.out.println("3.other");
                        System.out.print("Enter Choice(1-3): ");
                        String Choice = sc.nextLine();
                        switch (Choice) {             
                            case "1":
                                gender = "Male";
                                break;
                            case "2":
                                gender = "Female";
                                break;
                            case "3":
                                gender = "Other";
                                break;
                            default:
                                System.err.println("Invalid choice! Try again.");
                                continue;
                        }                             
                        break;
                    } while (true);                   
                    String mobile_no;
                    do {                              
                        System.out.print("Enter Phone number: ");
                        mobile_no = sc.nextLine();
                        if (mobile_no.length() == 10) {
                            if (mobile_no.startsWith("6") || mobile_no.startsWith("7") ||
                                mobile_no.startsWith("8") || mobile_no.startsWith("9")) {
                                break;
                            } else {
                                System.err.println("Phone number must starts with 6,7,8,or 9");
                            }
                        } else {
                            System.err.println("Phone number must have exactly 10digits numbers");
                        }
                    } while (true);   
                    String email_id;
                    do {                              
                        System.out.print("Enter Email Id: ");
                        email_id = sc.nextLine();
                        if (email_id.endsWith("@gmail.com")) {
                            if (email_id.indexOf("@") == email_id.lastIndexOf("@")) {
                                if (!(email_id.contains(" ") || email_id.contains(",") ||
                                      email_id.contains("!") || email_id.contains("#") ||
                                      email_id.contains("$") || email_id.contains("%") ||
                                      email_id.contains("^") || email_id.contains("&") ||
                                      email_id.contains("*") || email_id.contains("(") ||
                                      email_id.contains(")") || email_id.contains("`") ||
                                      email_id.contains("=") || email_id.contains("+") ||
                                      email_id.contains("{") || email_id.contains("}") ||
                                      email_id.contains("[") || email_id.contains("]") ||
                                      email_id.contains("<") || email_id.contains(">") ||
                                      email_id.contains("?") || email_id.contains("/") ||
                                      email_id.contains("|") || email_id.contains("~") ||
                                      email_id.contains("\\"))) {
                                    break;
                                } else {
                                    System.err.println("Email id contain special characters like('-', '.', '_') only. Try again!");
                                }
                            } else {
                                System.err.println("Email id should not contain '@' more than once. Try again!");
                            }
                        } else {
                            System.err.println("Email id must end with '@gmail.com'. Try again!");
                        }
                    } while (true);                   
                    String address;
                    System.out.print("Enter Address: ");
                    address = sc.nextLine();
                    String marital_status;
                    do {
                    	System.out.println("Select Marital Status: ");
                        System.out.println("1.Single");
                        System.out.println("2.Married");
                        System.out.print("Enter Choice(1-2): ");
                        String Choice = sc.nextLine();
                    
                    switch(Choice) {
                    case "1":
                    	marital_status="Single";
                    	break;
                    case "2":
                    	marital_status="Married";
                    	break;
                    default :
                    	System.err.println("Invalid choice! Try again.");
                    	continue;
                    }
                    break;
                    }
                    while(true);
                    String Qualification;
                    do {
                    	System.out.println("Select Qualification: ");
                    	System.out.println("1. UG");
                    	System.out.println("2. PG");
                    	System.out.print("Enter Your Choice(1-2): ");
                    	String Choice = sc.nextLine();
                    	
                    	switch(Choice) {
                    	case "1":
                    		Qualification="UG";
                    		break;
                    	case "2":
                    		Qualification="PG";
                    		break;
                        default:
                        	System.err.println("Invalid choice! Try again.");
                    		continue;
                    	}
                    	break;
                    }
                    while(true);
                    String course;	
                    System.out.print("Enter Course Completed: ");
                    course = sc.nextLine();
                    String Position;
                    System.out.print("Enter Job Position Applying For: ");
                    Position = sc.nextLine();
                    String status;
                    do {
                    	 System.out.println("Select Status: ");
                    	 System.out.println("1. Fresher");
                    	 System.out.println("2. Experienced");
                    	 System.out.print("Enter Choice(1-2): ");
                    	 String Choice=sc.nextLine();
                    	 switch(Choice) {
                    	 case "1":
                    		 status="Fresher";
                    		 break;
                    	 case "2":
                    		 status="Experienced";
                    		 break;
                    	 default:
                    		 System.err.println("Invalid choice! Try again.");
                    		 continue;	 
                    	 }
                    	 break;
                    }while(true);
                    
                    String internship="",company="",date_joined="",date_relieved="";
                    int last_salary=0;
                    

                    if (status.equalsIgnoreCase("Fresher")) { 
                        System.out.print("Enter Internship Company: ");
                        internship = sc.nextLine();
                    } else {                                     
                        System.out.print("Enter last Company name: ");
                        company = sc.nextLine();

                        do {
                            System.out.print("Enter Date joined(YYYY-MM-DD): ");
                            date_joined = sc.nextLine();
                            if(!(date_joined.length()==10&&date_joined.charAt(4)=='-'&&date_joined.charAt(7)=='-')) {
                            	System.err.println("Invalid! Please enter in YYYY-MM-DD format.");
                            }else {
                            	break;
                            }
                            }while(true);
                        

                        do {
                            System.out.print("Enter Date relieved(YYYY-MM-DD): ");
                            date_relieved = sc.nextLine();
                            if(!(date_relieved.length()==10&&date_relieved.charAt(4)=='-'&&date_relieved.charAt(7)=='-')) {
                            	System.err.println("Invalid! Please enter in YYYY-MM-DD format.");
                            }else {
                            	break;
                            }
                            }while(true);      
                        
                        do {
                        	System.out.print("Enter last salary: ");
                            String salaryInput=sc.nextLine();
                        try {
                        	last_salary=Integer.parseInt(salaryInput);
                        	if(last_salary<10000) {
                        		System.err.println("Invalid! Salary must not be below 10000.");
                        		last_salary=0;
                        	}else {
                        		break;
                        	}
                        }catch(Exception e) {
                        	System.err.println("Invalid input please enter numbers only.");
                        	last_salary=0;
                        }
                        }while(last_salary==0);
                    }
                    
                    String sql = "INSERT INTO emp(name, age, dob, gender, mobile_no, email_id, address, marital_status, Qualification, course, Position, status, internship, company, date_joined, date_relieved, last_salary) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setInt(2, age);
                    ps.setString(3, dob);
                    ps.setString(4, gender);
                    ps.setString(5, mobile_no);
                    ps.setString(6, email_id);
                    ps.setString(7, address);
                    ps.setString(8, marital_status);
                    ps.setString(9, Qualification);
                    ps.setString(10, course);
                    ps.setString(11, Position);
                    
                    ps.setString(12, status);
                    if(status.equalsIgnoreCase("Fresher")) {
                    ps.setString(13, internship);
                    ps.setString(14, "");
                    ps.setNull(15, java.sql.Types.DATE);
                    ps.setNull(16, java.sql.Types.DATE);
                    ps.setNull(17, 0);
                    }else {
                    	ps.setString(13, "");
                    	 ps.setString(14, company);
                         ps.setString(15, date_joined);
                         ps.setString(16, date_relieved);
                         ps.setInt(17, last_salary);
                    }
      
                    ps.executeUpdate();
                    System.out.println("\nEmployee added successfully!\n");
                }
                } else if (choice == 2) {
                    // View Employees
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT*FROM emp");

                        if (!rs.next()) {  // if no rows in ResultSet
                            System.out.println("No employees found in the database!");
                        } else {
                            do {  // use do-while since rs.next() is already true
                                System.out.println("\n================ Employee ================");
                                System.out.println("Name: " + rs.getString("name"));
                                System.out.println("Age: " + rs.getInt("age"));
                                System.out.println("DOB: " + rs.getString("dob"));
                                System.out.println("Gender: " + rs.getString("gender"));
                                System.out.println("Phone: " + rs.getString("mobile_no"));
                                System.out.println("Email: " + rs.getString("email_id"));
                                System.out.println("Address: " + rs.getString("address"));
                                System.out.println("Marital Status: " + rs.getString("marital_status"));
                                System.out.println("Qualification: " + rs.getString("Qualification"));
                                System.out.println("Course: " + rs.getString("course"));
                                System.out.println("Position: " + rs.getString("Position"));
                                System.out.println("Status: " + rs.getString("status"));
                                if (rs.getString("status").equalsIgnoreCase("Fresher"))
                                    System.out.println("Internship: " + rs.getString("internship"));
                                else {
                                    System.out.println("Company: " + rs.getString("company"));
                                    System.out.println("Date Joined: " + rs.getString("date_joined"));
                                    System.out.println("Date Relieved: " + rs.getString("date_relieved"));
                                    System.out.println("Last Salary: " + rs.getInt("last_salary"));
                                }
                                System.out.println("===============================================");
                            } while(rs.next());
                    }

            }else if(choice == 3) { // deleted employee
                System.out.print("Enter Employee ID to delete: ");
                String emp_id = sc.nextLine(); 
                
                String deleteSQL = "DELETE FROM emp WHERE emp_id = ?";
                PreparedStatement psDelete = con.prepareStatement(deleteSQL);
                psDelete.setString(1, emp_id);
                
                int rowsDeleted = psDelete.executeUpdate();
                if(rowsDeleted > 0) {
                    System.out.println("Employee with ID " + emp_id + " deleted successfully!");
                } else {
                    System.err.println("No employee found with ID " + emp_id);
                }
            }else if(choice == 4) { // Search Employee
                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                ResultSet rs = con.createStatement().executeQuery(
                    "SELECT * FROM emp WHERE name = '" + name + "'"
                );

                if(!rs.isBeforeFirst()) { // checks if ResultSet has no rows
                    System.err.println("Employee with name '" + name + "' not found!");
                } else {
                    while(rs.next()) {  
                        System.out.println("\n================ Employee ================");
                        System.out.println("ID: " + rs.getInt("emp_id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Age: " + rs.getInt("age"));
                        System.out.println("DOB: " + rs.getString("dob"));
                        System.out.println("Gender: " + rs.getString("gender"));
                        System.out.println("Phone: " + rs.getString("mobile_no"));
                        System.out.println("Email: " + rs.getString("email_id"));
                        System.out.println("Address: " + rs.getString("address"));
                        System.out.println("Marital Status: " + rs.getString("marital_status"));
                        System.out.println("Qualification: " + rs.getString("Qualification"));
                        System.out.println("Course: " + rs.getString("course"));
                        System.out.println("Position: " + rs.getString("Position"));
                        System.out.println("Status: " + rs.getString("status"));
                        if(rs.getString("status").equalsIgnoreCase("Fresher"))
                            System.out.println("Internship: " + rs.getString("internship"));
                        else {
                            System.out.println("Company: " + rs.getString("company"));
                            System.out.println("Date Joined: " + rs.getString("date_joined"));
                            System.out.println("Date Relieved: " + rs.getString("date_relieved"));
                            System.out.println("Last Salary: " + rs.getInt("last_salary"));
                        }
                        System.out.println("========================================");
                    }
                }
            }


            else if(choice == 5) { // Reports / Analytics
                Statement stmt = con.createStatement();
                
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM emp"); // Total
                rs.next();
                int total = rs.getInt(1);

                rs = stmt.executeQuery("SELECT COUNT(*) FROM emp WHERE gender='Male'"); // Male
                rs.next();
                int male = rs.getInt(1);

                rs = stmt.executeQuery("SELECT COUNT(*) FROM emp WHERE gender='Female'"); // Female
                rs.next();
                int female = rs.getInt(1);

                System.out.println("\n--- Employee Reports ---");
                System.out.println("Total Employees: " + total);
                System.out.println("Male: " + male);
                System.out.println("Female: " + female);
                System.out.println("------------------------\n");
            }
            else if (choice == 6) { // Update Employee
                System.out.print("Enter Employee ID to update: ");
                String emp_id = sc.nextLine();

                ResultSet rsCheck = con.createStatement().executeQuery("SELECT * FROM emp WHERE emp_id = '" + emp_id + "'");
                if (!rsCheck.next()) {
                    System.err.println("No employee found with ID " + emp_id);
                    continue;
                }

                int updateOption;
                do {
                    System.out.println("\nSelect field to update:");
                    System.out.println("1. Name");
                    System.out.println("2. Age");
                    System.out.println("3. DOB");
                    System.out.println("4. Gender");
                    System.out.println("5. Mobile No");
                    System.out.println("6. Email");
                    System.out.println("7. Address");
                    System.out.println("8. Marital Status");
                    System.out.println("9. Qualification");
                    System.out.println("10. Course");
                    System.out.println("11. Position");
                    System.out.println("12. Status & Fresher/Experienced Details");
                    System.out.println("13. Exit Update");

                    //String input;
                    do {
                        System.out.print("Enter choice: ");
                        input = sc.nextLine();
                        if(!input.matches("\\d+")) {
                            System.err.println("Invalid input! Numbers only.");
                        }
                    } while(!input.matches("\\d+"));
                    updateOption = Integer.parseInt(input);

                    switch(updateOption) {
                        case 1: // Name
                            String name;
                            do {
                                System.out.print("Enter Name: ");
                                name = sc.nextLine();
                                if (!name.matches("[a-zA-Z. ]+")) {
                                    System.err.println("Invalid name! Only letters and spaces allowed.");
                                } else break;
                            } while(true);
                            PreparedStatement psName = con.prepareStatement("UPDATE emp SET name=? WHERE emp_id=?");
                            psName.setString(1, name);
                            psName.setString(2, emp_id);
                            psName.executeUpdate();
                            System.out.println("Name updated successfully!");
                            break;

                        case 2: // Age
                            int age;
                            do {
                                System.out.print("Enter Age (18-60): ");
                                String ageInput = sc.nextLine();
                                try {
                                    age = Integer.parseInt(ageInput);
                                    if(age < 18 || age > 60) {
                                        System.err.println("Invalid age!");
                                        age = 0;
                                    } else break;
                                } catch(Exception e) {
                                    System.err.println("Numbers only!");
                                    age = 0;
                                }
                            } while(age == 0);
                            PreparedStatement psAge = con.prepareStatement("UPDATE emp SET age=? WHERE emp_id=?");
                            psAge.setInt(1, age);
                            psAge.setString(2, emp_id);
                            psAge.executeUpdate();
                            System.out.println("Age updated successfully!");
                            break;

                        case 3: // DOB
                            String dob;
                            do {
                                System.out.print("Enter DOB (YYYY-MM-DD): ");
                                dob = sc.nextLine();
                                if(dob.length()==10 && dob.charAt(4)=='-' && dob.charAt(7)=='-') break;
                                else System.err.println("Invalid format!");
                            } while(true);
                            PreparedStatement psDOB = con.prepareStatement("UPDATE emp SET dob=? WHERE emp_id=?");
                            psDOB.setString(1, dob);
                            psDOB.setString(2, emp_id);
                            psDOB.executeUpdate();
                            System.out.println("DOB updated successfully!");
                            break;

                        case 4: // Gender
                            String gender;
                            do {
                                System.out.println("Select Gender:");
                                System.out.println("1. Male");
                                System.out.println("2. Female");
                                System.out.println("3. Other");
                                System.out.print("Enter choice: ");
                                String gChoice = sc.nextLine();
                                switch(gChoice) {
                                    case "1": gender="Male"; break;
                                    case "2": gender="Female"; break;
                                    case "3": gender="Other"; break;
                                    default: System.err.println("Invalid!"); continue;
                                }
                                break;
                            } while(true);
                            PreparedStatement psGender = con.prepareStatement("UPDATE emp SET gender=? WHERE emp_id=?");
                            psGender.setString(1, gender);
                            psGender.setString(2, emp_id);
                            psGender.executeUpdate();
                            System.out.println("Gender updated successfully!");
                            break;

                        case 5: // Mobile
                            String mobile;
                            do {
                                System.out.print("Enter Phone number: ");
                                mobile = sc.nextLine();
                                if(mobile.length()==10 && (mobile.startsWith("6")||mobile.startsWith("7")||mobile.startsWith("8")||mobile.startsWith("9"))) break;
                                else System.err.println("Invalid number!");
                            } while(true);
                            PreparedStatement psMobile = con.prepareStatement("UPDATE emp SET mobile_no=? WHERE emp_id=?");
                            psMobile.setString(1, mobile);
                            psMobile.setString(2, emp_id);
                            psMobile.executeUpdate();
                            System.out.println("Mobile updated successfully!");
                            break;

                        case 6: // Email
                            String email;
                            do {
                                System.out.print("Enter Email: ");
                                email = sc.nextLine();
                                if(email.endsWith("@gmail.com") && email.indexOf("@")==email.lastIndexOf("@") &&
                                   !email.contains(" ") && !email.matches(".*[!#$%^&*()+=\\[\\]{}<>?/~|\\\\].*")) break;
                                else System.err.println("Invalid Email!");
                            } while(true);
                            PreparedStatement psEmail = con.prepareStatement("UPDATE emp SET email_id=? WHERE emp_id=?");
                            psEmail.setString(1, email);
                            psEmail.setString(2, emp_id);
                            psEmail.executeUpdate();
                            System.out.println("Email updated successfully!");
                            break;

                        case 7: // Address
                            System.out.print("Enter Address: ");
                            String address = sc.nextLine();
                            PreparedStatement psAddress = con.prepareStatement("UPDATE emp SET address=? WHERE emp_id=?");
                            psAddress.setString(1, address);
                            psAddress.setString(2, emp_id);
                            psAddress.executeUpdate();
                            System.out.println("Address updated successfully!");
                            break;

                        case 8: // Marital Status
                            String marital;
                            do {
                                System.out.println("Select Marital Status: 1. Single 2. Married");
                                String mChoice = sc.nextLine();
                                if(mChoice.equals("1")) marital="Single";
                                else if(mChoice.equals("2")) marital="Married";
                                else { System.err.println("Invalid!"); continue; }
                                break;
                            } while(true);
                            PreparedStatement psMarital = con.prepareStatement("UPDATE emp SET marital_status=? WHERE emp_id=?");
                            psMarital.setString(1, marital);
                            psMarital.setString(2, emp_id);
                            psMarital.executeUpdate();
                            System.out.println("Marital Status updated successfully!");
                            break;

                        case 9: // Qualification
                            String qual;
                            do {
                                System.out.println("Select Qualification: 1. UG 2. PG");
                                String qChoice = sc.nextLine();
                                if(qChoice.equals("1")) qual="UG";
                                else if(qChoice.equals("2")) qual="PG";
                                else { System.err.println("Invalid!"); continue; }
                                break;
                            } while(true);
                            PreparedStatement psQual = con.prepareStatement("UPDATE emp SET Qualification=? WHERE emp_id=?");
                            psQual.setString(1, qual);
                            psQual.setString(2, emp_id);
                            psQual.executeUpdate();
                            System.out.println("Qualification updated successfully!");
                            break;

                        case 10: // Course
                            System.out.print("Enter Course: ");
                            String course = sc.nextLine();
                            PreparedStatement psCourse = con.prepareStatement("UPDATE emp SET course=? WHERE emp_id=?");
                            psCourse.setString(1, course);
                            psCourse.setString(2, emp_id);
                            psCourse.executeUpdate();
                            System.out.println("Course updated successfully!");
                            break;

                        case 11: // Position
                            System.out.print("Enter Position: ");
                            String position = sc.nextLine();
                            PreparedStatement psPos = con.prepareStatement("UPDATE emp SET Position=? WHERE emp_id=?");
                            psPos.setString(1, position);
                            psPos.setString(2, emp_id);
                            psPos.executeUpdate();
                            System.out.println("Position updated successfully!");
                            break;

                        case 12: // Status & Fresher/Experienced
                            String status;
                            do {
                                System.out.println("Select Status: 1. Fresher 2. Experienced");
                                String sChoice = sc.nextLine();
                                if(sChoice.equals("1")) status="Fresher";
                                else if(sChoice.equals("2")) status="Experienced";
                                else { System.err.println("Invalid!"); continue; }
                                break;
                            } while(true);

                            PreparedStatement psStatus = con.prepareStatement("UPDATE emp SET status=?, internship=?, company=?, date_joined=?, date_relieved=?, last_salary=? WHERE emp_id=?");
                            if(status.equalsIgnoreCase("Fresher")) {
                                System.out.print("Enter Internship Company: ");
                                String intern = sc.nextLine();
                                psStatus.setString(1, status);
                                psStatus.setString(2, intern);
                                psStatus.setString(3, "");
                                psStatus.setNull(4, java.sql.Types.DATE);
                                psStatus.setNull(5, java.sql.Types.DATE);
                                psStatus.setNull(6, java.sql.Types.INTEGER);
                            } else {
                                System.out.print("Enter Last Company Name: ");
                                String company = sc.nextLine();
                                String date_joined, date_relieved;
                                int last_salary;
                                do {
                                    System.out.print("Enter Date Joined (YYYY-MM-DD): ");
                                    date_joined = sc.nextLine();
                                } while(!(date_joined.length()==10 && date_joined.charAt(4)=='-' && date_joined.charAt(7)=='-'));
                                do {
                                    System.out.print("Enter Date Relieved (YYYY-MM-DD): ");
                                    date_relieved = sc.nextLine();
                                } while(!(date_relieved.length()==10 && date_relieved.charAt(4)=='-' && date_relieved.charAt(7)=='-'));
                                do {
                                    System.out.print("Enter Last Salary (>=10000): ");
                                    try { last_salary=Integer.parseInt(sc.nextLine()); if(last_salary>=10000) break; else System.err.println("Salary >=10000"); } 
                                    catch(Exception e) { System.err.println("Numbers only"); last_salary=0; }
                                } while(last_salary==0);

                                psStatus.setString(1, status);
                                psStatus.setString(2, "");
                                psStatus.setString(3, company);
                                psStatus.setString(4, date_joined);
                                psStatus.setString(5, date_relieved);
                                psStatus.setInt(6, last_salary);
                            }
                            psStatus.setString(7, emp_id);
                            psStatus.executeUpdate();
                            System.out.println("Status and details updated successfully!");
                            break;

                        case 13:
                            System.out.println("Exiting update menu.");
                            break;

                        default:
                            System.err.println("Invalid choice!");
                    }

                } while(updateOption != 13);
            }

            
             else if (choice == 7) { //exit
                System.out.println("Existing..Thank you! ");
            } else {
                System.err.println("Invalid Choice.Please Try again.");
            }
        
        }
        while (choice != 7);   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }                                                              
}                                                                

