package gui.model;

public class SurgeryMaterial {

    private final Integer id;
    private final Integer person;
    private final Integer surgery;
    private final Integer swab;
    private final Integer bandage;
    private final Integer sutureMaterial;
    private final Integer surgicalMask;
    private final Integer surgicalGlove;

    public SurgeryMaterial(Integer id, Integer person, Integer surgery, Integer swab, Integer bandage, Integer sutureMaterial, Integer surgicalMask, Integer surgicalGlove) {
        this.id = id;
        this.person = person;
        this.surgery = surgery;
        this.swab = swab;
        this.bandage = bandage;
        this.sutureMaterial = sutureMaterial;
        this.surgicalMask = surgicalMask;
        this.surgicalGlove = surgicalGlove;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPerson() {
        return person;
    }

    public Integer getSurgery() {
        return surgery;
    }

    public Integer getSwab() {
        return swab;
    }

    public Integer getBandage() {
        return bandage;
    }

    public Integer getSutureMaterial() {
        return sutureMaterial;
    }

    public Integer getSurgicalMask() {
        return surgicalMask;
    }

    public Integer getSurgicalGlove() {
        return surgicalGlove;
    }
}
