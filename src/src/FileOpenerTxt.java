import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class FileOpenerTxt implements FileOpener {
    @Override
    public File velgFil()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("FileChooser");

        Stage stage = new Stage();
        stage.setY(250);
        stage.setX(200);

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file = fileChooser.showOpenDialog(stage);

        return file;
    }

    @Override
    public void lesFil() throws IOException {
        DataModell data = new DataModell(null,0,null,null,null);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(velgFil()));
        String navn;
        while ((navn = bufferedReader.readLine()) != null){
            data.setTxtData(navn);
        }
    }
}
