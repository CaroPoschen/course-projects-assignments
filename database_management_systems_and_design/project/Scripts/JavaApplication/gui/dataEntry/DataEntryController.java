package gui.dataEntry;

import gui.Connector;
import gui.model.SurgeryInstrument;
import gui.model.SurgeryMaterial;
import gui.model.TableWrapper;

import java.util.ArrayList;
import java.util.List;

public class DataEntryController {

    private DataEntryView view;
    private TableWrapper tableWrapper;
    private Connector connector;

    public DataEntryController() {
    }

    public DataEntryView getView() {
        return view;
    }

    public void setView(DataEntryView view) {
        this.view = view;
    }

    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public String getSurgery() {
        return tableWrapper.getNextSurgery().getId().toString();
    }

    public String getPatient() {
        return "5052";
    }

    public void cancel() {
        view.resetValues();
    }

    public void save() {
        List<Integer> list = view.getValues();

        SurgeryMaterial surgeryMaterial = new SurgeryMaterial(tableWrapper.getNextSurgeryMaterialId(),
                tableWrapper.getRandomMedicalPersonal().getId(), Integer.valueOf(view.getSurgery()),
                list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
        List<SurgeryMaterial> surgeryMaterialList = tableWrapper.getSurgeryMaterialList();
        surgeryMaterialList.add(surgeryMaterial);
        tableWrapper.setSurgeryMaterialList(surgeryMaterialList);
        List<Integer> valueList = new ArrayList<>();
        valueList.add(surgeryMaterial.getId());
        valueList.add(surgeryMaterial.getPerson());
        valueList.add(surgeryMaterial.getSurgery());
        valueList.add(surgeryMaterial.getSwab());
        valueList.add(surgeryMaterial.getBandage());
        valueList.add(surgeryMaterial.getSutureMaterial());
        valueList.add(surgeryMaterial.getSurgicalMask());
        valueList.add(surgeryMaterial.getSurgicalGlove());
        connector.putValue("surgery_material", valueList);

        SurgeryInstrument surgeryInstrument = new SurgeryInstrument(tableWrapper.getNextSurgeryInstrumentId(),
                surgeryMaterial.getPerson(), surgeryMaterial.getSurgery(),
                list.get(5), list.get(6), list.get(7), list.get(8));
        List<SurgeryInstrument> surgeryInstrumentList = tableWrapper.getSurgeryInstrumentList();
        surgeryInstrumentList.add(surgeryInstrument);
        tableWrapper.setSurgeryInstrumentList(surgeryInstrumentList);
        valueList = new ArrayList<>();
        valueList.add(surgeryInstrument.getId());
        valueList.add(surgeryInstrument.getPerson());
        valueList.add(surgeryInstrument.getSurgery());
        valueList.add(surgeryInstrument.getScalpel());
        valueList.add(surgeryInstrument.getScissors());
        valueList.add(surgeryInstrument.getClamps());
        valueList.add(surgeryInstrument.getSurgicalTweezers());
        connector.putValue("surgery_instrument", valueList);

        view.resetValues();
    }
}
