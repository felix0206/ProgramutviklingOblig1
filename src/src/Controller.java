import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<String, Person> tblNavn;
    @FXML
    private TableColumn <String, Person> tblAlder;
    @FXML
    private TableColumn<String, Person> tblFødsel;
    @FXML
    private TableColumn<String, Person> tblEpost;
    @FXML
    private TableColumn<String, Person> tblTlf;


    @FXML
    public void Registrer(ActionEvent event) {

        Person p = new Person();

        try{
            System.out.println("Du skrev inn følgende navn: " + p.Navn(txtNavn.getText()));
        }catch (Exception e){
        System.out.println("Ugyldig navn oppgitt!");
        }
        //sjekker alder og printer ut svar
        try {
            System.out.println("Du skrev inn følgende alder: " + p.Alder(Integer.parseInt(txtAlder.getText())));
        } catch (NumberFormatException e){
            System.out.println("Ugyldig heltall!");
        }

        //sjekker email og printer ut svar
        try{
            System.out.println("Du skrev inn følgende email: " + p.Epost(txtEpost.getText()));
        } catch (Exception e){
            System.out.println("Ugyldig email!");
        }

        try{
            System.out.println("Du skrev inn følgende mobilnummer: " + p.Tlf(txtTlf.getText()));
        }catch (NumberFormatException e){
            System.out.println("Ugyldig mobilnummer! * 8 siffre!");
        }

        try{
            System.out.println("Du oppga følgende fødselsdato: " + p.FødselsDato(Integer.parseInt(txtDag.getText()),Integer.parseInt(txtMåned.getText()),Integer.parseInt(txtAAr.getText())));
        } catch (Exception e){
            System.out.println("feil fødselsdato oppgitt!");
        }

    }

}