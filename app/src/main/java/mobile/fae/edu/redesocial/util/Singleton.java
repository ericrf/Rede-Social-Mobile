package mobile.fae.edu.redesocial.util;

import mobile.fae.edu.redesocial.model.Perfil;

/**
 * Created by Eric on 02/04/2015.
 */
public class Singleton {

    private static Singleton INSTANCE;

    private Perfil perfil;

    private Singleton(){}

    public static Singleton getInstance(){
        INSTANCE = INSTANCE == null ? new Singleton() : INSTANCE;
        return INSTANCE;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
