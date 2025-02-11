package com.locar.entidades;

public class Locacao {
    private long id;
    private Cliente cliente;
    private Carro carro;
    private double valorDiaria;
    private int diasLocados;
    private double valorTotal;
    private String formaPagamento;
    private int cliente_id;
    private int carro_id;
    
    public Locacao(Cliente cliente, Carro carro,  double valorDiaria, int diasLocados, double valorTotal, String formaPagamento) {
        this.cliente = cliente;
        this.carro = carro;
        this.diasLocados = diasLocados;
        this.valorDiaria = valorDiaria;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    public Locacao(int cliente_id, int carro_id, double valorDiaria, int diasLocados, double valorTotal, String formaPagamento) {
    	this.cliente_id = cliente_id;
    	this.carro_id = carro_id;
        this.diasLocados = diasLocados;
        this.valorDiaria = valorDiaria;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
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


}
