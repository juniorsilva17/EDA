package ArvSplay;

public class Splay<T extends Comparable<T>, Info> {
private NoSplay<T, Info> raiz = null;
	
	private NoSplay<T, Info> splay(NoSplay<T, Info> raiz, T dado){
		if(raiz == null) return null;
		int cmp = dado.compareTo(raiz.getDado());
		if(cmp == 0) return raiz;
		else if(cmp == 1){
			if(raiz.getLeft() != null){
				raiz.setLeft(splay(raiz.getLeft(), dado));
				raiz = rotacaosimplesDireita(raiz);
			}
			return raiz;
		}else{
			if(raiz.getRight() != null){
				raiz.setRight(splay(raiz.getRight(), dado));
				raiz = rotacaosimplesEsquerda(raiz);
			}
			return raiz;
		}
	}
	
	public NoSplay<T, Info> busca(T chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz != null && this.raiz.getDado() == chave) return this.raiz;
		return null;
	}

	public void inserir(T chave){
		raiz = splay(raiz, chave);
		if(raiz != null && chave.compareTo(raiz.getDado()) == 0) return;
		if(raiz == null){
			raiz = new NoSplay<T, Info>(chave);
		}else{
			int cmp = chave.compareTo(raiz.getDado());
			if(cmp > 0){
				NoSplay<T, Info> aux = new NoSplay<T, Info>(chave);
				aux.setRight(raiz);
				aux.getRight().setLeft(null);
				aux.setLeft(raiz.getLeft());
				raiz = aux;
			}else{
				NoSplay<T, Info> aux = new NoSplay<T, Info>(chave);
				aux.setLeft(raiz);
				aux.getLeft().setRight(null);
				aux.setRight(raiz.getRight());
				raiz = aux;
			}
		}
	}
	/*
	NoSplay<T, Info> insert_recursivo(NoSplay<T, Info> no, T chave){
		if(no == null)
			return new NoSplay<T, Info>(chave);
		int cmp = chave.compareTo(no.getDado());
		if(cmp == 1){
			no.setRight(insert_recursivo(no.getRight(), chave));
		}else if(cmp == -1){
			no.setLeft(insert_recursivo(no.getLeft(), chave));
		}
		return no;
	}
	*/
	
	public void remover(T chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getDado() != chave) return;
		NoSplay<T, Info> aux = splay(this.raiz.getLeft(), chave);
		if(raiz.getRight() != null && aux != null) aux.setRight(raiz.getRight());
		raiz = aux;
	}
	
	NoSplay<T, Info> rotacaosimplesDireita(NoSplay<T, Info> no){
		NoSplay<T, Info> aux = no.getLeft();
		no.setLeft(no.getLeft().getRight());
		aux.setRight(no);
		return aux;
	}
	
	NoSplay<T, Info> rotacaosimplesEsquerda(NoSplay<T, Info> no){
		NoSplay<T, Info> aux = no.getRight();
		no.setRight(no.getRight().getLeft());
		aux.setLeft(no);
		return aux;
}

}
