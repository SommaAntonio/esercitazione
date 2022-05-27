# esercitazioneBackend
esercitazione Somma Antonio Lorenzo

target:
	java version:1.8
	postger version:14
	Node: 16.15.0
	Angular CLI: 13.3.3
	spring boot:2.6.7
  
  il frontend si raggiunge dal url 
http://localhost:4200/

nel envirorments aprire il file enviroments.ts e mettere questa riga:
baseUrl: "http://localhost:8080"

per collegarlo al db e al backend sulla stessa porta

PER L'AVVIO DEL BACKEND:
cd .\FrontEnd\FrontEnd\

poi

ng serve

FUNZIONI:

subscibe :la subscribe serve al frontend per collegare le propie funzioni a quelle del backend che lavora sul DataBase

delete(id:number) richiede l'id del utente che va eliminato, non restituisce nulla , facendo la subscibe si riconnette al backend subscibe :la subscribe serve al frontend per collegare le propie funzioni a quelle del backend

getAll(): non richiede nessun paramentro e ha un return di tipo array di oggetto ListaTodo

getById(id:number): richiede solo l'id da cercare e collegandosi con la subscibe rimanda indietro la lista che ha quel id

post(lista:ListaTodo) : richiede la lista che deve salvare sul db mandandola al backend  , 

put(lista:ListaTodo) : richiede come paramentro la lista del record trovandolo in base al id 

search(word:string) : richiede la parola che andra cercata collegandosi poi al backend con la funzione apposita del BE


TODO:
manca la verifica dei dati in frontend, per ogni campo della create e update si dovrebbe controllare che la lunghezza non sia meno di 4 in modo da sapere di sicuro che non siano vuoti
sullo stato c'e da controllare che siano todo,done o inProgres, per le date si puo dare una data minima come quella del 2022-01-01 e con la comparazione delle date si controlla che 
siano anche possibili tra di loro(la data di fine non puo essere prima di quella di inizio)
