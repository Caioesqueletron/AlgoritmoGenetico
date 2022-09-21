package caixeiroviajantealgoritmogenetico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CaixeiroViajanteAlgoritmoGenetico {
	
	public static void main(String[] args) {
			
		 int kIndividuos = 10000;
		 int numeroGenes = 10;
		 int posicaoIndividuo1 = 0, posicaoIndividuo2 = 0,j, individuosSelecionados = 0, nIteracoces = 0;
		 double percentualCruzamento = 0.2;
		 double numeroCruzamento = Math.round(percentualCruzamento * kIndividuos);
		 Random random = new Random();

		 ArrayList<Individuo> populacao = new ArrayList<Individuo>();	
		 
		
		 for(int i = 0; i< kIndividuos; i++) {
			 Individuo individuo = new Individuo(numeroGenes); 
			 individuo.criarIndividuo();
			 populacao.add(individuo);
			 
		 }
		 
		 while(nIteracoces <= 2000) {
			 Cruzamento cruzamento = new Cruzamento(numeroCruzamento);
			 Mutacao mutacao = new Mutacao();
			 Avaliacao avaliacao = new Avaliacao();
			 Selecao selecao = new Selecao();
			 Grafo grafo = new Grafo();
			 ArrayList<Individuo> novaGeracao = new ArrayList<Individuo>();	
			 ArrayList<Individuo> selecaoIndividuo = new ArrayList<Individuo>();
			 Map<Integer, Integer> custo = new HashMap<Integer, Integer>();


			 /*Cruzar individuos */
				for(j = 0; j < numeroCruzamento; j++) {
					posicaoIndividuo1 = random.nextInt(kIndividuos);
					posicaoIndividuo2 = random.nextInt(kIndividuos);
					Individuo individuo1 = populacao.get(posicaoIndividuo1);
					Individuo individuo2 = populacao.get(posicaoIndividuo2);
					novaGeracao.add(cruzamento.fazerCruzamento(individuo1,individuo2,numeroGenes));

				}
				/* mutação dos novos individuos gerados */
				
				for(j = 0; j<novaGeracao.size(); j++) {
					Individuo teste = mutacao.fazerMutacao(novaGeracao.get(j));
					novaGeracao.set(j, teste);
				}
			
				/*Avaliação dos individuos */
				
				int[][] cidades = grafo.lerGrafo();
				
				for(j = 0; j<novaGeracao.size(); j++) {
					if(avaliacao.checarIndividuo(novaGeracao.get(j), cidades)) {
						custo.put(j, novaGeracao.get(j).getCusto());
						//selecaoIndividuo.add(novaGeracao.get(j));
					}
				}
				/*Seleção de Individuos - Elitismo */
				selecaoIndividuo = selecao.selecionaExtermina(novaGeracao, custo, individuosSelecionados);
				 for(int i = 0; i< kIndividuos; i++) {
					 if(i < selecaoIndividuo.size()) {
						 populacao.set(i, selecaoIndividuo.get(i));
					 }else {
						 Individuo individuo = new Individuo(numeroGenes); 
						 individuo.criarIndividuo();
						 populacao.set(i,individuo);
					 }
					 
					 
				 }
				 System.out.println(selecaoIndividuo.get(0).getCusto());
				
				nIteracoces++;
				
		 }
		 
		
		
	 
	}
}
