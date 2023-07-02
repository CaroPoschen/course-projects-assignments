package gui.model;

import java.util.List;
import java.util.Random;

public class TableWrapper {

    private List<MedicalPersonal> medicalPersonalList;
    private List<Surgery> surgeryList;
    private List<SurgeryInstrument> surgeryInstrumentList;
    private List<SurgeryMaterial> surgeryMaterialList;

    public TableWrapper() {
    }

    public void setMedicalPersonalList(List<MedicalPersonal> medicalPersonalList) {
        this.medicalPersonalList = medicalPersonalList;
    }

    public void setSurgeryList(List<Surgery> surgeryList) {
        this.surgeryList = surgeryList;
    }

    public List<SurgeryInstrument> getSurgeryInstrumentList() {
        return surgeryInstrumentList;
    }

    public void setSurgeryInstrumentList(List<SurgeryInstrument> surgeryInstrumentList) {
        this.surgeryInstrumentList = surgeryInstrumentList;
    }

    public List<SurgeryMaterial> getSurgeryMaterialList() {
        return surgeryMaterialList;
    }

    public void setSurgeryMaterialList(List<SurgeryMaterial> surgeryMaterialList) {
        this.surgeryMaterialList = surgeryMaterialList;
    }

    public MedicalPersonal getRandomMedicalPersonal() {
        if (medicalPersonalList == null || medicalPersonalList.size() < 1) {
            return null;
        } else {
            Random rand = new Random();
            int medicalPerson = rand.nextInt(medicalPersonalList.size());
            return medicalPersonalList.get(medicalPerson);
        }
    }

    public Surgery getNextSurgery() {
        if (surgeryList != null && surgeryList.size() > 0) {
            SurgeryMaterial surgeryMaterial = surgeryMaterialList.get(surgeryInstrumentList.size() - 1);
            for(int i = 0; i < surgeryList.size(); i++) {
                if(surgeryList.get(i).getId().equals(surgeryMaterial.getSurgery())) {
                    return surgeryList.get(i + 1);
                }
            }
        }
        return null;
    }

    public Integer getNextSurgeryInstrumentId() {
        int maxSurgery = -1;
        for(SurgeryInstrument surgeryInstrument : surgeryInstrumentList) {
            if(surgeryInstrument.getId() > maxSurgery)
                maxSurgery = surgeryInstrument.getId();
        }
        return maxSurgery + 1;
    }

    public Integer getNextSurgeryMaterialId() {
        return surgeryMaterialList.get(surgeryMaterialList.size() - 1).getId() + 1;
    }
}
