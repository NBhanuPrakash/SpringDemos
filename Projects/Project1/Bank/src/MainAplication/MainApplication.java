package MainAplication;

import com.bank.user.InsufficientFundsException;
import com.bank.user.User;
import com.bank.user.FileUtility;


import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class MainApplication {

    static Map<Integer, User> userMap = new HashMap<>();
    static Scanner  sc = new Scanner(System.in);
    static boolean exitFlag = true;
    public static void main(String[] args) throws InsufficientFundsException {
        while (exitFlag){
            FileUtility.readLogoFromFileSystem();
            print();
            print("Enter 1 to create the Account....");
            print("Enter 2 to Login the Account....");
            print("Enter 3 to the exit Account....");

            int userchoice = sc.nextInt();
            switch (userchoice){
                case 1:
                {
                    createuser();
                    break;
                }
                case 2:
                {
                    System.out.println("Please enter the Account the number !!!");
                    int userAccount = sc.nextInt();
                    User userobj = userMap.get(userAccount);
                    if  ( userobj == null) {
                        System.out.println("Invalid account number !!");
                        break;
                    } else {
                        System.out.println("enter the user Id ");
                        String Email = sc.next();
                        if (!userobj.getUsername().equals(Email)){
                            System.out.println("Invalid User Id, Try Again ");
                            break;
                        }
                        System.out.println("Please enter password");
                        String userPassword = sc.next();
                        if(!userobj.getpassward().equals(userPassword)) {
                            System.out.println("Invalid password , try again ");
                            break;

                          }else {
                            System.out.println("Login Succesfull !!!");
                            System.out.println("1 - view balance");
                            System.out.println("2 - withdraw balance");
                            System.out.println("3 - deposit amount");
                            System.out.println("4 - Logout");

                            int loginUserChoice = sc.nextInt();
                            switch (loginUserChoice) {

                                case 1: {

                                    System.out.println("your account balance is " + userobj.getdeposit());
                                    break;
                                }

                                case 2: {

                                    System.out.println("Please enter amount to withdraw ");
                                    int withdrawlAmount = sc.nextInt();

                                    if (withdrawlAmount > userobj.getaccountBalance()) {
                                        throw new InsufficientFundsException("Insufficient Balance !!!");
                                    }
                                    else{
                                        System.out.println("Withdrawlammount "+withdrawlAmount);
                                    }
                                    break;
                                }

                                case 3: {

                                    System.out.println("Please  amount to deposit ");
                                    int depositAmount = sc.nextInt();

                                    if (depositAmount <= 0) {
                                        throw new IllegalArgumentException("-ve balance not allowed");
                                    } else {

                                        Integer accountBalance = userobj.getaccountBalance();
                                        userobj.setaccountBalance(accountBalance + depositAmount);

                                    }
                                    break;
                                }
                                case 4: {
                                    exitFlag = false;
                                    System.out.println("Successfully LogOut !!!");
                                }
                                break;
                            }

                          }
                    }

                }
                case 3: {
                    exitFlag = false;
                    break;

                }
            }
        }

        
    }
   private static void createuser(){
        long Aadhar = CaptureAadhar();
        String Name = CaptureFirstnameandLastName();
        String username= captureusername();
        String gender = Capturegender();
        String DOB = CaptureDOb();
        String mobile = CaptureMobile();
        String pan = CapturePancard();
        String passward=CapturePassward();
        long deposit = captureDeposit();
        int account_number=CaptureAccountNumber();
        User userobj = new User(Aadhar,Name,gender,DOB,mobile,pan,passward,account_number,username,deposit);
        userMap.put(account_number, userobj);


        System.out.println("User account succesfully created with account number :" + account_number);
       System.out.println("User Id :"+username);


   }
   private static long CaptureAadhar(){
    System.out.println("Enter the AAdhar Number ");
        long aadhar=sc.nextLong();
        return aadhar;
    }
    private static String CaptureFirstnameandLastName(){
    System.out.println("Enter the First name as per AAdhar ");
    String First = sc.next();
    System.out.println("Enter the Last name as per AAdhar ");
    String Secound =sc.next();
    return First.concat(Secound);
    }
    private static String Capturegender() {
        System.out.println("please enter Gender Male/Female");
        String gender = sc.next();
        while (true) {

            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
                break;
            }
        }

        return gender;
    }
    private static String CaptureDOb(){
    System.out.println("Enter the date of birth dd/mm/yyyy");
        String dob = sc.next();
        return dob;
    }
    private static String CaptureMobile(){
    System.out.println("Enter the Mobile Number ");
    String mobile;
    for (mobile=sc.next(); mobile.length()!=10; mobile=sc.next())
    {
        System.out.println("Invalid Number");

    }
    return mobile;

    }
    private static String CapturePancard(){
    System.out.println("Enter the Pancard Number ");
    String pan;
    for (pan=sc.next(); pan.length()!=10; pan=sc.next()){
        System.out.println("Invalid Pancard ");
    }
    return pan;
    }
    private static String CapturePassward(){
        String passward;
        String conformpassward;
    System.out.println("Enter the Passward ");
    passward=sc.next();
    System.out.println("Enter the ConformPassward ");
    conformpassward=sc.next();
    while (!passward.equalsIgnoreCase(conformpassward))
    {
        System.out.println("Above Passward DiDn't Match...Please try Again ");
        conformpassward=sc.next();
    }
    return passward;

    }
    private static int CaptureAccountNumber(){
    System.out.println("This is your Account number ");
    int accountnumber;
    accountnumber=new Random().nextInt(500000)+1000000;

    System.out.println("Sucessfully done your Account Generation..." +
            "Thanks for choiceing this Bank !!!!....");
    return accountnumber;
    }
    public static String captureusername(){
        System.out.println("Enter the username ");
        String username=sc.next();
        return username;
    }
    public static long captureDeposit(){
        System.out.println("Enter the First Deposit of More than 5000 ");
        long deposit = sc.nextLong();
        return deposit;
    }

    public static void print() {
        System.out.println();
    }
    public static void print(String msg){
        System.out.println(msg);
    }

}

