package com.smups.codenightly;

import java.io.Serializable;

/**
 * Abstracte class die gebruikt kan worden om datacontainers te maken. De Data-
 * Container class zelf bevat geen data field, maar wel alle functies en velden
 * die vereist zijn voor dataoverdracht. DataContainers hebben geen expliciete
 * eigenaar.
 * 
 * @author Raúl
 */
public abstract class DataContainer implements Serializable{
    public static final long serialVersionUID = 1L;

    //Data moet worden kunnen gehasht, dus de volgende velden zijn noodzakelijk
    @Override
    public abstract int hashCode();
    @Override
    public abstract boolean equals(Object o);

}