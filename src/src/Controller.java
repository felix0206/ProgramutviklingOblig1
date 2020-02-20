import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller{

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
    private TextField txtPath;
    @FXML
    private TableColumn<Person, String> tblNavn;
    @FXML
    private TableColumn<Person, String> tblAlder;
    @FXML
    private TableColumn<Person, String> tblFødsel;
    @FXML
    private TableColumn<Person, String> tblEpost;
    @FXML
    private TableColumn<Person, String> tblTlf;
    @FXML
    private static TableView<Person> tblView;

    @FXML
    public void Registrer(ActionEvent event) throws IOException {

        Person p = new Person(txtNavn.getText(),Integer.parseInt(txtAlder.getText()),txtEpost.getText(),Integer.parseInt(txtTlf.getText()),txtAAr.getText());
        StringBuilder sb = new StringBuilder();

        File file = new File(txtPath.getText()+"RegistrertePersoner.txt/");
        FileWriter fil = new FileWriter(file);

        try{
            System.out.println("Du skrev inn følgende navn: " + p.Navn(txtNavn.getText()));
            sb.append(txtNavn.getText() + ":::");
        }catch (Exception e){
        System.out.println("Ugyldig navn oppgitt!");
        }
        //sjekker alder og printer ut svar
        try {
            System.out.println("Du skrev inn følgende alder: " + p.Alder(Integer.parseInt(txtAlder.getText())));
            sb.append(txtAlder.getText() + ":::");
        } catch (NumberFormatException e){
            System.out.println("Ugyldig heltall!");
        }

        //sjekker email og printer ut svar
        try{
            System.out.println("Du skrev inn følgende email: " + p.Epost(txtEpost.getText()));
            sb.append(txtEpost.getText() + ":::");
        } catch (Exception e){
            System.out.println("Ugyldig email!");
        }

        try{
            System.out.println("Du skrev inn følgende mobilnummer: " + p.Tlf(txtTlf.getText()));
            sb.append(txtTlf.getText() + ":::");
        }catch (NumberFormatException e){
            System.out.println("Ugyldig mobilnummer! * 8 siffre!");
        }

        try{
            System.out.println("Du oppga følgende fødselsdato: " + p.FødselsDato(Integer.parseInt(txtDag.getText()),Integer.parseInt(txtMåned.getText()),Integer.parseInt(txtAAr.getText())));
            sb.append(p.FødselsDato(Integer.parseInt(txtDag.getText()),Integer.parseInt(txtMåned.getText()),Integer.parseInt(txtAAr.getText())));
        } catch (Exception e){
            System.out.println("feil fødselsdato oppgitt!");
        }

        if (txtPath.getText() != null){
            fil.write(sb.toString());
            fil.close();
        }

    }

}