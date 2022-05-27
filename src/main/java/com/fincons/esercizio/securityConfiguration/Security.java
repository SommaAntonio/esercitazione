package com.fincons.esercizio.securityConfiguration;

public class Security {
	/*
	 * in questa classe si dovrebbe creare un token ovvero una stringa firmata che
	 * sarebbe potuta essere verificata solo al momento del filtraggio della
	 * request, in questo modo si aggiunge un ulteriore strato si sicurezza, nel
	 * dettaglio: il tocken potrebbe essere una stringa formata da un hash di una
	 * password o nel nostro caso non avendola un serie di caretteri casuali in modo
	 * da averlo in modo univoco, una volta creato questo tocken lo si salva nel
	 * database se e permanente o se one-time si controlla durante la sessione in
	 * corso, nel caso del permanente ad ogni richiesta di
	 * accedere/leggere/modificare/leggere dei dati del database tramite un filtro
	 */
}
