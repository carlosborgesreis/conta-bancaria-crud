package com.example.demo.models;

public class SaldoResponseModel {
	private int numeroConta;
	private double saldo;
	
	public SaldoResponseModel(double saldo, int numeroConta) {
		this.saldo = saldo;
		this.numeroConta = numeroConta;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumeroConta() {
		return this.numeroConta;
	}
}
