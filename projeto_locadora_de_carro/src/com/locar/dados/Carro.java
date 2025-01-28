package com.locar.dados;

public class Carro {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private int precoDiaria;
    
    public Carro(int id, String marca, String modelo, int ano, int precoDiaria) {
    	this.id = id;
    	this.setMarca(marca);
    	this.setModelo(modelo);
    	this.setAno(ano);
    	this.setPrecoDiaria(precoDiaria);
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(int precoDiaria) {
		this.precoDiaria = precoDiaria;
	}
    
}
