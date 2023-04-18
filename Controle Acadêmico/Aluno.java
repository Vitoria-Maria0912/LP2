package lab4;

import java.util.Objects;

/**
 * Classe reponsável por criar um aluno.
 * 
 * @author Vitoria Maria do Nascimento
 *
 */
public class Aluno {
	
	/**
	 * É o nome do aluno.
	 */
	private String nome;
	
	/**
	 * É a matricula do aluno.
	 */
	private String matricula;
	
	/**
	 * É o nome do curso.
	 */
	private String curso;
	
	/**
	 * Contrói um aluno a partir de seu nome, sua matrícula e seu curso.
	 * 
	 * @param nome      É o nome do aluno.
	 * @param matricula É a matricula do aluno.
	 * @param curso     É o nome do curso.
	 */
	public Aluno(String nome, String matricula, String curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	/**
	 * Acessa o nome do aluno.
	 * 
	 * @return o nome do aluno.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Acessa a matrícula do aluno.
	 * 
	 * @return a matricula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Acessa o curso do aluno.
	 * 
	 * @return o curso do aluno.
	 */
	public String getCurso() {
		return this.curso;
	}
	
	@Override
	public String toString() {
		return getMatricula() + " - " + getNome() + " - " + getCurso();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		if (this == obj)
			return true;
		
		Aluno other = (Aluno) obj;
		
		return Objects.equals(matricula, other.matricula);
	}
}
