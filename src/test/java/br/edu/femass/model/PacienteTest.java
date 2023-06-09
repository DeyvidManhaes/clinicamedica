package br.edu.femass.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PacienteTest {

    private Paciente paciente;
    
    @BeforeEach
    void setUp() {
        Plano plano2 = new Plano(
            "Sulamerica"
        );
        paciente = new Paciente(
            "Teste", 
            "02792655062", 
            "22 99999-9991",
            plano2
        );
    } 

    @Test
    void construtorCpfIncorreto(){
        Plano plano = new Plano(
            "Bradesco Saude"
        );

        assertThrows(
            IllegalArgumentException.class,() -> new Paciente(
                "Teste2",
                "123456789",
                "22 99229-9922",
                plano
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
        Plano plano = new Plano(
            "Bradesco Saude"
        );
        paciente = new Paciente("Teste2","69625386009","22 98764-1234",plano);
        assertEquals(2, paciente.getProntuario());

    }

    @Test
    void testRemoverumTelefone() throws Exception {
    
           assertThrows( Exception.class,
            () -> paciente.removerTelefone("22 99999-0109"));
        
        


    }
}
