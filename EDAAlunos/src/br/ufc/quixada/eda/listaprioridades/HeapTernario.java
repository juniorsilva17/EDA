package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando Heap Ternario.
 * @author fabio
 *
 */
public class HeapTernario {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapTernario(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){	
		int j = (i+1)/3;
		if(j >= 1){
			if(vetor[i] > vetor[j]){
				int aux = this.vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				subir(j);
			}
		}	     
	}

	private void descer(int i){	
		int j = 3*i-1;
		if(j <= n){
			int aux = 0;
			if(vetor[j+2] <= n){
				if(vetor[j+1] < vetor[j+2])
					aux = j+2;
				else
					aux = j+1;
			}
			if(vetor[aux] < vetor[j]){
				if(vetor[i] < vetor[j]){
					int aux2 = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux2;
					descer(j);
				}
			}else if(vetor[i] < vetor[aux]){
				int aux2 = vetor[i];
				vetor[i] = vetor[aux];
				vetor[aux] = aux2;
				descer(aux);
			}
		}else{
			if(j+1 <= n && vetor[j] < vetor[j+1]){
				j = j+1;
				if(vetor[i] < vetor[j]){
					int aux2 = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux2;
					descer(j);
				}
			}
		}
	}

	public void contruir(List<Integer> entrada){
		for (int i = 1; i <= entrada.size(); i++) {
			vetor[i] = entrada.get(i-1);
			n++;
		}
		for(int j=(n/3)+1;j>1;j--){
			descer(j);
		}
		/*
		n = entrada.size();
		for (int i = (n/3)+1; i >= 0; i--){
			descer(i);
		}*/
	}

	public int getMaximaPrioridade(){
		return vetor[1];
	}

	public int remove(){
		if(n >= 1){
			int aux = vetor[1];
			vetor[1] = vetor[n];
			vetor[n] = aux;
			n--;
			descer(1);
			return aux;
		}
		return 0;
	}

	public void inserir(int prioridade){
		if(n <= nMaximo){
			n++;
			vetor[n] = prioridade;
			subir(n);
		}
	}

	public void alterarPrioridade(int prioridade, int novaPrioridade){
		for(int i = 1; i <= n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				if(prioridade > novaPrioridade) 
					descer(i);
				else 
					subir(i);
				break;
			}
		}
	}	
}