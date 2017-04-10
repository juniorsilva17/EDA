package br.ufc.quixada.eda.algoritmos;

public class ConjuntoDisjunto {
	private int pai[]=null;
	private int ordem[]=null;
	private int n = 0;

	public ConjuntoDisjunto(int n){
		this.n = n;
		pai = new int[n+1];
		ordem = new int[n+1];
	}
	
	public void make_set(int i){
		pai[i] = i;
		ordem[i] = 0;
	}
	public void make_set_all(){
		for (int i = 1 ; i<=n ; i++) {
			make_set(i);
		}
	}
	
	public int find_set(int v){
		if(v==pai[v]) return v;
		else return find_set(pai[v]);
	}
	
	public int find_set2(int v){
		if(v==pai[v]) return v;
		
		pai[v] = find_set(pai[v]);
		return pai[v];
	}
	
	public void link_set(int v,int u){
		pai[v]=u;
	}
	public void link_set2(int v, int u){
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
