package lab2;

/**
* Classe que acompanha desempenho de um aluno através dos resumos de estudos
* registrados ao longo do período.
* 
* @author Vitória Maria do Nascimento
*/
public class RegistroResumos {

    /**
     * Refere-se a quantidade máxima de resumos.
     */
    private int numeroDeResumos;

    /**
     * Refere-se a quantidade válida de resumos, ou seja, diferente de 'null'.
     */
    private int quantidadeResumosValidos;

    /**
     * Atributo referente a todas os temas concatenado;
     */
    private String temasConcatenados;

    /**
     * Array com todos os temas e seus respectivos resumos.
     */
    private String[] resumos;

    /**
     * Array apenas com os temas dos resumos.
     */
    private String[] temas;

    /**
     * Construtor que define a quantidade máxima de resumos e constrói dois arrays 
     * que têm o tamanho do número de resumos e define temas concatenados.
     * @param numeroResumos que é o número de resumos
     */
    public RegistroResumos(int numeroResumos) {
        this.numeroDeResumos = numeroResumos;
        this.resumos = new String[numeroResumos];
        this.temas = new String[numeroResumos];
        this.temasConcatenados = "";
    }

    /**
     * Método que adiciona um novo tema e um novo resumo.
     * @param tema é o assunto de que se trata o resumo. 
     * @param resumo é o conteúdo estudado.
     */
    public void adiciona(String tema, String resumo) {

        if (this.quantidadeResumosValidos == this.numeroDeResumos) {
        	this.quantidadeResumosValidos = 0;
            this.resumos[this.quantidadeResumosValidos] = tema + ": " + resumo;
            this.temas[this.quantidadeResumosValidos] = tema;
        }
        
        else {
        	if (temas[this.quantidadeResumosValidos] == null && resumos[this.quantidadeResumosValidos] == null) {
                this.resumos[this.quantidadeResumosValidos] = tema + ": " + resumo;
                this.temas[this.quantidadeResumosValidos] = tema;
            }
        }
        
        this.quantidadeResumosValidos ++;
        
        concatenaTemas(tema);    
    }

    /**
     * Método que concatena todos os temas.
     * @param tema é o assunto de que se trata o resumo. 
     */
    private void concatenaTemas(String tema) {
        this.temasConcatenados += tema + " | ";
    }

    /**
     * Método que retorna um array com todos os resumos.
     * @return array composto por todos os temas e resumos.
     */
    public String[] pegaResumos() {
        return resumos;
    }

    /**
     * Método que imprime os resumos válidos, ou seja, diferentes de 'null'.
     * @return o que será exibido.
     */
    public String imprimeResumos() {
        return "- " + quantidadeResumosValidos + " resumo(s) cadastrado(s)" + "\n" + "- " + this.temasConcatenados.substring(0, temasConcatenados.length() - 2);
    }

    /**
     * Método que contabiliza a quantidade de resumos cadastrados.
     * @return a quantidade de resumos diferentes de 'null'.
     */
    public int conta() {
        return quantidadeResumosValidos;
    }

    /**
     * Método que avalia se algum dos temas é o mesmo do parâmetro 'assunto'.
     * @param assunto é o tema de um resumo.
     * @return se tem algum resumo no array que tenha o mesmo nome do parâmetro.
     */
    public boolean temResumo(String assunto) {
        boolean tem = false;
        for (String ele: temas) {
            if (ele != null) {
                if (ele.equals(assunto)) {
                    tem = true;
                } 
            }
        } 
        return tem;
    }
}
