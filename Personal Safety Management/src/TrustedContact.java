import java.util.Scanner; //import Scanner class from java.util package
import java.lang.String; //import String class from java.lang package

public interface TrustedContact { //interface with methods to be implemented later on in classes
    void addContact();
    void removeContact();
    void callContact();
}

abstract class Contact implements TrustedContact { //TrustedContact implements two of interface's methods
    String contactOneName; //String variable to hold first Trusted Contact's name
    int contactOneNum; //integer variable to hold first Trusted Contact's number
    String contactTwoName; //String variable to hold second Trusted Contact's name
    int contactTwoNum; //integer variable to hold first Trusted Contact's number
    String contactThreeName; //String variable to hold third Trusted Contact's name
    int contactThreeNum; //integer variable to hold first Trusted Contact's number
    int deleteContact; //integer variable to be used when deleting one or more Trusted Contacts

    public void addContact() {
        Scanner nameOne = new Scanner(System.in); //create Scanner object nameOne
        System.out.println("Enter 1st Trusted Contact's name:"); //ask user to input first Trusted Contact's name
        contactOneName = nameOne.nextLine(); //user inputs first Trusted Contact's name
        Scanner numOne = new Scanner(System.in); //create Scanner object numOne
        System.out.println("Enter 1st Trusted Contact's number:"); //ask user to input first Trusted Contact's number
        contactOneNum = numOne.nextInt(); //user inputs first Trusted Contact's number
        Scanner nameTwo = new Scanner(System.in); //create Scanner object nameTwo
        System.out.println("Enter 2nd Trusted Contact's name:"); //ask user to input second Trusted Contact's name
        contactTwoName = nameTwo.nextLine(); //user inputs second Trusted Contact's name
        Scanner numTwo = new Scanner(System.in); //create Scanner object numTwo
        System.out.println("Enter 2nd Trusted Contact's number:"); //ask user to input second Trusted Contact's number
        contactTwoNum = numOne.nextInt(); //user inputs second Trusted Contact's number
        Scanner nameThree = new Scanner(System.in); //create Scanner object nameThree
        System.out.println("Enter 3rd Trusted Contact's name:"); //ask user to input third Trusted Contact's name
        contactThreeName = nameOne.nextLine(); //user inputs third Trusted Contact's name
        Scanner numThree = new Scanner(System.in); //create Scanner object numThree
        System.out.println("Enter 3rd Trusted Contact's number:"); //ask user to input third Trusted Contact's number
        contactThreeNum = numThree.nextInt(); //user inputs third Trusted Contact's number

        if (contactOneNum==contactTwoNum || contactOneNum==contactThreeNum || contactTwoNum==contactThreeNum){
            System.out.println("Error: repetitive phone number"); //error message pops up if two or more Trusted Contact's numbers are same
        }
        else if (contactOneName.equals("")) {
            System.out.println("Warning: First Trusted Contact's name is empty"); //error message pops up if first Trusted Contact's name is empty
        }
        else if (contactTwoName.equals("")) {
            System.out.println("Warning: Second Trusted Contact's name is empty"); //error message pops up if second Trusted Contact's name is empty
        }
        else if (contactThreeName.equals("")) {
            System.out.println("Warning: Third Trusted Contact's name is empty"); //error message pops up if third Trusted Contact's name is empty
        }
        else System.out.println("Trusted Contacts added successfully"); //if no error occurs, system lets user know that all Trusted Contacts have been added
    }

    public void removeContact() {
        Scanner del = new Scanner(System.in);
        System.out.println("Do you want to remove one or more Trusted Contacts? If no, press 0");
        System.out.println("To delete Contact 1, press 1"+"\n"+"To delete Contact 2, press 2"+"\n"+"To delete Contact 3, press 3");
        System.out.println("To delete Contact 1 & 2 press 4"+"\n"+"To delete Contact 1 & 3, press 5"+"\n"+"To delete Contact 2 & 3, press 6");
        System.out.println("To delete all 3 Contacts, press 7");
        deleteContact = del.nextInt();
        if (deleteContact==0) {
            System.out.println("No Contact deleted"); //if user presses 0, no Trusted Contacts are removed
        }
        else if (deleteContact==1) {
            contactOneName = null;
            contactOneNum = 0;
            System.out.println("Contact 1 deleted"); //if user presses 1, first Trusted Contact is removed, their name and number set to null
        }
        else if (deleteContact==2) {
            contactTwoName = null;
            contactTwoNum = 0;
            System.out.println("Contact 2 deleted"); //if user presses 2, second Trusted Contact is removed, their name and number set to null
        }
        else if (deleteContact==3) {
            contactThreeName = null;
            contactThreeNum = 0;
            System.out.println("Contact 3 deleted"); //if user presses 3, third Trusted Contact is removed, their name and number set to null
        }
        else if (deleteContact==4) {
            contactOneName = null;
            contactOneNum = 0;
            contactTwoName = null;
            contactTwoNum = 0;
            System.out.println("Contacts 1 & 2 deleted"); //if user presses 4, first and second Trusted Contacts are removed, their name and number set to null
        }
        else if (deleteContact==5) {
            contactOneName = null;
            contactOneNum = 0;
            contactThreeName = null;
            contactThreeNum = 0;
            System.out.println("Contacts 1 & 3 deleted"); //if user presses 5, first and third Trusted Contacts are removed, their name and number set to null
        }
        else if (deleteContact==6) {
            contactTwoName = null;
            contactTwoNum = 0;
            contactThreeName = null;
            contactThreeNum = 0;
            System.out.println("Contacts 2 & 3 deleted"); //if user presses 6, second and third Trusted Contacts are removed, their name and number set to null
        }
        else if (deleteContact==7) {
            contactOneName = null;
            contactOneNum = 0;
            contactTwoName = null;
            contactTwoNum = 0;
            contactThreeName = null;
            contactThreeNum = 0;
            System.out.println("All 3 Contacts deleted"); //if user presses 7, all Trusted Contacts are removed, their name and number set to null
        }
        else System.out.println("Error: invalid input"); //if user presses anything other than numbers 1 to 7, error message pops up
    }
}

class CallContact extends Contact{ //CallContact implements interface's callContact() method
    public void callContact(){ //method to call Trusted Contact
        int trustedCont; //String variable to be used when calling Trusted Contact
        Scanner trust = new Scanner(System.in); //create Scanner object trust
        System.out.println("Would you like to call your Trusted Contacts? Dial 111 to do so"); //asks user if they want to call their Trusted Contacts
        trustedCont = trust.nextInt(); //user inputs 111 to call Trusted Contacts
        if (trustedCont==111) {
            System.out.println("Calling Trusted Contacts..."); //if user inputs 111, Trusted Contacts will be called
        }
        else System.out.println("Error: invalid input"); //if user inputs anything other than 111, error message will pop up

        if (deleteContact!=7) {
            System.out.println("Trusted Contacts have been contacted"); //if user has added Trusted Contacts, they will be called
        }
        else System.out.println("No Trusted Contact exists in your directory"); //if user has not added any Trusted Contacts, error message will pop up
    }
}