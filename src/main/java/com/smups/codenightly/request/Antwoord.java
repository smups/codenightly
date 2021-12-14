package com.smups.codenightly.request;

import java.util.UUID;

public abstract class Antwoord extends Bericht{

    public Antwoord(UUID ontvanger, UUID verzender) {
        super(ontvanger, verzender, false); //false want dit is een antwoord
    }
    
}