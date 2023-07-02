package gui.model;

public class Surgery {

    private final Integer id;
    private final String name;
    private final Integer patient_id;

    public Surgery(Integer id, String name, Integer patient_id) {
        this.id = id;
        this.name = name;
        this.patient_id = patient_id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPatient_id() {
        return patient_id;
    }
}
