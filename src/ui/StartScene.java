package ui;

import java.util.ResourceBundle;
import global.Initializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StartScene extends ProgScene {

	private ComboBox<String> comboBox;
	private String algorithm;
	private String goString = "Go";
	private EventHandler<ActionEvent> exitAction;
	private Initializer initializer;
	private ResourceBundle myResource;

	public StartScene(EventHandler<ActionEvent> exitAction, Initializer initializer) {
		super();
		this.exitAction = exitAction;
		this.initializer = initializer;
	}


	public Scene initScene(int size, ResourceBundle myResource) {
		this.myResource = myResource;
		Button exitButton = initExitButton();
		Button chooseFile = initFileButton();
		VBox box = new VBox();
		Label title = initTitle();
		box.getChildren().addAll(title, chooseFile, exitButton);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(100);
		BorderPane root = new BorderPane();
		root.setCenter(box);
		return new Scene(root, width, height);
	}

//	private ComboBox<String> initComboBox() {
//		ObservableList<String> options = 
//				FXCollections.observableArrayList(
//						Initializer.SEGREGATION,
//						Initializer.PRED_PREY,
//						Initializer.FIRE,
//						Initializer.LIFE
//						);
//		comboBox = new ComboBox<String>(options);
//		comboBox.setPromptText("Select a Simulation");
//		comboBox.setPrefWidth(200);
//		comboBox.setOnAction((e) -> {
//			algorithm =  comboBox.getSelectionModel().getSelectedItem().toString();    
//		});
//		return comboBox;
//	}

//	private VBox initCombinedSelectionBox(){
//		VBox box = new VBox(10);
//		HBox selectionBox = initSelectionBox();
//		Button chooseFile = initFileButton();
//		box.getChildren().addAll(selectionBox, chooseFile);
//		box.setAlignment(Pos.CENTER);
//		return box;
//
//	}

//	//drop down and go button
//	private HBox initSelectionBox() {
//		ComboBox<String> selection = initComboBox();
//		Button goButton = initGoButton();
//		HBox box = new HBox();
//		box.getChildren().addAll(selection, goButton);
//		box.setAlignment(Pos.CENTER);
//		return box;
//	}

//	private Button initGoButton() {
//		Button go = new Button(goString);
//		go.setOnAction(e->{
//			if (algorithm == null) {
//				ErrorPop pop = new ErrorPop(300, 200, myResource.getString("GoError"), myResource);
//				pop.popup();
//				return;
//			}
//			initializer.initSimulation(algorithm);
//		});
//		return go;
//	}

	private Button initFileButton() {
		Button chooseFile = new Button("Choose File");
		chooseFile.setOnAction(e ->{
			initializer.initSimulationFromFile();
		});
		return chooseFile;
	}

	private Label initTitle() {
		Label lbl = new Label("Cell Society");
		lbl.setFont(new Font(20));
		return lbl;
	}

	private Button initExitButton() {
		Button exit = new Button("Exit");
		exit.setPrefWidth(100);
		exit.setOnAction(exitAction);
		return exit;
	}
}
