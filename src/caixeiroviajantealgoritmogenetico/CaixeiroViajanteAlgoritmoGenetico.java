package caixeiroviajantealgoritmogenetico;

import java.util.ArrayList;
import java.util.Random;

public class CaixeiroViajanteAlgoritmoGenetico {
	
	public static void main(String[] args) {
			
		 int kIndividuos = 1000;
		 int numeroGenes = 5;
		 int posicaoIndividuo1 = 0, posicaoIndividuo2 = 0,j;
		 double percentualCruzamento = 0.2;
		 double numeroCruzamento = Math.round(percentualCruzamento * kIndividuos);
		 Random random = new Random();

		 ArrayList<Individuo> populacao = new ArrayList<Individuo>();	
		 ArrayList<Individuo> novaGeracao = new ArrayList<Individuo>();	

		 Cruzamento cruzamento = new Cruzamento(numeroCruzamento);
		 Mutacao mutacao = new Mutacao();
		 Avaliacao avaliacao = new Avaliacao();
		 Grafo grafo = new Grafo();
		 for(int i = 0; i< kIndividuos; i++) {
			 Individuo individuo = new Individuo(numeroGenes); 
			 individuo.criarIndividuo();
			 populacao.add(individuo);
			 
		 }
		 
		 /*Cruzar individuos */
		for(j = 0; j < numeroCruzamento; j++) {
			posicaoIndividuo1 = random.nextInt(kIndividuos);
			posicaoIndividuo2 = random.nextInt(kIndividuos);
			Individuo individuo1 = populacao.get(posicaoIndividuo1);
			Individuo individuo2 = populacao.get(posicaoIndividuo2);
		   // individuo1.imprimiGenes();
		    //individuo2.imprimiGenes();
		    novaGeracao.add(cruzamento.fazerCruzamento(individuo1,individuo2,numeroGenes));

		}
		System.out.println(novaGeracao.size());
		/* mutação dos novos individuos gerados */
		
		for(j = 0; j<novaGeracao.size(); j++) {
			//novaGeracao.get(j).imprimiGenes();
			Individuo teste = mutacao.fazerMutacao(novaGeracao.get(j));
			novaGeracao.set(j, teste);
			//novaGeracao.get(j).imprimiGenes();
		}
	
		/*Avaliação dos individuos */
		
		int[][] cidades = grafo.lerGrafo();
		boolean teste;
		
		for(j = 0; j<novaGeracao.size(); j++) {
			teste = avaliacao.checarIndividuo(novaGeracao.get(j), cidades);
			System.out.println(teste);
		}
		
	 
	}
}
