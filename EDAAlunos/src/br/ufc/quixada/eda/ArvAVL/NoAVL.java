package br.ufc.quixada.eda.ArvAVL;

public class NoAVL {
	private NoAVL esquerdo;
	private NoAVL direito;
	private int altura;
	private int valor;
	
	public NoAVL(int valor) {
		this.valor = valor;
		this.setAltura(1);
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public NoAVL getEsquerdo() {
		return esquerdo;
	}
	
	public void setEsquerdo(NoAVL esquerdo) {
		this.esquerdo = esquerdo;
	}
	
	public NoAVL getDireito() {
		return direito;
	}
	
	public void setDireito(NoAVL direito) {
		this.direito = direito;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
}
