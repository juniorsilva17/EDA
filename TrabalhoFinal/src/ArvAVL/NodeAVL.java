package ArvAVL;

public class NodeAVL {
	private NodeAVL esquerdo;
	private NodeAVL direito;
	private int altura;
	private int valor;
	
	public NodeAVL(int valor) {
		this.valor = valor;
		this.setAltura(1);
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public NodeAVL getEsquerdo() {
		return esquerdo;
	}
	
	public void setEsquerdo(NodeAVL esquerdo) {
		this.esquerdo = esquerdo;
	}
	
	public NodeAVL getDireito() {
		return direito;
	}
	
	public void setDireito(NodeAVL direito) {
		this.direito = direito;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
}
