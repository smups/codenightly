package com.smups.codenightly.request;

import java.util.UUID;

public class DataAanvraag extends Verzoek{

    public DataAanvraag(UUID ontvanger, UUID verzender) {
        super(ontvanger, verzender);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String display() {
        // TODO Auto-generated method stub
        return null;
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
