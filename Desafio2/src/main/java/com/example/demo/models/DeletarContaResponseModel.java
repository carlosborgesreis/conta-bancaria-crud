package com.example.demo.models;

import com.example.demo.entities.Conta;

public class DeletarContaResponseModel {
	private Conta contaDeletada;
	
	public DeletarContaResponseModel(Conta contaDeletada) {
		this.contaDeletada = contaDeletada;
	}

	public Conta getContaDeletada() {
		return contaDeletada;
	}

	public void setContaDeletada(Conta contaDeletada) {
		this.contaDeletada = contaDeletada;
	}

}
