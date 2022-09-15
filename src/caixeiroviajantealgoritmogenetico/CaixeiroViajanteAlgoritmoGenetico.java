package caixeiroviajantealgoritmogenetico;

import java.util.ArrayList;

public class CaixeiroViajanteAlgoritmoGenetico {
	
	public static void main(String[] args) {
			
		 int kIndividuos = 10000;
		 ArrayList<Individuo> populacao = new ArrayList<Individuo>();
		 for(int i = 0; i< kIndividuos; i++) {
			 Individuo individuo = new Individuo(100); 
			 individuo.criarIndividuo();
			 individuo.imprimiGenes();
			 populacao.add(individuo);
			 
		 }
		 
		// System.out.println(populacao);
		
		 
		  
	}
	 

}
