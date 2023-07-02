package gui.model;

public class InstrumentView {

    private final Integer scalpel;
    private final Integer scissors;
    private final Integer clamps;
    private final Integer surgicalTweezers;

    public InstrumentView(Integer scalpel, Integer scissors, Integer clamps, Integer surgicalTweezers) {
        this.scalpel = scalpel;
        this.scissors = scissors;
        this.clamps = clamps;
        this.surgicalTweezers = surgicalTweezers;
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
