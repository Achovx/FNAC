drop database if exists fnac;
create database fnac;
use fnac;

create table categorie
(
	idCategorie int(5) not null auto_increment,
	libelle varchar(50),
	primary key(idCategorie)
);

create table article
(
	idArticle int(5) not null auto_increment,
	designation varchar(50),
	prix float (6.2),
	qte int(5),
	idCategorie int(5) not null,
	primary key(idArticle),
	foreign key(idCategorie) references categorie(idCategorie)
);

create table user
(
	idUser int(5) not null auto_increment,
	email varchar(50) not null,
	mdp varchar(50) not null,
	nom varchar(50) not null,
	prenom varchar(50) not null,
	droit enum("admin", "user", "autre"),
	primary key(idUser)
);

create table client
(
	idClient int(5) not null auto_increment,
	nom varchar(50) not null,
	prenom varchar(50) not null,
	adresse varchar(50) not null,
	email varchar(50) not null,
	tel varchar(50) not null,
	primary key(idClient)
);

create table commander
(
	idClient int(5) not null,
	idArticle int(5) not null,
	date_cmde date,
	qte int(5),
	primary key(idClient, idArticle),
	foreign key(idClient) references client(idClient),
	foreign key(idArticle) references article(idArticle)
);

insert into categorie values 
	(null, "Documentaire"), 
	(null, "Films"), 
	(null, "Musique");

insert into article values
	(null, "Deuxième guerre", 5.60, 15, 1),
	(null, "Seul sur mars", 12.60, 5, 2),
	(null, "la marseillaise", 2.30, 12, 3);

insert into user values
	(null, "a@gmail.com", "123", "On", "Alban", "admin"),
	(null, "b@gmail.com", "123", "On", "Toan", "user");

insert into client values
	(null, "On", "Alban", "6 rue jules valles", "on_alban@yahoo.fr", "0659729022"),
	(null, "On", "Toan", "6 rue jules valles", "on_alban@yahoo.fr", "0659729022");

insert into commander values
	(1, 1, "2018-10-10", "2"),
	(1, 2, "2018-10-12", "1"),
	(1, 3, "2018-02-02", "3");

create view tableauBord as
	(
		select c.nom, c.prenom, a.designation, a.prix, cat.libelle, cmde.date_cmde, cmde.qte
		from client c, article a, categorie cat, commander cmde
		where c.idClient = cmde.idClient
		and a.idArticle = cmde.idArticle
		and a.idCategorie = cat.idCategorie
		order by cmde.date_cmde
		limit 0,10
	);