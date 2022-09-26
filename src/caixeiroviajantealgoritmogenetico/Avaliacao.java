package caixeiroviajantealgoritmogenetico;


public class Avaliacao {
	
	public boolean checarIndividuo(Individuo individuo, int[][] cidades) {
		int posicaoI = 0, posicaoJ = 0, nVertices = 0, custo = 0;
		int[] genes = new int[individuo.getTamanho()];
		int posicaoInicial = 0;
		boolean valido = false;
		genes = individuo.getGenes();
		posicaoInicial = genes[0];
		
		for(int i = 0; i < individuo.getTamanho()-1; i++) {
			posicaoI = genes[i];
			posicaoJ = genes[i+1];
			if(cidades[posicaoI][posicaoJ] > 0) {
				custo += cidades[posicaoI][posicaoJ];
				nVertices++;
			}if(nVertices == individuo.getTamanho()-1) {
				if(cidades[posicaoJ][posicaoInicial] > 0) {
					custo += cidades[posicaoJ][posicaoInicial];
					valido = true;
					individuo.setCusto(custo);
					break;
				}
				
			}
			
			
		}
		return valido;
	}
	//public ArrayList<Individuos> avaliacaoCusto(Array)
	

}
