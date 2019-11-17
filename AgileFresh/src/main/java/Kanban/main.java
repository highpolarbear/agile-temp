package main.java.Kanban;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class main extends Application {

    Parent root;
    BorderPane mainPane;
    HBox cols;

    ArrayList<Column> columns = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Load the FXML File
        //FXMLLoader loader = new FXMLLoader();
        root = FXMLLoader.load(getClass().getResource("FXML/Board.fxml"));

        //Set the root Pane
        mainPane = (BorderPane) root;

        //Get the HBox containing the Columns.
        ScrollPane colPane = (ScrollPane) mainPane.getCenter();
        cols = (HBox) colPane.getContent();

        /* UNCOMMENT TO TEST

        import javafx.scene.text.Text;
        //Add the word banana into the column.
        cols.getChildren().addAll( (new Text("b a n a n a")),(new Text("b a n a n a")),
                (new Text("b a n a n a")),(new Text("b a n a n a")),
                (new Text("b a n a n a")),(new Text("b a n a n a")));

        //Add two basic columns in the board.
        columns.add(new Column());
        columns.add(new Column());

        //collect all columns and add them to display
        for (Column col : columns){
            cols.getChildren().add(col.getColumn());
        }

        */


        //intialise the button actions
        initButtonAction();

        //Display everything out.
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void initButtonAction(){

        ButtonBar bar = (ButtonBar) mainPane.getBottom();

        ObservableList<Node> listOfButts = bar.getButtons();

        for (Node node : listOfButts) {
            Button butt = (Button) node;

            if (butt.getId().equals("insert")) {
                butt.setOnAction(e -> {
                    try {
                        addCol();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }

        }

    }


    public void addCol() throws IOException {
        Column newCol = new Column(" ");
        cols.getChildren().add(newCol.getColumn());
    }

    @FXML
    public void exitApplication(){
        System.exit(0);
    }

    @FXML
    public void showAbout() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(" KanBan Board");
        alert.setContentText("Made by Team Saffron");

        alert.showAndWait();

    }


}
