package com.smups.codenightly.request;

import java.io.Serializable;
import java.util.UUID;

import com.smups.codenightly.CodeNightlyID;

/**
 * Deze class dient voornamelijk als abstacte parent van berichten met
 * data velden.
 * 
 * De class bevat als public value de CodeNightlyID van het Bericht, en als protected
 * values de gebruiker CodeNightlyID's van de ontvanger en de verzender.
 * 
 * @author Raúl
 */
public abstract class Bericht implements Serializable{
    public static final long serialVersionUID = 1L;

    //Is dit een verzoek of een antwoord
    public final boolean VERZOEK;

    //ID van de request.
    public final UUID AANVRAAG_ID;

    //ID's van verzenders en ontvangers
    protected final CodeNightlyID ontvanger;
    protected final CodeNightlyID verzender;

    /**
     * Eenvoudige constructor die een Bericht met een willekeurig ID maakt voor
     * gegeven ontvanger en verzender.
     * 
     * @param ontvanger is de CodeNightlyID van de gebruiker voor wien dit Bericht
     * bedoeld is.
     * @param verzender is de CodeNightlyID van de gebruiker die dit Bericht verzonden
     * en/of aangemaakt heeft.
     * @param verzoek geeft aan of dit bericht een verzoek of een antwoord is.
     * 
     * @see Aanvraag(CodeNightlyID, CodeNightlyID, CodeNightlyID)
     */
    public Bericht(CodeNightlyID ontvanger, CodeNightlyID verzender, boolean verzoek) {

        //Kies willekeurig id voor de request
        this.AANVRAAG_ID = UUID.randomUUID();

        this.VERZOEK = verzoek;
        this.ontvanger = ontvanger;
        this.verzender = verzender;
    }

    /**
     * Constructor voor een aanvraag instance met een van te voren vastgelegd
     * CodeNightlyID. Deze constructor wordt gebruikt in de kopie() functie.
     * {@link #kopie(Bericht)}
     * 
     * @param id CodeNightlyID wat gebruikt moet worden als CodeNightlyID van het Bericht
     * @param ontvanger is de CodeNightlyID van de gebruiker voor wien dit Bericht
     * bedoeld is.
     * @param verzender is de CodeNightlyID van de gebruiker die dit Bericht verzonden
     * en/of aangemaakt heeft
     * @param verzoek geeft aan of dit bericht een verzoek of een antwoord is.
     * 
     * @see Bericht(CodeNightlyID, CodeNightlyID)
     */
    public Bericht(UUID id, CodeNightlyID ontvanger,
        CodeNightlyID verzender, boolean verzoek) {
        this.AANVRAAG_ID = id;
        this.ontvanger = ontvanger;
        this.verzender = verzender;
        this.VERZOEK = verzoek;
    }

    /**
     * Levert een kopie van de gespecificeerde aanvraag. Maakt gebruik van de
     * 3-CodeNightlyID constructor. {@link #Aanvraag(CodeNightlyID, CodeNightlyID, CodeNightlyID)}
     * 
     * <B>Gebruik deze functie niet direct!</B> De kopie die geleverd wordt door
     * deze functie bevat implementatie details. Bij voorkeur worden deze door
     * child-classes gedefiniëerd en niet door de parent.
     * 
     * @param that aanvraag die gekopiëerd moet worden
     * @return kopie van aanvraag that, met parent implementatie.
     */
    public Bericht kopie(Bericht that) {
        return new Bericht(
            that.AANVRAAG_ID,
            that.ontvanger,
            that.verzender,
            that.VERZOEK
        )
        { //Implementatie van abstracte velden is vereist
            @Override
            public String display() {
                return String.format(
                    "[ABSTRACTE AANVRAAG]\n id: {}\n{}",
                    this.AANVRAAG_ID.toString(),
                    this.parent_to_string()
                );
            }
            @Override
            public int hashCode(){ return parent_hash(); }
            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Bericht)) return false;
                else return parent_fields_eql((Bericht) o);
            }
        };
    }

    /**
     * Hulpfunctie om CodeNightlyID's van de verzender en de ontvanger te formatten.
     * 
     * @return geformatte String van 2 regels met CodeNightlyID's van de verzender en de
     * ontvanger.
     */
    protected String parent_to_string() {
        return String.format(
            "Verzender: {}\nOntvanger:{}\n",
            this.verzender.toString(),
            this.ontvanger.toString()
        );
    }

    /**
     * Hulpfunctie die de velden van de Aanvraag parent alvast hasht.
     * 
     * @return Hashcode van de velden AANVRAAG_ID, ontvanger en verzender.
     */
    protected int parent_hash() {
        int hash = this.AANVRAAG_ID.hashCode();
        hash = hash + 13*this.ontvanger.hashCode();
        hash = hash + 13*this.verzender.hashCode();
        return hash;
    }

    /**
     * Hulpfunctie die de velden van de caller en van <code> that <\code>
     * vergelijkt.
     * 
     * @param that Aanvraag waarmee de caller vergeleken moet worden.
     * @return true als de aanvraag hetzelfde is als de caller, en false indien
     * ze anders zijn
     */
    protected boolean parent_fields_eql(Bericht that) {
        return that.AANVRAAG_ID.equals(this.AANVRAAG_ID) &&
        that.ontvanger.equals(this.ontvanger) &&
        that.verzender.equals(this.verzender);
    }

    //Abstract methods
    /**
     * Maakt een string van de aanvraag.
     * @return Human-readable string versie van de aanvraag (het liefst geformat
     * op meerdere regels).
     */
    public abstract String display();

    //Aanvragen moeten kunnen worden gehasht:
    @Override
    public abstract int hashCode();
    @Override
    public abstract boolean equals(Object o);
}