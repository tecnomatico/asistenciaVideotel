
---
-- Creacion de las tablas para las base de datos del sistema de asistencia para la empresa videotel.
---

CREATE TABLE EMPRESA(
ID int(3) NOT NULL AUTO_INCREMENT,
NOMBRE VARCHAR(100) NULL,
TELEFONO VARCHAR(20) NULL,
DOMICILIO  VARCHAR(100) NULL,
LOCALIDAD  VARCHAR(50) NULL,
LOGO BLOB,
PRIMARY KEY (ID)
)
CREATE TABLE SECTOR(
SID int(3) NOT NULL AUTO_INCREMENT,
ID int(3) NULL,
DESCRIPCION VARCHAR(100) NULL,
PRIMARY KEY (SID),
INDEX(ID),
FOREIGN KEY (ID)
REFERENCES EMPRESA(ID)
ON DELETE CASCADE
ON UPDATE CASCADE
)
CREATE TABLE EMPLEADO(
EID int(3) NOT NULL AUTO_INCREMENT,
SID int(3) NULL,
DNI INT(9) NULL,
TELEFONO VARCHAR(20),
APELLIDO VARCHAR(40)  NULL,
NOMBRE VARCHAR(100) NULL,
FOTO BLOB,
ESTADO BIT,
ADMINISTRADOR BIT,
CLAVE VARCHAR(20),
PRIMARY KEY (EID),
INDEX(SID),
FOREIGN KEY (SID)
REFERENCES SECTOR(SID)
ON DELETE CASCADE
ON UPDATE CASCADE
)
CREATE TABLE DIATRABAJO(
DTID int(4) NOT NULL AUTO_INCREMENT,
EID int(3),
DID int(3),
NTURNO TINYINT(2),
PRIMARY KEY (DTID),
INDEX(EID),
FOREIGN KEY (EID)
REFERENCES EMPLEADO(EID)
ON DELETE CASCADE
ON UPDATE CASCADE
)
CREATE TABLE HORARIO(
HID int(3) NOT NULL AUTO_INCREMENT,
ENTRADA TIME NULL,
SALIDA TIME NULL,
ETIHORARIO TINYINT(2),
PRIMARY KEY (HID)
)
CREATE TABLE TURNO(
TID int(3) NOT NULL AUTO_INCREMENT,
DTID int(3) NULL,
HID int(3) NULL,
ETOLERANCIA TIME,
STOLERANCIA TIME,
PTURNO TINYINT(2),
PRIMARY KEY (TID),
INDEX(DTID),
INDEX(HID),
FOREIGN KEY (DTID)
REFERENCES DIATRABAJO(DTID)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY (HID)
REFERENCES HORARIO(HID)
ON DELETE CASCADE
ON UPDATE CASCADE
)
CREATE TABLE ASISTENCIA(
AID INT NOT NULL AUTO_INCREMENT,
EID int(3) NULL,
FECHA DATE,
MCONTADOR TINYINT(2),
NTURNO TINYINT(2),
PRIMARY KEY (AID),
INDEX(EID),
FOREIGN KEY (EID)
REFERENCES EMPLEADO(EID)
ON DELETE CASCADE
ON UPDATE CASCADE
)
CREATE TABLE MARCACION(
MAID INT NOT NULL AUTO_INCREMENT,
AID INT NULL,
ENTRADA DATE,
SALIDA DATE,
ETOLERANCIA TINYINT(3),
STOLERANCIA TINYINT(3),
MODIFICADO BIT,
FMODIFICADO DATE,
ESTADO BIT(1),
ETIMARCACION TINYINT(3),
MINTARDANZAE SMALLINT(3),
MINTARDANZAS SMALLINT(3),
ETIEXTRAM BIT(1),
ETIEXTRAD BIT(1),
PRIMARY KEY (MAID),
INDEX(AID),
FOREIGN KEY (AID)
REFERENCES ASISTENCIA(AID)
ON DELETE CASCADE
ON UPDATE CASCADE
)
CREATE TABLE COMENTARIO(
CID int(3) NOT NULL AUTO_INCREMENT,
SID int(3) NULL,
DESCRIPCION VARCHAR(100) NULL,
PRIMARY KEY (CID)
)


ALTER TABLE EMPRESA AUTO_INCREMENT=1;
ALTER TABLE SECTOR AUTO_INCREMENT=1;
ALTER TABLE EMPLEADO AUTO_INCREMENT=1;
ALTER TABLE DIATRABAJO AUTO_INCREMENT=1;
ALTER TABLE HORARIO AUTO_INCREMENT=1;
ALTER TABLE TURNO AUTO_INCREMENT=1;
ALTER TABLE ASISTENCIA AUTO_INCREMENT=1;
ALTER TABLE MARCACION AUTO_INCREMENT=1;
ALTER TABLE COMENTARIO AUTO_INCREMENT=1;



// POR AHORA NO SE REALIZARA ESTO
CREATE TABLE PERFIL(
PID INT NOT NULL,
DESCRIPCION VARCHAR(100) NULL,
PRIMARY KEY (PID)
)

CREATE TABLE USUARIO(
USID INT NOT NULL,
PID INT NOT NULL,
CONTRASEÑA VARCHAR(100) NULL,
USUARIO VARCHAR(100) NULL,
EID INT,
PRIMARY KEY (USID)
)