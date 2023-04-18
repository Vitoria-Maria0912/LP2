package documin;

/**
 * Cria um elemento do tipo Lista.
 * 
 * @author Vitória Maria Do Nascimento
 *
 */
public class ElementoLista extends ElementoGenerico{

    /**
     * é o caractere que separa cada elemento da lista.
     */
    private String separador;

    /**
     * é o caractere que substitui o separador na exibição completa.
     */
    private String caractereDeLista;

    /**
     * Constrói um elemento do tipo Lista.
     * 
     * @param valor São os valores da lista.
     * @param prioridade é a prioridade da lista.
     * @param separador é o caractere que separa cada elemento da lista.
     * @param caractereDeLista é o caractere que substitui o separador na exibição completa.
     */
    public ElementoLista(String valor, int prioridade, String separador, String caractereDeLista) {
    	super(valor, prioridade);
    	this.separador = separador;
    	this.caractereDeLista = caractereDeLista;
    }
   
    @Override
    public String exibeVersaoCompleta() {
    	return this.caractereDeLista + " " + super.getValor().replace(this.separador, "\n" + this.caractereDeLista + " ");
    }
    
    @Override
    public String exibeVersaoResumida() {
		return "" + super.getValor().replace(this.separador, ", "); 
    }
}
