import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataModell {

    private SimpleStringProperty txtNavn;
    private SimpleIntegerProperty intAlder;
    private SimpleStringProperty intFødsel;
    private SimpleStringProperty txtEpost;
    private SimpleStringProperty intTlf;

    String numberRegex = "(.)*(\\d)(.)*";  //For å sjekke om navnet inneholder numre.
    String emailRegex = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b";
    String mobilRegex = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
    String birthDateRegex = "^s*(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\-((?:19|20)\\d{2})\\s*$";


    InvalidPersonException e = new InvalidPersonException("");

    public DataModell(String txtData, int intData, String intFødsel, String txtEpost, String intTlf) {
        this.txtNavn = new SimpleStringProperty(txtData);
        this.intAlder = new SimpleIntegerProperty(intData);
        this.intFødsel = new SimpleStringProperty(intFødsel);
        this.txtEpost = new SimpleStringProperty(txtEpost);
        this.intTlf = new SimpleStringProperty(intTlf);
    }

    public String Navn(String navn) {

        if (navn.matches(numberRegex)) {
            System.out.println(e.InvalidNameException("Ugyldig navn er oppgitt!"));
        } else {
            this.txtNavn = new SimpleStringProperty(navn);
        }

        return navn;
    }

    public String Epost(String epost) {

        if (epost.matches(emailRegex)) {
            this.txtEpost = new SimpleStringProperty(epost);
        } else {
            System.out.println(e.InvalidEmailException("Feil emailadresse!"));
        }
        return epost;
    }

    public int Alder(int alder) {

        if (alder < 0 || alder > 120) {
            System.out.println(e.InvalidAgeExcepton("Alderen er ikke gyldig!"));
        } else {
            this.intAlder = new SimpleIntegerProperty(alder);
        }
        return alder;
    }

    public String Tlf(String tlf) {

        if (tlf.matches(mobilRegex)) {
            this.intTlf = new SimpleStringProperty(tlf);
        } else {
            System.out.println(e.InvalidTlfException("Ugyldig mobilnummer. Det må være et nummer som inneholder " +
                    "8 sifre. Ikke mer eller mindre."));
        }
        return tlf;
    }

    public String FødselsDato(String fødselsår) {

        if (fødselsår.matches(birthDateRegex)) {
            this.intFødsel = new SimpleStringProperty(fødselsår);
        } else {
            System.out.println(e.InvalidDateException("Ugyldig fødselsdato"));
        }

        return fødselsår;

    }

    //getters and setters:

    public String getTxtData() {
        return txtNavn.getValue();
    }

    public void setTxtData(String txtData) {
        this.txtNavn.set(txtData);

    }

    public int getIntData() {
        return intAlder.getValue();
    }

    public void setIntData(int intData) {
        this.intAlder.set(intData);
    }

    public String getTxtEpost() {
        return txtEpost.getValue();
    }

    public void setTxtEpost(String txtEpost) {

        this.txtEpost.set(txtEpost);

    }

    public String getIntFødsel() {
        return intFødsel.getValue();
    }

    public void setIntFødsel(String intFødsel) {

        this.intAlder.set(Integer.parseInt(intFødsel));
    }

    public String getIntTlf() {
        return intTlf.getValue();
    }

    public void setIntTlf(String intTlf) {

        this.intAlder.set(Integer.parseInt(intTlf));
    }
}