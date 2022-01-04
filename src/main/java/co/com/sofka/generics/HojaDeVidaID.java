package co.com.sofka.generics;

import co.com.sofka.domain.generic.Identity;

public class HojaDeVidaID extends Identity {

    public HojaDeVidaID(String uuid) {
        super(uuid);
    }

    public HojaDeVidaID(){}

    public static HojaDeVidaID of(String uuid){
        return new HojaDeVidaID(uuid);
    }
}
