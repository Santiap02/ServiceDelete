package com.example.ApplicationConfig;

import Model.Cliente;

import java.util.Optional;

public class TestUtils {
    public static final String CLIENTES = "clientes";
    public static final String RESPONSE_STATE = "$.status";

    public static Optional<Cliente> createClient(){
        return  Optional.ofNullable(new Cliente(1,"santiago", "Alvarez", "cc", 24, "Medellin"));
    }
}
