package br.ufc.quixada.eda.ArvAVL;

public class ArvAvl {
	
	private NoAVL raiz = null;
	
	int altura(NoAVL no) {
		return (no != null ? no.getAltura() : 0);
	}
	
	void inserir(int value) {
		raiz = inserirNO(raiz, value);
	}

	NoAVL inserirNO(NoAVL no, int value) {
		if (no == null) {
			no = new NoAVL(value);
			return no;
		} else if (value < raiz.getValor()) {
			no.setEsquerdo(inserirNO(no.getEsquerdo(), value));
			if ((altura(no.getEsquerdo()) - altura(no.getDireito())) == 2) {
				if (altura(no.getEsquerdo().getDireito()) < altura(no.getEsquerdo().getEsquerdo())) 
				no = rotacaosimplesDireita(no);
				else
				no = rotacaoduplaDireita(no);
			}
		} else if (raiz.getValor() < value) {
			no.setDireito(inserirNO(no.getDireito(), value));
			if ((altura(no.getDireito()) - altura(no.getEsquerdo())) == 2) {
				if (altura(no.getDireito().getEsquerdo()) < altura(no.getDireito().getDireito())) 
					no = rotacaosimplesEsquerda(no);
			    else 
			    	no = rotacaoduplaEsquerda(no);
			}
		}
		no.setAltura((altura(no.getDireito()) < (altura(no.getDireito())) ? altura(no.getDireito()) : (altura(no.getEsquerdo()))) + 1);
		return no;
	}

	NoAVL rotacaosimplesEsquerda(NoAVL no) {
		NoAVL aux = no.getDireito();
		aux.setEsquerdo(no);
		no.setDireito(no.getDireito().getEsquerdo());
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
	
	NoAVL rotacaosimplesDireita(NoAVL no) {
		NoAVL aux = no.getEsquerdo();
		no.setEsquerdo(no.getEsquerdo().getDireito());
		aux.setDireito(no);
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
NoAVL rotacaoduplaEsquerda(NoAVL no) {
		no.setDireito(rotacaosimplesDireita(no));
		no = rotacaosimplesEsquerda(no);
		return no;
	}

	NoAVL rotacaoduplaDireita(NoAVL no) {
		no.setEsquerdo(rotacaosimplesEsquerda(no));
		no = rotacaosimplesDireita(no);
		return no;
	}


	boolean buscaNO(NoAVL no, int value) {
		if (no == null)
			return false;
		return (buscaNO(no.getEsquerdo(), value) ||  (no.getValor() == value) || buscaNO(no.getDireito(), value));
	}

	void mostrar() {
		mostrarNO(raiz);
	}
	
	void mostrarNO(NoAVL no) {
		if (no == null) {
			System.out.print(" # ");
			return;
		}
		System.out.print(no.getValor() + " ");
		mostrarNO(no.getEsquerdo());
		mostrarNO(no.getDireito());
	}
	
}
