package documin;

import java.util.Arrays;
import java.util.Collections;

/**
 * Ordena termos.
 * 
 * @author Vitória Maria Do Nascimento
 *
 */
public class Ordem {
	
	 /**
     * é o tipo de ordenação.
     */
    private String ordem;

    /**
     * Constrói uma ordem.
     */
    public Ordem(String ordem) {
    	this.ordem = ordem;
    }

    /**
     * Recebe termos e ordena-os conforme desejado.
     * 
     * @param ordem é o tipo de ordenação.
     * @param valor são os termos a serem ordenados.
     * @return o valor na ordem desejada.
     */
    public String ordenaElementos(String[] valor, String separador) {
    	
    	switch(this.ordem.toUpperCase()) {
    	
    	case "NENHUM":
    		return nenhumaOrdenacao(valor, separador);
       	case "ALFABÉTICA":
       		return ordenacaoAlfabetica(valor, separador);
       	case "TAMANHO":
       		return ordenacaoPorTamanho(valor, separador);
       	default: 
       		return "ORDENAÇÃO INEXISTENTE!";
    	}
    }
    
    /**
     * Apenas retorna o valor.
     * 
     * @param valor são os termos a serem ordenados.
     * @param separador é o caractere que separa cada termo.
     * @return o valor sem ser alterado.
     */
    private String nenhumaOrdenacao(String[] valor, String separador) {
    	String valor2 = "";
    	for(int i = 0; i < valor.length; i++) {
    		if(i != valor.length - 1) {
    			valor2 += valor[i] + separador;
    		} else {
    			valor2 += valor[i];
    		}
    	}
		return valor2;
    }
    
    /**
     * Organiza os termos em ordem alfabética.
     * 
     * @param valor são os termos a serem ordenados.
     * @param separador é o caractere que separa cada termo.
     * @return os termos em ordem alfabética.
     */
    private String ordenacaoAlfabetica(String[] valor, String separador) {
    	Arrays.sort(valor, String.CASE_INSENSITIVE_ORDER);
    	String valor2 = "";
    	for(int i = 0; i < valor.length; i++) {
    		if(i != valor.length - 1) {
    			valor2 += valor[i] + separador;
    		} else {
    			valor2 += valor[i];
    		}
    	}
		return valor2;
    }
    
    /**
     * Organiza os termos por tamanho, do maior para o menor.
     * 
     * @param valor são os termos a serem ordenados.
     * @param separador é o caractere que separa cada termo.
     * @return os termos em ordem decrescente.
     */
    private String ordenacaoPorTamanho(String[] valor, String separador) {
    	String valor2 = "";
    	for(int i = 0; i < valor.length - 1; i++) {
    	    if(valor[i].length() > valor[i + 1].length()) {
    		    Collections.swap(Arrays.asList(valor), i, i + 1);
    		}
    	}
    	for(int i = valor.length - 1; i > - 1; i--) {
    		if(i > 0) {
    			valor2 += valor[i] + separador;
    		} else {
    			valor2 += valor[i];
    		}
    	}
		return valor2;
    }
}
