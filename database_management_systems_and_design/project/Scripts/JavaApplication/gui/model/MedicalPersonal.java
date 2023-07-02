package gui.model;

public class MedicalPersonal {

    private final Integer id;
    private final String name;

    public MedicalPersonal(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
