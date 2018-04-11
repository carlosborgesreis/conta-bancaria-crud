package com.example.demo.models;

public class DepositoRequestModel {
	private int id;
	private double valor;
	
	public DepositoRequestModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
