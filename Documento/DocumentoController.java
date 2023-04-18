package documin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Cria e faz o controle dos documentos.
 * 
 * @author Vitória Maria Do Nascimento
 *
 */
public class DocumentoController {

    /**
     * Documentos cadastrados no sistema.
     */
    private HashMap <String, Documento> documentos;
    
    /**
     * são as visões dos documentos.
     */
    private ArrayList <String[]> visoes;
    
    /**
     * São os atalhos dos documentos.
     */
    private ArrayList <String> atalho;

    /**
     * Constrói um controlador para os documentos.
     */	
    public DocumentoController() {
    	this.documentos = new HashMap <>();
    	this.visoes = new ArrayList <>();
    	this.atalho = new ArrayList <>();
    }

    /**
     * Cria um objeto do tipo Documento e adiciona ao mapa de documentos.
     * 
     * @param titulo é o título do documento.
     * @return true(se o documento foi cadastrado) or false.
     */
    public boolean criarDocumento(String titulo) {
    	Documento documento = new Documento(titulo);
    	if(documento.checaSeIdentificacaoValida() && !(documentos.containsKey(titulo))) {
    		documentos.put(titulo, documento);
    		return true;
    	}
    	return false;
    }

    /**
     * Cria um objeto do tipo Documento, com quantidade limitada de elementos, e adiciona ao mapa de documentos.
     * 
     * @param titulo é o título do documento.
     * @param tamanhoMaximo é o tamanho máximo de elementos do documento.
     * @return true(se o documento foi cadastrado) or false.
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
    	Documento documento = new Documento(titulo, tamanhoMaximo);
    	if(documento.checaSeIdentificacaoValida() && !(documentos.containsKey(titulo))) {
    		documentos.put(titulo, documento);
    		return true;
    	}
    	return false;
    }
    
    /**
     * Avalia se o documento já foi cadastrado.
     * 
     * @param titulo é a identificação do documento.
     * @return true(se o documento já foi cadastrado) or a exception.
     */
    public boolean checaSeDocumentoCadastrado(String titulo) {
    	if(!(documentos.containsKey(titulo))) {
			throw new NoSuchElementException();
		}
		return true;
    }
    
    /**
     * Cria uma visualização prioritária.
     * 
     * @param idDocumento é o título do documento que será criada a visão.
     * @return o código da visualização.
     */
    public int criaVisaoPrioritaria(String idDocumento) {
    	checaSeDocumentoCadastrado(idDocumento);
    	Visao visao = new Visao(this.documentos.get(idDocumento));
    	this.visoes.add(visao.representacaoPrioritaria());
    	return this.visoes.size() - 1;
    }
    
    /**
     * Cria uma visualização completa.
     * 
     * @param idDocumento é o título do documento que será criada a visão.
     * @return o código da visualização.
     */
    public int criaVisaoCompleta(String idDocumento) {
    	checaSeDocumentoCadastrado(idDocumento);
    	Visao visao = new Visao(this.documentos.get(idDocumento));
    	this.visoes.add(visao.representacaoCompleta());
    	return this.visoes.size() - 1;
    }
    
    /**
     * Cria uma visualização resumida.
     * 
     * @param idDocumento é o título do documento que será criada a visão.
     * @return o código da visualização.
     */
    public int criaVisaoResumida(String idDocumento) {
    	checaSeDocumentoCadastrado(idDocumento);
    	Visao visao = new Visao(this.documentos.get(idDocumento));
    	this.visoes.add(visao.representacaoResumida());
    	return this.visoes.size() - 1;
    }
    
    /**
     * Cria uma visualização de títulos.
     * 
     * @param idDocumento é o título do documento que será criada a visão.
     * @return o código da visualização.
     */
    public int criaVisaoTitulos(String idDocumento) {
    	checaSeDocumentoCadastrado(idDocumento);
    	Visao visao = new Visao(this.documentos.get(idDocumento));
    	this.visoes.add(visao.representacaoTitulos());
    	return this.visoes.size() - 1;
    }

    /**
     * Adiciona um elemento em um documento.
     * 
     * @param chaveElemento é a identificação do elemento.
     * @param idDocumento é a identificação do documento.
     */
    public void adicionaElemento(int chaveElemento, String idDocumento) {
    	checaSeDocumentoCadastrado(idDocumento);
    	ElementoGenerico elemento = documentos.get(idDocumento).getElementosDocumento().get(chaveElemento);
    	if(!(documentos.get(idDocumento).checaSeDocumentoCheio())) {
    		documentos.get(idDocumento).addElemento(elemento);
    	}
    }
    
    /**
     * Mostra a representação completa de um elemento.
     * 
     * @param tituloDoc é o título do documento.
     * @param elementoPosicao é a posição de um elemento no documento.
     * @return a representação completa de um elemento do documento.
     */
    public String pegaRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	checaSeDocumentoCadastrado(tituloDoc);
		return getDocumentos().get(tituloDoc).exibicaoCompleta(elementoPosicao);
    }

    /**
     * Mostra a representação resumida de um elemento.
     * 
     * @param tituloDoc é o título do documento.
     * @param elementoPosicao é a posição de um elemento no documento.
     * @return a representação resumida de um elemento do documento.
     */
    public String pegaRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	checaSeDocumentoCadastrado(tituloDoc);
    	return getDocumentos().get(tituloDoc).exibicaoResumida(elementoPosicao);
    }

    /**
     * Edita um elemento do documento.
     * 
     * @param chaveElemento é a identificação do elemento.
     * @param idDocumento é a identificação do documento.
     */
    public void editaElemento(String idDocumento, int chaveElemento, String novoValor) {
    	getDocumentos().get(idDocumento).editaElemento(chaveElemento, novoValor);
    }

    /**
     * Remove um elemento do documento.
     * 
     * @param chaveElemento é a identificação do elemento.
     * @param idDocumento é a identificação do documento.
     */
    public void removeElemento(String idDocumento, int chaveElemento) {
    	getDocumentos().get(idDocumento).removeElemento(chaveElemento);
    }
    
    /**
     * Apaga um documento do sistema.
     * 
     * @param idDocumento é a identificação do documento.
     */
    public void removeDocumento(String idDocumento) {
    	getDocumentos().remove(idDocumento);
    }

    /**
     * Adiciona o atalho de um documento a outro documento.
     * 
     * @param tituloDoc é o título do documento que será adicionado o atalho.
     * @param tituloDocReferenciado é o título do documento que será criado o atalho.
     * @return a posição do atalho.
     */
    public int addAtalho(String tituloDoc, String tituloDocReferenciado) {
    	checaSeDocumentoCadastrado(tituloDoc);
    	checaSeDocumentoCadastrado(tituloDocReferenciado);
    	
    	Documento doc = this.documentos.get(tituloDoc);
    	Documento doc2 = this.documentos.get(tituloDocReferenciado);
    	
    	if(this.atalho.size() > 1 || checaSeExistemAtalhos(doc) || checaSeExistemAtalhos(doc2)) {
    		throw new IllegalStateException();
    	}
		this.atalho.add(doc.criaAtalho(doc2));
		
		return this.atalho.size() - 1;
    }
    
    /**
     * Acessa o atalho do documento.
     * 
     * @param tituloDoc é o título do documento.
     * @return o atalho do documento.
     */
    public String pegaAtalho(String tituloDoc) {
    	return getDocumentos().get(tituloDoc).getAtalho();
    }
    
    /**
     * Checa se o documento tem atalho ou é atalho.
     * 
     * @param doc é documento.
     * @return true(se o documento tem atalho ou é atalho) or false.
     */
    public boolean checaSeExistemAtalhos(Documento doc) {
    	for(String idDocumento: this.atalho) {
    		if(idDocumento.equals(doc.getTitulo())) {
        		return true;
        	}
    	} return false;
    }
    
    /**
     * Acessa os documentos do sistema.
     * 
     * @return os documentos do sistema.
     */
     public HashMap <String, Documento> getDocumentos() {
		return this.documentos;
    }
    
	/**
	 * Acessa as visões do documento.
	 * 
	 * @return a visão do documento.
	 */
	public ArrayList <String[]> getVisao() {
		return this.visoes;
	}
}
