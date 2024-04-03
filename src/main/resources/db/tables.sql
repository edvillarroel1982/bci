CREATE TABLE BCI_USUARIO (
    ID UUID PRIMARY KEY,
    NOMBRE VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    FECHA_CREACION TIMESTAMP NOT NULL,
    FECHA_MODIFICACION TIMESTAMP,
    FECHA_ULTIMO_ACCESO TIMESTAMP,
    ACTIVO BOOLEAN NOT NULL,
    TOKEN UUID NOT NULL
);

CREATE TABLE BCI_TELEFONO (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NUMERO INTEGER,
    COD_CIUDAD INTEGER,
    COD_PAIS INTEGER,
    ID_USUARIO UUID,
    FOREIGN KEY (ID_USUARIO) REFERENCES BCI_USUARIO(ID)
);