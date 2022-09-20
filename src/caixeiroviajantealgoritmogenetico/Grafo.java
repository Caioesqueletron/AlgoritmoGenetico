package caixeiroviajantealgoritmogenetico;

import java.util.ArrayList;


public class Grafo {
	public int[][] lerGrafo(){
		 
        FileManager fileManager = new FileManager();
        ArrayList<String> text = fileManager.stringReader("./data/Teste.txt");
        
         int[][] graph = null;
		 int nVertex = 0;
	        
	        for (int i = 0; i < text.size(); i++) {
	            String line = text.get(i);
	            if (i == 0){
	                nVertex = Integer.parseInt(line.trim());
	                graph = new int[nVertex][nVertex];;
	            }
	            else {
	                int oriVertex = Integer.parseInt(line.split(" ")[0]);
	                String splits[] = line.substring(line.indexOf(" "), line.length()).split(";");
	                for (String part : splits){
	                    String edgeData[] = part.split("-");
	                    int targetVertex = Integer.parseInt(edgeData[0].trim());
	                    int weight = Integer.parseInt(edgeData[1]);
	                    
	                    /*
	                        ADICIONAR A ARESTA À REPRESENTAÇÃO
	                    */
	                    graph[oriVertex][ targetVertex] =  weight;
	                    graph[targetVertex][oriVertex] =  weight;
	                }
	            }
	        }
	        
		return graph;
	}
}
