package com.smups.codenightly.request;

import com.smups.codenightly.CodeNightlyID;

/**
 * Deze class is een kind van de {@link com.smups.request.Bericht}
 * class en specificeert het VERZOEK field als false. 
 */
public abstract class Antwoord extends Bericht{

    public Antwoord(CodeNightlyID ontvanger, CodeNightlyID verzender) {
        super(ontvanger, verzender, false); //false want dit is een antwoord
    }
    
}