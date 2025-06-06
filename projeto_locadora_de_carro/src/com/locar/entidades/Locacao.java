package com.locar.entidades;

public class Locacao {
    private long id;
    private Cliente cliente;
    private Carro carro;
    private double valorDiaria;
    private int diasLocados;
    private double valorTotal;
    private String formaPagamento;
    private String status;
    private String dataLocacao;

    public Locacao(Cliente cliente, Carro carro,  double valorDiaria, int diasLocados, double valorTotal, String formaPagamento, String status,
    		String dataLocacao) {
        this.cliente = cliente;
        this.carro = carro;
        this.diasLocados = diasLocados;
        this.valorDiaria = valorDiaria;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.dataLocacao = dataLocacao;
        }

    public Locacao(Cliente cliente, Carro carro,  double valorDiaria, int diasLocados, double valorTotal, String formaPagamento, String status) {
        this.cliente = cliente;
        this.carro = carro;
        this.diasLocados = diasLocados;
        this.valorDiaria = valorDiaria;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

	public Locacao(double valorDiaria, int diasLocados, double valorTotal, String formaPagamento, String status) {
        this.diasLocados = diasLocados;
        this.valorDiaria = valorDiaria;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.status = status;
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

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getDiasLocados() {
        return diasLocados;
    }

    public void setDiasLocados(int diasLocados) {
        this.diasLocados = diasLocados;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
    	this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
}
