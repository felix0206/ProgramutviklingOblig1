import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private StringBuilder sb = new StringBuilder();

    InvalidPersonException e = new InvalidPersonException("");

    @FXML
    private TableView tableView;

    @FXML
    private TextField txtField;
    @FXML
    private TextField intField;
    @FXML
    private TextField intDag;
    @FXML
    private TextField intMåned;
    @FXML
    private TextField intÅr;
    @FXML
    private TextField txtEpost;
    @FXML
    private TextField intMobil;

    DataCollection collection = new DataCollection();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        collection.attachTableView(tableView);
    }


    @FXML
    private void LoadFile(ActionEvent event) throws IOException {
        FileOpenerTxt fileOpener = new FileOpenerTxt();
        fileOpener.velgFil();

        fileOpener.lesFil();

    }

    @FXML
    private void addElemBtnClicked() {
        DataModell obj = createDataModelObjectFromGUI();

        if(obj != null) {
            resetTxtFields();
            collection.addElement(obj);
        }

    }

    private DataModell createDataModelObjectFromGUI() {

        try {
            //"tom" person opprettes, skal senere fylles inn.
            DataModell data = new DataModell(null,0,null,null,null);

            //oppretter hjelpeverdier
            String txt = txtField.getText();   //txt = navn
            String epost = txtEpost.getText();
            int i = Integer.parseInt(intField.getText()); // i = alder
            String dag = intDag.getText();
            String måned = intMåned.getText();
            String år = intÅr.getText();
            String fødsel = dag + "." + måned + "-" + år;
            String mobil = intMobil.getText();

            //Kjører igjennom tester for å sjekke om verdiene er korrekte.
            //og fyller inn i data (ny person).
            data.Navn(txt);
            data.Alder(i);
            data.Epost(epost);
            data.FødselsDato(fødsel);
            data.Tlf(mobil);
            //tester slutt

            //Legger inn i stringbuilderen sb, i tilfelle brukeren skal lagre til fil.
            //TODO: gjøre sånn at den ikke lagrer når noe feil blir skrevet.
                sb.append( "ny person: " + "\n \n"+"Navn: " + data.Navn(txt) + ", ");
                sb.append("Alder: " + data.Alder(i) + ", ");
                sb.append("Fødselsdato: " + data.FødselsDato(fødsel) + ", ");
                sb.append("Epostadresse: " + data.Epost(epost) + ", ");
                sb.append("Mobilnummer: " + data.Tlf(mobil) + "\n \n");
                //innlegging slutt

            //hvis noen av textfieldene er null eller 0, så fylles ikke kolonnene inn.
            if (data.getIntTlf() == null || data.getIntData() == 0 || data.getIntFødsel() == null
                    || data.getTxtData() == null || data.getTxtEpost() == null)
            {
                return null;
            }

            return data;
        } catch (IllegalArgumentException e) {
            intField.setText("<< Positivt nummer under 120!>>");
            intMobil.setText("<<Åtte numre (norsk nummer)>>");
            txtField.setText("<<Navn kan ikke inneholde numre eller være tom!>>");
            txtEpost.setText("<<Epost må være eksempel@noe.noe>>");
            return null;
        }
    }

    @FXML
    private void saveToFile(ActionEvent event) throws IOException {

        FileSaverTxt lagre = new FileSaverTxt();
        lagre.lesfil(sb);

    }

    private void resetTxtFields() {
        txtField.setText("");
        intField.setText("");
        intDag.setText("");
        intMåned.setText("");
        intÅr.setText("");
        txtEpost.setText("");
        intMobil.setText("");
    }
}
