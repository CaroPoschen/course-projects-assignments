package gui.overview;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class OverviewView extends BorderPane {
    private OverviewController controller;

    private List<Label> labelList;
    private GridPane grid;

    public OverviewView() {
    }

    public void setController(OverviewController controller) {
        this.controller = controller;
    }

    public void initView() {
        VBox vbox = new VBox(10);
        Label l = new Label("Overview");
        l.setFont(new Font("Arial", 20));
        vbox.getChildren().add(l);
        HBox hbox = new HBox(10);
        Button b = new Button("Materials");
        b.setOnAction(e -> controller.showMaterials());
        hbox.getChildren().add(b);
        b = new Button("Instruments");
        b.setOnAction(e -> controller.showInstruments());
        hbox.getChildren().add(b);
        vbox.getChildren().add(hbox);
        this.setTop(vbox);

        grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setPadding(new Insets(5,5,5,5));

        labelList = new ArrayList<>();
        l = new Label("");
        grid.add(l, 0, 0);
        l.setFont(new Font("Arial", 20));
        labelList.add(l);
        for(int i = 2; i < 12; i++) {
            l = new Label(String.valueOf(i));
            labelList.add(l);
            grid.add(l, i%2, (i/2));
        }

        this.setCenter(grid);
    }

    public void setLabels(List<String> values) {
        for (Label label : labelList) {
            label.setText("");
        }

        for (int i = 0; i < values.size(); i++) {
            labelList.get(i).setText(values.get(i));
        }
    }
}
