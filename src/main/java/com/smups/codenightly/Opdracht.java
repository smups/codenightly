package com.smups.codenightly;

import java.io.Serializable;


/**
 * 
 */
public class Opdracht implements Serializable{

    //Specificatie van de opdracht
    public final String OPDRACHT_CODE;
    public final int PRIORITEIT;

    /**
     * Deze constructor maakt een nieuwe Opdracht voor een gegeven opdrachtcode
     * en prioriteit. 
     * 
     * @param opdracht_code is de opdracht code van de nieuwe Opdracht.
     * @param prioriteit is de prioriteit dezes.
     */
    public Opdracht(String opdracht_code, int prioriteit) {
        this.OPDRACHT_CODE = opdracht_code;
        this.PRIORITEIT = prioriteit;
    }

    /**
     * Hulpfunctie om opdrachten te formatten in een human-readable format.
     * 
     * @return geformatte string van 1 regel met opdrachtcode en prioriteit.
     */
    public String display() {
        return String.format("opdracht: {} met prioriteit ({})}",
            this.OPDRACHT_CODE,
            String.valueOf(this.PRIORITEIT)
        );
    }

    //Opdrachten kunnen vergeleken worden
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Serializable)) return false;
        else {
            Opdracht that = (Opdracht) o;
            return 
                (that.OPDRACHT_CODE.equals(this.OPDRACHT_CODE)) &&
                (that.PRIORITEIT == this.PRIORITEIT);
        }
    }
}