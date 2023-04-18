package documin;

/**
 * Cria um elemento do tipo título.
 * 
 * @author Vitória Maria Do Nascimento
 * 
 */
public class ElementoTitulo extends ElementoGenerico{

    /**
     * é o nível do título.
     */
    private int nivel;
    
    /**
     * é a possibilidadde de criar um link.
     */
    private boolean linkavel;

    /**
     * Constrói um título.
     * 
     * @param valor é o título.
     * @param nivel é o nível do título.
     * @param prioridade é a prioridade do título.
     * @param linkavel é a possibilidadde de criar um link para o título.
     */
    public ElementoTitulo(String valor, int nivel, int prioridade, boolean linkavel) {
    	super(valor, prioridade);
    	this.nivel = nivel;
    	this.linkavel = linkavel;
    }
   
    @Override
    public String exibeVersaoCompleta() {
    	if(linkavel) {
    		return this.nivel + ". " + super.getValor() + " -- \n" + this.nivel + "-" + super.getValor().toUpperCase().replaceAll(" ", "");
    	}
    	return this.nivel + ". " + super.getValor();

    }
    @Override
    public String exibeVersaoResumida() {
		return this.nivel + ". " + super.getValor();
    }
    
    @Override
    public String toString() {
    	return super.getValor() + "\nNível: " + this.nivel + "\nLinkável: " + this.linkavel;
    }
}
