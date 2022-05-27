package com.fincons.esercizio.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fincons.esercizio.entities.ListaTodo;

/*implemento l'interfaccia serializable perche mi permette di creare dei dati auto incrementali*/
public class ListTodoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*definisco anche qui come l'entiti tutti i campi con i loro nomi e i vari metodi*/
	private Integer id;
	private String todo;
	private String stato;
	private Date datainizio;
	private Date scadenza;

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
