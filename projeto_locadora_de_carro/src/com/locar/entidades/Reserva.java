package com.locar.entidades;

public class Reserva {
	private long id;
	private Cliente cliente;
	private Carro carro;
	private String dataRetirada;
	private String horaRetirada;
	private String dataEntrega;
	private String horaEntrega;
	
	public Reserva(Cliente cliente, Carro carro, String dataRetirada, String horaRetirada, String dataEntrega,
			String horaEntrega) {
		
		this.cliente = cliente;
		this.carro = carro;
		this.dataRetirada = dataRetirada;
		this.horaRetirada = horaRetirada;
		this.dataEntrega = dataEntrega;
		this.horaEntrega = horaEntrega;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public String getHoraRetirada() {
		return horaRetirada;
	}

	public void setHoraRetirada(String horaRetirada) {
		this.horaRetirada = horaRetirada;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(String horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	
	

}
