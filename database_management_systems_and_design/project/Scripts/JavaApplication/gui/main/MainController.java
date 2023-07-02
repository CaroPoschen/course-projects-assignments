package gui.main;

import gui.dataEntry.DataEntryController;
import gui.overview.OverviewController;

public class MainController {

    private MainView view;
    private DataEntryController dataEntryController;
    private OverviewController overviewController;

    public MainController() {
    }

    public MainView getView() {
        return view;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public void setDataEntryController(DataEntryController dataEntryController) {
        this.dataEntryController = dataEntryController;
    }

    public void setOverviewController(OverviewController overviewController) {
        this.overviewController = overviewController;
    }

    public void showOverviewView() {
        view.setView(overviewController.getView());
    }

    public void showDataEntryView() {
        view.setView(dataEntryController.getView());
    }

}
