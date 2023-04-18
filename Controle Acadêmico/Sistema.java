package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe responsável por gerenciar os alunos e grupos.
 * 
 * @author Vitória Maria do Nascimento
 *
 */
public class Sistema {

	/**
	 * É um mapa que contém todos os alunos cadastrados.
	 */
	private HashMap <String, Aluno> alunos;
	
	/**
	 * É um mapa que contém todos os grupos cadastrados.
	 */
	private HashMap <String, Grupo> grupos;
	
	/**
	 * É um array que contém a matrícula de todos os alunos que responderam.
	 */
	private ArrayList <String> alunosQueResponderam;
	
	/**
	 * Constrói um sistema que permite o cadastro de alunos e grupos.
	 */
	public Sistema() {
		this.alunos = new HashMap <> ();
		this.grupos = new HashMap <> ();
		this.alunosQueResponderam = new ArrayList <> ();
	}

	/**
	 * Cadastra um aluno no sistema.
	 * 
	 * @param nomeAluno É o nome do aluno.
	 * @param matricula É a matrícula do aluno.
	 * @param curso     É o curso do aluno.
	 * 
	 * @return se o aluno foi cadastrado ou não.
	 */
	public String cadastraAlunoSistema(String nomeAluno, String matricula, String curso) {
	    
	    if(nomeAluno == null || matricula == null || curso == null) {
	        return "ALUNO INVÁLIDO!\n";
	    }
		
		Aluno newAluno = new Aluno(nomeAluno, matricula, curso);
		
		if(!alunos.containsKey(matricula)) {
			this.alunos.put(matricula, newAluno);
			return "CADASTRO REALIZADO!\n";
		}
		return "MATRÍCULA JÁ CADASTRADA!\n";
	}
	
	/**
	 * Exibe os dados do aluno.
	 * 
	 * @param matricula É a matrícula do aluno.
	 * 
	 * @return os dados do aluno.
	 */
	public String exibeAlunoCadastrado(String matricula) {
	    
	    if(!(this.alunos.containsKey(matricula))) {
	        return "ALUNO NÃO CADASTRADO.\n";
        }
		Aluno aluno = this.alunos.get(matricula);
		
		return "Aluno: " + aluno.toString() + "\n";
	}
	
	/**
     * Verifica se o nome do grupo foi cadastrado, desconsiderando maiúculas e minúsculas.
     * 
     * @param nomeDoGrupo É o nome do grupo.
     * 
     * @return o nome do grupo em LowerCase.
     */
    public String nomeDoGrupoToLowerCase(String nomeDoGrupo) {
        for(String chave: getGrupos().keySet()) {
            if(chave.toLowerCase().equals(nomeDoGrupo.toLowerCase())) {
                return chave.toLowerCase();
            }
        }
        return null;
    }
    
	/**
     * Checa se o grupo já foi cadastrado.
     * 
     * @param nomeDoGrupo É o nome do grupo.
     * 
     * @return se o grupo já foi cadastrado.
     */
    public boolean checaSeGrupoFoiCadastrado(String nomeDoGrupo) {
        if(nomeDoGrupoToLowerCase(nomeDoGrupo) != null) {
            return true;
        }
        return false;
    }
    
	/**
	 * Cadastra um grupo de tamanho limitado.
	 * 
	 * @param nomeDoGrupo         É o nome do grupo.
	 * @param limiteParticipantes É a quantidade máxima de participantes do grupo.
	 * 
	 * @return se o grupo foi cadastrado ou não.
	 */
	public String cadastraGrupoLimitadoSistema(String nomeDoGrupo, int limiteParticipantes) {
	    
	    if(limiteParticipantes < 1 || nomeDoGrupo == null) {
            return "GRUPO INVÁLIDO!\n";
        }
		
		Grupo newGrupo = new Grupo(nomeDoGrupo, limiteParticipantes);
		
		if(nomeDoGrupo != null && !(this.grupos.containsKey(nomeDoGrupoToLowerCase(nomeDoGrupo)))) {
			this.grupos.put(nomeDoGrupo, newGrupo);
			return "CADASTRO REALIZADO!\n";
		} return "GRUPO JÁ CADASTRADO!\n";
	}

	/**
	 * Adiciona grupo no sistema.
	 * 
	 * @param nomeDoGrupo É o nome do grupo.
	 * 
	 * @return se o grupo foi cadastrado ou não.
	 */
	public String cadastraGrupoNoSistema(String nomeDoGrupo) {
		
		Grupo newGrupo = new Grupo(nomeDoGrupo);
		
		if(nomeDoGrupo != null && !(checaSeGrupoFoiCadastrado(nomeDoGrupo))) {
			this.grupos.put(nomeDoGrupo, newGrupo);
			return "CADASTRO REALIZADO!\n";
		} return "GRUPO JÁ CADASTRADO!\n";
	}
	
	/**
	 * Checa se o grupo está cheio.
	 * 
	 * @param nomeDoGrupo É o nome do grupo.
	 * 
	 * @return se o grupo está cheio ou não.
	 */
	private boolean checaSeGrupoEstaCheio(String nomeDoGrupo) {
		
		Grupo grupo = getGrupos().get(nomeDoGrupoToLowerCase(nomeDoGrupo));
		
		if(grupo.getLimiteDeParticipantes() != 0 && grupo.getLimiteDeParticipantes() == grupo.getQuantidadeDeParticipantes()) {
			return true;
		} return false;
	}
	
	/**
	 * Checa a pertinência de um aluno em um grupo.
	 * 
	 * @param nomeDoGrupo É o nome do grupo.
	 * @param matricula   É a matrícula do aluno.
	 * 
	 * @return se o aluno pertence ao grupo.
	 */
	public String checaSeAlunoEstaEmGrupo(String nomeDoGrupo, String matricula) { 
	    
	    if(matricula == null || nomeDoGrupo == null) {
	        return "ALUNO NÃO PERTENCE AO GRUPO.\n";
	    }
	    
		Grupo grupo = this.grupos.get(nomeDoGrupoToLowerCase(nomeDoGrupo));
		
		for(Aluno aluno: grupo.getParticipantes()) {
			if(aluno.getMatricula().equals(matricula)) {
				return "ALUNO PERTENCE AO GRUPO.\n";
			}
		}
		return "ALUNO NÃO PERTENCE AO GRUPO.\n";
	}
	
	/**
     * Aloca um aluno em um grupo.
     * 
     * @param matricula   É a matrícula do aluno.
     * @param nomeDoGrupo É o nome do grupo.
     * 
     * @return se o aluno foi alocado.
     */
    public String alocaAlunoEmGrupoSistema(String matricula, String nomeDoGrupo) {
        
        Aluno aluno = alunos.get(matricula);
        
        if(checaSeGrupoEstaCheio(nomeDoGrupo)) {
            if(checaSeAlunoEstaEmGrupo(nomeDoGrupo, matricula).equals("ALUNO PERTENCE AO GRUPO.\n")) {
                return "ALUNO ALOCADO!\n";
            }
            return "GRUPO CHEIO!\n";
        }
        
        if(!(this.grupos.containsKey(matricula))) {
            this.grupos.get(nomeDoGrupoToLowerCase(nomeDoGrupo)).adicionaParticipantes(aluno);
            return "ALUNO ALOCADO!\n";
        } 
        return "ALUNO JÁ ALOCADO!\n";
    }
    
	/**
	 * Mostra os grupos que o aluno participa.
	 * 
	 * @param matricula É a matrícula do aluno.
	 * 
	 * @return os grupos que o aluno participa.
	 */
	public String gruposQueAlunoParticipa(String matricula) { 
		Aluno aluno = alunos.get(matricula);
		String gruposParticipados = "";
		
		for(String chave: grupos.keySet()) {
			Grupo grupo = this.grupos.get(chave);
			HashSet <Aluno> alunos = grupo.getParticipantes();
			
			if(alunos.contains(aluno) && grupo.getLimiteDeParticipantes() <= 0) {
				gruposParticipados += "- " + chave + " " + grupo.getQuantidadeDeParticipantes() + "/ilimitado\n";
			} else if(alunos.contains(aluno)) {
				gruposParticipados += "- " + chave + " " + grupo.getQuantidadeDeParticipantes() + "/" + grupo.getLimiteDeParticipantes() + "\n";
			}
		} if(gruposParticipados.isEmpty()) {
			return "";
		}
		
		return gruposParticipados;
	}
	
	/**
	 * Acessa os grupos cadastrados no sistema.
	 * 
	 * @return grupos do sistema.
	 */
	private HashMap <String, Grupo> getGrupos() {
		return this.grupos;
	}

	/**
	 * Acessa os grupos cadastrados no sistema.
	 * 
	 * @return alunos do sistema.
	 */
	public HashMap <String, Aluno> getAlunos() {
		return this.alunos;
	}
	
	/**
     * Acessa os alunos que responderam e retorna em String.
     * 
     * @return os alunos que responderam
     */
    public String getAlunosQueResponderam() {
        
        String alunos = "";
        int ordem = 1;
        for(int i = 0; i < this.alunosQueResponderam.size(); i ++) {
            Aluno aluno = this.alunos.get(alunosQueResponderam.get(i));
            alunos += ordem + ". " + aluno.getMatricula() + " - " + aluno.getNome() + " - " + aluno.getCurso() + "\n";
            ordem ++;
        }
        return alunos;
    }
    
    /**
     * Registra um aluno no array de alunos que responderam.
     * 
     * @param matricula É a matrícula do aluno.
     * @return se o aluno foi registrado
     */
    public String registraAlunoQueRespondeu(String matricula) {
        
        if (!(getAlunos().containsKey(matricula))) {
            return "ALUNO NÃO CADASTRADO.\n";
        }
        
        this.alunosQueResponderam.add(matricula);
        return "ALUNO REGISTRADO!\n";
    }
}
