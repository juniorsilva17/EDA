package br.ufc.quixada.eda.ArvSplay;

public class NoSplay<T> {
	private T dado;
	private NoSplay<T> left;
	private NoSplay<T> right;
	private int chave;
	

	public NoSplay(int chave){
		this.left = null;
		this.right = null;
		this.chave = chave;
	}

	public T getDado() {
		return dado;
	}

	public void setInfo(T dado) {
		this.dado = dado;
	}
	
	public NoSplay<T> getLeft() {
		return left;
	}

	public void setLeft(NoSplay<T> left) {
		this.left = left;
	}

	public NoSplay<T> getRight() {
		return right;
	}

	public void setRight(NoSplay<T> right) {
		this.right = right;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}
}
