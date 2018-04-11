package com.example.demo.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Cliente;
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

@Service
@Transactional
public class ContaServiceImpl implements ContaService {

	@Autowired
	ContaRepository contaRepository;
	
	@Override
	public Conta criar(AdicionarContaRequestModel request) {
		double contaSaldo = request.getSaldo();
		double contaLimite = request.getLimite();
		Cliente contaCliente = request.getCliente();

		Conta novaConta = contaRepository.save(new Conta(contaSaldo, contaLimite, contaCliente));

		return novaConta;
	}

	@Override
	public DeletarContaResponseModel deletar(DeletarContaRequestModel request) {
		Conta conta = contaRepository.findByContaId(request.getId());
		contaRepository.deleteById(request.getId());
		
		DeletarContaResponseModel deletarContaResponseModel = new DeletarContaResponseModel(conta);
		return deletarContaResponseModel;
	}

	@Override
	public List<Conta> deletarTodos() {
		List<Conta> deletados = contaRepository.findAll();
		for(Conta conta : deletados) {
			contaRepository.delete(conta);
		}
		
		return deletados;
	}

	@Override
	public List<Conta> listar() {
		return contaRepository.findAll();
	}

	@Override
	public SaqueResponseModel sacar(SaqueRequestModel request) {
		Conta conta = contaRepository.findByContaId(request.getId());
		double contaSaldo = conta.getSaldo();
		double contaLimite = conta.getLimite();
		int contaId = conta.getContaId();
		double valor = request.getValor();

		String msg;
		double saldoLimite = contaSaldo + contaLimite;

		if (valor >= 0) {
			if (valor <= contaSaldo) {
				double novoSaldo = contaSaldo - valor;
				conta.setSaldo(novoSaldo);
				SaqueResponseModel saqueResponse = new SaqueResponseModel(contaId, valor, contaRepository.findByContaId(request.getId()).getSaldo(), contaRepository.findByContaId(request.getId()).getLimite());
				contaRepository.save(conta);
				return saqueResponse;
			} else if (valor <= saldoLimite) {
				saldoLimite -= valor;
				conta.setSaldo(0);
				conta.setLimite(saldoLimite);
				SaqueResponseModel saqueResponse = new SaqueResponseModel(contaId, valor, contaRepository.findByContaId(request.getId()).getSaldo(), contaRepository.findByContaId(request.getId()).getLimite());
				contaRepository.save(conta);
				return saqueResponse;
			} else {
				msg = "Saldo e limite indisponíveis para saque";
				throw new RuntimeException(msg);
			}
		} else {
			msg = "Impossível sacar um valor negativo.";
			throw new RuntimeException(msg);
		}
	}

	@Override
	public DepositoResponseModel depositar(DepositoRequestModel request) {
		Conta conta = contaRepository.findByContaId(request.getId());
		int contaId = conta.getContaId();
		double contaSaldo = conta.getSaldo();
		double valor = request.getValor();

		DepositoResponseModel depositoResponse = new DepositoResponseModel(contaId, valor);

		if (valor >= 0) {
			double novoSaldo = contaSaldo + valor;
			conta.setSaldo(novoSaldo);
			
			contaRepository.save(conta);

			return depositoResponse;
		} else {
			String msg = "Impossível depositar um valor negativo.";
			throw new RuntimeException(msg);
		}
	}

	@Override
	public TransferenciaResponseModel transferir(TransferenciaRequestModel request) {
		Conta conta1 = contaRepository.findByContaId(request.getId1());
		Conta conta2 = contaRepository.findByContaId(request.getId2());
		double conta1Limite = conta1.getLimite();
		double conta1Saldo = conta1.getSaldo();
		double conta2Saldo = conta2.getSaldo();
		double valor = request.getValor();
		double saldoLimite = conta1Saldo + conta1Limite;
		String nomeCliente1 = conta1.getCliente().getNome();
		String nomeCliente2 = conta2.getCliente().getNome();
		String msg;

		TransferenciaResponseModel transferenciaResponse = new TransferenciaResponseModel(nomeCliente1,
				nomeCliente2, valor);
		if (valor >= 0) {
			if (valor <= conta1Saldo) {
				double novoSaldoC1 = conta1Saldo - valor;
				double novoSaldoC2 = conta2Saldo + valor;
				conta1.setSaldo(novoSaldoC1);
				conta2.setSaldo(novoSaldoC2);
				contaRepository.save(conta2);
				contaRepository.save(conta1);
				return transferenciaResponse;
			} else if (valor <= saldoLimite) {
				double novoSaldoC2 = conta2Saldo + valor;
				saldoLimite -= valor;
				conta1.setSaldo(0);
				conta1.setLimite(saldoLimite);
				conta2.setSaldo(novoSaldoC2);
				contaRepository.save(conta2);
				contaRepository.save(conta1);
				return transferenciaResponse;
			} else {
				msg = "Saldo e limite indisponíveis para transferência";
				throw new RuntimeException(msg);
			}
		} else {
			msg = "Impossível transferir um valor negativo.";
			throw new RuntimeException(msg);
		}
	}

	@Override
	public AlterNomeResponseModel alterarNome(AlterNomeRequestModel request) {
		Conta conta = contaRepository.findByContaId(request.getId());
		String contaNovoNome = request.getCliente().getNome();
    	
    	if(!contaNovoNome.equals("")) {
    		conta.getCliente().setNome(contaNovoNome);
        	AlterNomeResponseModel alterNomeResponse = new AlterNomeResponseModel(contaNovoNome);

    		contaRepository.save(conta);
        	return alterNomeResponse;
    	} else {
    		String msg = "Impossível alterar para nome vazio.";
    		throw new RuntimeException(msg);
    	}
	}

	@Override
	public SaldoResponseModel consultarSaldo(SaldoRequestModel request) {
		Conta conta = contaRepository.findByContaId(request.getId());
		double contaSaldo = conta.getSaldo();

		SaldoResponseModel saldoResponse = new SaldoResponseModel(contaSaldo, conta.getContaId());
		return saldoResponse;
	}

	@Override
	public Conta buscarPorId(int id) {
		return contaRepository.findByContaId(id);

	}
	
}
