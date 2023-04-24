package br.edu.femass.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlanoTest {

    @Test
    void testconstrutor(){
        Plano plano = new Plano(
            "Sulamerica"
     );

        assertEquals("Sulamerica", plano.getNomeplano());


    }
}
