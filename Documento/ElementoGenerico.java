package documin;

import java.util.HashSet;
import java.util.Objects;

/**
 * Cria um elemento genérico.
 * 
 * @author Vitória Maria Do Nascimento
 *
 */
public abstract class ElementoGenerico {
	
	/**
	 * são os valores de um elemento.
	 */
	private String valor;
	
	/**
	 * São as propriedades de um elemento.
	 */
	private HashSet <String> propriedades;
	
	/**
	 * é a prioridade de um elemento.
	 */
	private int prioridade;
	
	/**
	 * Contrói um elemento a partir de um valor e uma prioridade.
	 * 
	 * @param valor são os valores de um elemento.
	 * @param prioridade é a prioridade de um elemento.
	 */
	public ElementoGenerico(String valor, int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
		this.propriedades = new HashSet<>();
	}

    /**
     * Adiciona uma propriedade ao elemento.
     * 
     * @param propriedade é a propriedade do documento.
     */
    public void addPropriedade(String propriedade) {
		this.propriedades.add(propriedade);
	}

	/**
	 * Muda o valor do elemento.
	 * 
	 * @param novoValor é o novo valor do elemento.
	 */
	public void setValor(String novoValor) {
		this.valor = novoValor;
	}
	
	/**
	 * Acessa o valor do elemento.
	 * 
	 * @return o valor do elemento.
	 */
	public String getValor() {
		return this.valor;
	}

	/**
	 * Acessa as propriedades do elemento.
	 * 
	 * @return as propriedades do elemento.
	 */
	public HashSet <String> getPropriedades() {
		return this.propriedades;
	}
	
	/**
	 * Muda a prioridade do elemento.
	 * 
	 * @param prioridade é a prioridade do elemento.
	 */
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	/**
	 * Acessa a prioridade do elemento.
	 * 
	 * @return a prioridade do elemento.
	 */
	public int getPrioridade() {
		return this.prioridade;
	}

	/**
	 * Exibe uma representação completa do elemento.
	 * 
	 * @return a representação completa do elemento.
	 */
	public abstract String exibeVersaoCompleta();
	
	/**
	 * Exibe uma representação resumida do elemento.
	 * 
	 * @return a representação resumida do elemento.
	 */
	public abstract String exibeVersaoResumida();
	
	@Override
	public int hashCode() {
		return Objects.hash(this.valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementoGenerico other = (ElementoGenerico) obj;
		return Objects.equals(this.valor, other.valor);
	}
}
