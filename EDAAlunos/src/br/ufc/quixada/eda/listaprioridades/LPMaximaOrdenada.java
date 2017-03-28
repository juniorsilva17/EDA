package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui você devem utilizar obrigatóriamente o quickSort 
 * para realizar a ordenação, quando for necessário.
 * @author fabio
 *
 */
public class LPMaximaOrdenada {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public LPMaximaOrdenada(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
		for (int i = 0; i < entrada.size(); i++) {
			vetor[i] = entrada.get(i);
		}
		n = entrada.size();
		quickSort(0, n-1);
	}
	
	public int getMaximaPrioridade(){
		if(n>0){
		return vetor[n-1];
		}
		return -1;
	}
	
	public int remove(){
		if(n>0){
			/*int aux=vetor[n-1];
			n--;
			return aux;
		*/return vetor[--n];
		}
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(n+1<=nMaximo){
			int i=n-1;
			while(vetor[i]>prioridade && i>=0){
				vetor[i+1]=vetor[i];
			    i--;
			}
			vetor[i+1]=prioridade;
			n++;
		}
		//Acrescentando no final e ordenando novamente(Maior complexidade)
		/*if(n + 1 < nMaximo){			
			vetor[n] = prioridade;
			n++;
		}
		quickSort(vetor[0], vetor[n-1]);*/
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		if(n>0){
			int i = 0;
			while(true){
				if(vetor[i]==prioridade) 
					break; 
				i++;
			}
		}
	}
	
	private void quickSort(int ini, int fim){
	if(ini < fim){
		int posicaopivo = particiona(ini,fim);
		quickSort(ini, posicaopivo - 1);
		quickSort(posicaopivo + 1, fim);
	}
	}
	
	private int particiona(int p, int r){		
		int pivo = vetor[p];
		int ini = p + 1;
		int fim = r;
		while(ini<=fim){
			if(vetor[ini]<=pivo) ini++;
			else if(pivo<vetor[fim]) fim--;
			else{
				int aux = vetor[ini];
				vetor[ini] = vetor[fim];
				vetor[fim] = aux;
				ini++;
				fim--;
			}
		}
		vetor[p]=vetor[fim];
		vetor[fim] = pivo;
		return fim;
	}
}