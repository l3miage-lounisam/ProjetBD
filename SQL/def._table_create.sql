CREATE TABLE public.velo (
    id int NOT NULL,
    datemiseservice date NOT NULL,
    puce varchar(30) NOT NULL,
    idetat integer NOT NULL,
    idmodel integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.velo
    (idetat);
CREATE INDEX ON public.velo
    (idmodel);


CREATE TABLE public.model (
    id integer NOT NULL,
    nom varchar(30) NOT NULL,
    couthoraire real NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE public.location (
    id integer NOT NULL,
    prix double precision NOT NULL,
    idabonne integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.location
    (idabonne);


CREATE TABLE public.etat (
    id integer NOT NULL,
    typeetat varchar(2) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE public.bornette (
    id integer NOT NULL,
    idetat integer NOT NULL,
    idstation integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.bornette
    (idetat);
CREATE INDEX ON public.bornette
    (idstation);


CREATE TABLE public.abonne (
    id integer NOT NULL,
    nom varchar(20) NOT NULL,
    prenom varchar(20) NOT NULL,
    daten date NOT NULL,
    adresse varchar(50) NOT NULL,
    datedebutab date NOT NULL,
    credittemps integer NOT NULL,
    numerocb integer NOT NULL,
    codesecret varchar(10) NOT NULL,
    sexe integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.abonne
    (sexe);


CREATE TABLE public.sexe (
    id integer NOT NULL,
    sexe varchar(20) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE public.station (
    id integer NOT NULL,
    adresse varchar(50) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE public.nonabonne (
    id integer NOT NULL,
    numerocb integer NOT NULL,
    codesecret varchar(10) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE public.stationdefinition (
    id integer NOT NULL,
    heure integer NOT NULL,
    definition varchar(10) NOT NULL,
    idstation integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.stationdefinition
    (idstation);


CREATE TABLE public.trajet (
    datedebuttrajet timestamp with time zone NOT NULL,
    datefintrajet timestamp with time zone NOT NULL,
    duree integer NOT NULL,
    prix double precision NOT NULL,
    idvelo integer NOT NULL,
    id integer NOT NULL,
    stationdepart integer NOT NULL,
    stationarrive integer NOT NULL,
    idlocation integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.trajet
    (idvelo);
CREATE INDEX ON public.trajet
    (stationdepart);
CREATE INDEX ON public.trajet
    (stationarrive);
CREATE INDEX ON public.trajet
    (idlocation);


ALTER TABLE public.velo ADD CONSTRAINT FK_velo__idetat FOREIGN KEY (idetat) REFERENCES public.etat(id);
ALTER TABLE public.velo ADD CONSTRAINT FK_velo__idmodel FOREIGN KEY (idmodel) REFERENCES public.model(id);
ALTER TABLE public.location ADD CONSTRAINT FK_location__idabonne FOREIGN KEY (idabonne) REFERENCES public.abonne(id);
ALTER TABLE public.bornette ADD CONSTRAINT FK_bornette__idetat FOREIGN KEY (idetat) REFERENCES public.etat(id);
ALTER TABLE public.bornette ADD CONSTRAINT FK_bornette__idstation FOREIGN KEY (idstation) REFERENCES public.station(id);
ALTER TABLE public.abonne ADD CONSTRAINT FK_abonne__sexe FOREIGN KEY (sexe) REFERENCES public.sexe(id);
ALTER TABLE public.stationdefinition ADD CONSTRAINT FK_stationdefinition__idstation FOREIGN KEY (idstation) REFERENCES public.station(id);
ALTER TABLE public.trajet ADD CONSTRAINT FK_trajet__idvelo FOREIGN KEY (idvelo) REFERENCES public.velo(id);
ALTER TABLE public.trajet ADD CONSTRAINT FK_trajet__stationdepart FOREIGN KEY (stationdepart) REFERENCES public.station(id);
ALTER TABLE public.trajet ADD CONSTRAINT FK_trajet__stationarrive FOREIGN KEY (stationarrive) REFERENCES public.station(id);
ALTER TABLE public.trajet ADD CONSTRAINT FK_trajet__idlocation FOREIGN KEY (idlocation) REFERENCES public.location(id);