package com.smups.codenightly;

public interface Conventions {
    /**
     * Deze interface bevat _alleen_ constantes en conventies
     * 
     * @author Raúl
     */

    /** Port die gebruikt wordt voor communicatie tussen de server en de clients */
    public static int CODENIGHTLY_PORT = 8888;

    /** Map waar alle codenightly bestanden in worden opgeslagen */
    public static String CODENIGHTLY_PATH = "/codenightly/";

    /** Map waar codenightly ids in worden opgeslagen */
    public static String CODENIGHTLY_ID_PATH = CODENIGHTLY_PATH + "ids/";

}