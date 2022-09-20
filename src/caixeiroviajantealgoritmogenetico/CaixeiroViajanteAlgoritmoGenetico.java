package caixeiroviajantealgoritmogenetico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class CaixeiroViajanteAlgoritmoGenetico {
	
	public static void main(String[] args) {
			
		 int kIndividuos = 1000;
		 int numeroGenes = 5;
		 int posicaoIndividuo1 = 0, posicaoIndividuo2 = 0,j, individuosSelecionados = 0;
		 double percentualCruzamento = 0.2;
		 double numeroCruzamento = Math.round(percentualCruzamento * kIndividuos);
		 Random random = new Random();

		 ArrayList<Individuo> populacao = new ArrayList<Individuo>();	
		 ArrayList<Individuo> novaGeracao = new ArrayList<Individuo>();	
		 ArrayList<Individuo> selecaoIndividuo = new ArrayList<Individuo>();
		 Map<Integer, Integer> custo = new HashMap<Integer, Integer>();


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
		
		Map<Integer, Integer> custoOrdenado = custo.entrySet()
		        .stream()
		        .sorted(Map.Entry.comparingByValue())
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		

        for (Integer key : custoOrdenado.keySet()) {
        	if(individuosSelecionados <= 200) {
        		selecaoIndividuo.add(novaGeracao.get(key));
        		//novaGeracao.get(key);
        		individuosSelecionados++;
        	}
        }
        

	 
	}
}
