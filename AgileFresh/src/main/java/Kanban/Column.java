package main.java.Kanban;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Column {

    Parent root;
    VBox taskBox;
    FXMLLoader loader;

    public Column(String str) throws IOException {

        //load the FXML FILE
        loader = new FXMLLoader(getClass().getResource("FXML/Column.fxml"));
        root = loader.load();

        //gets the controller to use its values & functions
        ColumnController control = loader.getController();
        control.initialise();

        //set the name of the Column at launch.
        control.setColName();

    }


    public Parent getColumn() throws IOException {
        return root;
    }


}


//        //add the basic two tasks.
//        BorderPane mainRoot = (BorderPane) root;
//        ScrollPane taskPane = (ScrollPane) mainRoot.getCenter();
//        taskBox = (VBox) taskPane.getContent();
//
//        taskBox.getChildren().addAll((new Task().getTask()) ,(new Task().getTask())  );