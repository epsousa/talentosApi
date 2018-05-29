package com.example.pastel.models;

import java.util.List;

public class Pedido {

	private Long id;
	
	private String nomeUsuarioPedido;
	
	private String formaPagamento;
	
	private List<Pastel> pasteis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuarioPedido() {
		return nomeUsuarioPedido;
	}

	public void setNomeUsuarioPedido(String nomeUsuarioPedido) {
		this.nomeUsuarioPedido = nomeUsuarioPedido;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<Pastel> getPasteis() {
		return pasteis;
	}

	public void setPasteis(List<Pastel> pasteis) {
		this.pasteis = pasteis;
	}
			
}
