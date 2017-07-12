package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import Veiculo.Veiculo;

public class EDAUtil {
	Veiculo e;
	public EDAUtil(){
		e = new Veiculo();
	}
	public void gerarPontos(int quantidadeVeiculos){
		PrintWriter writer = null;

		try {
			writer = new PrintWriter("veiculosC.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < quantidadeVeiculos; i++) {
			int min = 1;
			int max = quantidadeVeiculos-1;
			int finalX = min + (int)(Math.random() * max); 

			writer.print(finalX+" ");
		}

		writer.println();
		
		for (int i = 0; i < quantidadeVeiculos; i++) {
			int minX = 1;
			int maxX = quantidadeVeiculos-1;
			int finalY = minX + (int)(Math.random() * maxX);
			
			writer.print(finalY+" ");
		}

		writer.close();
	}

	public ArrayList<Veiculo> carregar(){
		Scanner s = null;
		try {
			s = new Scanner(new File("veiculosC.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		while(s.hasNext()){
			String string = s.nextLine();
			String[] vet = string.split(", ");
			
			for(int i = 0; i < vet.length; i++){
				e = new Veiculo();
				//if (i==0){
				//e.setMarca(vet[0].split("=")[1]);
				//System.out.println(e.getMarca());
				//}
				if (i==3){
				e.setRenavam(vet[3].split("=")[1]);
				//System.out.println(e.getRenavam());
				}
				listaVeiculos.add(e);
			}
		}
		
		s.close();

		return listaVeiculos;
	}
}
