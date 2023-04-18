package lab4;

import java.util.HashSet;
import java.util.Objects;

/**
 * Classe responsável por criar um grupo que pode conter alunos.
 * 
 * @author Vitoria Maria do Nascimento
 *
 */
public class Grupo {
	
	/**
	 * É o nome do grupo.
	 */
	private String nomeGrupo;
	
	 /**
     * HashSet de participantes de determinado grupo.
     */
    private HashSet <Aluno> participantes;
    
	/**
	 * É a quantidade de participantes de um determinado grupo.
	 */
	private int quantidadeParticipantes;
	
	/**
	 * É a quantidade máxima de participantes de um grupo.
	 */
	private int limiteDeParticipantes;
	
	/**
	 * Constrói um grupo de tamanho ilimitado a partir de seu nome.
	 * 
	 * @param nomeGrupo É o nome do grupo.
	 */
	public Grupo(String nomeGrupo) {
		this.participantes = new HashSet <> ();
		this.nomeGrupo = nomeGrupo;
		this.quantidadeParticipantes = 0;
		this.limiteDeParticipantes = 0;
	}
	
	/**
	 * Constrói um grupo de tamanho limitado a partir de seu nome e seu limite.
	 * 
	 * @param nomeGrupo É o nome do grupo.
	 * @param limite É o limite de participantes do grupo.
	 */
	public Grupo(String nomeGrupo, int limite) {
		this.participantes = new HashSet <> ();
		this.nomeGrupo = nomeGrupo;
		this.quantidadeParticipantes = 0;
		this.limiteDeParticipantes = limite;
	}
	
	/**
	 * Aloca aluno em um HashSet de um grupo e incrementa a quantidade de participantes. 
	 * 
	 * @param aluno É o aluno que será alocado.
	 */
	public void adicionaParticipantes(Aluno aluno) {
		if(quantidadeParticipantes < limiteDeParticipantes || limiteDeParticipantes == 0) {
			this.participantes.add(aluno);
			this.quantidadeParticipantes ++;
		}
	}
	
	 /**
     * Acessa o nome do grupo.
     * 
     * @return nome do grupo.
     */
    public String getNomeGrupo() {
        return this.nomeGrupo;
    }
    
	/**
	 * Acessa os participantes de um grupo.
	 * 
	 * @return participantes do grupo.
	 */
	public HashSet <Aluno> getParticipantes(){
		return this.participantes;
	}
	
	/**
	 * Acessa a quantidade de participantes de um grupo.
	 * 
	 * @return quantidade de participantes de um grupo.
	 */
	public int getQuantidadeDeParticipantes() {
		return this.quantidadeParticipantes;
	}
	
	/**
	 * Acessa a quantidade máxima de participantes de um gruop.
	 * 
	 * @return limite de participantes.
	 */
	public int getLimiteDeParticipantes() {
		return this.limiteDeParticipantes;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nomeGrupo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(nomeGrupo, other.nomeGrupo);
	}
}
