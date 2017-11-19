package hust.minh.grapp;

import hust.minh.grapp.model.Patient;
import hust.minh.grapp.view.PatientTableController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private ObservableList<Patient> _patients = FXCollections.observableArrayList();

    private Stage _primaryStage;
    private BorderPane _rootLayout;

    public Main() {
        _patients.add(new Patient(0));
        _patients.add(new Patient(1));
        _patients.add(new Patient(2));
        _patients.add(new Patient(3));
        _patients.add(new Patient(4));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        _primaryStage = primaryStage;
        primaryStage.setTitle("Grapp");
        primaryStage.show();

        initRootLayout();
        showPatientTable();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            _rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(_rootLayout, 1600, 900);
            _primaryStage.setScene(scene);
            _primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPatientTable() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/PatientManagementLayout.fxml"));
            AnchorPane patientManagementView = loader.load();

            // Set person overview into the center of root layout.
            _rootLayout.setCenter(patientManagementView);

            // Setup Controller
            PatientTableController patientTableController = loader.getController();
            patientTableController.setTableItems(_patients);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
