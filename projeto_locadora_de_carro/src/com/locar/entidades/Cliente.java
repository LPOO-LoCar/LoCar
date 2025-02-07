package com.locar.entidades;

public class Cliente {
	private long id;
    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String sexo;
    private String cnh;
    private String vencimentoCnh;
    private String bairroRua;
    private int numero;
    private String cep;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    
    public Cliente(String nomeCompleto, String dataNascimento, String cpf, String sexo, String cnh,
    		String vencimentoCnh, String bairroRua, int numero, String cep, String cidade, String estado,
    		String telefone, String email) {
    	this.nomeCompleto = nomeCompleto;
    	this.dataNascimento = dataNascimento;
    	this.cpf = cpf;
    	this.sexo = sexo;
    	this.cnh = cnh;
    	this.vencimentoCnh = vencimentoCnh;
    	this.bairroRua = bairroRua;
    	this.numero = numero;
    	this.cep = cep;
    	this.cidade = cidade;
    	this.estado = estado;
    	this.telefone = telefone;
    	this.email = email;
    }
    
    public Cliente(String nomeCompleto, String telefone, String email) {
    	this.nomeCompleto = nomeCompleto;
    	this.telefone = telefone;
    	this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getCnh() {
        return cnh;
    }
    
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
    public String getVencimentoCnh() {
        return vencimentoCnh;
    }
    
    public void setVencimentoCnh(String vencimentoCnh) {
        this.vencimentoCnh = vencimentoCnh;
    }

    public String getBairroRua() {
        return bairroRua;
    }

    public void setBairroRua(String bairroRua) {
        this.bairroRua = bairroRua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
