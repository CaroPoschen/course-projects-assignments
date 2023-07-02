package gui;

import gui.dataEntry.DataEntryController;
import gui.dataEntry.DataEntryView;
import gui.main.MainController;
import gui.main.MainView;
import gui.model.TableWrapper;
import gui.overview.OverviewController;
import gui.overview.OverviewView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    private Connector connector;

    @Override
    public void start(Stage stage) {
        try {
            connector = new Connector();

            TableWrapper tableWrapper = initModel(connector);
            MainController mainController = initViews(tableWrapper, connector);
            mainController.showDataEntryView();
            Scene scene = new Scene(mainController.getView(), 300, 420);
            stage.setScene(scene);
            stage.setTitle("Surgery Materials");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection();
        }
    }

    public TableWrapper initModel(Connector connector) throws SQLException {

        TableWrapper tableWrapper = new TableWrapper();
        tableWrapper.setSurgeryInstrumentList(connector.readInstrumentTable());
        tableWrapper.setSurgeryMaterialList(connector.readMaterialTable());
        tableWrapper.setSurgeryList(connector.readSurgeryTable());
        tableWrapper.setMedicalPersonalList(connector.readMedicalPersonalTable());

        return tableWrapper;
    }

    public MainController initViews(TableWrapper tableWrapper, Connector connector) {
        MainView mainView = new MainView();
        MainController mainController = new MainController();
        OverviewView overviewView = new OverviewView();
        OverviewController overviewController = new OverviewController();
        DataEntryView dataEntryView = new DataEntryView();
        DataEntryController dataEntryController = new DataEntryController();

        mainView.setController(mainController);
        mainController.setDataEntryController(dataEntryController);
        mainController.setOverviewController(overviewController);
        mainController.setView(mainView);

        overviewView.setController(overviewController);
        overviewController.setView(overviewView);
        overviewController.setConnector(connector);

        dataEntryView.setController(dataEntryController);
        dataEntryController.setView(dataEntryView);
        dataEntryController.setTableWrapper(tableWrapper);
        dataEntryController.setConnector(connector);

        mainView.initView();
        dataEntryView.initView();
        overviewView.initView();
        overviewController.showMaterials();

        return mainController;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
