package documin;

/**
 * Cria um atalho.
 * 
 * @author Vitória Maria Do Nascimento
 * 
 */
public class Atalho {

	/**
	 * é o documento que será criado o atalho.
     */
	private Documento documento;
	
    /**
     * Constrói um atalho.
     * 
     * @param documento é o documento que será criado o atalho.
     */
    public Atalho(Documento documento) {
    	this.documento = documento;
    }

    /**
     * Exibe um atalho versão completa.
     * 
     * @return um atalho versão completa.
     */
    public String exibeVersaoCompleta() {
    	String representacaoCompleta = "";
    	if(this.documento.calculaMediaPrioridade() == 4 || this.documento.calculaMediaPrioridade() == 5) {
    		for(ElementoGenerico elemento: documento.getElementosDocumento()) {
    			representacaoCompleta += elemento.exibeVersaoCompleta() + System.lineSeparator() + System.lineSeparator();
    		}
    	}
    	return representacaoCompleta;
    }

    /**
     * Exibe um atalho versão resumida.
     * 
     * @return um atalho versão resumida.
     */
    public String exibeVersaoResumida() {
    	String representacaoResumida = "";
    	if(this.documento.calculaMediaPrioridade() == 4 || this.documento.calculaMediaPrioridade() == 5) {
    		for(ElementoGenerico elemento: documento.getElementosDocumento()) {
    			representacaoResumida += elemento.exibeVersaoResumida() + System.lineSeparator() + System.lineSeparator();
    		}
    	} return representacaoResumida.trim();
    }
}
