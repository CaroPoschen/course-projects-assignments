package gui.overview;

import gui.Connector;
import gui.model.InstrumentView;
import gui.model.MaterialView;
import gui.model.TableWrapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OverviewController {
    private OverviewView view;
    private Connector connector;

    public OverviewController() {
    }

    public OverviewView getView() {
        this.showMaterials();
        return view;
    }

    public void setView(OverviewView view) {
        this.view = view;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public void showMaterials() {
        try {
            MaterialView materialView = connector.readMaterialView();

            List<String> list = new ArrayList<>();
            list.add("Materials");
            list.add("Swab");
            list.add(materialView.getSwab().toString());
            list.add("Bandage");
            list.add(materialView.getBandage().toString());
            list.add("suture Material");
            list.add(materialView.getSutureMaterial().toString());
            list.add("Surgical Masks");
            list.add(materialView.getSurgicalMasks().toString());
            list.add("Surgical Gloves");
            list.add(materialView.getSurgicalGlove().toString());

            view.setLabels(list);
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void showInstruments() {
        try {
            InstrumentView instrumentView = connector.readInstrumentView();
            List<String> list = new ArrayList<>();
            list.add("Instruments");
            list.add("Scalpel");
            list.add(instrumentView.getScalpel().toString());
            list.add("Scissors");
            list.add(instrumentView.getScissors().toString());
            list.add("Clamps");
            list.add(instrumentView.getClamps().toString());
            list.add("Surgical Tweezers");
            list.add(instrumentView.getSurgicalTweezers().toString());

            view.setLabels(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
