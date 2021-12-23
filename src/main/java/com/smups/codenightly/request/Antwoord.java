package com.smups.codenightly.request;

import java.util.UUID;

/**
 * Deze class is een kind van de {@link com.smups.request.Bericht}
 * class en specificeert het VERZOEK field als false. 
 */
public abstract class Antwoord extends Bericht{

    public Antwoord(UUID ontvanger, UUID verzender) {
        super(ontvanger, verzender, false); //false want dit is een antwoord
    }
    
}