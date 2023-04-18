package lab2;

/**
* Classe que avalia o descanso semanal mostrando se a pessoa está cansada, caso o descanso semanal seja inferior a 26 horas,
* ou descansada, caso contrário. Não inclui as horas de sono, mas de atividades de lazer em geral. 
* 
* @author Vitória Maria do Nascimento
*/
public class Descanso {

	/**
	 * Referente as horas de descanso.
	 */
	private int horasDeDescanso;

	/**
	 * Referente as horas de descanso semanal.
	 */
	private int descansoSemanal;

	/**
	 * Referente ao status de descanso.
	 */
	private String statusGeral = "cansado";

	/**
	 * Define a quantidade de horas de descanso.
	 * @param horas são as de descanso.
	 */
	public void defineHorasDescanso(int horas) {
		this.horasDeDescanso = horas;
	}

	/**
	 * Define a quantidade de semanas .
	 * @param semanas são semanas de descanso.
	 */

	public void defineNumeroSemanas(int semanas) {
		this.descansoSemanal = calculaDescansoSemanal(this.horasDeDescanso, semanas);
	}

	/**
	 * Método que calcula o descanso semanal, por meio da divisão da quantidade de horas pela quantidade de semanas 
	 * e atualiza o status geral para descansado se o descanso semanal for equivalente ou maior que 26 horas.
	 * @param horas são as horas descansadas
	 * @param semanas são as semanas de descanso
	 * @return o cálculo da divisão, referente ao descaso semanal.
	 */

	private int calculaDescansoSemanal(int horas, int semanas) {
		if (semanas != 0) {
			descansoSemanal = horas / semanas;
			if (descansoSemanal >= 26) {
				this.statusGeral = "descansado";
			} else {
				this.statusGeral = "cansado";
			}
		} 
		return descansoSemanal;		
	}

	/**
	 * Método que retorna o atual status de descanso.
	 * @return o statusGeral
	 */
	public String getStatusGeral() {
		return this.statusGeral;
	}
}
