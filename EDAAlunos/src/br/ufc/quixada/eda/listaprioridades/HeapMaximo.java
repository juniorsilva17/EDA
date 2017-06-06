package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */
public class HeapMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){
		int j = i/2;
		if(j>=1){
		 if(vetor[j]<vetor[i]){
		  int aux=vetor[j];
		  vetor[j]=vetor[i];
		  vetor[i]=aux;
		  subir(j);
		  }   
		 }
	}
	private void subir_int(int i){
		int j = i/2;
		while(j >= 1){
			if(vetor[j]<vetor[i]){
				int aux=vetor[j];
				vetor[j]=vetor[i];
				vetor[i]=aux;
				i=j;
				j = j/2;
				}
			else{
				break;
			}
		}
	}
	
	private void descer_int(int i){
		int j = 2*i;
		while(j <= n){
			if(j+1<=n && vetor[j+1]>vetor[j]) j++;
			if(vetor[j]>vetor[i]){
				 int aux=vetor[j];
				 vetor[j]=vetor[i];
				 vetor[i]=aux;
				 i=j;
				 j = j*2;
				 }
			else{
				break;
			}
		}
	}
	private void descer(int i){
		int j=2*i;
		if(j<=n){
		if(j+1<=n && vetor[j+1]>vetor[j]) j++;
		 if(vetor[j]>vetor[i]){
			 int aux=vetor[j];
			 vetor[j]=vetor[i];
			 vetor[i]=aux;
		   descer(j);
		  }
		 }
	}
	
	public void contruir(List<Integer> entrada){
	for(int i=1;i<=entrada.size();i++){
		vetor[i]=entrada.get(i-1);
		n++;
	}
	for(int j=n/2;j>1;j--){
		descer(j);
	}
		
	/*for(int i=n/2;i>=1;i--){
		descer(i);
		}*/
		
	}
	
	public int getMaximaPrioridade(){
		return vetor[0];
	}
	
	public int remove(){
	int aux=0;
	if(n >= 1){
	aux = vetor[0];
	int aux2=vetor[0];
	vetor[0]=vetor[n-1];
	vetor[n-1]=aux2;
	n--;
	descer(0);
	}
	return aux;
	}
	
	
	public void inserir(int prioridade){
	if(n+1<=nMaximo){
		  vetor[n+1]=prioridade;
		  n++;
		  subir(n);
		 }
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){		
	for(int i = 0; i<n;i++){
		if(vetor[i]==prioridade){
			if(vetor[i]<novaPrioridade){
				vetor[i]=novaPrioridade;
				subir(i);		
			}
			else{
				vetor[i]=novaPrioridade;
				descer(i);
			}
		break;
		}
	}
	}	
}