package UI;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.readJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/*************************************************/
/**  SERVER MUST RUN FIRST FOR PROGRAM TO RUN   **/
/*************************************************/

//UI for the Tokimon Application
//Initializes and runs all elements on UI
public class tokimonViewer extends Application {

    private TextField nameField;
    private TextField weightField;
    private TextField heightField;
    private TextField fireField;
    private TextField waterField;
    private TextField strengthField;
    private TextField electricField;
    private TextField iceField;
    private TextField flyField;
    private Button addTokimon;

    private TextField changeStrViewer;
    private TextField setID;
    private Button alterTokimon;

    private TextField deleteTokiID;
    private Button deleteTokimon;

    private Label showTokimon;
    private GridPane tokimonGrid = new GridPane();

    private TextField idInput;
    private Button showTokiId;


    private readJson reader;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        showTokimons();

        /***********************************Create a Tokimon*********************************************/

        GridPane gridpane = new GridPane();
        gridpane.setHgap(20);
        gridpane.setVgap(20);

        Label newTokimon = new Label("Create a Tokimon!");
        newTokimon.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        /*********************Name*********************/

        Label nameLabel = new Label("Name");
        nameField = new TextField();
        gridpane.add(nameLabel, 0, 0);
        gridpane.add(nameField, 1,0);

        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!nameField.getText().equals("")) {
                checkAddButton();
            }else{
                addTokimon.setDisable(true);
            }
        });

        /*********************Weight*********************/

        Label weightLabel = new Label("Weight");
        gridpane.add(weightLabel, 0, 1);

        Slider weightSlider = new Slider(1,500,1);
        weightSlider.setShowTickMarks(true);
        weightSlider.setMajorTickUnit(500);
        weightSlider.setShowTickLabels(true);
        gridpane.add(weightSlider, 1,1);

        weightField = new TextField();
        weightField.setEditable(false);
        gridpane.add(weightField, 2, 1);

        weightSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int weight = (int) weightSlider.getValue();
                weightField.setText("" + weight);
                checkAddButton();
            }
        });


        /*********************Height*********************/

        Label heightLabel = new Label("Height");
        gridpane.add(heightLabel, 0, 2);

        Slider heightSlider = new Slider(1,500,1);
        heightSlider.setShowTickMarks(true);
        heightSlider.setMajorTickUnit(500);
        heightSlider.setShowTickLabels(true);
        gridpane.add(heightSlider, 1,2);

        heightField = new TextField();
        heightField.setEditable(false);
        gridpane.add(heightField, 2, 2);

        heightSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int height = (int) heightSlider.getValue();
                heightField.setText("" + height);
                checkAddButton();
            }
        });

        /*********************Fire Ability*********************/

        Label fireLabel = new Label("Fire");
        gridpane.add(fireLabel, 0, 3);

        Slider fireSlider = new Slider(1,100,1);
        fireSlider.setShowTickMarks(true);
        fireSlider.setMajorTickUnit(100);
        fireSlider.setShowTickLabels(true);
        gridpane.add(fireSlider, 1,3);

        fireField = new TextField();
        fireField.setEditable(false);
        gridpane.add(fireField, 2, 3);

        fireSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int fire = (int) fireSlider.getValue();
                fireField.setText("" + fire);
                checkAddButton();
            }
        });

        /*********************Water Ability*********************/

        Label waterLabel = new Label("Water");
        gridpane.add(waterLabel, 0, 4);

        Slider waterSlider = new Slider(1,100,1);
        waterSlider.setShowTickMarks(true);
        waterSlider.setMajorTickUnit(100);
        waterSlider.setShowTickLabels(true);
        gridpane.add(waterSlider, 1,4);

        waterField = new TextField();
        waterField.setEditable(false);
        gridpane.add(waterField, 2, 4);

        waterSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int water = (int) waterSlider.getValue();
                waterField.setText("" + water);
                checkAddButton();
            }
        });

        /*********************Electric Ability*********************/

        Label electricLabel = new Label("Electric");
        gridpane.add(electricLabel, 0, 5);

        Slider electricSlider = new Slider(1,100,1);
        electricSlider.setShowTickMarks(true);
        electricSlider.setMajorTickUnit(100);
        electricSlider.setShowTickLabels(true);
        gridpane.add(electricSlider, 1,5);

        electricField = new TextField();
        electricField.setEditable(false);
        gridpane.add(electricField, 2, 5);

        electricSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int electric = (int) electricSlider.getValue();
                electricField.setText("" + electric);
                checkAddButton();
            }
        });

        /*********************Ice Ability*********************/

        Label iceLabel = new Label("Ice");
        gridpane.add(iceLabel, 0, 6);

        Slider iceSlider = new Slider(1,100,1);
        iceSlider.setShowTickMarks(true);
        iceSlider.setMajorTickUnit(100);
        iceSlider.setShowTickLabels(true);
        gridpane.add(iceSlider, 1,6);

        iceField = new TextField();
        iceField.setEditable(false);
        gridpane.add(iceField, 2, 6);

        iceSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int ice = (int) iceSlider.getValue();
                iceField.setText("" + ice);
                checkAddButton();
            }
        });

        /*********************Fly Ability*********************/

        Label flyLabel = new Label("Fly");
        gridpane.add(flyLabel, 0, 7);

        Slider flySlider = new Slider(1,100,1);
        flySlider.setShowTickMarks(true);
        flySlider.setMajorTickUnit(100);
        flySlider.setShowTickLabels(true);
        gridpane.add(flySlider, 1,7);

        flyField = new TextField();
        flyField.setEditable(false);
        gridpane.add(flyField, 2, 7);

        flySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int fly = (int) flySlider.getValue();
                flyField.setText("" + fly);
                checkAddButton();
            }
        });

        /*********************Strength*********************/

        Label strengthLabel = new Label("Strength");
        gridpane.add(strengthLabel, 0, 8);

        Slider strengthSlider = new Slider(1,100,1);
        strengthSlider.setShowTickMarks(true);
        strengthSlider.setMajorTickUnit(100);
        strengthSlider.setShowTickLabels(true);
        gridpane.add(strengthSlider, 1,8);

        strengthField = new TextField();
        strengthField.setEditable(false);
        gridpane.add(strengthField, 2, 8);

        strengthSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int strength = (int) strengthSlider.getValue();
                strengthField.setText("" + strength);
                checkAddButton();
            }
        });

        /*********************Color Button*********************/

        Label colorLabel = new Label();

        RadioButton colorBlue = new RadioButton("Blue");
        RadioButton colorGreen = new RadioButton("Green");
        RadioButton colorRed = new RadioButton("Red");
        RadioButton colorBlack = new RadioButton("Black");
        RadioButton colorYellow = new RadioButton("Yellow");

        ToggleGroup G1 = new ToggleGroup();
        colorBlue.setToggleGroup(G1);
        colorGreen.setToggleGroup(G1);
        colorRed.setToggleGroup(G1);
        colorBlack.setToggleGroup(G1);
        colorYellow.setToggleGroup(G1);


        HBox hbox = new HBox();
        hbox.setSpacing(20);
        hbox.getChildren().addAll(colorBlue,colorGreen,colorRed,colorBlack,colorYellow);
        colorBlue.setSelected(true);


        /*********************add Tokimon Button*********************/

        addTokimon = new Button("Create Tokimon!");
        addTokimon.setDisable(true);
        gridpane.add(addTokimon, 2 ,9);

        addTokimon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    URL url = new URL("http://localhost:8080/api/tokimon/add");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type","application/json");

                    String color = "";
                    if(colorBlue.isSelected()){
                        color = "blue";
                    }else if(colorGreen.isSelected()){
                        color = "green";
                    }else if(colorRed.isSelected()){
                        color = "red";
                    }else if(colorBlack.isSelected()){
                        color = "black";
                    }else if(colorYellow.isSelected()){
                        color = "yellow";
                    }

                    OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
                    wr.write("{\"name\":\"" + nameField.getText() + "\",\"weight\":" + weightField.getText() + ",\"height\":"
                    + heightField.getText() + ",\"strength\":" + strengthField.getText() + ",\"fire\":" + fireField.getText()
                    + ",\"water\":" + waterField.getText() + ",\"electric\":" + electricField.getText() + ",\"ice\":" + iceField.getText()
                    + ",\"fly\":" + flyField.getText() + ",\"color\":\"" + color + "\"}");
                    wr.flush();
                    wr.close();

                    connection.connect();
                    System.out.println(connection.getResponseCode());

                    connection.disconnect();

                    nameField.setText("");
                    weightSlider.setValue(1);
                    heightSlider.setValue(1);
                    strengthSlider.setValue(1);
                    fireSlider.setValue(1);
                    waterSlider.setValue(1);
                    electricSlider.setValue(1);
                    iceSlider.setValue(1);
                    flySlider.setValue(1);

                    addTokimon.setDisable(true);
                    showTokimons();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        /************************************Alter tokimon height********************************************/

        Label smartResponse = new Label();

        Label alterTokiLabel = new Label("Change Tokimon Height");
        alterTokiLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        alterTokimon = new Button("Alter Tokimon");
        alterTokimon.setDisable(true);

        Label changeID = new Label("Tokimon ID");
        setID = new TextField();
        setID.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!setID.getText().equals("")) {
                checkAlterButton();
            }else{
                alterTokimon.setDisable(true);
            }
        });


        Label changeHeight = new Label("Set New Height");
        Slider newHeightSlider = new Slider(1,500,1);
        newHeightSlider.setShowTickMarks(true);
        newHeightSlider.setMajorTickUnit(500);
        newHeightSlider.setShowTickLabels(true);

        changeStrViewer = new TextField();
        changeStrViewer.setEditable(false);

        newHeightSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int newStrength = (int) newHeightSlider.getValue();
                changeStrViewer.setText("" + newStrength);
                checkAlterButton();
            }
        });

        GridPane alterTokiGrid = new GridPane();
        alterTokiGrid.setHgap(20);
        alterTokiGrid.setVgap(20);
        alterTokiGrid.add(changeID,0 ,0);
        alterTokiGrid.add(setID, 1 , 0);
        alterTokiGrid.add(changeHeight, 0, 1);
        alterTokiGrid.add(newHeightSlider,1,1);
        alterTokiGrid.add(changeStrViewer, 2, 1);
        alterTokiGrid.add(alterTokimon, 0, 2);
        alterTokiGrid.add(smartResponse, 1, 2);

        alterTokimon.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   URL url = new URL("http://localhost:8080/api/tokimon/change/" + setID.getText() + "?height=" + changeStrViewer.getText());
                   HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                   connection.setDoOutput(true);
                   connection.setRequestMethod("POST");

                   connection.connect();
                   System.out.println(connection.getResponseCode());
                   if(connection.getResponseCode() == 404){
                        smartResponse.setText("Invalid ID number!");
                   }else{
                        smartResponse.setText( "ID " + setID.getText() + "'s Heights Changed!");
                   }
                   connection.disconnect();

                   newHeightSlider.setValue(1);
                   setID.setText("");
                   changeStrViewer.setText("");
                   alterTokimon.setDisable(true);
                   showTokimons();
               }catch(IOException e){
                   e.printStackTrace();
               }

           }
       });

        /************************************Delete tokimon********************************************/

        Label deleteTokiLabel = new Label("Delete a Tokimon");
        deleteTokiLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        GridPane deleteTokiGrid = new GridPane();
        deleteTokiGrid.setVgap(20);
        deleteTokiGrid.setHgap(20);

        Label tokiIDLabel = new Label("Tokimon ID");

        deleteTokimon = new Button("Delete Tokimon");
        deleteTokimon.setDisable(true);

        Label delSmartResponse = new Label();

        deleteTokiID = new TextField();
        deleteTokiID.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!deleteTokiID.getText().equals("")) {
                checkDeleteButton();
            }else{
                deleteTokimon.setDisable(true);
            }
        });

        deleteTokiGrid.add(tokiIDLabel, 0, 0);
        deleteTokiGrid.add(deleteTokiID, 1, 0);
        deleteTokiGrid.add(deleteTokimon, 0, 1);
        deleteTokiGrid.add(delSmartResponse, 1,1);

        deleteTokimon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    URL url = new URL("http://localhost:8080/api/tokimon/" + deleteTokiID.getText());
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setRequestMethod("DELETE");

                    connection.connect();
                    System.out.println(connection.getResponseCode());
                    if(connection.getResponseCode() == 404){
                        delSmartResponse.setText("Invalid ID number!");
                    }else{
                        delSmartResponse.setText( "ID " + deleteTokiID.getText() + " has been deleted!");
                    }
                    connection.disconnect();

                    deleteTokiID.setText("");
                    deleteTokimon.setDisable(true);

                    showTokimons();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        /************************************Display Specific tokimon********************************************/

        Label displayTokiLabel = new Label("Display Specific Tokimon");
        displayTokiLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        showTokiId = new Button("Display Tokimon");
        showTokiId.setDisable(true);

        Label displaySmartResponse = new Label();

        Label displayIDLabel = new Label("Tokimon ID");
        idInput = new TextField();
        idInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!idInput.getText().equals("")) {
                checkDisplayButton();
            }else{
                showTokiId.setDisable(true);
            }
        });

        TextField resultId = new TextField();
        resultId.setEditable(false);
        resultId.setMinSize(40, 100);

        showTokiId.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    URL url = new URL("http://localhost:8080/api/tokimon/" + idInput.getText());
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    if(connection.getResponseCode() == 404){
                        displaySmartResponse.setText("Invalid ID number!");
                        resultId.setText("");
                    }else {
                        displaySmartResponse.setText("Displaying ID " + idInput.getText() + "!");

                        connection.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                        String output = br.readLine();
                        resultId.setText(output);

                    }
                    idInput.setText("");

                }catch(IOException e){
                    e.printStackTrace();
                }

            }
        });

        GridPane displayTokiGrid = new GridPane();
        displayTokiGrid.setHgap(20);
        displayTokiGrid.setVgap(20);

        displayTokiGrid.add(displayIDLabel, 0,0);
        displayTokiGrid.add(idInput, 1, 0);
        displayTokiGrid.add(showTokiId, 0,1);
        displayTokiGrid.add(displaySmartResponse,1,1);




        /******************************Sorts elements onto scene**************************************************/



        VBox vboxLeft = new VBox(20);
        VBox.setMargin(newTokimon, new Insets(30,0,0,90));
        VBox.setMargin(hbox, new Insets(5,0,0,90));
        VBox.setMargin(gridpane, new Insets(5,0,0,90));
        vboxLeft.getChildren().addAll(newTokimon, hbox ,gridpane);

        VBox vboxRight = new VBox();
        VBox.setMargin(alterTokiLabel, new Insets(30,0,0,200));
        VBox.setMargin(alterTokiGrid, new Insets(30,0,0,200));
        VBox.setMargin(deleteTokiLabel, new Insets(80,0,0,200));
        VBox.setMargin(deleteTokiGrid, new Insets(30,0,0,200));
        VBox.setMargin(displayTokiLabel, new Insets(80,0,0,200));
        VBox.setMargin(displayTokiGrid, new Insets(30,0,0,200));
        VBox.setMargin(resultId, new Insets(30,0,0,200));
        vboxRight.getChildren().addAll(alterTokiLabel, alterTokiGrid, deleteTokiLabel, deleteTokiGrid, displayTokiLabel, displayTokiGrid, resultId);

        HBox basehbox = new HBox();
        basehbox.getChildren().addAll(vboxLeft,vboxRight);

        VBox outline = new VBox();
        VBox.setMargin(showTokimon, new Insets(50,0,0,90));
        VBox.setMargin(tokimonGrid, new Insets(100,0,0,90));
        outline.getChildren().addAll(basehbox, showTokimon, tokimonGrid);

        Scene scene = new Scene(outline , 1300, 1300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tokimon Viewer");
        primaryStage.show();
    }

    /*********************EnableAddTokimonButton*********************/
    public void checkAddButton(){
        if(!nameField.getText().equals("") && !weightField.getText().equals("") &&
                !heightField.getText().equals("") && !strengthField.getText().equals("") &&
                !fireField.getText().equals("") && !waterField.getText().equals("") &&
                !electricField.getText().equals("") && !iceField.getText().equals("") &&
                !flyField.getText().equals("")){
            addTokimon.setDisable(false);
        }
    }

    /*********************EnableAlterTokimonButton*********************/
    public void checkAlterButton(){
        if(!setID.getText().equals("") && !changeStrViewer.getText().equals("")) {
            alterTokimon.setDisable(false);
        }
    }

    /*********************EnableDeleteTokimonButton*********************/
    public void checkDeleteButton(){
        if(!deleteTokiID.getText().equals("")){
            deleteTokimon.setDisable(false);
        }
    }

    /*********************EnableDisplayTokimonButton*********************/
    public void checkDisplayButton(){
        if(!idInput.getText().equals("")){
            showTokiId.setDisable(false);
        }
    }

    /************************************Show tokimons*******************************************/
    public void showTokimons(){

        tokimonGrid.getChildren().clear();

        showTokimon = new Label("Stored Tokimons");
        showTokimon.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        try {
            URL url = new URL("http://localhost:8080/api/tokimon/all");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String output = br.readLine();

            reader = new readJson(output);
            System.out.println(connection.getResponseCode());


        }catch(IOException e){
            e.printStackTrace();
        }

        for(int i=0 ; i<reader.getAmount(); i++){
            Rectangle tokiRec = new Rectangle();
            int weight = reader.getWeight(i)/2;
            int height = reader.getHeight(i)/2;
            tokiRec.setWidth(weight);
            tokiRec.setHeight(height);

            //So you can at least see the square
            if(weight < 10 && height < 10){
                tokiRec.setWidth(10);
                tokiRec.setHeight(10);
            }


            Rectangle insideRec = new Rectangle();
            insideRec.setWidth(weight);
            insideRec.setHeight(height-20);


            if(reader.getColor(i).equals("black")){
                tokiRec.setFill(Color.BLACK);
                insideRec.setFill(Color.DARKGREY);
            }else if(reader.getColor(i).equals("blue")){
                tokiRec.setFill(Color.BLUE);
                insideRec.setFill(Color.LIGHTBLUE);
            }else if(reader.getColor(i).equals("green")){
                tokiRec.setFill(Color.GREEN);
                insideRec.setFill(Color.LIGHTGREEN);
            }else if(reader.getColor(i).equals("yellow")){
                tokiRec.setFill(Color.YELLOW);
                insideRec.setFill(Color.LIGHTYELLOW);
            }else if(reader.getColor(i).equals("red")){
                tokiRec.setFill(Color.RED);
                insideRec.setFill(Color.ORANGERED);
            }

            insideRec.widthProperty().unbind();

            tokimonGrid.setHgap(20);
            tokimonGrid.setVgap(20);

            tokimonGrid.add(tokiRec, i, 0);
            tokimonGrid.add(insideRec, i, 0);
            Label labName = new Label(reader.getName(i));
            labName.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
            tokimonGrid.add(labName, i, 1);

        }


    }

}
