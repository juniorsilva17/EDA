package br.ufc.quixada.eda.grafo;

import java.util.ArrayList;

public class Grafo {
	private int n; //Qtd. de vértices
	ArrayList<Aresta> arestas;
	ArrayList<Integer> vertices;
	
	public Grafo(int n, ArrayList<Aresta> arestas, ArrayList<Integer> vertices) {
		super();
		this.n = n;
		this.arestas = arestas;
		this.vertices = vertices;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}

	public ArrayList<Integer> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Integer> vertices) {
		this.vertices = vertices;
	}

	int addVertice(int value) {
		int v = value;
		vertices.add(v);
		return v;
	}
	
	Aresta addAresta(int v, int u, int peso) {
		Aresta e = new Aresta(v, u, peso);
		arestas.add(e);
		return e;
	}

}
