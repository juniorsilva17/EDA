package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ArvRubNeg.RubroNegra;
import Veiculo.Veiculo;

public class TesteRB {
	public static void main(String args[]) {
		System.out.println("Arvore Rubro Negra");
		
		EDAUtil m = new EDAUtil();
		long tempoInicial = System.currentTimeMillis();
		List<Veiculo> lista = m.carregar();
		long tempo = System.currentTimeMillis() - tempoInicial;
		System.out.println("Tempo de ler Arquivo: " + tempo);
		
		List<Veiculo> buscados = new ArrayList<Veiculo>();
		RubroNegra<Veiculo, Veiculo> arv = new RubroNegra<Veiculo, Veiculo>();
		
		tempoInicial = System.currentTimeMillis();
		for (Veiculo veiculo : lista) {
			arv.inserir(veiculo,veiculo);
		}
		
		tempo = System.currentTimeMillis() - tempoInicial;
		System.out.println("Tempo de insercao: " + tempo);
		
		int tam = lista.size();
		for (int i = 0; i < tam * 0.3; i++) {
			Random rand = new Random();
			Veiculo e = lista.get(rand.nextInt(tam));
			buscados.add(e);
		}
		tempoInicial = System.currentTimeMillis();
		for (Veiculo veiculo : buscados) {
			arv.busca(veiculo);
		}
		tempo = System.currentTimeMillis() - tempoInicial;			  
		System.out.println("Tempo de busca: " + tempo);
		
		tempoInicial = System.currentTimeMillis();
		for (Veiculo veiculo : buscados){
			arv.remover(veiculo);
		}
		
		tempo = System.currentTimeMillis() - tempoInicial;			  
		System.out.println("Tempo de remorcao: " + tempo);
	}
}
