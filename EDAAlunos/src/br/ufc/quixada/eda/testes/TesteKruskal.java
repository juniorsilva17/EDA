package br.ufc.quixada.eda.testes;

import java.io.IOException;

import br.ufc.quixada.eda.algoritmos.ArvoreGeradoraMinima;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;


public class TesteKruskal {

	public static void main(String[] args) {
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias2) {
				for (int i = 0; i < 4; i++) {
					String path = EDAConstants.caminhoPasta2 + "tb8ch" + tamanho + "_" + i + ".txt";
					
					Grafo entrada = EDAUtil.lerGrafo(path);
					
					long tempoInicial = System.currentTimeMillis();
					ArvoreGeradoraMinima grafo = new ArvoreGeradoraMinima(tamanho);
					System.out.println(tempoInicial + "\n");
					int caminho = 0;
					System.out.println("\n" + "tb8ch" + tamanho + "_" + i + ":\n");
					int h = 0;
					for (Aresta e : grafo.kruskal(entrada)) {
						System.out.println(h + "\n");
						h++;
						caminho += e.getW();
					}
					System.out.println("Custo: " + caminho);
					
					long tempo = System.currentTimeMillis() - tempoInicial;			  
					System.out.println(tempo + "\n");
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
