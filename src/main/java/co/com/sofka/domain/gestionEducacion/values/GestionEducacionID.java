package co.com.sofka.domain.gestionEducacion.values;

import co.com.sofka.domain.generic.Identity;

public class GestionEducacionID extends Identity {

    public GestionEducacionID(String uuid) {
        super(uuid);
    }

    public GestionEducacionID(){}

    public static GestionEducacionID of(String uuid){
        return new GestionEducacionID(uuid);
    }

}
