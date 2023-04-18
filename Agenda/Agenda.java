package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	/**
	 * Constante referente ao tamanho da agenda
	 */
	private static final int TAMANHO_AGENDA = 100;
	
	/**
	 * Array que contém todos os contatos 
	 */
	private Contato[] contatos; 

	/**
	 * Array com os contatos favoritos
	 */
	private Contato[] contatosFavoritados;
	
	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.contatosFavoritados = new Contato[10];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * 
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return contatos;
	}

	/**
	 * Acessa os dados de um contato específico.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}
	
	/**
	 * Acessa o tamanho da agenda
	 * 
	 * @return o tamanho da agenda
	 */
	public int getTamanhoAgenda() {
		return TAMANHO_AGENDA;
	}
	
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		this.contatos[posicao] = new Contato(nome, sobrenome, telefone);
	}
	
	/**
	 * Cadastra um novo favorito
	 * 
	 * @param posicaoArrayFavoritos É a posição no array de favoritos
	 * @param posicaoContato É a posição do contato na agenda
	 * 
	 * @return se é possível favoritá-lo
	 */
	public boolean favoritaContato(int posicaoArrayFavoritos, int posicaoContatos) {
		 if(!verificaSeContatoFavorito(contatos[posicaoContatos]) && contatos[posicaoContatos] != null) {
			this.contatosFavoritados[posicaoArrayFavoritos] = contatos[posicaoContatos];
			return true;
		} return false;
	}

	/**
	 * Altera o array de favoritos, removendo o contato pedido
	 * 
	 * @param posicaoArrayFavoritos É a posição no array de favoritos
	 * @param contatoArray É a posição do contato na agenda
	 */
	public void setContatosFavoritados(int posicaoArrayFavoritos, int contatoArray) {
		 this.contatosFavoritados[contatoArray] = null;
	}
	
	/**
	 * Concatena todos os contatos
	 * 
	 * @return os contatos concatenados
	 */
	public String contatosListados() {
		String resultado = "\n";
		for (int i = 0; i < TAMANHO_AGENDA; i++) {
			if (contatos[i] != null) {
				resultado += i + " - " + contatos[i].nomeCompleto() + "\n";
			} 
		} return resultado;
	}

	/**
	 * Checa se o contato já foi cadastrado
	 * 
	 * @param nome É o nome do contato
	 * @param sobrenome É o sobrenome do contato
	 * @return se o contato já foi cadastrado
	 */
	public boolean checaIdentificacao(String nome, String sobrenome) {
		for(Contato ele: contatos) {
			if(ele != null && ele.getNome().equals(nome) && ele.getSobrenome().equals(sobrenome)) {
				return true;
			}
		} return false;
	}
	
	/**
	 * Concatena os contatos favoritados
	 * 
	 * @return contatos favoritados
	 */
	public String toString() {
		String contatosConcatenados = "";
		for (int i = 0; i < contatosFavoritados.length; i ++) {
			if(contatosFavoritados[i] != null && contatosFavoritados[i].nomeCompleto() != null) {
				contatosConcatenados += i + " - " + contatosFavoritados[i].nomeCompleto() + "\n";
			}
		} return contatosConcatenados;
	}

	/**
	 * Checa se a posição é válida no array
	 * 
	 * @param posicao É a posição do contato na agenda
	 * 
	 * @return se a posição é válida
	 */
	public boolean checaPosicao(int posicao) {
		if (posicao < 1 || posicao > getTamanhoAgenda()) {
			return true;
		} return false;
	}
	
	/**
	 * Verifica se o contato está no array de favoritos
	 * 
	 * @param contato É o contato a ser comparado
	 * 
	 * @return se o contato está no array de favoritos
	 */
	public boolean verificaSeContatoFavorito(Contato contato) {
		for(Contato ele: contatosFavoritados) {
			if(ele != null && ele.equals(contato)) {
				return true;
			}
		} return false;
	}
}
