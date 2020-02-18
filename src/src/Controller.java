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
    private TextField txtDato;
    @FXML
    private TextField txtTlf;



    @FXML
    public void Registrer(ActionEvent event) {
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
            System.out.println("Ugyldig mobilnummer!");
        }

    }

}