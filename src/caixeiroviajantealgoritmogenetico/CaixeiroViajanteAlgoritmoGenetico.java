package caixeiroviajantealgoritmogenetico;

import java.util.ArrayList;
import java.util.Random;

public class CaixeiroViajanteAlgoritmoGenetico {
	
	public static void main(String[] args) {
			
		 int kIndividuos = 10000;
		 int numeroGenes = 100;
		 int posicaoIndividuo1 = 0, posicaoIndividuo2 = 0;
		 double percentualCruzamento = 0.2;
		 double numeroCruzamento = Math.round(percentualCruzamento * kIndividuos);
		 Random random = new Random();

		 ArrayList<Individuo> populacao = new ArrayList<Individuo>();	
		 ArrayList<Individuo> novaGeracao = new ArrayList<Individuo>();	

		 Cruzamento cruzamento = new Cruzamento(numeroCruzamento);
		 for(int i = 0; i< kIndividuos; i++) {
			 Individuo individuo = new Individuo(numeroGenes); 
			 individuo.criarIndividuo();
			 populacao.add(individuo);
			 
		 }
		 
		 /*Cruzar individuos */
		for(int j = 0; j < numeroCruzamento; j++) {
			posicaoIndividuo1 = random.nextInt(kIndividuos);
			posicaoIndividuo2 = random.nextInt(kIndividuos);
			Individuo individuo1 = populacao.get(posicaoIndividuo1);
			Individuo individuo2 = populacao.get(posicaoIndividuo2);
		    //individuo1.imprimiGenes();
		    //individuo2.imprimiGenes();
		    novaGeracao.add(cruzamento.fazerCruzamento(individuo1,individuo2,numeroGenes));

		}
		
		
		
		
		 
		  
	}
	 

}
