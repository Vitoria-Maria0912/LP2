package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class ElementoListaTest {

	ElementoLista lista;
	
	@BeforeEach
	void criaElementoLista() {
		this.lista = new ElementoLista("Exemplo|de uma lista|de 3 termos", 3, "|", "-");
	}

	@Test
	void testExibeVersaoCompleta() {
		assertEquals("- Exemplo\n"
					+"- de uma lista\n"
					+"- de 3 termos", lista.exibeVersaoCompleta());
	}

	@Test
	void testExibeVersaoResumida() {
		assertEquals("Exemplo, de uma lista, de 3 termos", lista.exibeVersaoResumida());
	}
	
	@Test
	void testEquals() {
		ElementoLista lista2 = new ElementoLista("^Boas festas!", 2, "^", "-> ");
		assertFalse(this.lista.equals(lista2));
	}
	
	@Test
	void testHashCode() {
		ElementoLista lista2 = new ElementoLista("^Boas festas!", 2, "^", "-> ");
		assertNotEquals(lista2.hashCode(), this.lista.hashCode());
	}
}
