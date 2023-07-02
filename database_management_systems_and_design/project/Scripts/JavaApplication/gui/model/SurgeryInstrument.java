package gui.model;

public class SurgeryInstrument {
    private final Integer id;
    private final Integer person;
    private final Integer surgery;
    private final Integer scalpel;
    private final Integer scissors;
    private final Integer clamps;
    private final Integer surgicalTweezers;

    public SurgeryInstrument(Integer id, Integer person, Integer surgery, Integer scalpel, Integer scissors, Integer clamps, Integer surgicalTweezers) {
        this.id = id;
        this.person = person;
        this.surgery = surgery;
        this.scalpel = scalpel;
        this.scissors = scissors;
        this.clamps = clamps;
        this.surgicalTweezers = surgicalTweezers;
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

    public Integer getScalpel() {
        return scalpel;
    }

    public Integer getScissors() {
        return scissors;
    }

    public Integer getClamps() {
        return clamps;
    }

    public Integer getSurgicalTweezers() {
        return surgicalTweezers;
    }
}
