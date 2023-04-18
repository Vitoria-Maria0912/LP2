package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class DocumentoTest {

	Documento documento;
	
	@BeforeEach
	void criaDocumento() {
		this.documento = new Documento("Lab5");
	}
	
	@Test
	void testDocumentoString() {
		assertEquals("Lab5", this.documento.toString());
	}

	@Test
	void testDocumentoStringInt() {
		Documento documento2 = new Documento("Lab5", 5);
		assertEquals("Lab5", documento2.toString());
	}

	@Test
	void testChecaSeIdentificacaoValida() {
		try {
			Documento doc = new Documento("");
			assertFalse(doc.checaSeIdentificacaoValida());
		} catch(IllegalArgumentException error) {}
	}

	@Test
	void testChecaSeDocumentoCheio() {
		assertFalse(this.documento.checaSeDocumentoCheio());
	}

	@Test
	void testChecaSeTamanhoValido() {
		try {
			Documento documento2 = new Documento("Lab5", 0);
			assertFalse(documento2.checaSeTamanhoValido());
		} catch(IllegalArgumentException error) {}
	}
	
	@Test
	void testCalculaMediaPrioridade() {
		this.documento.addElemento(new ElementoTexto("texto", 1));
		this.documento.addElemento(new ElementoLista("p2/lp2", 5, "/", "-"));
		assertEquals(3, this.documento.calculaMediaPrioridade(), 0);
	}

	@Test
	void testAddElemento() {
		this.documento.addElemento(new ElementoTexto("texto", 1));
		assertEquals("texto", this.documento.elementosToString());
	}
	
	@Test
	void testEditaElemento() {
		this.documento.addElemento(new ElementoTexto("texto", 1));
		this.documento.addElemento(new ElementoLista("Lista/Antiga", 2, " ", "-"));
		this.documento.editaElemento(1, "nova lista");
		this.documento.editaElemento(0, "novo texto");
		assertEquals("novo texto\n- nova\n- lista", this.documento.elementosToString());
	}
	
	@Test
	void testAdicionaElemento() {
		assertTrue(this.documento.getElementosDocumento().add(new ElementoTexto("programação", 2)));
	}
	
	@Test
	void testCriaAtalho() {
		Documento documento2 = new Documento("Lab5", 5);
		this.documento.addElemento(new ElementoTexto("texto", 3));
		this.documento.addElemento(new ElementoLista("p2/lp2", 5, "/", "-"));
		assertEquals("texto" + System.lineSeparator() + System.lineSeparator()
					+ "- p2\n"
					+ "- lp2" + System.lineSeparator() + System.lineSeparator()
					+ "texto" + System.lineSeparator() + System.lineSeparator()
					+ "p2, lp2", documento2.criaAtalho(this.documento));
	}
	
	@Test
	void testRemoveElemento() {
		assertFalse(this.documento.getElementosDocumento().remove(new ElementoTexto("programação", 2)));
	}

	@Test
	void testGetElementos() {
		this.documento.addElemento(new ElementoTexto("<<<<Feliz 2023>>>>", 1));
		this.documento.addElemento(new ElementoTexto("<<<<Abençoado 2023>>>>", 4));
		assertEquals("<<<<Feliz 2023>>>>\n<<<<Abençoado 2023>>>>", this.documento.elementosToString());
	}

	@Test
	void testGetQuantidadeDeElementos() {
		this.documento.addElemento(new ElementoTexto("texto", 1));
		assertEquals(1, this.documento.getQuantidadeDeElementos());
	}
	
	@Test
	void testGetTitulo() {
		assertEquals("Lab5", this.documento.getTitulo());
	}
	
	@Test
	void testGetTamanho() {
		Documento documento2 = new Documento("p2", 5);
		assertEquals(5, documento2.getTamanho());
	}
	
	@Test
	void testHashCode() {
		Documento documento2 = new Documento("Lab5");
		assertEquals(documento2.hashCode(), this.documento.hashCode());
	}
	
	@Test
	void testEquals() {
		Documento documento2 = new Documento("lab5");
		assertFalse(this.documento.equals(documento2));
	}

	@Test
	void testToString() {
		this.documento.addElemento(new ElementoTexto("<<<<Feliz 2023>>>>", 1));
		assertEquals("Lab5" + System.lineSeparator() + System.lineSeparator() + "<<<<Feliz 2023>>>>", this.documento.toString());
	}
}
