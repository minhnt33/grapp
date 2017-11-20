package hust.minh.grapp;

import hust.minh.grapp.model.Patient;
import hust.minh.grapp.model.PatientListWrapper;
import hust.minh.grapp.view.PatientTableController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Main extends Application {
    private ObservableList<Patient> _patients = FXCollections.observableArrayList();

    private Stage _primaryStage;
    private BorderPane _rootLayout;
    private String _filePath;

    @Override
    public void start(Stage primaryStage) throws Exception {
        _primaryStage = primaryStage;
        primaryStage.setTitle("Grapp");
        primaryStage.show();

        initRootLayout();

        _filePath = new File("").getAbsolutePath();
        _filePath = _filePath.concat("/data/patient.xml");

        loadPatientDataFromFile(new File(_filePath));
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
            patientTableController.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPatientDataFromFile(File file)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(PatientListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading xml from file and unmarshalling
            PatientListWrapper wrapper = (PatientListWrapper) um.unmarshal(file);
            _patients.clear();
            _patients.addAll(wrapper.getPatients());
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());
            alert.showAndWait();
        }
    }

    public void savePatientDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(PatientListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            PatientListWrapper wrapper = new PatientListWrapper();
            wrapper.setPatients(_patients);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    public Stage getPrimaryStage()
    {
        return _primaryStage;
    }

    public ObservableList<Patient> getPatientList() {
        return _patients;
    }
}
