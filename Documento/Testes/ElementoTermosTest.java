package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class ElementoTermosTest {

	ElementoTermos termosAlfabetica;
	ElementoTermos termoSemOrdenacao;
	ElementoTermos termosTamanho;
	
	@BeforeEach
	void criaElementoTermo() {
		this.termosAlfabetica = new ElementoTermos("Teste/termos/Aleatórios", 1, "/", "ALFABÉTICA");
		this.termoSemOrdenacao = new ElementoTermos("Teste/termos/Aleatórios", 2, "/", "NENHUM");
		this.termosTamanho = new ElementoTermos("Teste/termos/Aleatórios", 3, "/", "TAMANHO");
	}
	
	@Test
	void testExibeVersaoCompletaAlfabetica() {
		assertEquals("Total termos: 3\n- Aleatórios, termos, Teste", this.termosAlfabetica.exibeVersaoCompleta());
	}

	@Test
	void testExibeVersaoResumidaAlfabetica() {
		assertEquals("Aleatórios/termos/Teste", this.termosAlfabetica.exibeVersaoResumida());
	}
	
	@Test
	void testExibeVersaoCompletaSemOrdenacao() {
		assertEquals("Total termos: 3\n- Teste, termos, Aleatórios", this.termoSemOrdenacao.exibeVersaoCompleta());
	}

	@Test
	void testExibeVersaoResumidaSemOrdenacao() {
		assertEquals("Teste/termos/Aleatórios", this.termoSemOrdenacao.exibeVersaoResumida());
	}
	
	@Test
	void testExibeVersaoCompletaTamanho() {
		assertEquals("Total termos: 3\n- Aleatórios, termos, Teste", this.termosTamanho.exibeVersaoCompleta());
	}

	@Test
	void testExibeVersaoResumidaTamanho() {
		assertEquals("Aleatórios/termos/Teste", this.termosAlfabetica.exibeVersaoResumida());
	}
	
	@Test
	void testEquals() {
		ElementoTermos termos2 = new ElementoTermos("Boas festas!-Feliz Natal!-Próspero 2023!", 2, "-", "nenhum");
		assertFalse(this.termosAlfabetica.equals(termos2));
	}
	
	@Test
	void testHashCode() {
		assertEquals(this.termosAlfabetica.hashCode(), this.termosAlfabetica.hashCode());
	}
}
