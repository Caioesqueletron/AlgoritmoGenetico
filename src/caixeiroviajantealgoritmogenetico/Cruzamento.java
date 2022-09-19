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
		int tamanho = gerador.nextInt(numeroGenes), i = 0;
		int[] genes = new int[numeroGenes];
		int[] genesIndividuo1 = individuo1.getGenes();
		int[] genesIndividuo2 = individuo2.getGenes();
		boolean[] jaExiste = new boolean[numeroGenes];
		Individuo filho = new Individuo(numeroGenes);

		for (i = 0; i < numeroGenes; i++) {
			if (i >= tamanho) {
				if (!jaExiste[genesIndividuo2[i]]) {
					genes[i] = genesIndividuo2[i];
					jaExiste[genesIndividuo2[i]] = true;
				}else {
					genes[i] = genesIndividuo1[i];
					jaExiste[genesIndividuo1[i]] = true;
				}

			}else {
				genes[i] = genesIndividuo1[i];
				jaExiste[genesIndividuo1[i]] = true;
			}
			
		}

		filho.setGenes(genes);

		return filho;
	}

}
