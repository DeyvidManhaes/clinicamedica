package br.edu.femass.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PacienteTest {

    private Paciente paciente;
    
    @BeforeEach
    void setUp() {
        paciente = new Paciente(
            "Teste", 
            "02792655062", 
            "22 99999-9991"
        );
    } 

    @Test
    void construtorCpfIncorreto(){

        assertThrows(
            IllegalArgumentException.class,() -> new Paciente(
                "Teste2",
                "123456789",
                "22 99229-9922"
                )
        );
    }

    @Test
    void ConstrutorPaciente(){
        assertEquals("Teste", paciente.getNome());
        assertEquals("02792655062", paciente.getCpf());
        
    }
    @Test
    void contrutorcomumtelefone(){
        assertEquals(1, paciente.getTelefones().size());


    }
    @Test
    void testpacientedoisTelefones() {

     
        paciente.adicionarTelefone("22 99999-0109");
        assertEquals(2, paciente.getTelefones().size());

    }


    @Test
    void testAtualizarUltimoProntuario() {
        paciente = new Paciente("Teste2","69625386009","22 98764-1234");
        assertEquals(2, paciente.getProntuario());

    }

    @Test
    void testRemoverumTelefone() throws Exception {
    
           assertThrows( Exception.class,
            () -> paciente.removerTelefone("22 99999-0109"));
        
        


    }
}
