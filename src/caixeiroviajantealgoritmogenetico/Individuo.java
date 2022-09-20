package caixeiroviajantealgoritmogenetico;

import java.util.ArrayList;
import java.util.Random;

public class Individuo {
	private int tamanho;
	private int custo;
	private int[] genes;
	
	public Individuo(int tamanho) {
		this.tamanho = tamanho;
		this.custo = Integer.MAX_VALUE;
		this.genes = new int[this.getTamanho()];
		for(int i = 0; i < tamanho; i++) {
			this.genes[i] = -1;
		}
	}
	
	public void criarIndividuo() {
		Random gerador = new Random();
		int posicao = 0;
		for(int i = 0; i<this.getTamanho(); i++) {
			
			do {
				
				posicao = gerador.nextInt(this.getTamanho());
				if(this.genes[posicao] == -1) {
				 this.genes[posicao] = i;
				 break;
				}

			}while(this.genes[posicao] != -1);
		}
	}
	
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int[] getGenes() {
		return genes;
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
	}
	
	public void imprimiGenes(){
		ArrayList<Integer> genes = new ArrayList<Integer>();
		for(int i = 0; i<this.tamanho;i++) {
			genes.add(this.genes[i]);
		}
		
		System.out.println(genes);
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}
		

}
