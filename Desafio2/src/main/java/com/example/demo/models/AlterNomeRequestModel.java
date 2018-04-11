package com.example.demo.models;

import com.example.demo.entities.Cliente;

public class AlterNomeRequestModel {
	private int id;
	private Cliente cliente;
	
	public AlterNomeRequestModel() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
