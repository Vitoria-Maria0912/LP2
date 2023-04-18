package documin;

/**
 * Cria uma visão.
 * 
 * @author Vitória Maria Do Nascimento
 * 
 */
public class Visao {
	
	/**
	 * é o documento que será criada a visão.
	 */
	Documento documento;
	
    /**
     * Constrói uma visão.
     * 
     * @param documento é o documento que será criada a visão.
     */
    public Visao(Documento documento) {
    	this.documento = documento;
    }
    
    /**
     * Acessa os elementos do documento e cria um visão com as representações completas de cada um.
     * 
     * @return a visualização completa.
     */
    public String[] representacaoCompleta() {
    	String[] visaoCompleta = new String[this.documento.getQuantidadeDeElementos()];
    	
    	for(int i = 0; i < this.documento.getElementosDocumento().size(); i++) {
    		visaoCompleta[i] = this.documento.getElementosDocumento().get(i).exibeVersaoCompleta();
    	}
    	return visaoCompleta;
    }
    
    /**
     * Acessa os elementos do documento e cria um visão com as representações resumidas de cada um.
     * 
     * @return a visualização resumida.
     */
    public String[] representacaoResumida() {
    	String[] visaoResumida = new String[this.documento.getQuantidadeDeElementos()];
    	
    	for(int i = 0; i < this.documento.getElementosDocumento().size(); i++) {
    		visaoResumida[i] = this.documento.getElementosDocumento().get(i).exibeVersaoResumida();
    	}
    	return visaoResumida;
    }
    
    /**
     * Avalia se a prioridade de cada elemento é igual ou superior ao parâmetro passado, 
     * se sim, cria um visão com as representações completas de cada um.
     * 
     * @return a visualização prioritária.
     */
    public String[] representacaoPrioritaria() {
    	String[] visaoPrioritaria = new String[this.documento.getQuantidadeDeElementos()];
    	for(int i = 0; i < this.documento.getElementosDocumento().size(); i++) {
    		if(this.documento.getElementosDocumento().get(i).getPrioridade() >= this.documento.calculaMediaPrioridade()) {
    			visaoPrioritaria[i] = this.documento.getElementosDocumento().get(i).exibeVersaoCompleta();
    		}
    	}
    	return visaoPrioritaria;
    }
    
    /**
     * Acessa os elementos do documento e adiciona à visão as representações resumidas de cada elementoTítulo.
     * 
     * @return a visualização de títulos.
     */
    public String[] representacaoTitulos() {
    	ElementoTitulo titulo = new ElementoTitulo(null, 0, 0, false);
    	String[] visaoTitulos = new String[this.documento.getQuantidadeDeElementos()];
    	for(int i = 0; i < this.documento.getElementosDocumento().size(); i++) {
    		if(this.documento.getElementosDocumento().get(i).getClass() == titulo.getClass()) {
    			visaoTitulos[i] = this.documento.getElementosDocumento().get(i).exibeVersaoResumida();
    		}
    	}
    	return visaoTitulos;
    }
}
