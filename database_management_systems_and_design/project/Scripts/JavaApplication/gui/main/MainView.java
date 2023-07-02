package gui.main;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {

    private MainController controller;

    public MainView() {
    }

    public void initView() {
        this.setPadding(new Insets(5,5,5,5));
        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(5,5,5,5));
        Button b = new Button("Data Entry");
        b.setOnAction(e -> controller.showDataEntryView());
        hbox.getChildren().add(b);
        b = new Button("Overview");
        b.setOnAction(e -> controller.showOverviewView());
        hbox.getChildren().add(b);
        this.setTop(hbox);
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public void setView(Pane view) {
        this.setCenter(view);

    }
}
