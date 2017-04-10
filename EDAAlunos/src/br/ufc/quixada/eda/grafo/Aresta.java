package br.ufc.quixada.eda.grafo;

public class Aresta {

	private int u; //vértice1
	private int v; //vértice2
	private int w; //peso

	public Aresta(int u, int v, int w) {
		this.setV(v);
		this.setU(u);
		this.setW(w);
	}
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
}