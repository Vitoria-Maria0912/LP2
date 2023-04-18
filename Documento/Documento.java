package documin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * Cria um documento.
 * 
 * @author Vitória Maria Do Nascimento
 *
 */
public class Documento{
	
	 /**
     * é o atalho do documento.
     */
    private String atalho;

    /**
     * Elementos que pertencem ao documento.
     */
    private ArrayList <ElementoGenerico> elementosDocumento;

    /**
     * é o título do documento.
     */
    private String titulo;

    /**
     * é a quantidade máxima de elementos no documento.
     */
    private int tamanho;

    /**
     * é a quantidade de elementos que o documento possui.
     */
    private int quantidadeDeElementos;

    /**
     * Constrói um documento a partir de um título.
     * 
     * @param titulo é o título do documento.
     */
    public Documento(String titulo) {
    	this.elementosDocumento = new ArrayList<>();
    	this.titulo = titulo;
    	this.tamanho = 1;
    	this.quantidadeDeElementos = 0;
    	this.atalho = "";
    }

    /**
     * Constrói um documento a partir de um título e um tamanho.
     * 
     * @param titulo é o título do documento.
     * @param tamanho é a quantidade máxima de elementos no documento.
     */
    public Documento(String titulo, int tamanho) {
    	this.elementosDocumento = new ArrayList<>();
    	this.titulo = titulo;
    	this.tamanho = tamanho;
    	this.quantidadeDeElementos = 0;
    	this.atalho = "";
    }

    /**
     * Avalia se o documento atingiu a capacidade máxima de elementos.
     * 
     * @return true(se a quantidade máxima foi atingida) or false.
     */
    public boolean checaSeDocumentoCheio() {
    	if(getTamanho() == 1) {
    		return false;
    	}
    	if(getTamanho() == getQuantidadeDeElementos()) {
			return true;
		}
		return false;
    }

    /**
     * Avalia se o tamanho é válido.
     * 
     * @return true(se o tamanho for válido) or a exception.
     */
    public boolean checaSeTamanhoValido() {
    	if(getTamanho() <= 0) {
			throw new IllegalArgumentException();
		}
		return true;
    }
    
    /**
     * Avalia se o título do documento não é vazio.
     * 
     * @return true(se o título é válido) or a exception.
     */
    public boolean checaSeIdentificacaoValida() {
    	if(getTitulo().isBlank() || getTitulo() == null) {
    		throw new IllegalArgumentException();
		}
    	return true;
    }
    
    /**
     * Acrescenta um elemento ao documento.
     * 
     * @param elemento é um elemento.
     * @return a posição do elemento.
     */
    public int addElemento(ElementoGenerico elemento) {
    	if(!(checaSeDocumentoCheio())) {
        	this.elementosDocumento.add(elemento);
        	this.quantidadeDeElementos ++;
    	}
    	return this.elementosDocumento.size() - 1;
    }
    
    /**
     * Cria uma representação completa para o elemento.
     * 
     * @param posicao é a posição do elemento no documento.
     * @return a representação completa do elemento.
     */
    public String exibicaoCompleta(int posicao) {
    	return this.elementosDocumento.get(posicao).exibeVersaoCompleta();
    }
    
    /**
     * Cria uma representação resumida para o elemento.
     * 
     * @param posicao é a posição do elemento no documento.
     * @return a representação resumida do elemento.
     */
    public String exibicaoResumida(int posicao) {
    	return this.elementosDocumento.get(posicao).exibeVersaoResumida();
    }
    
    /**
     * Remove um elemento do documento.
     * 
     * @param elementoPosicao é a posição do elemento.
     * @return 
     */
    public boolean removeElemento(int elementoPosicao) {
    	if(elementoPosicao < 0 || elementoPosicao > this.elementosDocumento.size() - 1) {
    		throw new IllegalArgumentException();
    	}
    	elementosDocumento.remove(elementoPosicao);
    	return true;
    }
    
    /**
     * Acessa o tamanho do documento.
     * 
     * @return o tamanho do documento.
     */
    public int getTamanho() {
		return this.tamanho;
    }
    
    /**
     * Acessa o título do documento.
     * 
     * @return o título do documento
     */
    public String getTitulo() {
    	return this.titulo;
    }

    /**
     * Acessa os elementos do documento e transforma-os em String.
     * 
     * @return os elementos do documento.
     */
    public String elementosToString() {
    	if(getElementosDocumento().isEmpty()) {
    		return "";
    	}
    	String elementos = "";
    	for(ElementoGenerico chave: getElementosDocumento()) {
    		elementos += chave.exibeVersaoCompleta() + "\n";
    	}
		return elementos.trim();
    }
    
    /**
     * Edita um elemento do documento.
     * 
     * @param chaveElemento é a identificação do elemento.
     */
    public void editaElemento(int chaveElemento, String novoValor) {
    	getElementosDocumento().get(chaveElemento).setValor(novoValor);
    }
    
    /**
     * Cria um array com a versão completa dos elementos do documento.
     * 
     * @return os elementos do documento.
     */
    public String[] arrayDeElementos() {
    	if(getElementosDocumento().isEmpty()) {
    		return null;
    	}
    	String[] elementos = new String[getQuantidadeDeElementos()];
    	
    	for(int i = 0; i < getQuantidadeDeElementos(); i++) {
    		elementos[i] = getElementosDocumento().get(i).exibeVersaoCompleta();
    	}
		return elementos;
    }
    
    /**
     * Move o elemento uma posição acima.
     * 
     * @param elementoPosicao é a posição do elemento.
     */
    public void moveElementoPosicaoAcima(int elementoPosicao) {
    	for(int i = 0; i < getQuantidadeDeElementos(); i++) {
			if(i == elementoPosicao && elementoPosicao < getQuantidadeDeElementos() - 2) {
				Collections.swap(Arrays.asList(getElementosDocumento()), i, i - 1);
			}
		}
	}

    /**
     * Move o elemento uma posição acima.
     * 
     * @param elementoPosicao é a posição do elemento.
     */
	public void moveElementoPosicaoAbaixo(int elementoPosicao) {
		for(int i = 0; i < getQuantidadeDeElementos(); i++) {
			if(i == elementoPosicao && elementoPosicao < getQuantidadeDeElementos() - 2) {
				Collections.swap(Arrays.asList(getElementosDocumento()), i, i + 1);
			}
		}
	}
    
    /**
     * Acessa os elementos do documento.
     * 
     * @return os elementos do documento.
     */
    public ArrayList <ElementoGenerico> getElementosDocumento() {
		return this.elementosDocumento;
    }
    
    /**
     * Acessa a quantidade de elementos do documento.
     * 
     * @return a quantidade de elementos do documento.
     */
    public int getQuantidadeDeElementos() {
		return this.quantidadeDeElementos;
    }

    /**
     * Calcula a média de prioridade do documento.
     * 
     * @return a média de prioridade do documento.
     */
    public double calculaMediaPrioridade() {
    	int somaPrioridade = 0;
    	for(ElementoGenerico ele: this.elementosDocumento) {
    		somaPrioridade += ele.getPrioridade();
    	} 
    	if(this.quantidadeDeElementos != 0) {
    		return somaPrioridade / this.quantidadeDeElementos;
    	} 
    	return 0;
    }
    
    /**
     * Cria um atalho para o documento.
     * 
     * @param doc o documento que será criado o atalho.
     * @return o atalho do documento.
     */
    public String criaAtalho(Documento doc) {
    	if(doc.getElementosDocumento().isEmpty()) {
    		return "";
    	}
    	Atalho atalho2 = new Atalho(doc);
		this.atalho = atalho2.exibeVersaoCompleta() + atalho2.exibeVersaoResumida();
		
		return this.atalho;
    }
    
    /**
     * Acessa o atalho no documento.
     * 
     * @return o atalho no documento.
     */
    public String getAtalho() {
    	return this.atalho;
    }
    
    @Override
    public String toString() {
    	if(!(elementosToString().isEmpty())) {
    		return this.titulo + System.lineSeparator() + System.lineSeparator() + elementosToString();
    	}
    	return this.titulo + elementosToString();
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(elementosDocumento, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(elementosDocumento, other.elementosDocumento) && Objects.equals(titulo, other.titulo);
	}
}
