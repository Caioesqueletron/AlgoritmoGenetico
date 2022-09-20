package caixeiroviajantealgoritmogenetico;

import java.util.Random;

public class Mutacao {
	
	public Individuo fazerMutacao(Individuo filho) {
		Random random = new Random();
		int particao1, particao2,aux,i,j;
		int[] genes = new int[filho.getTamanho()];
		genes = filho.getGenes();
		aux = 0;
		particao1 = random.nextInt(filho.getTamanho()-1);
		particao2 = filho.getTamanho() - particao1-1;
		i = particao1;
		j = particao2;
		if(i>j) {
			i = particao2;
			j = particao1;
		}
		while(i<=j){
			aux = genes[i];
			genes[i] = genes[j];
			genes[j] = aux;
			i++;
			j--;
		} 
		filho.setGenes(genes);
		return filho;
	}

}
