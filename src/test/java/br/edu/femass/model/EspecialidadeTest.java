package br.edu.femass.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EspecialidadeTest {

    @Test
    void testconstrutor(){
Especialidade especialidade = new Especialidade(
    "Clinico Geral"
);
assertEquals("Clinico Geral", especialidade.getNome());


    }


}
