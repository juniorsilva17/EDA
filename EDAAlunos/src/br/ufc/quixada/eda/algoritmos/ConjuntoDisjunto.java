package br.ufc.quixada.eda.algoritmos;

public class ConjuntoDisjunto {
	private int pai[]=null;
	private int ordem[]=null;
	private int n = 0;

	public ConjuntoDisjunto(int n){
		this.n = n;
		pai = new int[n];
		ordem = new int[n];
	}
	
	public void make_set(int i){
		pai[i] = i;
		ordem[i] = 0;
	}
	public void make_set_all(){
		for (int i = 0 ; i<n ; i++) {
			make_set(i);
		}
	}
	/*
	public int find_set(int v){
	if(v==pai[v]) return v;
	else return find_set(pai[v]);
	}
	*/
	public int find_set(int v){
		if(v==pai[v]) return v;
		else{
			int paiv = find_set(pai[v]);
			pai[v]=paiv;
			return paiv;
		}
	}
	/*
	public void link_set(int v,int u){
		pai[v]=u;
	}*/
	public void link_set(int v, int u){
		if(ordem[v] < ordem[u]) pai[v]=u;
		else{
			pai[u] = v;
			if(ordem[u]==ordem[v]) ordem[v]++;
		}
	}
	public void union(int v, int u){
		link_set(find_set(v), find_set(u));
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[] getPai() {
		return pai;
	}

	public void setPai(int[] pai) {
		this.pai = pai;
	}
	
	
}