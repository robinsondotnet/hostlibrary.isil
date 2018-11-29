use HostLibrary;
-- STORE PROCEDURE --
-- AUTOR --
CREATE PROCEDURE sp_insertar_autor(in nom VARCHAR(60), in ape VARCHAR(60))
    INSERT INTO autor values(NULL, nom, ape);

CREATE PROCEDURE sp_actualizar_autor(in id int(4), in nom VARCHAR(60), in ape VARCHAR(60))
    UPDATE autor 
		SET id_autor = id,
				nombre=nom,
				apellido=ape
    WHERE id_autor=id;

CREATE PROCEDURE sp_buscar_autor(in id int(4))
    select * from autor where id_autor = id;

CREATE PROCEDURE sp_listar_autor()
    select * from autor;

-- EMPLEADO LOG --
CREATE PROCEDURE sp_insertar_empleado_log(in idEmp int (4), in ema VARCHAR(50), in pass VARCHAR(50))
    INSERT INTO empleado_log values(NULL,idEmp, ema, pass);

CREATE PROCEDURE sp_actualizar_empleado_log(in id int(4),in idEmp int (4), in ema VARCHAR(50), in pass VARCHAR(50))
    UPDATE empleado_log 
		SET id_log=id,
				id_empleado=idEmp,
				email=ema,
				contraseña = pass
    WHERE id_log=id;

CREATE PROCEDURE sp_buscar_empleado_log(in id int(4))
    select * from empleado_log where id_log=id;

CREATE PROCEDURE sp_listar_empleado_log()
    select * from empleado_log;


-- CARGO --
CREATE PROCEDURE sp_insertar_cargo(in nombre_c VARCHAR(50))
    INSERT INTO cargo values(NULL,nombre_cargo);

CREATE PROCEDURE sp_actualizar_cargo(in id int(4),in nombre_c varchar(50))
    UPDATE cargo 
		SET id_cargo=id,
				nombre_cargo=nombre_c
    WHERE id_cargo=id;

CREATE PROCEDURE sp_buscar_cargo(in id int(4))
    select * from cargo where id_cargo=id;

CREATE PROCEDURE sp_listar_cargo()
    select * from cargo;

-- TIENDA --
CREATE PROCEDURE sp_insertar_tienda(in nom VARCHAR(50),in rc char(11),in dir VARCHAR(100))
    INSERT INTO tienda values(NULL,nom,rc,dir);

CREATE PROCEDURE sp_actualizar_tienda(in id int(4),in nom VARCHAR(50),in rc char(11),in dir VARCHAR(100))
    UPDATE tienda 
		SET id_tienda=id,
				nombre=nom,
				ruc=rc,
				direccion=dir
    WHERE id_tienda=id;

CREATE PROCEDURE sp_buscar_tienda(in id int(4))
    select * from tienda where id_tienda=id;

CREATE PROCEDURE sp_listar_tienda()
    select * from tienda;

--  EMPLEADO --
CREATE PROCEDURE sp_insertar_empleado(in dn VARCHAR(8),in nom VARCHAR(60),in ape VARCHAR(60),in dir VARCHAR(100),
																			in fec_nac TIMESTAMP,in id_carg int(4),in id_tien int(4),in remu double,in fec_ini TIMESTAMP,
																			in fec_cese TIMESTAMP)
    INSERT INTO empleado values(NULL,dn,nom,ape,dir,fec_nac,id_carg,id_tien,remu,fec_ini_fec_cese);

CREATE PROCEDURE sp_actualizar_empleado(in id int(4),in dn VARCHAR(8),in nom VARCHAR(60),in ape VARCHAR(60),in dir VARCHAR(100),
																			in fec_nac TIMESTAMP,in id_carg int(4),in id_tien int(4),in remu double,in fec_ini TIMESTAMP,
																			in fec_cese TIMESTAMP)
    UPDATE empleado 
		SET id_empleado=id,
				dni=dn,
				nombre=nom,
				apellido=ape,
				direccion=dir,
				fec_nacimiento=fec_nac,
				id_cargo=id_carg,
				id_tienda=id_tien,
				remuneracion=remu,
				fec_inicio=fec_ini,
				fec_cese=fec_cese
    WHERE id_empleado=id;

CREATE PROCEDURE sp_buscar_empleado(in id int(4))
    select * from empleado where id_empleado=id;

CREATE PROCEDURE sp_listar_empleado()
    select * from empleado;

-- LIBRO --
CREATE PROCEDURE sp_insertar_libro(in tit VARCHAR(50),in gen VARCHAR(20),in id_pub int(4),in id_au int(4),
																	 in precio double, in fec_pub TIMESTAMP, in num_pg int(5), in pais_pub varchar(30),in stoc int(10))
    INSERT INTO libro values(NULL,tit,gen,id_pub,id_au,precio,fec_pub,num_pg,pais_pub,stoc);

CREATE PROCEDURE sp_actualizar_libro(in id int(4),in tit VARCHAR(50),in gen VARCHAR(20),in id_pub int(4),in id_au int(4),
																	 in prec double, in fec_pub TIMESTAMP, in num_pg int(5),in pais_pub varchar(30),in stoc int(10))
    UPDATE libro 
		SET id_libro=id,
				titulo=tit,
				genero=gen,
				id_publicador=id_pub,
				id_autor=id_au,
				precio=prec,
				fec_publicacion=fec_pub,
				num_paginas=num_pg,
				pais_publicacion=pais_pub
				stock=stoc
    WHERE id_libro=id;

CREATE PROCEDURE sp_buscar_libro(in id int(4))
    select * from libro where id_libro=id;

CREATE PROCEDURE sp_listar_libro()
    select * from libro;

-- PUBLICADOR --
CREATE PROCEDURE sp_insertar_publicador(in rc char(11),in raz_so VARCHAR(60),in telef int(9))
    INSERT INTO publicador values(NULL,rc,raz_so,telef);

CREATE PROCEDURE sp_actualizar_publicador(in id int(4),in rc char(11),in raz_so VARCHAR(60),in telef int(9))
    UPDATE publicador 
		SET id_publicador=id,
				ruc=rc,
				raz_social=raz_so,
				telefono=telef
    WHERE id_publicador=id;

CREATE PROCEDURE sp_buscar_publicador(in id int(4))
    select * from publicador where id_publicador=id;

CREATE PROCEDURE sp_listar_publicador()
    select * from publicador;

-- BOLETA --
CREATE PROCEDURE sp_insertar_boleta(in fec TIMESTAMP,in dni_cli VARCHAR(8),in id_emp int(4))
    INSERT INTO boleta values(NULL,fec,dni_cli,id_emp);

CREATE PROCEDURE sp_actualizar_boleta(in id int(4),in fec TIMESTAMP,in dni_cli VARCHAR(8),in id_emp int(4))
    UPDATE boleta 
		SET id_boleta=id,
				fecha=fec,
				dni_cliente=dni_cli,
				id_empleado=id_emp
    WHERE id_boleta=id;

CREATE PROCEDURE sp_buscar_boleta(in id int(4))
    select * from boleta where id_boleta=id;

CREATE PROCEDURE sp_listar_boleta()
    select * from boleta;

-- DETALLE BOLETA --
CREATE PROCEDURE sp_insertar_boleta_detalle(in id_tien int(4),in id_lib int(4),in cant int(11), in precio_tot double)
    INSERT INTO boleta_detalle values(NULL,id_tien,id_lib,cant,precio_tot);

CREATE PROCEDURE sp_actualizar_boleta_detalle(in id int(4),in id_tien int(4),in id_lib int(4),in cant int(11), in precio_tot double)
    UPDATE boleta_detalle
		SET id_boleta=id,
				id_tienda=id_tien,
				id_libro=id_lib,
				cantidad=cant,
				precio_total=precio_tot
    WHERE id_boleta=id;

CREATE PROCEDURE sp_buscar_boleta_detalle(in id int(4))
    select * from boleta_detalle where id_boleta=id;

CREATE PROCEDURE sp_listar_boleta_detalle()
    select * from boleta_detalle;