package co.com.sofka.domain.gestionCertificacion.values;

import co.com.sofka.domain.generic.Identity;

public class GestionCertificacionID extends Identity {

    public GestionCertificacionID(String uuid) {
        super(uuid);
    }

    public GestionCertificacionID(){}

    public static GestionCertificacionID of(String uuid){
        return new GestionCertificacionID(uuid);
    }

}
