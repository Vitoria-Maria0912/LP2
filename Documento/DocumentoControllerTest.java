package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class DocumentoControllerTest {

	DocumentoController documentoController;
	
	@BeforeEach
	void criaDocumentoController() {
		this.documentoController = new DocumentoController();
		this.documentoController.criarDocumento("Lab5", 4);
		this.documentoController.criarDocumento("programação");
	}

	@Test
	void testCriaDocumentoStringVazia() {
		try {
			assertFalse(this.documentoController.criarDocumento(""));
		} catch(IllegalArgumentException error) {}
	}

	@Test
	void testCriaDocumentoStringIsBlanck() {
		try {
			assertFalse(this.documentoController.criarDocumento("    ", 2));
		} catch(IllegalArgumentException error) {}
	}
	
	@Test
	void testExibirDocumentoInexistente() {
		try{
			this.documentoController.getDocumentos().get("p2");
		} catch (NoSuchElementException error) {}
	}

	@Test
	void testAdicionaAtalho() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTexto("computação", 4));
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoLista("p2/lp2", 5, "/", "-"));
		this.documentoController.addAtalho("programação", "Lab5");
		assertEquals("computação" + System.lineSeparator() + System.lineSeparator()
					+ "- p2\n- lp2" + System.lineSeparator() + System.lineSeparator()
					+ "computação" + System.lineSeparator() + System.lineSeparator()
					+ "p2, lp2", this.documentoController.getDocumentos().get("programação").criaAtalho(this.documentoController.getDocumentos().get("Lab5")));
	}
	
	@Test
	void testPegaRepresentacaoCompletaTermos() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTermos("Teste/termos/Aleatórios", 1, "/", "ALFABÉTICA"));
		assertEquals("Total termos: 3\n"
				   + "- Aleatórios, termos, Teste", this.documentoController.pegaRepresentacaoCompleta("Lab5", 0));
	}

	@Test
	void testPegaRepresentacaoResumidaTermos() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTermos("Teste/termos/Aleatórios", 1, "/", "ALFABÉTICA"));
		assertEquals("Aleatórios/termos/Teste", this.documentoController.pegaRepresentacaoResumida("Lab5", 0));
	}
	
	@Test
	void testPegaRepresentacaoCompletaLista() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoLista("Exemplo|de uma lista|de 3 termos", 3, "|", "-"));
		assertEquals("- Exemplo\n"
				   + "- de uma lista\n"
				   + "- de 3 termos", this.documentoController.pegaRepresentacaoCompleta("Lab5", 0));
	}

	@Test
	void testPegaRepresentacaoResumidaLista() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoLista("Exemplo|de uma lista|de 3 termos", 3, "|", "-"));
		assertEquals("Exemplo, de uma lista, de 3 termos", this.documentoController.pegaRepresentacaoResumida("Lab5", 0));
	}
	
	@Test
	void testPegaRepresentacaoCompletaTitulo() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTitulo("Documentos Texto", 4, 1, true));
		assertEquals("4. Documentos Texto -- \n"
				   + "4-DOCUMENTOSTEXTO", this.documentoController.pegaRepresentacaoCompleta("Lab5", 0));
	}

	@Test
	void testPegaRepresentacaoResumidaTitulo() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTitulo("Documentos Texto", 4, 1, true));
		assertEquals("4. Documentos Texto", this.documentoController.pegaRepresentacaoResumida("Lab5", 0));
	}
	
	@Test
	void testPegaRepresentacaoCompletaTexto() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTexto("Exemplo de texto", 2));
		assertEquals("Exemplo de texto", this.documentoController.pegaRepresentacaoCompleta("Lab5", 0));
	}

	@Test
	void testPegaRepresentacaoResumidaTexto() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTexto("Exemplo de texto", 2));
		assertEquals("Exemplo de texto", this.documentoController.pegaRepresentacaoResumida("Lab5", 0));
	}
	
	@Test
	void testCriaVisaoCompleta() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTexto("texto", 1));
		this.documentoController.criaVisaoCompleta("Lab5");
		assertEquals("[texto]", Arrays.toString(this.documentoController.getVisao().get(0)));
	}
	
	@Test
	void testCriaVisaoResumida() {
		this.documentoController.getDocumentos().get("programação").addElemento(new ElementoLista("p2/lp2", 5, "/", "-"));
		this.documentoController.criaVisaoResumida("programação");
		assertEquals("[p2, lp2]", Arrays.toString(this.documentoController.getVisao().get(0)));
	}
	
	@Test
	void testCriaVisaoPrioritaria() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTexto("texto", 6));
		this.documentoController.criaVisaoPrioritaria("Lab5");
		assertEquals("[texto]", Arrays.toString(this.documentoController.getVisao().get(0)));
	}
	
	@Test
	void testCriaVisaoTitulo() {
		this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTitulo("texto", 6, 3, true));
		this.documentoController.criaVisaoTitulos("Lab5");
		assertEquals("[6. texto]", Arrays.toString(this.documentoController.getVisao().get(0)));
	}
	
	@Test
	void testRemoveElemento() {
		try {
			this.documentoController.removeElemento("Lab5", 0);
		} catch(IllegalArgumentException error) {}
	}
	
	@Test
	void testRemoveElemento2() {
		try {
			this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTitulo("texto", 6, 3, true));			
			this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTitulo("texto", 6, 3, true));
			this.documentoController.removeElemento("Lab5", 2);
		} catch(IllegalArgumentException error) {}
	}
	
	@Test
	void testRemoveElemento3() {
		try {
			this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTitulo("texto", 6, 3, true));			
			this.documentoController.getDocumentos().get("Lab5").addElemento(new ElementoTitulo("texto", 6, 3, true));
			this.documentoController.removeElemento("Lab5", - 1);
		} catch(IllegalArgumentException error) {}
	}
	
	@Test
	void testRemoveDocumento() {
		try {
			this.documentoController.removeDocumento("ufcg");
		} catch(NoSuchElementException error) {}
	}

	@Test
	void testChecaSeDocumentoCadastrado() {
		assertTrue(this.documentoController.checaSeDocumentoCadastrado("Lab5"));
	}
	
	@Test
	void testChecaSeDocumentoCadastrado2() {
		try {
			assertTrue(this.documentoController.checaSeDocumentoCadastrado("programação"));
		} catch(NoSuchElementException error) {}
	}
}
