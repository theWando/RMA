CREATE DATABASE rma;
USE rma;

CREATE USER 'rma_user'@'localhost' IDENTIFIED BY 'rma2011';
GRANT SELECT,INSERT,UPDATE,DELETE
     ON rma.*
     TO 'rma_user'@'localhost';

-- -----------------------------------------------------
-- Table `rma`.`documento_identificacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rma`.`documento_identificacion` (
  `id_doc_ident` INT NOT NULL AUTO_INCREMENT ,
  `tipo` VARCHAR(3) NOT NULL ,
  `valor` VARCHAR(14) NOT NULL ,
  PRIMARY KEY (`id_doc_ident`) )
COMMENT = 'Guarda los tipos de identificaciones que tiene una persona';


-- -----------------------------------------------------
-- Table `rma`.`persona`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rma`.`persona` (
  `id_persona` INT NOT NULL AUTO_INCREMENT ,
  `id_doc_ident` INT NOT NULL ,
  `nombre` VARCHAR(30) NOT NULL ,
  `apellido` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`id_persona`) ,
  INDEX `fk_id_doc_ident` (`id_doc_ident` ASC) ,
  CONSTRAINT `fk_id_doc_ident`
    FOREIGN KEY (`id_doc_ident` )
    REFERENCES `rma`.`documento_identificacion` (`id_doc_ident` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
COMMENT = 'table donde se guardaran los principales datos del cliente';


-- -----------------------------------------------------
-- Table `rma`.`direccion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rma`.`direccion` (
  `id_direccion` INT NOT NULL AUTO_INCREMENT ,
  `id_ciudad` INT NOT NULL ,
  `cod_pais` VARCHAR(3) NOT NULL ,
  `zona` VARCHAR(15) NULL DEFAULT NULL ,
  `linea1` VARCHAR(200) NULL DEFAULT NULL ,
  `linea2` VARCHAR(200) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_direccion`) ,
  CONSTRAINT `fk_id_ciudad`
    FOREIGN KEY (`id_ciudad` )
    REFERENCES `rma`.`City` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pais_cod`
    FOREIGN KEY (`cod_pais` )
    REFERENCES `rma`.`Country` (`Code` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Direcciones del Cliente o proveedor';


-- -----------------------------------------------------
-- Table `rma`.`tipo_contacto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rma`.`tipo_contacto` (
  `id` VARCHAR(3) NOT NULL ,
  `nombre` VARCHAR(15) NOT NULL ,
  `descripcion` VARCHAR(50) NOT NULL ,
  `patron` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
COMMENT = 'Los tipos de contacto con la persona';


-- -----------------------------------------------------
-- Table `rma`.`contacto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rma`.`contacto` (
  `id_contacto` INT NOT NULL ,
  `tipo_contacto` VARCHAR(3) NULL DEFAULT NULL ,
  `id_persona` INT NOT NULL ,
  `valor` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`id_contacto`) ,
  INDEX `fk_id_persona` (`id_persona` ASC) ,
  INDEX `fk_tipo_contacto` (`tipo_contacto` ASC) ,
  CONSTRAINT `fk_id_persona`
    FOREIGN KEY (`id_persona` )
    REFERENCES `rma`.`persona` (`id_persona` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tipo_contacto`
    FOREIGN KEY (`tipo_contacto` )
    REFERENCES `rma`.`tipo_contacto` (`id` )
    ON DELETE SET NULL
    ON UPDATE SET NULL)
COMMENT = 'Contactos de la persona';


-- -----------------------------------------------------
-- Table `rma`.`empleado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rma`.`empleado` (
  `id_empleado` INT NOT NULL AUTO_INCREMENT ,
  `id_persona` INT NOT NULL ,
  `puesto` VARCHAR(20) NOT NULL ,
  `fecha_inicio` DATE NOT NULL ,
  `fecha_fin` DATE NULL DEFAULT NULL ,
  `nivel_acceso` TINYINT NOT NULL ,
  PRIMARY KEY (`id_empleado`) ,
  INDEX `fk_id_persona_empleado` (`id_persona` ASC) ,
  CONSTRAINT `fk_id_persona_empleado`
    FOREIGN KEY (`id_persona` )
    REFERENCES `rma`.`persona` (`id_persona` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
COMMENT = 'empleados de la compaÃ±ia';


-- -----------------------------------------------------
-- Table `rma`.`producto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rma`.`producto` (
  `id_producto` INT NOT NULL ,
  `marca` VARCHAR(25) NOT NULL ,
  `nombre` VARCHAR(50) NOT NULL ,
  `precio` FLOAT NOT NULL ,
  `cantidad` INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`id_producto`) )
COMMENT = 'Productos en inventario';


-- -----------------------------------------------------
-- Table `rma`.`factura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rma`.`factura` (
  `id_factura` INT NOT NULL AUTO_INCREMENT ,
  `cajero` INT NOT NULL ,
  `cliente` INT NOT NULL ,
  `fecha_compra` DATE NOT NULL ,
  `total` DECIMAL NOT NULL ,
  `iva` INT NOT NULL ,
  `descuento` INT NOT NULL ,
  `subtotal` DECIMAL NOT NULL ,
  PRIMARY KEY (`id_factura`) ,
  INDEX `fk_cajero` (`cajero` ASC) ,
  INDEX `fk_cliente` (`cliente` ASC) ,
  CONSTRAINT `fk_cajero`
    FOREIGN KEY (`cajero` )
    REFERENCES `rma`.`empleado` (`id_empleado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente`
    FOREIGN KEY (`cliente` )
    REFERENCES `rma`.`persona` (`id_persona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Factura de compras realizadas en la empresa';


-- -----------------------------------------------------
-- Table `rma`.`compra_factura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rma`.`compra_factura` (
  `id_producto` INT NOT NULL ,
  `cantidad` TINYINT NOT NULL ,
  `precio` DECIMAL NOT NULL ,
  `id_factura` INT NOT NULL ,
  PRIMARY KEY (`id_producto`, `id_factura`) )
COMMENT = 'Relacion entre los productos adquiridos ';
