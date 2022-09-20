package caixeiroviajantealgoritmogenetico;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Selecao {
	
	public ArrayList<Individuo> selecionaExtermina(ArrayList<Individuo> novaGeracao, Map<Integer, Integer>custo, int individuosSelecionados){
		ArrayList<Individuo> selecionaIndividuo = new ArrayList<Individuo>();
		Map<Integer, Integer> custoOrdenado = custo.entrySet()
		        .stream()
		        .sorted(Map.Entry.comparingByValue())
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		

        for (Integer key : custoOrdenado.keySet()) {
        	if(individuosSelecionados <= 200) {
        		selecionaIndividuo.add(novaGeracao.get(key));
        		//novaGeracao.get(key);
        		individuosSelecionados++;
        	}
        }
        
		return selecionaIndividuo;
	}

}
