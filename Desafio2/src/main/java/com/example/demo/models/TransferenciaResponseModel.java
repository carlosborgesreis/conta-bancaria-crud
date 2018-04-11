package com.example.demo.models;

public class TransferenciaResponseModel {
	private String transferiu;
	private String recebeu;
	private double valor;

	public TransferenciaResponseModel(String transferiu, String recebeu, double valor) {
		this.transferiu = transferiu;
		this.recebeu = recebeu;
		this.valor = valor;
	}

	public String getTransferiu() {
		return transferiu;
	}

	public void setTransferiu(String transferiu) {
		this.transferiu = transferiu;
	}

	public String getRecebeu() {
		return recebeu;
	}

	public void setRecebeu(String recebeu) {
		this.recebeu = recebeu;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
