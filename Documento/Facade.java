package documin;

/**
 * Estabelece a relação entre o Controller dos documentos e a classe de lógica, 
 * ela é quem faz a gestão das informações.
 * 
 * @author Vitória Maria Do Nascimento
 *
 */
public class Facade {

    /**
     * Objeto do tipo DocumentoController que permite o acesso aos documentos e seus métodos.
     */
    private DocumentoController documentoController;

    /**
     * Cria um sistema que contém os documentos.
     */
    public Facade() {
    	this.documentoController = new DocumentoController();
    }

    /**
     * Cria um objeto do tipo Documento.
     * 
     * @param titulo é o título do documento.
     * @return true(se o documento foi cadastrado) or false.
     */
    public boolean criarDocumento(String titulo) {
		return this.documentoController.criarDocumento(titulo);
    }

    /**
     * Cria um objeto do tipo Documento com quantidade limitada de elementos.
     * 
     * @param titulo é o título do documento.
     * @param tamanhoMaximo é o tamanho máximo de elementos do documento.
     * @return true(se o documento foi cadastrado) or false.
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		return this.documentoController.criarDocumento(titulo, tamanhoMaximo);
    }

    /**
     * Remove um documento do sistema.
     * 
     * @param titulo é o título do documento.
     */
    public void removerDocumento(String titulo) {
    	this.documentoController.checaSeDocumentoCadastrado(titulo);
    	this.documentoController.removeDocumento(titulo);
    }

    /**
     * Edita um elemento do documento.
     * 
     * @param titulo é o título do documento.
     * @param chaveElemento é a posição do elemento que será alterado.
     * @param novoValor é o novo valor para o elemento.
     */
    public void editaElemento(String titulo, int chaveElemento, String novoValor) {
    	this.documentoController.getDocumentos().get(titulo).editaElemento(chaveElemento, novoValor);;
    }
    
    /**
     * Conta quantos elementos um documento tem.
     * 
     * @param titulo é o título do documento.
     * @return a quantidade de elemento.
     */
    public int contarElementos(String titulo) {
    	this.documentoController.checaSeDocumentoCadastrado(titulo);
    	return documentoController.getDocumentos().get(titulo).getQuantidadeDeElementos();
    }

    /**
     * Exibe um documento através de seu título.
     * 
     * @param titulo é o título do documento.
     * @return a representação do documento.
     */
    public String[] exibirDocumento(String titulo) {
    	this.documentoController.checaSeDocumentoCadastrado(titulo);
		return this.documentoController.getDocumentos().get(titulo).arrayDeElementos();
    }

    /**
     * Cria um elemento do tipo Texto.
     * 
     * @param tituloDoc é o título do documento.
     * @param valor é o texto.
     * @param prioridade é a prioridade que o texto tem.
     * @return a posição do elemento.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	this.documentoController.checaSeDocumentoCadastrado(tituloDoc);
    	ElementoTexto texto = new ElementoTexto(valor, prioridade);
    	return this.documentoController.getDocumentos().get(tituloDoc).addElemento(texto);
    }
    
    /**
     * Cria um elemento do tipo Título.
     * 
     * @param tituloDoc é o título do documento.
     * @param valor é o título.
     * @param prioridade é a prioridade que o título tem.
     * @param nivel é o nível do título.
     * @param linkavel se é possível criar um link ou não.
     * @return a posição do elemento.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	this.documentoController.checaSeDocumentoCadastrado(tituloDoc);
    	ElementoTitulo titulo = new ElementoTitulo(valor, prioridade, nivel, linkavel);
    	return this.documentoController.getDocumentos().get(tituloDoc).addElemento(titulo);
    }

    /**
     * Cria um elemento do tipo Lista.
     * 
     * @param tituloDoc é o título do documento.
     * @param valorLista são os valores da lista.
     * @param prioridade é a prioridade que a lista tem.
     * @param separador é o caractere que separa cada elemento da lista.
     * @param charLista é o caractere que substitui o separador na exibição completa.
     * @return a posição do elemento.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	this.documentoController.checaSeDocumentoCadastrado(tituloDoc);
    	ElementoLista lista = new ElementoLista(charLista, prioridade, separador, charLista);
    	return this.documentoController.getDocumentos().get(tituloDoc).addElemento(lista);
    }

    /**
     * Cria um elemento do tipo Termo.
     * 
     * @param tituloDoc é o título do documento.
     * @param valorTermos são os termos.
     * @param prioridade é a prioridade que o termo tem.
     * @param separador é o caractere que separa cada termo.
     * @param ordem é a ordenação dos termos.
     * @return a posição do elemento.
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	this.documentoController.checaSeDocumentoCadastrado(tituloDoc);
    	ElementoTermos termos = new ElementoTermos(ordem, prioridade, separador, ordem);
    	return this.documentoController.getDocumentos().get(tituloDoc).addElemento(termos);
    }

    /**
     * Mostra a representação completa de um elemento.
     * 
     * @param tituloDoc é o título do documento.
     * @param elementoPosicao é a posição de um elemento no documento.
     * @return a representação completa de um elemento do documento.
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		return this.documentoController.pegaRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    /**
     * Mostra a representação resumida de um elemento.
     * 
     * @param tituloDoc é o título do documento.
     * @param elementoPosicao é a posição de um elemento no documento.
     * @return a representação resumida de um elemento do documento.
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.pegaRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    /**
     * Remove um elemento do documento.
     * 
     * @param tituloDoc é o título do documento.
     * @param elementoPosicao é a posição de um elemento no documento.
     * @return true(se foi possível remover o elemento) or a exception.
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
    	this.documentoController.checaSeDocumentoCadastrado(tituloDoc);
    	return this.documentoController.getDocumentos().get(tituloDoc).removeElemento(elementoPosicao);
    }

    /**
     * Move o elemento uma posição acima.
     * 
     * @param tituloDoc é o título do documento.
     * @param elementoPosicao é a posição do elemento no documento.
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	this.documentoController.checaSeDocumentoCadastrado(tituloDoc);
    	this.documentoController.getDocumentos().get(tituloDoc).moveElementoPosicaoAcima(elementoPosicao);
    }

    /**
     * Move o elemento uma posição abaixo.
     * 
     * @param tituloDoc é o título do documento.
     * @param elementoPosicao é a posição do elemento no documento.
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	this.documentoController.checaSeDocumentoCadastrado(tituloDoc);
    	this.documentoController.getDocumentos().get(tituloDoc).moveElementoPosicaoAbaixo(elementoPosicao);
    }

    /**
     * Cria um atalho para um documento.
     * 
     * @param tituloDoc é o título do documento que será adicionado o atalho.
     * @param tituloDocReferenciado é o título do documento que será criado o atalho.
     * @return o código do atalho.
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		return this.documentoController.addAtalho(tituloDoc, tituloDocReferenciado);
    }

    /**
     * Cria uma visão completa para o documento.
     * 
     * @param tituloDoc é o título do documento.
     * @return a posição da visão.
     */
    public int criarVisaoCompleta(String tituloDoc) {
		return this.documentoController.criaVisaoCompleta(tituloDoc);
    }

    /**
     * Cria uma visão resumida para o documento.
     * 
     * @param tituloDoc é o título do documento.
     * @return a posição da visão.
     */
    public int criarVisaoResumida(String tituloDoc) {
		return this.documentoController.criaVisaoResumida(tituloDoc);
    }

    /**
     * Cria uma visão prioritária para o documento.
     * 
     * @param tituloDoc é o título do documento.
     * @return a posição da visão.
     */
    public int criarVisaoPrioritaria(String tituloDoc) {
    	return this.documentoController.criaVisaoPrioritaria(tituloDoc);
    }

    /**
     * Cria uma visão de títulos para o documento.
     * 
     * @param tituloDoc é o título do documento.
     * @return a posição da visão.
     */
    public int criarVisaoTitulo(String tituloDoc) {
    	return this.documentoController.criaVisaoTitulos(tituloDoc);
    }

    /**
     * Exibe uma visão do documento.
     * 
     * @param idVisao é a posição da visão.
     * @return uma visão.
     */
    public String[] exibirVisao(int visaoId) {
		return this.documentoController.getVisao().get(visaoId);
    }
}
