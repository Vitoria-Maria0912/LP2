package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;

public class ContatoTest {
 
    private Contato contato;
 
    @BeforeEach
    void contato() {
        this.contato = new Contato("Vitória Maria", "", "9841-2002");
    }

    @Test
    void testContato() {
       assertEquals("Vitória Maria\n9841-2002\n", contato.toString());
    }
	
    @BeforeEach
    void nomeCompleto() {
        this.contato = new Contato("Matheus", "Gaudêncio", "555-5551");
    }

    @Test
    void testNomeCompleto() {
       assertEquals("Matheus Gaudêncio", contato.nomeCompleto());
    }
    
    @BeforeEach
    void nomeCompleto2() {
        this.contato = new Contato("Lívia", "Sampaio", "2101-1585");
    }

    @Test
    void testNomeCompleto2() {
       assertNotEquals("Lívia", contato.nomeCompleto());
    }
    
    @BeforeEach
    void nome() {
        this.contato = new Contato("Lívia", "Sampaio", "2101-1585");
    }

    @Test
    void testNome() {
       assertEquals("Lívia", contato.getNome());
    }
    
    @BeforeEach
    void nomeErrado() {
        this.contato = new Contato("Matheus", "Gaudêncio", "555-5551");
    }

    @Test
    void testNomeErrado() {
       assertNotEquals("Gaudêncio", contato.getNome());
    }
    
    @BeforeEach
    void sobrenome() {
        this.contato = new Contato("Fábio", "Morais", "9401-1001");
    }

    @Test
    void testSobrenome() {
       assertEquals("Morais", contato.getSobrenome());
    }
    
    @BeforeEach
    void sobrenome2() {
        this.contato = new Contato("Fábio", "Morais", "9401-1001");
    }

    @Test
    void testSobrenome2() {
       assertNotEquals("Fábio", contato.getSobrenome());
    }
    
    @BeforeEach
    void sobrenomeVazio() {
        this.contato = new Contato("Nazareno", "", "1101-1995");
    }

    @Test
    void testSobrenomeVazio() {
       assertEquals("", contato.getSobrenome());
    }
    
    @BeforeEach
    void telefone() {
        this.contato = new Contato("Vitória Maria", "", "9841-2002");
    }

    @Test
    void testTelefone() {
       assertEquals("9841-2002", contato.getTelefone());
    }
}
