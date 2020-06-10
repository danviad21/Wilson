insert into cliente (id_cliente, nombre_cliente) values(1,'OSCAR DAVID');
insert into cliente (id_cliente, nombre_cliente) values(2,'DAVID TIZOL');


insert into `usuario` (id_usuario, username,password,enabled) values (1, 'OSCAR','$2a$10$svJ0hq/xdIlFpxBATzYlo.19DkNVBZ6CtIjlzdnlhZO0yy4RAVGm2',1);
insert into `usuario` (id_usuario, username,password,enabled) values (2, 'DAVID','$2a$10$.I0WZ8qFpcBM8zD5b8PlyuPeT3tvgWoFTWh.rS11IRjqv1YjPb/J.',1);

insert into `rol` (id_rol,descripcion) values (1,'ROLE_USER');
insert into `rol` (id_rol,descripcion) values (2,'ROLE_ADMIN');

insert into `users_authorities` (id_usuario,id_rol) values(1,1);
insert into `users_authorities` (id_usuario,id_rol) values(2,2);
insert into `users_authorities` (id_usuario,id_rol) values(2,1);

