package co.com.sofka.domain.gestionCertificacion.values;

import co.com.sofka.domain.generic.Identity;

public class CertificacionID extends Identity {

    public CertificacionID(String uuid) {
        super(uuid);
    }

    public CertificacionID(){}

    public static CertificacionID of(String uuid){
        return new CertificacionID(uuid);
    }

}
