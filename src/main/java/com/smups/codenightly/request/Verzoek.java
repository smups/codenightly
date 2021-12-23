package com.smups.codenightly.request;

import com.smups.codenightly.CodeNightlyID;

/**
 * Deze class is een kind van de {@link com.smups.request.Bericht}
 * class en specificeert het VERZOEK field als true. 
 */
public abstract class Verzoek extends Bericht{

    public Verzoek(CodeNightlyID ontvanger, CodeNightlyID verzender) {
        super(ontvanger, verzender, true); //true omdat dit een verzoek is
    }
    
}