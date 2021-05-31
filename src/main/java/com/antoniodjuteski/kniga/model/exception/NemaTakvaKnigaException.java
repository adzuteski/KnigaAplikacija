package com.antoniodjuteski.kniga.model.exception;

public class NemaTakvaKnigaException extends RuntimeException{
    public NemaTakvaKnigaException(String ISBN) {
        super(String.format("Kniga so sledniov: " + ISBN + " ne e pronajdena" ));
    }
}
