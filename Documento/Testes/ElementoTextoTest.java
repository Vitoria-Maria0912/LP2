package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class ElementoTextoTest {

	ElementoTexto texto;
	
	@BeforeEach
	void ElementoTexto() {
		this.texto = new ElementoTexto("Exemplo de texto", 2);
	}
	
	@Test
	void testExibeVersaoCompleta() {
		assertEquals("Exemplo de texto", this.texto.exibeVersaoCompleta());
	}

	@Test
	void testExibeVersaoResumida() {
		assertEquals("Exemplo de texto", this.texto.exibeVersaoResumida());
	}
	
	@Test
	void testEquals() {
		ElementoTexto texto2 = new ElementoTexto("Boas festas!", 2);
		assertFalse(this.texto.equals(texto2));
	}
	
	@Test
	void testHashCode() {
		ElementoTexto texto2 = new ElementoTexto("Exemplo de texto", 2);
		assertEquals(texto2.hashCode(), this.texto.hashCode());
	}
}
