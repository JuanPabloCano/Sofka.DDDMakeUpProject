package co.com.sofka.generics;

import co.com.sofka.domain.generic.Identity;

public class HojaDeVidID extends Identity {

    public HojaDeVidID(String uuid) {
        super(uuid);
    }

    public HojaDeVidID(){}

    public static HojaDeVidID of(String uuid){
        return new HojaDeVidID(uuid);
    }
}
