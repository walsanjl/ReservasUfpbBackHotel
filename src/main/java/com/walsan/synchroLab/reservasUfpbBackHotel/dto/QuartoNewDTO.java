package com.walsan.synchroLab.reservasUfpbBackHotel.dto;

import java.io.Serializable;

public class QuartoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//dados do quarto
	private Integer numeroDoQuarto;
	private Integer qtdeDeLeitos;
	private Integer preco;
	private String status;
	
	//dados do hotel
	private Integer idDoHotel;
	
	//dados do cliente
	private Integer idDoCliente;
	
	public QuartoNewDTO() {
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Integer getQtdeDeLeitos() {
		return qtdeDeLeitos;
	}

	public void setQtdeDeLeitos(Integer qtdeDeLeitos) {
		this.qtdeDeLeitos = qtdeDeLeitos;
	}

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIdDoHotel() {
		return idDoHotel;
	}

	public void setIdDoHotel(Integer idDoHotel) {
		this.idDoHotel = idDoHotel;
	}

	public Integer getIdDoCliente() {
		return idDoCliente;
	}

	public void setIdDoCliente(Integer idDoCliente) {
		this.idDoCliente = idDoCliente;
	}
}
