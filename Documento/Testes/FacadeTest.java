package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class FacadeTest {

	Facade facade;
	
	@BeforeEach
	void criaFacade() {
		this.facade = new Facade();
		this.facade.criarDocumento("Lab5", 10);
	}

	@Test
	void testCriarDocumentoString() {
		assertTrue(this.facade.criarDocumento("Programação"));
	}

	@Test
	void testCriarDocumentoStringInt() {
		assertTrue(this.facade.criarDocumento("Programação", 10));
	}

	@Test
	void testRemoverDocumento() {
		this.facade.removerDocumento("Lab5");
	}

	@Test
	void testContarElementos() {
		assertEquals(0, this.facade.contarElementos("Lab5"));
	}

	@Test
	void testExibirDocumento() {
		this.facade.criarTexto("Lab5", "<<<<Feliz 2023>>>>", 2);
		assertEquals("[<<<<Feliz 2023>>>>]", Arrays.toString(this.facade.exibirDocumento("Lab5")));
	}
	
	@Test
	void testCriarTexto() {
		assertEquals(0, this.facade.criarTexto("Lab5", "Exemplo de texto", 2));
	}

	@Test
	void testCriarTitulo() {
		this.facade.criarTexto("Lab5", "Exemplo de texto", 2);
		assertEquals(1, this.facade.criarTitulo("Lab5", "Documentos Texto", 4, 1, true));
	}

	@Test
	void testCriarLista() {
		this.facade.criarTexto("Lab5", "Exemplo de texto", 2);
		this.facade.criarTitulo("Lab5", "Documentos Texto", 4, 1, true);
		assertEquals(2, this.facade.criarLista("Lab5", "Exemplo|de uma lista|de 3 termos", 3, "|", "-"));
	}

	@Test
	void testCriarTermos() {
		this.facade.criarTexto("Lab5", "Exemplo de texto", 2);
		this.facade.criarTitulo("Lab5", "Documentos Texto", 4, 1, true);
		this.facade.criarLista("Lab5", "Exemplo|de uma lista|de 3 termos", 3, "|", "-");
		assertEquals(3, this.facade.criarTermos("Lab5", "Teste/termos/Aleatórios", 1, "/", "ALFABÉTICA"));
	}
	
	@Test
	void testPegarRepresentacaoCompleta() {
		this.facade.criarTexto("Lab5", "Exemplo de texto", 2);
		assertEquals("Exemplo de texto", this.facade.pegarRepresentacaoCompleta("Lab5", 0));
	}

	@Test
	void testPegarRepresentacaoResumida() {
		this.facade.criarTexto("Lab5", "Exemplo de texto", 2);
		assertEquals("Exemplo de texto", this.facade.pegarRepresentacaoResumida("Lab5", 0));
	}
	
	@Test
	void testPegarRepresentacaoCompleta2() {
		this.facade.criarTitulo("Lab5", "Documentos Texto", 4, 1, true);
		assertEquals("4. Documentos Texto -- \n"
				   + "4-DOCUMENTOSTEXTO", this.facade.pegarRepresentacaoCompleta("Lab5", 0));
	}

	@Test
	void testPegarRepresentacaoResumida2() {
		this.facade.criarTitulo("Lab5", "Documentos Texto", 4, 1, true);
		assertEquals("4. Documentos Texto", this.facade.pegarRepresentacaoResumida("Lab5", 0));
	}

	@Test
	void testApagarElemento() {
		this.facade.criarTermos("Lab5", "Teste/termos/Aleatórios", 1, "/", "ALFABÉTICA");
		assertTrue(this.facade.apagarElemento("Lab5", 0));
	}

	@Test
	void testMoverParaCima() {
		this.facade.criarTermos("Lab5", "Teste/termos/Aleatórios", 1, "/", "ALFABÉTICA");
		this.facade.criarTexto("Lab5", "Exemplo de texto", 2);
		this.facade.moverParaCima("Lab5", 1);
	}

	@Test
	void testMoverParaBaixo() {
		this.facade.criarTermos("Lab5", "Teste/termos/Aleatórios", 1, "/", "ALFABÉTICA");
		this.facade.criarTexto("Lab5", "Exemplo de texto", 2);
		this.facade.moverParaCima("Lab5", 0);
	}

	@Test
	void testCriarAtalho() {
		this.facade.criarDocumento("Programação", 3);
		this.facade.criarTermos("Programação", "Teste/termos/Aleatórios", 1, "/", "ALFABÉTICA");
		this.facade.criarTexto("Programação", "Exemplo de texto", 2);
		assertEquals(0, this.facade.criarAtalho("Lab5", "Programação"));
	}
	
	@Test
	void testCriarAtalho2() {
		this.facade.criarDocumento("Programação", 3);
		this.facade.criarTexto("Programação", "Exemplo de texto", 2);
		this.facade.criarLista("Lab5", "Exemplo|de uma lista|de 3 termos", 3, "|", "-");
		this.facade.criarAtalho("Lab5", "Programação");
		assertEquals(1, this.facade.criarAtalho("Programação", "Lab5"));
	}
	
	@Test
	void testCriarVisaoCompleta() {
		assertEquals(0, this.facade.criarVisaoCompleta("Lab5"));
	}

	@Test
	void testCriarVisaoResumida() {
		this.facade.criarVisaoCompleta("Lab5");
		assertEquals(1, this.facade.criarVisaoResumida("Lab5"));
	}

	@Test
	void testCriarVisaoPrioritaria() {
		this.facade.criarVisaoCompleta("Lab5");
		this.facade.criarVisaoResumida("Lab5");
		assertEquals(2, this.facade.criarVisaoPrioritaria("Lab5"));
	}

	@Test
	void testCriarVisaoTitulo() {
		this.facade.criarVisaoCompleta("Lab5");
		this.facade.criarVisaoResumida("Lab5");
		this.facade.criarVisaoPrioritaria("Lab5");
		this.facade.criarTexto("Lab5", "Exemplo de texto", 2);
		assertEquals(3, this.facade.criarVisaoTitulo("Lab5"));
	}

	@Test
	void testExibirVisao() {
		this.facade.criarVisaoPrioritaria("Lab5");
		assertEquals("[]", Arrays.toString(this.facade.exibirVisao(0)));
	}
}
