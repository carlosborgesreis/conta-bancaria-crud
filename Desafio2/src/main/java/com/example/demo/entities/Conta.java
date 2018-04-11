package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contaId;
	private double saldo = 0;
	private double limite = 0;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clienteId")
	private Cliente cliente;

	protected Conta() {}
	
	public Conta(double saldo, double limite, Cliente cliente) {
		this.limite = limite;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	
	public int getContaId() {
		return contaId;
	}

	public void setContaId(int id) {
		this.contaId = id;
	}

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