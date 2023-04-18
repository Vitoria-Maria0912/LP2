package lab2;

/**
* Classe que avalia se o aluno dedicou o tempo de estudo online necessário, que é o dobro do tempo da disciplina. 
*
* @author Vitória Maria do Nascimento
*/
public class RegistroTempoOnline {

    /**
     * Atributo referente ao nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Atributo referente ao tempo online esperado.
     */
    private int tempoOnlineEsperado;

    /**
     * Atributo referente ao tempo gasto.
     */
    private int tempoGasto;

    /**
     * Constrói um objeto disciplina que recebe uma String, referente ao nome da disciplina e define como padrão 120 horas de tempo online esperado.
     * @param nomeDisciplina é nome da disciplina.
     */
    public RegistroTempoOnline (String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * Constrói um objeto disciplina que recebe uma String, referente ao nome da disciplina e um inteiro referente ao tempo online esperado.
     * @param nomeDisciplina é nome da disciplina.
     * @param tempoOnlineEsperado é o tempo de estudo online esperado.
    */
    public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Método, cumulativo, que recebe um inteiro, referente ao tempo gasto e soma ao tempo anterior.
     * @param tempoGasto é o tempo estudado.
     */
    public void adicionaTempoOnline(int tempoGasto) {
        this.tempoGasto += tempoGasto;
    }

    /**
     * Método que avalia se o tempo gasto foi, pelo menos, o dobro do esperado.
     * @param tempoEsperado é o tempo online esperado.
     * @param tempoGasto é o tempo online gasto.
     */
    private boolean calculaTempoDedicado (int tempoEsperado, int tempoGasto) {
        if (tempoGasto != 0) {
            if (tempoGasto >= tempoOnlineEsperado) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Método que avalia se a meta foi atingida, se o tempo dedicado foi equivalente ou superior ao esperado, ou não.
     * @return se a meta foi atingida.
     */
    public boolean atingiuMetaTempoOnline() {
        return calculaTempoDedicado(tempoOnlineEsperado, tempoGasto);
    }

    /**
     * Método que converte os dados em String e concatena todas as informações.
     * @return a concatenação de todas as informações
    */
    public String toString() {
        return this.nomeDisciplina + " " + tempoGasto + "/" + this.tempoOnlineEsperado;
    }
}
