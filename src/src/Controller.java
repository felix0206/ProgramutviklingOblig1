import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private TextField txtNavn;
    @FXML
    private TextField txtAlder;
    @FXML
    private TextField txtEpost;
    @FXML
    private TextField txtDag;
    @FXML
    private TextField txtMåned;
    @FXML
    private TextField txtAAr;
    @FXML
    private TextField txtTlf;



    @FXML
    public void Registrer(ActionEvent event) {

        try{
        NameCheck navn = new NameCheck(txtNavn.getText());
        System.out.println("Du skrev inn følgende navn: " + navn.getName());

        }catch (Exception e){
        System.out.println("Ugyldig navn oppgitt!");
        }
        //sjekker alder og printer ut svar
        try {
            Alder alder = new Alder(Integer.parseInt(txtAlder.getText()));
            System.out.println("Du skrev inn følgende alder: " + alder.getAlder());
        } catch (NumberFormatException e){
            System.out.println("Ugyldig heltall!");
        }

        //sjekker email og printer ut svar
        try{
            EmailCheck email = new EmailCheck(txtEpost.getText());
            System.out.println("Du skrev inn følgende email: " + email.getEmail());
        } catch (Exception e){
            System.out.println("Ugyldig email!");
        }

        try{
            PhoneCheck mobil = new PhoneCheck(txtTlf.getText());
            System.out.println("Du skrev inn følgende mobilnummer: " + mobil.getTelefon());
        }catch (NumberFormatException e){
            System.out.println("Ugyldig mobilnummer! * 8 siffre!");
        }

        try{
            DateCheck dato = new DateCheck(Integer.parseInt(txtDag.getText()),Integer.parseInt(txtMåned.getText()),Integer.parseInt(txtAAr.getText()));
            System.out.println("Du oppga følgende fødselsdato: " + dato.getDag() + "/" + dato.getMåned() + "/" + dato.getÅr());
        } catch (Exception e){
            System.out.println("feil fødselsdato oppgitt!");
        }

    }

}