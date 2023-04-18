package agenda;

/**
 * Cria um contato a partir de um nome, sobrenome e telefone e cadastra-o na agenda
 * 
 * @author Vitória Maria do Nascimento
 */
public class Contato {
	
	/**
	 * nome do contato
	 */
	private String nome;
	/**
	 * sobrenome do contato
	 */
	private String sobrenome;
	/**
	 * telefone do contato
	 */
	private String telefone;
	
	/**
	 * Constrói um contato
	 * 
	 * @param nome É nome do contato
	 * @param sobrenome É sobrenome do contato
	 * @param telefone É telefone do contato
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	/**
	 * Acessa o nome do contato
	 * 
	 * @return nomeContato
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Acessa o sobrenome do contato
	 * 
	 * @return sobrenomeContato
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * Acessa o telefone do contato
	 * 
	 * @return telefoneContato
	 */
	public String getTelefone() {
		return this.telefone;
	}

	@Override
	public String toString() {
		return nomeCompleto() + "\n" + this.telefone;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this.getClass() != obj.getClass()) {
            return false;
        }
		
		Contato contato = (Contato) obj;
        
		if((this.nome).equals(contato.getNome()) && (this.sobrenome).equals(contato.getSobrenome())) {
			return true;
		} return false;
	}
	
	/**
	 * Concatena nome e sobrenome
	 * 
	 * @return o nomeCompleto
	 */
	public String nomeCompleto() {
		return this.nome + " " + this.sobrenome;
	}
}
