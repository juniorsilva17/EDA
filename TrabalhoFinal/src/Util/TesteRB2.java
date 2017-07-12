package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ArvRubNeg.RubroNegra;
import Veiculo.Veiculo;

public class TesteRB2 {
	public static void main(String args[]) {
		
		System.out.println("Arvore Rubro Negra Teste 2");
		EDAUtil m = new EDAUtil();
		long tempoInicial = System.currentTimeMillis();
		List<Veiculo> lista = m.carregar();
		long tempo = System.currentTimeMillis() - tempoInicial;
		System.out.println("Tempo de ler Arquivo: " + tempo);

		List<Veiculo> buscados = new ArrayList<Veiculo>();
		RubroNegra<Veiculo, Veiculo> arv = new RubroNegra<Veiculo, Veiculo>();

		tempoInicial = System.currentTimeMillis();

		int taxa = (int) (lista.size() * 0.2);
		for (int i = 1; i <= lista.size(); i++) {
			arv.inserir(lista.get(i - 1),lista.get(i - 1));
			if (i % taxa == 0) {
				for (int j = 0; j < i * 0.3; j++) {
					Random rand = new Random();
					Veiculo veic = lista.get(rand.nextInt(lista.size()));
					buscados.add(veic);
				}
				 for (Veiculo veiculo : buscados) {
				 arv.busca(veiculo);
				 }
				for (int j = 0; j < i * 0.1; j++) {
					Random rand = new Random();
					arv.remover(buscados.remove(rand.nextInt(buscados.size())));
				}
			}
		}
		 tempo = System.currentTimeMillis() - tempoInicial;
		 System.out.println("Tempo total: " + tempo);
		 }
}
