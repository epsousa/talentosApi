package com.example.pastel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pastel.models.Pedido;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedido")
public class PedidoController {

	private List<Pedido> pedidos = new ArrayList<Pedido>();
	private static Long id = 0L;
	
	@GetMapping
	public List<Pedido> returnHelloWorld() {
		return pedidos;
	}

	@GetMapping("{id}")
	public Pedido returnHelloWorld(@PathVariable("id") Long id) {

		Pedido ped = new Pedido();

		for (Pedido pedido : pedidos) {
			if (pedido.getId() == id) {
				ped = pedido;
			}
		}

		return ped;
	}

	@PostMapping
	public Pedido addPastel(@RequestBody Pedido pedido) {
		id++;
		pedido.setId(id);
		pedidos.add(pedido);
		return pedido;
	}

	@PutMapping
	public Pedido updatePastel(@RequestBody Pedido pedido) throws Exception {

		List<Pedido> pedidoAux = new ArrayList<>();		
		
		if (pedido.getId() <= 0)
			throw new Exception("Opa! Id inv�lido");

		for (Pedido ped : pedidos) {
			if (ped.getId() == pedido.getId()) {
				pedidoAux.add(ped);
			} else {
				pedidoAux.add(ped);
			}
		}
		
		pedidos = pedidoAux;

		return pedido;
	}

	@DeleteMapping("/{id}")
	public Pedido deletePastel(@PathVariable("id") Long id) throws Exception {

		List<Pedido> pedidosAux = new ArrayList<>();
		Pedido pedidoAux = new Pedido();

		if (id <= 0)
			throw new Exception("Opa! Id inv�lido");

		for (Pedido ped : pedidos) {
			if (ped.getId() != id) {
				pedidosAux.add(ped);
			} else {
				pedidoAux = ped;
			}
		}

		pedidos = pedidosAux;
		return pedidoAux;
	}

	
	
}
