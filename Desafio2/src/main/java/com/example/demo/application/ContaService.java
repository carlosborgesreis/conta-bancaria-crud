package com.example.demo.application;

import java.util.List;

import com.example.demo.entities.Conta;
import com.example.demo.models.AdicionarContaRequestModel;
import com.example.demo.models.AlterNomeRequestModel;
import com.example.demo.models.AlterNomeResponseModel;
import com.example.demo.models.DeletarContaRequestModel;
import com.example.demo.models.DeletarContaResponseModel;
import com.example.demo.models.DepositoRequestModel;
import com.example.demo.models.DepositoResponseModel;
import com.example.demo.models.SaldoRequestModel;
import com.example.demo.models.SaldoResponseModel;
import com.example.demo.models.SaqueRequestModel;
import com.example.demo.models.SaqueResponseModel;
import com.example.demo.models.TransferenciaRequestModel;
import com.example.demo.models.TransferenciaResponseModel;

public interface ContaService {
	Conta criar(AdicionarContaRequestModel request);
	DeletarContaResponseModel deletar(DeletarContaRequestModel request);
	List<Conta> deletarTodos();
	Conta buscarPorId(int id);
	List<Conta> listar();
	SaqueResponseModel sacar(SaqueRequestModel request);
	DepositoResponseModel depositar(DepositoRequestModel request);
	TransferenciaResponseModel transferir(TransferenciaRequestModel request);
	AlterNomeResponseModel alterarNome(AlterNomeRequestModel request);
	SaldoResponseModel consultarSaldo(SaldoRequestModel request);
	
	
}
