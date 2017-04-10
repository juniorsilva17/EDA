package br.ufc.quixada.eda.algoritmos;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;

public class ArvoreGeradoraMinima {

	private void quickSort(Aresta[] arestas, int ini, int fim) {
		if (ini < fim) {
			int posicaopivo = particiona(arestas, ini, fim);
			quickSort(arestas, ini, posicaopivo - 1);
			quickSort(arestas, posicaopivo + 1, fim);
		}
	}

	private int particiona(Aresta[] arestas, int p, int r) {
		int pivo = p;
		int ini = p + 1;
		int fim = r;
		while (ini <= fim) {
			if (arestas[ini].getW() <= arestas[pivo].getW())
				ini++;
			else if (arestas[pivo].getW() < arestas[fim].getW())
				fim--;
			else {
				Aresta aux = arestas[ini];
				arestas[ini] = arestas[fim];
				arestas[fim] = aux;
				ini++;
				fim--;
			}
		}
		arestas[p] = arestas[fim];
		arestas[fim] = arestas[pivo];
		return fim;
	}

	public Aresta[] kruskal(Grafo g) {
		Aresta[] solucao = new Aresta[g.getN()-1];
		ConjuntoDisjunto conj = new ConjuntoDisjunto(g.getN());
		for (int i = 1; i <= g.getN(); i++) {
			conj.make_set(i);
		}
		quickSort(g.getArestas(), 0 ,g.getArestas().length -1);
		int i = 0;
		for (int j = 0; j < g.getM(); j++) {
			Aresta e = g.getArestas()[j];
			if (conj.find_set(e.getV()) != conj.find_set(e.getU())) {
				solucao[i] = e;
				i++;
				conj.union(e.getV(), e.getU());
			}
		}
		return solucao;
	}
}
