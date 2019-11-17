package main.java.Kanban;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;


import java.util.Optional;

public class TaskController {

    @FXML Label taskName;

    @FXML
    Text taskText;

    public TaskController(){
    }

    @FXML
    public void initialise(){
    }
    

    @FXML
    public void changeTaskName() {
        TextInputDialog dialog = new TextInputDialog(taskName.getText());
        dialog.setTitle("Change Task Name");
        dialog.setHeaderText("Change Task Name");
        dialog.setContentText(" Task " + taskName.getText() + " To :");

        Optional<String> newName = dialog.showAndWait();

        newName.ifPresent(e -> taskName.setText((newName.get()).toString()));
    }

    @FXML
    public void setTaskName() {

        TextInputDialog dialog = new TextInputDialog(taskName.getText());
        dialog.setTitle("New Task");
        dialog.setHeaderText("Name new Task");
        dialog.setContentText(" Name of Task :");

        Optional<String> newName = dialog.showAndWait();

        setTaskText();

        newName.ifPresent(e -> taskName.setText((newName.get()).toString()));
    }

    @FXML
    public void setTaskText() {

        TextInputDialog dialog = new TextInputDialog(taskText.getText());
        dialog.setTitle("New Task");
        dialog.setHeaderText(" New Task Description");
        dialog.setContentText(" Describe Task :");

        Optional<String> newTaskText = dialog.showAndWait();

        newTaskText.ifPresent(e -> taskText.setText((newTaskText.get()).toString()));
    }

    @FXML
    public void changeTaskText() {

        TextInputDialog dialog = new TextInputDialog(taskText.getText());
        dialog.setTitle("Edit Task Text");
        dialog.setHeaderText("Edit Task Text");
        dialog.setContentText(" Describe Task :");


        Optional<String> newTaskText = dialog.showAndWait();

        newTaskText.ifPresent(e -> taskText.setText((newTaskText.get()).toString()));
    }
    

}
