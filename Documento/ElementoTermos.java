package documin;

/**
 * Cria um elemento do tipo Termo.
 * 
 * @author Vitória Maria Do Nascimento
 *
 */
public class ElementoTermos extends ElementoGenerico{

    /**
     * é a quantidade de termos de um elemento.
     */
    private int quantidadeTermos;
    
    /**
     * é o caractere que separa cada termo.
     */
    private String separador;
    
    /**
     * é o tipo de ordenação.
     */
    private String ordem;

    /**
     * Constrói um termo.
     * 
     * @param valor São os termos.
     * @param prioridade é a prioridade do termo.
     * @param separador é o caractere que separa cada termo.
     * @param ordem é a ordenação dos termos.
     */
    public ElementoTermos(String valor, int prioridade, String separador, String ordem) {
    	super(valor, prioridade);
    	this.separador = separador;
    	this.quantidadeTermos = valor.split(this.separador).length;
    	this.ordem = ordem;
    }
    
	/**
	 * Ordena os termos da maneira desejada.
	 * 
	 * @return os termos em ordem.
	 */
	private String ordenaElementos() {
		Ordem ordenacao = new Ordem(this.ordem);
		String[] valores = super.getValor().split(this.separador);
		return ordenacao.ordenaElementos(valores, separador);
	}
	
    @Override
    public String exibeVersaoCompleta() {
		return "Total termos: " + this.quantidadeTermos + "\n- " + ordenaElementos().replace(this.separador, ", ");
    }
    
    @Override
    public String exibeVersaoResumida() {
		return ordenaElementos();
    }
}
