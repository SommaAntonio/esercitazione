package com.fincons.esercizio.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listatodo")
public class ListaTodo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * qui creamo il dto con l'id e si spiega come funziona l'autoincrement del id,
	 * si spiega poi a quale colonna del database corrisponde ogni variabile
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "todo")
	private String todo;

	@Column(name = "stato")
	private String stato;

	@Column(name = "datainizio", nullable = false)
	private Date datainizio;

	@Column(name = "scadenza")
	private Date scadenza;

	/*
	 * da qui ci sono i vari setter e getter che serviranno per le implementazioni
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDatainizio() {
		return datainizio;
	}

	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
