-- INICIAIS
describe usuarios;
describe prestadores_servicos;
describe enderecos;

-- CONSULTAS
select * from usuarios;
select * from servicos;
select * from prestadores_servicos;
select * from agendamentos;
select * from enderecos;
select * from mensagens;

-- INSERT ADMIN
insert into usuarios (dtype, nome, email, perfil, senha, habilitado)
value ("Administrador", "admin", "admin@mail.com", "ADMIN", "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1); # 123456

insert into enderecos (cidade, uf, logradouro, numero) value ("São Paulo", "SP", "Rua do Dev", "42");

update usuarios set endereco_id = 1 where id = 1;

