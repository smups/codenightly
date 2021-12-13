package com.smups.codenightly.request;

import java.io.Serializable;
import java.util.UUID;

/**
 * Deze class dient voornamelijk als abstacte parent van aanvragen met
 * data velden.
 * 
 * De class bevat als public value de UUID van de aanvraag, en als protected
 * values de gebruiker UUID's van de ontvanger en de verzender.
 * 
 * @author Raúl
 */
public abstract class Aanvraag implements Serializable{
    public static final long serialVersionUID = 1L;

    //ID van de request.
    public final UUID AANVRAAG_ID;

    //ID's van verzenders en ontvangers
    protected final UUID ontvanger;
    protected final UUID verzender;

    /**
     * Eenvoudige constructor die een aanvraag met een willekeurig ID maakt voor
     * gegeven ontvanger en verzender.
     * 
     * @param ontvanger is de UUID van de gebruiker voor wien deze aanvraag
     * bedoeld is.
     * @param verzender is de UUID van de gebruiker die deze aanvraag verzonden
     * en/of aangemaakt heeft
     * 
     * @see #Aanvraag(UUID, UUID, UUID)
     */
    public Aanvraag(UUID ontvanger, UUID verzender) {

        //Kies willekeurig id voor de request
        this.AANVRAAG_ID = UUID.randomUUID();

        this.ontvanger = ontvanger;
        this.verzender = verzender;
    }

    /**
     * Constructor voor een aanvraag instance met een van te voren vastgelegd
     * UUID. Deze constructor wordt gebruikt in de kopie() functie.
     * @see #kopie(Aanvraag)
     * 
     * @param id UUID wat gebruikt moet worden als UUID van de aanvraag
     * @param ontvanger is de UUID van de gebruiker voor wien deze aanvraag
     * bedoeld is.
     * @param verzender is de UUID van de gebruiker die deze aanvraag verzonden
     * en/of aangemaakt heeft
     * 
     * @see #Aanvraag(UUID, UUID)
     */
    public Aanvraag(UUID id, UUID ontvanger, UUID verzender) {
        this.AANVRAAG_ID = id;
        this.ontvanger = ontvanger;
        this.verzender = verzender;
    }

    /**
     * Levert een kopie van de gespecificeerde aanvraag. Maakt gebruik van de
     * 3-UUID constructor. @see #Aanvraag(UUID, UUID, UUID)
     * 
     * <B>Gebruik deze functie niet direct!</B> De kopie die geleverd wordt door
     * deze functie bevat implementatie details. Bij voorkeur worden deze door
     * child-classes gedefiniëerd en niet door de parent.
     * 
     * @param that aanvraag die gekopiëerd moet worden
     * @return kopie van aanvraag that, met parent implementatie.
     */
    public Aanvraag kopie(Aanvraag that) {
        return new Aanvraag(
            that.AANVRAAG_ID,
            that.ontvanger,
            that.verzender
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
                if (!(o instanceof Aanvraag)) return false;
                else return parent_fields_eql((Aanvraag) o);
            }
        };
    }

    /**
     * Hulpfunctie om UUID's van de verzender en de ontvanger te formatten.
     * 
     * @return geformatte String van 2 regels met UUID's van de verzender en de
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
    protected boolean parent_fields_eql(Aanvraag that) {
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