package com.example.demo.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Conta;
import com.example.demo.models.AdicionarContaRequestModel;
import com.example.demo.models.AlterNomeRequestModel;
import com.example.demo.models.AlterNomeResponseModel;
import com.example.demo.models.BuscarRequestModel;
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

@RestController
@RequestMapping("/conta/")
public class ContaController {
	
	@Autowired
	ContaService contaService;

	@PostMapping("criar")
	public Conta abrirConta(@RequestBody AdicionarContaRequestModel request) {
		return contaService.criar(request);
	}
	
	@PostMapping("deletar")
	public DeletarContaResponseModel fecharConta(@RequestBody DeletarContaRequestModel request) {
		return contaService.deletar(request);
	}

	@PostMapping("deletarTodos")
	public List<Conta> fecharContaTodos() {
		return contaService.deletarTodos();
	}
	
	@GetMapping("buscar")
	public Conta buscarConta(@RequestBody BuscarRequestModel request) {
		return contaService.buscarPorId(request.getId());
	}
	
	@GetMapping("listar")
	public List<Conta> listarContas() {
		return contaService.listar();
	}

	@PutMapping("sacar")
	public SaqueResponseModel sacar(@RequestBody SaqueRequestModel request) {
		return contaService.sacar(request);
	}

	@GetMapping("saldo")
	public SaldoResponseModel consultarSaldo(@RequestBody SaldoRequestModel request) {
		return contaService.consultarSaldo(request);
	}

	@PutMapping("transferir")
	public TransferenciaResponseModel transferir(@RequestBody TransferenciaRequestModel request) {
		return contaService.transferir(request);
	}

	@PutMapping("depositar")
	public DepositoResponseModel depositar(@RequestBody DepositoRequestModel request) {
		return contaService.depositar(request);
	}

	@PutMapping("alterarNome")
	public AlterNomeResponseModel alterarNome(@RequestBody AlterNomeRequestModel request) {
		return contaService.alterarNome(request);
	}
}
