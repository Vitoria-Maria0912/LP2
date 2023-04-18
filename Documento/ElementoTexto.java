package documin;

/**
 * Cria um elemento do tipo Texto.
 * 
 * @author Vitória Maria Do Nascimento
 */
public class ElementoTexto extends ElementoGenerico{

    /**
     * Constrói um elemento do tipo texto.
     * 
     * @param valor é o texto do elemento.
     * @param prioridade é a prioridade do texto.
     */
    public ElementoTexto(String valor, int prioridade) {
    	super(valor, prioridade);
    }
    
    @Override
    public String exibeVersaoCompleta() {
		return super.getValor();
    }
    @Override
    public String exibeVersaoResumida() {
		return super.getValor();
    }
}
