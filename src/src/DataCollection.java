import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class DataCollection {

    private ObservableList<DataModell> list = FXCollections.observableArrayList();

    public void attachTableView(TableView tv) {
        tv.setItems(list);
    }

    public void addElement(DataModell obj) {
        list.add(obj);
    }

}