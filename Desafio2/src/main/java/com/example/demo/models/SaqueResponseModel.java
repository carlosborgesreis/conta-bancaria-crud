package com.example.demo.models;

public class SaqueResponseModel {
	private int numeroConta;
	private double valorSaque;
	private double saldoAtual;
	private double limiteAtual;
	
	public SaqueResponseModel(int numeroConta, double valorSaque, double saldoAtual, double limiteAtual) {
		this.numeroConta = numeroConta;
		this.valorSaque = valorSaque;
		this.saldoAtual = saldoAtual;
		this.limiteAtual = limiteAtual;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getValorSaque() {
		return valorSaque;
	}

	public void setValorSaque(double valorSaque) {
		this.valorSaque = valorSaque;
	}
	
	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	
	public double getLimiteAtual() {
		return limiteAtual;
	}

	public void setLimiteAtual(double limiteAtual) {
		this.limiteAtual = limiteAtual;
	}
	
	
	
}
