package com.locar.entidades;

public class Funcionario {
		private String nome;
		private String cpf;
		private String rg;
		private String orgExp;
		private String telefone;
		private String email;
		private String dataNascimento;
		private String dataExp;
		private String cnh;
		private String validadeCNH;
		private String cep;
		private String rua;
		private String numeroRua;
		private String bairro;
		private String cidade;
		private String complemento;
		private String senha;

	public Funcionario (String nome, String cpf, String rg, String orgExp, String telefone, String email, String dataNascimento, String dataExp,
			String cnh, String validadeCNH, String cep, String rua, String numeroRua, String bairro, String cidade, String complemento, String senha) {
			this.setNome(nome);
			this.setCpf(cpf);
			this.setRg(rg);
			this.setOrgExp(orgExp);
			this.setTelefone(telefone);
			this.setEmail(email);
			this.setDataNascimento(dataNascimento);
			this.setDataExp(dataExp);
			this.setCnh(cnh);
			this.setValidadeCNH(validadeCNH);
			this.setCep(cep);
			this.setRua(rua);
			this.setNumeroRua(numeroRua);
			this.setBairro(bairro);
			this.setCidade(cidade);
			this.setComplemento(complemento);
			this.setSenha(senha);
	}

	public Funcionario (String nome, String rg, String orgExp, String telefone, String email, String dataNascimento, String dataExp,
			String cnh, String validadeCNH, String cep, String rua, String numeroRua, String bairro, String cidade, String complemento, String senha) {
			this.setNome(nome);
			this.setRg(rg);
			this.setOrgExp(orgExp);
			this.setTelefone(telefone);
			this.setEmail(email);
			this.setDataNascimento(dataNascimento);
			this.setDataExp(dataExp);
			this.setCnh(cnh);
			this.setValidadeCNH(validadeCNH);
			this.setCep(cep);
			this.setRua(rua);
			this.setNumeroRua(numeroRua);
			this.setBairro(bairro);
			this.setCidade(cidade);
			this.setComplemento(complemento);
			this.setSenha(senha);
	}
	public Funcionario (String cpf, String nome, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public Funcionario (String cpf, String nome, String telefone,String dataNascimento, String email, String cnh) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.cnh = cnh;

	}

	public Funcionario(String nome, String rg, String telefone, String email, String dataNascimento, String cnh,
			String validadeCNH, String cep) {
		this.nome = nome;
		this.rg = rg;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cnh = cnh;
		this.validadeCNH = validadeCNH;
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgExp() {
		return orgExp;
	}

	public void setOrgExp(String orgExp) {
		this.orgExp = orgExp;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataExp() {
		return dataExp;
	}

	public void setDataExp(String dataExp) {
		this.dataExp = dataExp;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getValidadeCNH() {
		return validadeCNH;
	}

	public void setValidadeCNH(String validadeCNH) {
		this.validadeCNH = validadeCNH;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroRua() {
		return numeroRua;
	}

	public void setNumeroRua(String numeroRua) {
		this.numeroRua = numeroRua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
