package com.example.demo.models;

public class TransferenciaRequestModel {
	private int id1;
	private int id2;
	private double valor;
	
	public TransferenciaRequestModel() {
		super();
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
