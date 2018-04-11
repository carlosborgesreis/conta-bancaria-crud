package com.example.demo.models;

import com.example.demo.entities.Cliente;

public class AdicionarContaRequestModel {
	private Cliente cliente;
	private double saldo;
	private double limite;
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
