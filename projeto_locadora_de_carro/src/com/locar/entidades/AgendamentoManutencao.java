package com.locar.entidades;

public class AgendamentoManutencao {

	private Carro carro;
	private String tipoManuntencao;
	private String dataManuntencao;
	private String hora;
	private String observacao;
	
	public AgendamentoManutencao() {
	}

	public AgendamentoManutencao(Carro carro, String tipoManuntencao, String dataManuntencao, String hora, String observacao) {
		this.carro = carro;
		this.tipoManuntencao = tipoManuntencao;
		this.dataManuntencao = dataManuntencao;
		this.hora = hora;
		this.observacao = observacao;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public String getTipoManuntencao() {
		return tipoManuntencao;
	}
	public void setTipoManuntencao(String tipoManuntencao) {
		this.tipoManuntencao = tipoManuntencao;
	}
	public String getDataManuntencao() {
		return dataManuntencao;
	}
	public void setDataManuntencao(String dataManuntencao) {
		this.dataManuntencao = dataManuntencao;
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
