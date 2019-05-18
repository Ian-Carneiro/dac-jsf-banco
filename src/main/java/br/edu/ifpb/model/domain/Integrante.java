package br.edu.ifpb.model.domain;

import java.time.LocalDate;

public class Integrante {
	private int id;
    private String nome;
    private LocalDate dataDeNascimento;
    private CPF cpf = new CPF("");
	public Integrante(int id, String nome, LocalDate dataDeNascimento, CPF cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
	}
	public Integrante() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public CPF getCpf() {
		return cpf;
	}
	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
    
}
