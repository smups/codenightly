package com.smups.codenightly.request;

import java.util.UUID;

public abstract class Verzoek extends Bericht{

    public Verzoek(UUID ontvanger, UUID verzender) {
        super(ontvanger, verzender, true); //true omdat dit een verzoek is
    }
    
}