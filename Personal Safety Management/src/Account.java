import java.util.Scanner; //import Scanner class from java.util package
import java.lang.String; //import String class from java.lang package

public interface Account{ //interface with methods to be implemented later on in classes
    void createAccount();
    void deleteAccount();
    void login();
}

abstract class UserAccount implements Account { //UserAccount implements implements interface's methods
    String newUsername; //String variable to hold new username when creating an account
    String newPassword; //String variable to hold new password when creating an account
    String username; //String variable to hold existing username when logging into system
    String password; //String variable to hold existing password when logging into system
    int deleteAccount; //integer variable to be used when deleting an existing account

    public void createAccount() { //method for creating account
        Scanner newUser = new Scanner(System.in); //create Scanner object newUser
        System.out.println("To create account, enter new username:"); //asks user to input new username to create account
        newUsername = newUser.nextLine(); //user inputs new username
        Scanner newPass = new Scanner(System.in); //create Scanner object newPass
        System.out.println("Enter new password:"); //asks user to input new password to create account
        newPassword = newPass.nextLine(); //user inputs new password
        System.out.println("Account creation successful"); //print statement
    }

    public void deleteAccount() { //method for deleting account
        Scanner del = new Scanner(System.in); //create Scanner object del
        System.out.println("Do you want to delete your account?"); //asks user if they want to delete account or not
        System.out.println("If yes, press 1. If no, press 0"); //pressing 1 will delete account, 0 will not
        deleteAccount = del.nextInt(); //user inputs their decision to delete account or not

        if (deleteAccount==0){
            System.out.println("Account NOT deleted"); //if user presses 0, account will not be deleted
        }
        else if (deleteAccount==1){
            String newUsername = null;
            String newPassword = null;
            System.out.println("Account deleted successfully"); //if user presses 1, account will be deleted; username and password will be set to null
            System.exit(0);
        }
        else System.out.println("Error: invalid input"); //if user inputs anything other than 0 or 1, system will display error message
    }
}

class Login extends UserAccount{ //child class of UserAccount
    public void login() { //method for logging into system
        Scanner name = new Scanner(System.in); //create Scanner object name
        System.out.println("To login, enter username:"); //asks user to input username if they want to log into system
        username = name.nextLine(); //user inputs username
        Scanner pass = new Scanner(System.in); //create Scanner object pass
        System.out.println("Enter password:"); //asks user to input password if they want to log into system
        password = pass.nextLine(); //user inputs password
        if (newUsername.equals(username) && newPassword.equals(password)) {
            System.out.println("Login successful. Welcome back, " + username); //if both username and password match, user will log into system
        }
        else if(newUsername!=username && newPassword.equals(password)) {
            System.out.println("Error: incorrect username"); //system will let user know if username does not match
            System.exit(0);
        }
        else if (newUsername.equals(username) && newPassword!=password) {
            System.out.println("Error: incorrect password"); //system will let user know if password does not match
            System.exit(0);
        }
        else {
            System.out.println("Error: Account does not exist"); //system will let user know that account does not exist if neither username nor password match
            System.exit(0);
        }
    }
}
