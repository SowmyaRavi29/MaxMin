package myApplication;

public class UserRegistration {

    public boolean validateFirstName(String name) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return name.matches(regex);
    }

    public boolean validateLastName(String name) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return name.matches(regex);
    }

    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*@" +
                       "[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$";
        return email.matches(regex);
    }

    // MOBILE FORMAT VALIDATION (91 9919819801)
    public boolean validateMobile(String mobile) {
        String regex = "^[0-9]{2}\\s[0-9]{10}$";
        return mobile.matches(regex);
    }


    public boolean validatePassword(String password) {

        if (!password.matches("^.{8,}$")) return false;

        if (!password.matches(".*[A-Z].*")) return false;

        if (!password.matches(".*[0-9].*")) return false;

        int specialCount = password.replaceAll("[a-zA-Z0-9]", "").length();
        if (specialCount != 1) return false;

        return true;
    }
}
