package gui.dataEntry;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class DataEntryView extends VBox {
    private DataEntryController controller;

    private GridPane grid;
    private Label patient;
    private Label surgery;

    public DataEntryView() {
    }

    public void setController(DataEntryController controller) {
        this.controller = controller;
    }

    public void initView() {

        Label l = new Label("Data Entry");
        l.setFont(new Font("Arial", 20));
        this.getChildren().add(l);
        grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(5, 5, 5, 5));

        l = new Label("Surgery");
        grid.add(l, 0,0);
        this.surgery = new Label(controller.getSurgery());
        grid.add(surgery, 1, 0);
        l = new Label("Patient");
        grid.add(l, 0,1);
        this.patient = new Label(controller.getPatient());
        grid.add(patient, 1,1);

        l = new Label("Swab");
        grid.add(l, 0, 2);
        TextField swabField = new TextField("0");
        grid.add(swabField, 1,2);
        l = new Label("Bandage");
        grid.add(l, 0, 3);
        TextField bandageField = new TextField("0");
        grid.add(bandageField, 1,3);
        l = new Label("Suture Material");
        grid.add(l, 0, 4);
        TextField sutureMaterialField = new TextField("0");
        grid.add(sutureMaterialField, 1, 4);
        l = new Label("Surgical Mask");
        grid.add(l, 0, 5);
        TextField surgicalMaskField = new TextField("0");
        grid.add(surgicalMaskField, 1, 5);
        l = new Label("Surgical Glove");
        grid.add(l, 0, 6);
        TextField surgicalGloveField = new TextField("0");
        grid.add(surgicalGloveField, 1, 6);
        l = new Label("Scalpel");
        grid.add(l, 0, 7);
        TextField scalpelField = new TextField("0");
        grid.add(scalpelField, 1, 7);
        l = new Label("Scissors");
        grid.add(l, 0, 8);
        TextField scissorsField = new TextField("0");
        grid.add(scissorsField, 1, 8);
        l = new Label("Clamps");
        grid.add(l, 0, 9);
        TextField clampsField = new TextField("0");
        grid.add(clampsField, 1, 9);
        l = new Label("Surgical Tweezers");
        grid.add(l, 0, 10);
        TextField surgicalTweezerField = new TextField("0");
        grid.add(surgicalTweezerField, 1, 10);

        this.getChildren().add(grid);
        HBox hbox = new HBox(5);
        Button b = new Button("Save");
        b.setOnAction(e -> controller.save());
        hbox.getChildren().add(b);
        b = new Button("Cancel");
        b.setOnAction(e -> controller.cancel());
        hbox.getChildren().add(b);
        this.getChildren().add(hbox);
    }

    public List<Integer> getValues() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < grid.getChildren().size(); i++) {
            if(grid.getChildren().get(i) instanceof TextField) {
                list.add(Integer.valueOf(((TextField)grid.getChildren().get(i)).getText()));
            }
        }
        return list;
    }

    public void resetValues() {
        for(int i = 0; i < grid.getChildren().size(); i++) {
            if(grid.getChildren().get(i) instanceof TextField) {
                ((TextField) grid.getChildren().get(i)).setText("0");
            }
        }
    }

    public String getSurgery() {
        return this.surgery.getText();
    }

}
