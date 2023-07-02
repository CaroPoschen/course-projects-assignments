package gui.model;

public class MaterialView {

    private final Integer swab;
    private final Integer bandage;
    private final Integer sutureMaterial;
    private final Integer surgicalMasks;
    private final Integer surgicalGlove;

    public MaterialView(Integer swab, Integer bandage, Integer sutureMaterial, Integer surgicalMasks, Integer surgicalGlove) {
        this.swab = swab;
        this.bandage = bandage;
        this.sutureMaterial = sutureMaterial;
        this.surgicalMasks = surgicalMasks;
        this.surgicalGlove = surgicalGlove;
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

    public Integer getSurgicalMasks() {
        return surgicalMasks;
    }

    public Integer getSurgicalGlove() {
        return surgicalGlove;
    }
}
