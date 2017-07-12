package ArvAVL;

public class NodeAVL <T, Info> {
	private NodeAVL<T, Info> esquerdo;
	private NodeAVL<T, Info> direito;
	private int altura;
	private T valor;
	private Info infor;
	
	public NodeAVL(T valor) {
		this.valor = valor;
		this.setAltura(1);
	}
	
	public T getValor() {
		return valor;
	}
	
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public NodeAVL<T, Info> getEsquerdo() {
		return esquerdo;
	}
	
	public void setEsquerdo(NodeAVL<T, Info> esquerdo) {
		this.esquerdo = esquerdo;
	}
	
	public NodeAVL<T, Info> getDireito() {
		return direito;
	}
	
	public void setDireito(NodeAVL<T, Info> direito) {
		this.direito = direito;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Info getInfor() {
		return infor;
	}

	public void setInfor(Info infor) {
		this.infor = infor;
	}
}
