package br.ufc.quixada.eda.grafo;

public class Grafo {
	private int n; //Qtd. de vértices
	private Aresta arestas[]=null;
	private int m; //Qtd. de arestas

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public Aresta[] getArestas() {
		return arestas;
	}

	public void setArestas(Aresta[] arestas) {
		this.arestas = arestas;
	}

	
}
