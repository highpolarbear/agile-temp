package main.java.Kanban;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class Task {

    public Parent getTask() throws IOException {

        //load the fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/Card.fxml"));
        Parent root = loader.load();

        //get the controller to get the new Task name.
        TaskController control = loader.getController();
        control.initialise();

        //set the new Task name
        control.setTaskName();

        return root;
    }
}
