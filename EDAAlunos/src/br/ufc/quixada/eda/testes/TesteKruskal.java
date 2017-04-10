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
					ArvoreGeradoraMinima grafo = new ArvoreGeradoraMinima();
					System.out.println(tempoInicial + "\n");
					System.out.println("\n" + "tb8ch" + tamanho + "_" + i + ":\n");
					
					Aresta solucao[] = grafo.kruskal(entrada);
					
					double custo = 0;
					for (Aresta aresta : solucao) {
						custo += aresta.getW();
					}
					
					System.out.println("Custo: " + custo);
					
					long tempo = System.currentTimeMillis() - tempoInicial;			  
					System.out.println(tempo + "\n");
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
