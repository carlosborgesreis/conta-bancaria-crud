package com.example.demo.models;

public class DepositoResponseModel {
	private int numeroConta;
	private double valorDepositado;
	
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getValorDepositado() {
		return valorDepositado;
	}
	public void setValorDepositado(double valorDepositado) {
		this.valorDepositado = valorDepositado;
	}
	public DepositoResponseModel(int numeroConta, double valorDepositado) {
		super();
		this.numeroConta = numeroConta;
		this.valorDepositado = valorDepositado;
	}
	

}
