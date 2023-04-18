package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class ElementoTituloTest {

	ElementoTitulo titulo;
	ElementoTitulo titulo2;
	
	@BeforeEach
	void criaTitulo() {
		this.titulo = new ElementoTitulo("Documentos Texto", 4, 1, true);
		this.titulo2 = new ElementoTitulo("Elementos simples", 3, 2, false);
	}
	
	@Test
	void testExibeVersaoCompleta() {
		assertEquals("4. Documentos Texto -- \n4-DOCUMENTOSTEXTO", this.titulo.exibeVersaoCompleta());
	}
	
	@Test
	void testExibeVersaoResumida() {
		assertEquals("4. Documentos Texto", this.titulo.exibeVersaoResumida());
	}
	
	@Test
	void testExibeVersaoCompleta2() {
		assertEquals("3. Elementos simples", this.titulo2.exibeVersaoCompleta());
	}

	@Test
	void testExibeVersaoResumida2() {
		assertEquals("3. Elementos simples", this.titulo2.exibeVersaoResumida());
	}
	
	@Test
	void testToString() {
		assertEquals("Elementos simples\n"
					+ "Nível: 3\n"
					+ "Linkável: false", this.titulo2.toString());
	}
	
	@Test
	void testEquals() {
		assertFalse(this.titulo.equals(this.titulo2));
	}
	
	@Test
	void testHashCode() {
		assertEquals(this.titulo2.hashCode(), this.titulo2.hashCode());
	}
}
