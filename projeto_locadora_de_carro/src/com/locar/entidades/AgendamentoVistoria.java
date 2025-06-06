package com.locar.entidades;

public class AgendamentoVistoria {

	private Carro carro;
	private String tipoVistoria;
	private String dataVistoria;
	private String hora;
	private String observacao;

	public AgendamentoVistoria(Carro carro, String tipoVistoria, String dataVistoria, String hora, String observacao) {
		this.carro = carro;
		this.tipoVistoria = tipoVistoria;
		this.dataVistoria = dataVistoria;
		this.hora = hora;
		this.observacao = observacao;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public String getTipoVistoria() {
		return tipoVistoria;
	}
	public void setTipoVistoria(String tipoVistoria) {
		this.tipoVistoria = tipoVistoria;
	}
	public String getDataVistoria() {
		return dataVistoria;
	}
	public void setDataVistoria(String dataVistoria) {
		this.dataVistoria = dataVistoria;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}