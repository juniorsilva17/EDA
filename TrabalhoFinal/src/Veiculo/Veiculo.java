package Veiculo;

public class Veiculo implements Comparable<Veiculo> {
	private String marca;
	private String modelo;
	private int ano;
	private String renavam;
	private String placa;
	private String cor;
	private long chave;
	
	public Veiculo() {
		// TODO Auto-generated constructor stub
	}
	public Veiculo(String marca, String modelo, int ano, String renavam, String placa, String cor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.renavam = renavam;
		this.placa = placa;
		this.cor = cor;
		this.chave = getRenaLong();
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

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
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
	
	public long getChave() {
		return chave;
	}

	public void setChave(long chave) {
		this.chave = chave;
	}
	@Override
	public int compareTo(Veiculo o) {
		if(this.chave > o.getChave()) return 1;
		else if(this.chave < o.getChave()) return -1;
		return 0;
	}
	
	public long getRenaLong() {
		String renavamT = this.renavam;
		Long renaT = Long.parseLong(renavamT);
		return renaT;
}

	
	
}
