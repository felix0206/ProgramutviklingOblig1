public class PhoneCheck {

    int telefon;
    String mobilRegex = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";

    public PhoneCheck(String telefon) {
        if (telefon.matches(mobilRegex)){
            this.telefon = Integer.parseInt(telefon);
        }else{
            throw new IllegalArgumentException("Ugyldig mobilnummer. Det må være et nummer som inneholder " +
                    "8 sifre. Ikke mer eller mindre.");
        }
    }

    public int getTelefon() {
        return telefon;
    }
}