package com.smups.codenightly.request;

import com.smups.codenightly.CodeNightlyID;
import com.smups.codenightly.DataContainer;
import com.smups.codenightly.Opdracht;

/**
 * Deze class breidt de Verzoek class uit met een data veld en een verwerkings-
 * code. Dit verzoek moet gebruikt worden als de gebruiker data wil versturen
 * naar de server die op de server verwerkt moet worden. De verwerkingscode
 * wordt gespecificeert in de vorm van een opdracht.
 * 
 * Deze class kan worden geserialiseerd en gehasht.
 * 
 * @author Raúl
 */
public class VerwerkingsVerzoek extends Verzoek{
    public static final long serialVersionUID = 1L;

    //Data
    private final DataContainer VERZOEK_DATA;

    //En de opdracht
    private final Opdracht OPDRACHT;

    /**
     * 
     * Constructor voor een VerwerkingsVerzoek instance. Een server die een
     * instance van dit verzoek ontvangt kan beslissen om het verzoek uit te
     * voeren
     * 
     * @param ontvanger ontvanger van de aanvraag (server).
     * @param verzender verzender van de aanvraag (client).
     * @param data data die verwerkt moet worden door de server.
     * @param opdracht opdracht ter verwerking der data voor de server.
     */
    public VerwerkingsVerzoek(CodeNightlyID ontvanger, CodeNightlyID verzender,
        DataContainer data, Opdracht opdracht) {
        super(ontvanger, verzender);
        
        this.VERZOEK_DATA = data;
        this.OPDRACHT = opdracht;
    }

    //Overrides van de Bericht class
    @Override
    /**
     * Levert een geformatte string met informatie over de VerwerkingsVerzoek.
     * 
     * @return String met geformatte informatie over deze VerwerkingsVerzoek.
     */
    public String display() {
        return String.format(
            "[VerwerkingsVerzoek]\nid: {}\n{}\n{}",
            this.AANVRAAG_ID.toString(),
            this.parent_to_string(),
            this.OPDRACHT.display()  
        );
    }

    @Override
    public int hashCode() {
        int hash = this.parent_hash();
        hash = hash + 13*this.VERZOEK_DATA.hashCode();
        hash = hash + 13*this.OPDRACHT.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VerwerkingsVerzoek)) return false;
        else {
            VerwerkingsVerzoek va = (VerwerkingsVerzoek) o;
            return this.parent_fields_eql(va) &&
                this.VERZOEK_DATA.equals(va.VERZOEK_DATA) &&
                this.OPDRACHT.equals(va.OPDRACHT);
        }
    }

    /**
     * Getter voor de Opdracht van een VerwerkingsVerzoek
     * 
     * @return Opdracht van deze VerwerkingsVerzoek
     * 
     * @see com.smups.Opdracht
     */
    public Opdracht getOpdracht() { return this.OPDRACHT; }

    /**
     * Getter voor de data van een VerwerkingsVerzoek
     * 
     * @return Data die verwerkt moet worden voor deze VerwerkingsVerzoek.
     * 
     * @see com.smups.DataContainer
     */
    public DataContainer getData() { return this.VERZOEK_DATA; }
    
}