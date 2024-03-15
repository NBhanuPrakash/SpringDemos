package com.bank.hdfc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.bank.user.InsufficientFundsException;
import com.bank.user.User;

public class MainApplication {

	static Map<Integer, User> userMap = new HashMap<>();
	static Scanner scannerObject = new Scanner(System.in);
	static boolean exitFlag = true;

	public static void main(String[] args) throws InsufficientFundsException {

		// FileUtility.readLogoFromFileSystem();

		while (exitFlag) {
			print();
			print("Enter 1 to Create a New Account");
			print("Enter 2 to Access an Existing Account");
			print("Enter 3 to Exit");

			int userChoice = scannerObject.nextInt();

			switch (userChoice) {

			case 1: {
				createUser();
				break;

			}

			case 2: {
				System.out.println("Please enter account number !!!");
				int userAccount = scannerObject.nextInt();
				User userObject = userMap.get(userAccount);
				if (userObject == null) {
					System.out.println("Invalid account number !!");
					break;
				} else {
					System.out.println("Please enter password");
					String userPassword = scannerObject.next();
					if (!userObject.getPassword().equals(userPassword)) {
						System.out.println("Invalid password , try again ");
					} else {
						System.out.println("Login Succesfull !!!");
						System.out.println("1 - view balance");
						System.out.println("2 - withdraw balance");
						System.out.println("3 - deposit amount");

						int loginUserChoice = scannerObject.nextInt();

						switch (loginUserChoice) {

						case 1: {

							System.out.println("your account balance is " + userObject.getAccountBalance());
							break;
						}

						case 2: {

							System.out.println("Please enter amount to withdraw ");
							int withdrawlAmount = scannerObject.nextInt();

							if (withdrawlAmount > userObject.getAccountBalance()) {
								throw new InsufficientFundsException("Insufficient Balance !!!");
							}

							break;
						}

						case 3: {

							System.out.println("Please  amount to deposit ");
							int depositAmount = scannerObject.nextInt();

							if (depositAmount <= 0) {
								throw new IllegalArgumentException("-ve balance not allowed");
							} else {

								Integer accountBalance = userObject.getAccountBalance();
								userObject.setAccountBalance(accountBalance + depositAmount);

							}

							break;
						}

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

	private static void createUser() {

		String captureName = captureFirstNameAndLastName();

		String gender = validateGenderAndCapture();

		String dob = captureDOB();

		String mobileNumber = validateAndCaptureMobileNumber();

		String userPassword = doPasswordValidation();

		int accountNumber = new Random().nextInt(900000) + 100000;

		User userObj = new User(captureName, gender, mobileNumber, dob, userPassword, accountNumber);

		userMap.put(accountNumber, userObj);

		System.out.println("User account succesfully created with account number " + accountNumber);
	}

	private static String doPasswordValidation() {
		String password;
		
		String confirmpassword;
		
		
		System.out.println("please enter your password ");
		password= scannerObject.next();

		System.out.println("please enter confirm  password ");
		confirmpassword = scannerObject.next();

		while (!password.equalsIgnoreCase(confirmpassword)) {

			System.out.println("Password and confirm password didn't match");

			password = scannerObject.next();

			confirmpassword = scannerObject.next();

		}

		return password;
	}

	private static String validateAndCaptureMobileNumber() {
		System.out.println("please enter your mobile number ");

		String mobileNumber = scannerObject.next();
		while (mobileNumber.length() != 10) {

			System.out.println("invalid mobile number length , please try again ..");
			mobileNumber = scannerObject.next();

		}

		return mobileNumber;
	}

	private static String captureDOB() {
		System.out.println("please enter your DOB in dd/mm/yyyy format ");
		String dob = scannerObject.next();

		return dob;
	}

	private static String captureFirstNameAndLastName() {
		// create new account for user.
		System.out.println("please enter first name");
		String firstName = scannerObject.next();

		System.out.println("please enter last name");
		String lastName = scannerObject.next();

		return firstName.concat(lastName);
	}

	private static String validateGenderAndCapture() {
		System.out.println("please enter Gender M/F");
		String gender = scannerObject.next();
		while (true) {

			if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
				break;
			}
		}

		return gender;
	}

	public static void print() {
		System.out.println();

	}

	public static void print(String msg) {
		System.out.println(msg);
	}

}
