package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String Department;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String Company = "aqlabs.xyz";
    // Constructor to get first and lastname
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;


        // Call Method asking for the department - then return the department
        this.Department = setDepartment();


        // call the method that generates random password
        this.password = randomPassword(defaultPasswordLength);


        // Combine elements to create email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "." + Department.toLowerCase() + "@" + Company.toLowerCase();

    }
    // Ask for the department
    private String setDepartment(){
        System.out.println("---Department Codes---\n[1] -- Accounting \n[2] -- Development \n[3] -- Sales \n[4] -- HumanResources \nEnter Code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return "Accounting";
        } else if(depChoice == 2){
            return "Development";
        } else if(depChoice == 3){
            return "Sales";
        } else if(depChoice == 4){
            return "HumanResources";
        } else {
            return " ";
        }

    }
    // Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXWXYZ1234567890!@#$%^&*()_+.";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
           int rand = (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // Set the mailbox capacity
    public void setMailboxCapacity(int Capacity){
        this.mailboxCapacity = Capacity;
    }

    // Alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassord(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "EMPLOYEE NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nTEMP PASSWORD: "+ password +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "MB";

    }
}
