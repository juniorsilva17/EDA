package Veiculo;

public class Veiculo {
	private String marca;
	private String modelo;
	private int ano;
	private double renavam;
	private String placa;
	private String cor;

	public Veiculo(String marca, String modelo, int ano, double renavam, String placa, String cor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.renavam = renavam;
		this.placa = placa;
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getRenavam() {
		return renavam;
	}

	public void setRenavam(double renavam) {
		this.renavam = renavam;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
