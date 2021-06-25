CREATE SCHEMA master;

CREATE TABLE master_pengurus(
  kode_pengurus             CHARACTER VARYING(255)            NOT NULL PRIMARY KEY,
  nama_pengurus             CHARACTER VARYING(255)            NOT NULL UNIQUE,
  jk_pengurus               CHARACTER VARYING(50)             NOT NULL,
  pekerjaan_pengurus        CHARACTER VARYING(150)            NOT NULL,
  alamat_pengurus           CHARACTER VARYING(1000)           NOT NULL,
  telephone_pengurus        CHARACTER VARYING(15)             NOT NULL,
  jabatan_pengurus          CHARACTER VARYING(255)            NOT NULL,
  status_pengurus           CHARACTER VARYING(255)            NOT NULL,
  created_date              TIMESTAMP                         NOT NULL,
  created_by                CHARACTER VARYING(50)
);

 create table master_bilal(
  kode_bilal                CHARACTER VARYING(255)            NOT NULL PRIMARY KEY,
  nama_bilal                CHARACTER VARYING(150)            NOT NULL UNIQUE,
  alamat_bilal              CHARACTER VARYING(1000)           NOT NULL,
  status_bilal              CHARACTER VARYING(10)             NOT NULL,
  telephone_bilal           CHARACTER VARYING(5)              NOT NULL,
  created_date              TIMESTAMP                         NOT NULL,
  created_by                CHARACTER VARYING(20),
  bilal_id                  CHARACTER VARYING(255)            NOT NULL REFERENCES master_pengurus(nama_pengurus)
);

create table master_imam(
  kode_imam                 CHARACTER VARYING(255)            NOT NULL PRIMARY KEY,
  nama_imam                 CHARACTER VARYING(150)            NOT NULL UNIQUE,
  alamat_imam               CHARACTER VARYING(1000)           NOT NULL,
  status_imam               CHARACTER VARYING(10)             NOT NULL,
  telephone_imam            CHARACTER VARYING(5)              NOT NULL,
  created_date              TIMESTAMP                         NOT NULL,
  created_by                CHARACTER VARYING(20),
  imam_id                   CHARACTER VARYING(255)            NOT NULL REFERENCES master_pengurus(nama_pengurus)
);

create table master_muazin(
  kode_muazin               CHARACTER VARYING(255)            NOT NULL PRIMARY KEY,
  nama_muazin               CHARACTER VARYING(150)            NOT NULL UNIQUE,
  alamat_muazin             CHARACTER VARYING(1000)           NOT NULL,
  status_muazin             CHARACTER VARYING(10)             NOT NULL,
  telephone_muazin          CHARACTER VARYING(5)              NOT NULL,
  created_date              TIMESTAMP                         NOT NULL,
  created_by                CHARACTER VARYING(20),
  muazin_id                 CHARACTER VARYING(255)            NOT NULL REFERENCES master_pengurus(nama_pengurus)
);

create table master_marbot(
  kode_marbot               CHARACTER VARYING(255)            NOT NULL PRIMARY KEY,
  nama_marbot               CHARACTER VARYING(150)            NOT NULL UNIQUE,
  alamat_marbot             CHARACTER VARYING(1000)           NOT NULL,
  status_marbot             CHARACTER VARYING(10)             NOT NULL,
  telephone_marbot          CHARACTER VARYING(5)              NOT NULL,
  created_date              TIMESTAMP                         NOT NULL,
  created_by                CHARACTER VARYING(20),
  marbot_id                 CHARACTER VARYING(255)            NOT NULL REFERENCES master_pengurus(nama_pengurus)
);

create table master_remaja(
  kode_remaja               CHARACTER VARYING(255)            NOT NULL PRIMARY KEY,
  nama_remaja               CHARACTER VARYING(150)            NOT NULL UNIQUE,
  alamat_remaja             CHARACTER VARYING(1000)           NOT NULL,
  status_remaja             CHARACTER VARYING(10)             NOT NULL,
  telephone_remaja          CHARACTER VARYING(5)              NOT NULL,
  created_date              TIMESTAMP                         NOT NULL,
  created_by                CHARACTER VARYING(20),
  remaja_id                 CHARACTER VARYING(255)            NOT NULL REFERENCES master_pengurus(nama_pengurus)
);

create table master_yatimdandhuafa(
  kode_yatimdandhuafa       CHARACTER VARYING(255)            NOT NULL PRIMARY KEY,
  nama_yatimdandhuafa       CHARACTER VARYING(150)            NOT NULL UNIQUE,
  alamat_yatimdandhuafa     CHARACTER VARYING(1000)           NOT NULL,
  status_yatimdandhuafa     CHARACTER VARYING(10)             NOT NULL,
  telephone_yatimdandhuafa  CHARACTER VARYING(5)              NOT NULL,
  created_date              TIMESTAMP                         NOT NULL,
  created_by                CHARACTER VARYING(20),
  yatimdandhuafa_id         CHARACTER VARYING(255)            NOT NULL REFERENCES master_pengurus(nama_pengurus)
);