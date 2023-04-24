package br.edu.femass.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MedicoTest {

    @Test
    void testconstrutor(){
        Especialidade especialidade = new Especialidade(
            "Oftalmologia"
        );
        Medico medico = new Medico("Joao Pedro",
        "43215",
         "86117032005", 
         "22 92134-5678",
         especialidade);

         assertEquals("Oftalmologia", especialidade.getNome());
         assertEquals("Joao Pedro", medico.getNome());
        return;
    }
}
