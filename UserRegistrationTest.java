package myApplication;

public class UserRegistrationTest {
    public static void main(String[] args) {

        UserRegistration user = new UserRegistration();

        System.out.println("First Name: " + user.validateFirstName("Sowmya"));
        System.out.println("Last Name: " + user.validateLastName("Ravi"));
        System.out.println("Email: " + user.validateEmail("abc.xyz@bl.co.in"));
        System.out.println("Mobile: " + user.validateMobile("91 9919819801"));
        System.out.println("Password: " + user.validatePassword("Passw0rd@"));
    }
}
