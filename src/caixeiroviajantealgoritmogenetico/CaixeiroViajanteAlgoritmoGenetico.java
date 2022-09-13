package caixeiroviajantealgoritmogenetico;

import java.util.ArrayList;

public class CaixeiroViajanteAlgoritmoGenetico {
	
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		ArrayList<String> text = fileManager.stringReader("./data/Teste.txt");

		int nVertex = 0;
		int graph[][] = null;
		int i;

		for (i = 0; i < text.size(); i++) {
			String line = text.get(i);
			if (i == 0) {
				nVertex = Integer.parseInt(line.trim());
				graph = new int[nVertex][nVertex];
			} else {
				int oriVertex = Integer.parseInt(line.split(" ")[0]);
				String splits[] = line.substring(line.indexOf(" "), line.length()).split(";");
				for (String part : splits) {
					String edgeData[] = part.split("-");
					int targetVertex = Integer.parseInt(edgeData[0].trim());
					int weight = Integer.parseInt(edgeData[1]);

					graph[oriVertex][targetVertex] = weight;
					graph[targetVertex][oriVertex] = weight;
				}

			}

		}

		
		  
		  for (i = 0; i < nVertex; i++) { for (int j = 0; j < nVertex; j++) {
		 System.out.print(" " + graph[i][j] + " "); } System.out.println(); }
		  
		  
	}
	
	public int[] geraIndividuo(int tamanho, int numeroIndividuos){
		int[] genes = new int[tamanho];
		
		for(int i = 0; i < tamanho;i++) {
			
		}
		
		
		return genes;
		
	}
	
	
	 

}
