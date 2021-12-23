package com.smups.codenightly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/**
 * 
 */
public class CodeNightlyID implements Serializable{
    public static final long serialVersionUID = 1L;

    //path waar alle ids worden opgeslagen
    private static final String PATH = Conventions.CODENIGHTLY_ID_PATH;

    //path waar de super speciale self id wordt opgeslagen
    private static final String SELF_PATH = PATH + "defself";

    //onderliggend ID
    private final UUID id;

    //Maakt nieuwe codenightlyID uit
    public CodeNightlyID(UUID id) {
        this.id = id;
    }

    public static void save_codenightlyID(CodeNightlyID cnID) throws IOException {
        cnID.save();
    }

    private static void save_as_self(CodeNightlyID selfID) throws IOException {
        selfID.save(new File(SELF_PATH));
    }

    public static CodeNightlyID load_self_CodeNightlyID() {
        //Controleer of de codenightlyID van jezelf al bestaat
        File f = new File(SELF_PATH);
        if (f.exists()) {
            try { return CodeNightlyID.load(f); }
            catch (Exception e) {e.printStackTrace();}
            return null;
        } else {
            //ID bestaat dus nog niet -> maak een nieuwe aan
            CodeNightlyID cnID = new CodeNightlyID(UUID.randomUUID());
            try { CodeNightlyID.save_as_self(cnID); }
            catch (Exception e) {e.printStackTrace();}
            return cnID;
        }
    }

    private static CodeNightlyID load(File f) throws Exception {
        FileInputStream fin = new FileInputStream(f);
        ObjectInputStream oin = new ObjectInputStream(fin);
        CodeNightlyID resp = (CodeNightlyID) oin.readObject();
        oin.close();
        fin.close();
        return resp;
    }

    private void save(File f) throws IOException {
        FileOutputStream fout = new FileOutputStream(f);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(this);
        oout.flush();
        oout.close();
        fout.close();
    }

    public void save() throws IOException {
        File f = new File(PATH + this.id.toString());
        save(f);
    }

}