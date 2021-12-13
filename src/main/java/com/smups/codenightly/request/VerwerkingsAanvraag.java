package com.smups.codenightly.request;

import java.util.UUID;

import com.smups.codenightly.DataContainer;
import com.smups.codenightly.Opdracht;

/**
 * Deze class breidt de Aanvraag class uit met een data veld en een verwerkings-
 * code. Deze aanvraag moet gebruikt worden als de gebruiker data wil versturen
 * naar de server die op de server verwerkt moet worden. De verwerkingscode
 * wordt gespecificeert in de vorm van een opdracht.
 */
public class VerwerkingsAanvraag extends Aanvraag{
    public static final long serialVersionUID = 1L;

    //Data
    private final DataContainer VERZOEK_DATA;

    //En de opdracht
    private final Opdracht OPDRACHT;

    /**
     * 
     * @param ontvanger
     * @param verzender
     * @param data
     * @param opdracht
     */
    public VerwerkingsAanvraag(UUID ontvanger, UUID verzender,
        DataContainer data, Opdracht opdracht) {
        super(ontvanger, verzender);
        
        this.VERZOEK_DATA = data;
        this.OPDRACHT = opdracht;
    }

    @Override
    /**
     * Levert een geformatte string met informatie over de verwerkingsaanvraag.
     * 
     * @return String met geformatte informatie over deze verwerkingsaanvraag.
     */
    public String display() {
        return String.format(
            "[VERWERKINGSAANVRAAG]\nid: {}\n{}\n{}",
            this.AANVRAAG_ID.toString(),
            this.parent_to_string(),
            this.OPDRACHT.display()  
        );
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        return false;
    }
    
}