package com.locar.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Carro {
    private long id;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private String placa;
    private String numMotor;
    private String chassi;
    private String combustivel;
    private String transmissao;
    private String categoria;
    private String conservacao;
    private String direcao;
    private String kmRodados;
    private int numLugares;
    private int numPortas;
    private List<Reserva> reservas;
    
    public Carro() {
    }
    
    public Carro(String marca, String modelo, int ano, String cor, String placa, String numMotor,
            String chassi, String combustivel, String transmissao, String categoria, String conservacao,
            String direcao, String kmRodados, int numLugares, int numPortas) {
 this.marca = marca;
 this.modelo = modelo;
 this.ano = ano;
 this.cor = cor;
 this.placa = placa;
 this.numMotor = numMotor;
 this.chassi = chassi;
 this.combustivel = combustivel;
 this.transmissao = transmissao;
 this.categoria = categoria;
 this.conservacao = conservacao;
 this.direcao = direcao;
 this.kmRodados = kmRodados;
 this.numLugares = numLugares;
 this.numPortas = numPortas;
}
    
    public Carro(String marca, String modelo, int ano, String cor, String numMotor,
            String chassi, String combustivel, String transmissao, String categoria, String conservacao,
            String direcao, String kmRodados, int numLugares, int numPortas) {
 this.marca = marca;
 this.modelo = modelo;
 this.ano = ano;
 this.cor = cor;
 this.numMotor = numMotor;
 this.chassi = chassi;
 this.combustivel = combustivel;
 this.transmissao = transmissao;
 this.categoria = categoria;
 this.conservacao = conservacao;
 this.direcao = direcao;
 this.kmRodados = kmRodados;
 this.numLugares = numLugares;
 this.numPortas = numPortas;
}
    
    public Carro(String marca, String modelo, int ano, String kmRodados, String categoria) {
    	 this.marca = marca;
    	 this.modelo = modelo;
    	 this.ano = ano;
    	 this.kmRodados = kmRodados;    	
    	 this.categoria = categoria;
    }
    
    public Carro(String marca, String modelo, int ano, String cor, String placa, String numMotor, String chassi ) {
   	 this.marca = marca;
   	 this.modelo = modelo;
   	 this.ano = ano;
   	 this.cor = cor;
   	 this.placa = placa;
   	 this.numMotor = numMotor;
   	 this.chassi = chassi;
   }
    
    public Carro(Long id) {
    	this.id = id;
    }
    
    public long getId() {
    	return id; 
    }
    
    public void setId(long id) {
    	this.id = id; 
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

    public String getCor() { 
    	return cor; 
    }
    
    public void setCor(String cor) { 
    	this.cor = cor; 
    }

    public String getPlaca() { 
    	return placa; 
    }
    
    public void setPlaca(String placa) { 
    	this.placa = placa; 
    }

    public String getNumMotor() { 
    	return numMotor; 
    }
    
    public void setNumMotor(String numMotor) { 
    	this.numMotor = numMotor; 
    }

    public String getChassi() { 
    	return chassi; 
    }
    
    public void setChassi(String chassi) { 
    	this.chassi = chassi; 
    }

    public String getCombustivel() { 
    	return combustivel; 
    }
    
    public void setCombustivel(String combustivel) { 
    	this.combustivel = combustivel; 
    }

    public String getTransmissao() { 
    	return transmissao; 
    }
    
    public void setTransmissao(String transmissao) { 
    	this.transmissao = transmissao; 
    }

    public String getCategoria() { 
    	return categoria; 
    }
    
    public void setCategoria(String categoria) { 
    	this.categoria = categoria; 
    }

    public String getConservacao() { 
    	return conservacao; 
    }
    
    public void setConservacao(String conservacao) { 
    	this.conservacao = conservacao; 
    }

    public String getDirecao() { 
    	return direcao; 
    }
    
    public void setDirecao(String direcao) { 
    	this.direcao = direcao; 
    }

    public String getKmRodados() { 
    	return kmRodados; 
    }
    
    public void setKmRodados(String kmRodados) {
    	this.kmRodados = kmRodados; 
    }

    public int getNumLugares() { 
    	return numLugares; 
    }
    
    public void setNumLugares(int numLugares) { 
    	this.numLugares = numLugares; 
    }

    public int getNumPortas() { 
    	return numPortas; 
    }
    
    public void setNumPortas(int numPortas) { 
    	this.numPortas = numPortas; 
    }
    
    public boolean estaDisponivel(String dataRetirada, String dataEntrega) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        try {
            // Converte as datas fornecidas para objetos Date
            Date dataRetiradaDate = formatoData.parse(dataRetirada);
            Date dataEntregaDate = formatoData.parse(dataEntrega);

            // Verifica se o carro está disponível para o intervalo de datas
            for (Reserva reserva : reservas) {
                Date reservaDataRetirada = formatoData.parse(reserva.getDataRetirada());
                Date reservaDataEntrega = formatoData.parse(reserva.getDataEntrega());

                // Verifica se o intervalo de datas da nova reserva sobrepõe o intervalo de reservas existentes
                if ((dataRetiradaDate.before(reservaDataEntrega) && dataEntregaDate.after(reservaDataRetirada))) {
                    return false; // O carro já está reservado no período desejado
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de data inválido.");
        }

        // Se não houver sobreposição de reservas, o carro está disponível
        return true;
    }
    
}
