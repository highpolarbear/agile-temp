package main.java.Kanban;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class ColumnController {

    @FXML
    private MenuItem addTaskMenuButton;

    @FXML private VBox boxOfTask;

    @FXML private Label colName;

    public ColumnController(){
    }

    @FXML
    public void initialise(){

    }

    public void handleNewTask(){
        try {
            boxOfTask.getChildren().add((new Task()).getTask());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void changeColName() {
        TextInputDialog dialog = new TextInputDialog(colName.getText());
        dialog.setTitle("Change Column Name");
        dialog.setHeaderText("Change Column Name");
        dialog.setContentText(" Column " + colName.getText() + " To :");

        Optional<String> newName = dialog.showAndWait();

        newName.ifPresent(e -> colName.setText((newName.get()).toString()));
    }

    @FXML
    public void setColName() {
        TextInputDialog dialog = new TextInputDialog(colName.getText());
        dialog.setTitle("New Column");
        dialog.setHeaderText("Name new Column");
        dialog.setContentText(" Name of Column :");

        Optional<String> newName = dialog.showAndWait();

        newName.ifPresent(e -> colName.setText((newName.get()).toString()));
    }


//    @FXML
//    public void exitApplication(){
//        System.exit(0);
//    }

}
