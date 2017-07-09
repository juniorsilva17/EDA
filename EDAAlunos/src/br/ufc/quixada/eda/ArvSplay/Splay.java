package br.ufc.quixada.eda.ArvSplay;

public class Splay<T> {
private NoSplay<T> raiz = null;
	
	private NoSplay<T> splay(NoSplay<T> raiz, int chave){
		if(raiz == null) return null;
		if(raiz.getChave() == chave) return raiz;
		if(chave < raiz.getChave()){
			if(raiz.getLeft() != null){
				raiz.setLeft(splay(raiz.getLeft(), chave));
				raiz = rotacaosimplesDireita(raiz);
			}
		}else if(chave > raiz.getChave()){
			if(raiz.getRight() != null){
				raiz.setRight(splay(raiz.getRight(), chave));
				raiz = rotacaosimplesEsquerda(raiz);
			}
		}
		return raiz;
	}
	
	public NoSplay<T> busca(int chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz != null && this.raiz.getChave() == chave) return this.raiz;
		return null;
	}
	
	public void inserir(int chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getChave() == chave) return;
		NoSplay<T> aux = new NoSplay<T>(chave);
		aux.setRight(this.raiz);
		aux.setLeft(this.raiz.getLeft());
		this.raiz = aux;
	}
	
	public void remover(int chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getChave() != chave) return;
		NoSplay<T> aux = splay(this.raiz.getLeft(), chave);
		aux.setRight(raiz.getRight());
		raiz = aux;
	}
	
	NoSplay<T> rotacaosimplesDireita(NoSplay<T> no){
		NoSplay<T> aux = no.getLeft();
		no.setLeft(no.getLeft().getRight());
		aux.setRight(no);
		return aux;
	}
	
	NoSplay<T> rotacaosimplesEsquerda(NoSplay<T> no){
		NoSplay<T> aux = no.getRight();
		no.setRight(no.getRight().getLeft());
		aux.setLeft(no);
		return aux;
	}

}
