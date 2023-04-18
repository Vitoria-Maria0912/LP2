package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import agenda.Agenda;

class AgendaTest {

	private Agenda agenda;
	
	@Test
    void testContatoInválido() {
		agenda.cadastraContato(1, "", "Gaudêncio", "(83) 9091-4056");
		assertEquals("CONTATO INVÁLIDO", agenda.checaIdentificacao(null, "Gaudêncio"));
	}
	
	@Test
    void testContatoInválido2() {
		agenda.cadastraContato(2, "Lívia", "Sampaio", "");
		assertEquals("CONTATO INVÁLIDO", agenda.checaIdentificacao("Lívia", "Sampaio"));
	}
	
    @Test
	void testContatosIguais() {
    	agenda.cadastraContato(3, "Lívia", "Sampaio", "(83) 8041-4265");
		assertEquals(true, agenda.checaIdentificacao("Lívia", "Sampaio"));
	}
    
    @Test
	void testContatosDiferentes() {
    	agenda.cadastraContato(3, "Lívia", "Sampaio", "(83) 8041-4265");
		assertEquals(false, agenda.checaIdentificacao("Matheus", "Gaudêncio"));
	}
    
	@Test
	void testToString() {
		 agenda.cadastraContato(99, "Vitória Maria", "", "9841-2002");
	     assertEquals("99 - Vitória Maria\n9841-2002\n", agenda.toString());
	}
    
    @Test
    void testFavoritaContato() {
    	agenda.cadastraContato(2, "Matheus", "Gaudêncio", "(83) 9091-4056");
   		agenda.favoritaContato(1, 2);
    	assertEquals(true, agenda.favoritaContato(1, 2));
    }
    
    @Test
    void testFavoritaContatoJaFavoritado() {
    	agenda.cadastraContato(2, "Matheus", "Gaudêncio", "(83) 9091-4056");
   		agenda.favoritaContato(1, 2);
    	assertEquals(false, agenda.favoritaContato(1, 2));
    }
    
    @Test
    void testDesfavoritaContato() {
    	agenda.cadastraContato(7, "Nazareno", "", "(83) 8691-4088");
   		agenda.favoritaContato(1, 7);
    	assertEquals(true, agenda.favoritaContato(1, 7));
    	assertEquals(true, agenda.verificaSeContatoFavorito(agenda.getContato(7)));
    }
    
    @Test
    void testDesfavoritaContatoNaoFavoritado() {
    	agenda.cadastraContato(2, "Matheus", "Gaudêncio", "(83) 9091-4056");
		assertEquals(false, agenda.verificaSeContatoFavorito(agenda.getContato(2)));
    }
    
    @Test
    void testVerificaSeContatoFavorito() {
    	agenda.cadastraContato(2, "Matheus", "Gaudêncio", "(83) 9091-4056");
		assertEquals(false, agenda.verificaSeContatoFavorito(agenda.getContato(2)));
    }
    
	@Test
    void testPosiçãoInválida() {
		assertEquals(false, agenda.checaPosicao(0));
    }
	
	@Test
    void testPosiçãoInválida2() {
		assertEquals(false, agenda.checaPosicao(101));
    }
}
