package emailApp;

import java.awt.*;
import java.util.Scanner;

public class Email {

    // This Application will do following.
//    Emial Application
//           Scenario: You are an IT Support Administrator Specialist and
//           are charged with the task of
//           creating email accounts for new hires


    //    1. Generate an email with the following syntax: firstname.lastname@department.com
//    2. Determine the department (sales, development, accounting), if none, leave blank.\
//    3. Generate a random string for password
//    4. Have set methods string for a password
//    5. Have set of methods to change the password, set mailbox capacity, and define an alternate email address
//    6. Have get methods to display the name, email, and mailbox capacity.

    private String firstName;
    private String lastName;
    private String password;
    private int randomPasswordLenght = 10;
    private String department;
    private String alternateEmail;
    private int mailBoxCapacity;
    private int mailboxCapacity = 500;
    private String email;
    private String companySuffix = "pascal.com";

    Scanner in = new Scanner(System.in);

    //constructor to receive the firstName and LastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


//        System.out.println("Enter your first name");
//        firstName = in.next();
//
//        System.out.println("Enter your last name");
//        lastName = in.next();

//        System.out.println("Emial Create: " + " firstName " + this.firstName + " lastName " + this.lastName);
        //Call a method asking for the department  = return the department
        this.department = setDepartment();
        System.out.println("Department is: " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(randomPasswordLenght);
//        System.out.println("Your password is :" + this.password);

        //Combine elements to generate email.
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
//        System.out.println("Your email is : " + email);

    }

    //Ask for the department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\nEnter the department code: ");
        int depChoice = in.nextInt();

        // check the input is == to the corresponding department.
        if(depChoice == 1){
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        }else{
            return "Department not found!";
        }
    };

    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789!@#$%^&*";
        char[] password = new char[length];
        for(int i =0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    };

    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    };

    //Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    };

    //Change password
    public void changePassword(String password){
        this.password = password;
    };

    public int getMailBoxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    };

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "----WELCOME TO PASCAL CONSULT---" +
                "\nDISPLAY NAME: " + firstName.toUpperCase() + " " + lastName.toUpperCase() +
                "\nCOMPANY EMAIL: " + email +
                "\nYour PASSWORD: " + password +
                "\nYOUR DEPARTMENT: " + department.toUpperCase() +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    };

}
