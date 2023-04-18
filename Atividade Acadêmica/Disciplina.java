package lab2;

import java.util.Arrays;

/**
* Classe que avalia o rendimento escolar de um aluno, se a média necessária para ser aprovado foi 
* atingida, calcula as horas dedicadas ao estudo e mostra as 4 notas obtidas.
* 
* @author Vitória Maria do Nascimento
*/
public class Disciplina {

    /**
     * Referente ao nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Array de inteiros composto pelos valores das notas.
     */
    private double[] notas = {0, 0, 0, 0};

    /**
     * Referente a horas de estudo.
     */
    private int horasDeEstudo;

    /**
     * Referente a média do aluno.
     */
    private double media;

    /**
     * Constrói um objeto disciplina através do nome da disciplina.
     * @param disciplina que é nome da disciplina.
     */
    public Disciplina (String disciplina) {
        this.nomeDisciplina = disciplina;
    }

    /**
     * Construtor que recebe um inteiro referente a quantidade de horas de estudo 
     * e soma a quantidade anterior, contruindo um objeto horas de estudo.
     * @param horasEstudando que são as horas de estudo.
     */
    public void cadastraHoras(int horasEstudando) {
        this.horasDeEstudo += horasEstudando;
    }

    /**
     * Método que possui dois parâmetros referentes as notas, um inteiro, de 1 a 4, e um double que é a nota obtida.
     * @param nota que é número de 1 a 4.
     * @param valorNota que é um valor, de 0.0 a 10.0, referente a cada nota.
     */
    public void cadastraNota(int nota, double valorNota) {
        notas[nota - 1] = valorNota;
    }

    /**
     * Método que calcula a média aritmética do aluno somando todas as notas e dividindo o resultado por 4.
     * @param notas um array com todas as notas tiradas pelo aluno.
     * @return a média do aluno.
     */
    private double calculaMedia(double[] notas) {
        double soma = 0;
        for (double ele : notas) {
            soma += ele;
        }
        media = soma / 4;
        return media;
    }

    /**
     * Método que retorna um valor boleano 'true', caso a média seja maior ou igual a sete e, caso contrário, retorna 'false'. 
     * @return se aprovado ou reprovado. 
     */
    public boolean aprovado() {
        if (calculaMedia(notas) >= 7) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que converte em String e concatena todas as informações.
     * @return uma concatenação de Strings.
     */
    public String toString() {
        return nomeDisciplina + " " + horasDeEstudo + " " + calculaMedia(notas) + " " + Arrays.toString(notas);
    }
}
