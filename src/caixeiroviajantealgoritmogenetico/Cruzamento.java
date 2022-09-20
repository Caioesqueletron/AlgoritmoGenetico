package caixeiroviajantealgoritmogenetico;

import java.util.Random;

public class Cruzamento {
	private double numeroCruzamento;

	public Cruzamento(double numeroCruzamento2) {
		this.numeroCruzamento = numeroCruzamento2;
	}

	public double getTaxaCruzamento() {
		return numeroCruzamento;
	}

	public void setTaxaCruzamento(int numeroCruzamento) {
		this.numeroCruzamento = numeroCruzamento;
	}

	public Individuo fazerCruzamento(Individuo individuo1, Individuo individuo2, int numeroGenes) {
		Random gerador = new Random();
		int tamanho = gerador.nextInt(numeroGenes), i = 0, k = 0, contador = 0, gene = 0;
		int[] genes = new int[numeroGenes];
		int[] genesIndividuo1 = individuo1.getGenes();
		int[] genesIndividuo2 = individuo2.getGenes();
		boolean[] jaExiste = new boolean[numeroGenes];
		for (k = 0; k < numeroGenes; k++) {
			jaExiste[i] = false;
		}
		Individuo filho = new Individuo(numeroGenes);
		while (contador != numeroGenes) {
			if (i >= tamanho) {
				if (!jaExiste[genesIndividuo2[i]]) {
					genes[i] = genesIndividuo2[i];
					jaExiste[genesIndividuo2[i]] = true;
					contador++;
					i++;
				} else {
					gene = verificaAlguemDisponível(jaExiste, numeroGenes);
					genes[i] = gene;
					jaExiste[gene] = true;
					contador++;
					i++;
				}

			} else {
				if (!jaExiste[genesIndividuo1[i]]) {
					genes[i] = genesIndividuo1[i];
					jaExiste[genesIndividuo1[i]] = true;
					contador++;
					i++;
				} else {
					gene = verificaAlguemDisponível(jaExiste, numeroGenes);
					genes[i] = gene;
					jaExiste[gene] = true;
					contador++;
					i++;
				}

			}
		}
		
		filho.setGenes(genes);

		return filho;
	}

	public int verificaAlguemDisponível(boolean[] jaExiste, int numeroGenes) {
		int gene = 0;
		for (int i = 0; i < numeroGenes; i++) {
			if (jaExiste[i]) {
				continue;
			} else {
				gene = i;
				break;
			}
		}
		return gene;
	}

}
