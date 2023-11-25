package com.projetointegrador.app.rest.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String marca;

	@Column
	private String modelo;

	@Column
	private Date anoFabricacao;

	@Column
	private Date anoModelo;
	
	@Column
	private double valor;

	@Column
	private String descricao;
	
	@Column
	private Boolean carroInteresse;
	
	public Boolean getCarroInteresse() {
		return carroInteresse;
	}

	public void setCarroInteresse(Boolean carroInteresse) {
		this.carroInteresse = carroInteresse;
	}

	public Carro () {}

	public Carro(int id, String marca, String modelo, Date anoFabricacao, Date anoModelo, double valor,
			String descricao, Boolean carroInteresse) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.valor = valor;
		this.descricao = descricao;
		this.carroInteresse = carroInteresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Date anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Date getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Date anoModelo) {
		this.anoModelo = anoModelo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
