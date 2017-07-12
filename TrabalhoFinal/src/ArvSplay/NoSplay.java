package ArvSplay;

public class NoSplay<T, Info> {
	private NoSplay<T, Info> left;
	private NoSplay<T, Info> right;
	private Info info;
	private T dado;

	public NoSplay(T dado){
		this.left = null;
		this.right = null;
		this.dado = dado;
	}

	public T getDado() {
		return dado;
	}


	public void setDado(T dado) {
		this.dado = dado;
	}


	public NoSplay<T, Info> getLeft() {
		return left;
	}


	public void setLeft(NoSplay<T, Info> left) {
		this.left = left;
	}


	public NoSplay<T, Info> getRight() {
		return right;
	}


	public void setRight(NoSplay<T, Info> right) {
		this.right = right;
	}


	public Info getInfo() {
		return info;
	}


	public void setInfo(Info info) {
		this.info = info;
	}
	
	

}
