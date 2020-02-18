public class EmailCheck {

    String emailRegex = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b";
    String email;

    public EmailCheck(String email) {

        if (email.matches(emailRegex)){
            this.email = email;
        }
        else {
            throw new IllegalArgumentException("Feil emailadresse!");
        }
    }

    public String getEmail() {
        return email;
    }
}
