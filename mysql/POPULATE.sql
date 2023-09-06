-- POPULATE

-- SERVIÇOS
INSERT INTO servicos (categoria, descricao, nome) 
VALUES 
    ('Limpeza', 'Serviço de limpeza residencial', 'Limpeza Residencial'),
    ('Treinamento', 'Treinamento corporativo em liderança', 'Treinamento em Liderança'),
    ('Saúde', 'Consulta médica de clínico geral', 'Consulta Clínico Geral'),
    ('Desenvolvimento', 'Desenvolvimento de aplicativo móvel', 'Desenvolvimento de App'),
    ('Design', 'Design de logotipo para empresas', 'Design de Logotipo'),
    ('Limpeza', 'Limpeza de escritórios comerciais', 'Limpeza Comercial'),
    ('Treinamento', 'Treinamento em habilidades de comunicação', 'Treinamento em Comunicação'),
    ('Saúde', 'Sessão de fisioterapia para reabilitação', 'Fisioterapia de Reabilitação'),
    ('Desenvolvimento', 'Desenvolvimento de site institucional', 'Desenvolvimento de Site Institucional'),
    ('Design', 'Design de interface de usuário para aplicativos', 'Design de Interface de Aplicativo');

-- NOVOS SERVIÇOS:
INSERT INTO servicos (categoria, descricao, nome) 
VALUES 
    ('Limpeza', 'Serviço de limpeza residencial', 'Limpeza Residencial Novo'),
    ('Treinamento', 'Treinamento corporativo em liderança', 'Treinamento em Liderança Novo'),
    ('Saúde', 'Consulta médica de clínico geral', 'Consulta Clínico Geral Novo'),
    ('Desenvolvimento', 'Desenvolvimento de aplicativo móvel', 'Desenvolvimento de App Novo'),
    ('Design', 'Design de logotipo para empresas', 'Design de Logotipo Novo'),
    ('Limpeza', 'Limpeza de escritórios comerciais', 'Limpeza Comercial Novo'),
    ('Treinamento', 'Treinamento em habilidades de comunicação', 'Treinamento em Comunicação Novo'),
    ('Saúde', 'Sessão de fisioterapia para reabilitação', 'Fisioterapia de Reabilitação Novo'),
    ('Desenvolvimento', 'Desenvolvimento de site institucional', 'Desenvolvimento de Site Institucional Novo'),
    ('Design', 'Design de interface de usuário para aplicativos', 'Design de Interface de Aplicativo Novo'),
    ('Limpeza', 'Limpeza de carpetes residenciais', 'Limpeza de Carpetes Residenciais Novo'),
    ('Treinamento', 'Treinamento em gestão de projetos', 'Treinamento em Gestão de Projetos Novo'),
    ('Saúde', 'Consulta médica de pediatria', 'Consulta Pediátrica Novo'),
    ('Desenvolvimento', 'Desenvolvimento de software personalizado', 'Desenvolvimento de Software Personalizado Novo'),
    ('Design', 'Design de embalagens para produtos', 'Design de Embalagens Novo'),
    ('Limpeza', 'Limpeza de janelas de arranha-céus', 'Limpeza de Janelas em Arranha-céus Novo'),
    ('Treinamento', 'Treinamento em atendimento ao cliente', 'Treinamento em Atendimento ao Cliente Novo'),
    ('Saúde', 'Terapia ocupacional para crianças', 'Terapia Ocupacional Infantil Novo'),
    ('Desenvolvimento', 'Desenvolvimento de jogos para dispositivos móveis', 'Desenvolvimento de Jogos Móveis Novo'),
    ('Design', 'Design de site de comércio eletrônico', 'Design de Site de E-Commerce Novo');


-- CLIENTES
INSERT INTO usuarios (nome, email, senha, habilitado, perfil, dtype)
VALUES
    ('Cliente 1', 'cliente1@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente"),
    ('Cliente 2', 'cliente2@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente"),
    ('Cliente 3', 'cliente3@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente"),
    ('Cliente 4', 'cliente4@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente"),
    ('Cliente 5', 'cliente5@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente"),
    ('Cliente 6', 'cliente6@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente"),
    ('Cliente 7', 'cliente7@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente"),
    ('Cliente 8', 'cliente8@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente"),
    ('Cliente 9', 'cliente9@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente"),
    ('Cliente 10', 'cliente10@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "CLIENTE", "Cliente");
    
-- PRESTADORES
INSERT INTO usuarios (nome, email, senha, habilitado, perfil, dtype)
VALUES
    ('Prestador 1', 'prestador1@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador"),
    ('Prestador 2', 'prestador2@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador"),
    ('Prestador 3', 'prestador3@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador"),
    ('Prestador 4', 'prestador4@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador"),
    ('Prestador 5', 'prestador5@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador"),
    ('Prestador 6', 'prestador6@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador"),
    ('Prestador 7', 'prestador7@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador"),
    ('Prestador 8', 'prestador8@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador"),
    ('Prestador 9', 'prestador9@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador"),
    ('Prestador 10', 'prestador10@example.com', "$2a$10$r3r9V682sIhE/61jZjqkauT.08pxrBx.GE1T.yEogN5r8Ly2S8eTK", 1, "PRESTADOR", "Prestador");
    
-- PRESTADORES RELACIONADOS COM SERVIÇOS
INSERT INTO prestadores_servicos (prestador_id, servico_id)
VALUES
    (13, 1),
    (14, 1),
    (13, 2),
    (14, 2),
    (13, 3),
    (14, 3),
    (13, 4),
    (14, 4),
    (13, 5),
    (14, 5),
    (13, 6),
    (14, 6),
    (13, 7),
    (14, 7),
    (13, 8),
    (14, 8),
    (13, 9),
    (14, 9),
    (13, 10),
    (14, 10),
    (13, 11),
    (14, 11),
    (13, 12),
    (14, 12),
    (13, 13),
    (14, 13),
    (13, 14),
    (14, 14),
    (13, 15),
    (14, 15),
    (13, 16),
    (14, 16),
    (13, 17),
    (14, 17),
    (13, 18),
    (14, 18),
    (13, 19),
    (14, 19),
    (13, 20),
    (14, 20),
    (13, 21),
    (14, 21),
    (13, 22),
    (14, 22);
    
    -- Continuação da inserção dos valores
INSERT INTO prestadores_servicos (prestador_id, servico_id)
VALUES
    (15, 1),
    (16, 1),
    (15, 2),
    (16, 2),
    (15, 3),
    (16, 3),
    (15, 4),
    (16, 4),
    (15, 5),
    (16, 5),
    (15, 6),
    (16, 6),
    (15, 7),
    (16, 7),
    (15, 8),
    (16, 8),
    (15, 9),
    (16, 9),
    (15, 10),
    (16, 10),
    (15, 11),
    (16, 11),
    (15, 12),
    (16, 12),
    (15, 13),
    (16, 13),
    (15, 14),
    (16, 14),
    (15, 15),
    (16, 15),
    (15, 16),
    (16, 16),
    (15, 17),
    (16, 17),
    (15, 18),
    (16, 18),
    (15, 19),
    (16, 19),
    (15, 20),
    (16, 20),
    (15, 21),
    (16, 21),
    (15, 22),
    (16, 22);

-- Repita o mesmo padrão para prestador_id de 17 a 22
INSERT INTO prestadores_servicos (prestador_id, servico_id)
VALUES
    (17, 1),
    (18, 1),
    (17, 2),
    (18, 2),
    (17, 3),
    (18, 3),
    (17, 4),
    (18, 4),
    (17, 5),
    (18, 5),
    (17, 6),
    (18, 6),
    (17, 7),
    (18, 7),
    (17, 8),
    (18, 8),
    (17, 9),
    (18, 9),
    (17, 10),
    (18, 10),
    (17, 11),
    (18, 11),
    (17, 12),
    (18, 12),
    (17, 13),
    (18, 13),
    (17, 14),
    (18, 14),
    (17, 15),
    (18, 15),
    (17, 16),
    (18, 16),
    (17, 17),
    (18, 17),
    (17, 18),
    (18, 18),
    (17, 19),
    (18, 19),
    (17, 20),
    (18, 20),
    (17, 21),
    (18, 21),
    (17, 22),
    (18, 22);

-- CRIAÇÃO DOS ENDEREÇOS    
INSERT INTO enderecos (cidade, uf, logradouro, numero)
VALUES
    ('São Paulo', 'SP', 'Avenida Paulista', '123'),
    ('Rio de Janeiro', 'RJ', 'Rua Copacabana', '456'),
    ('Belo Horizonte', 'MG', 'Avenida Afonso Pena', '789'),
    ('Salvador', 'BA', 'Rua da Barra', '101'),
    ('Brasília', 'DF', 'Quadra 302', '34'),
    ('Curitiba', 'PR', 'Avenida Sete de Setembro', '567'),
    ('Fortaleza', 'CE', 'Avenida Beira Mar', '890'),
    ('Recife', 'PE', 'Rua do Recife', '1122'),
    ('Porto Alegre', 'RS', 'Rua da República', '1314'),
    ('Manaus', 'AM', 'Avenida das Torres', '1516'),
    ('Natal', 'RN', 'Rua Mossoró', '1718'),
    ('Vitória', 'ES', 'Avenida Beira Mar', '1920'),
    ('Goiânia', 'GO', 'Avenida T-63', '2122'),
    ('Cuiabá', 'MT', 'Rua das Flores', '2324'),
    ('Florianópolis', 'SC', 'Rua Felipe Schmidt', '2526'),
    ('João Pessoa', 'PB', 'Avenida Epitácio Pessoa', '2728'),
    ('Maceió', 'AL', 'Avenida Fernandes Lima', '2930'),
    ('Teresina', 'PI', 'Avenida Raul Lopes', '3132'),
    ('Campo Grande', 'MS', 'Avenida Afonso Pena', '3334'),
    ('Aracaju', 'SE', 'Rua João Pessoa', '3536');

-- VINCULAÇÃO DOS ENDEREÇOS COM OS USUÁRIOS
UPDATE usuarios SET endereco_id = 2 WHERE id = 2;
UPDATE usuarios SET endereco_id = 3 WHERE id = 3;
UPDATE usuarios SET endereco_id = 4 WHERE id = 4;
UPDATE usuarios SET endereco_id = 5 WHERE id = 5;
UPDATE usuarios SET endereco_id = 6 WHERE id = 6;
UPDATE usuarios SET endereco_id = 7 WHERE id = 7;
UPDATE usuarios SET endereco_id = 8 WHERE id = 8;
UPDATE usuarios SET endereco_id = 9 WHERE id = 9;
UPDATE usuarios SET endereco_id = 10 WHERE id = 10;
UPDATE usuarios SET endereco_id = 11 WHERE id = 11;
UPDATE usuarios SET endereco_id = 12 WHERE id = 12;
UPDATE usuarios SET endereco_id = 13 WHERE id = 13;
UPDATE usuarios SET endereco_id = 14 WHERE id = 14;
UPDATE usuarios SET endereco_id = 15 WHERE id = 15;
UPDATE usuarios SET endereco_id = 16 WHERE id = 16;
UPDATE usuarios SET endereco_id = 17 WHERE id = 17;
UPDATE usuarios SET endereco_id = 18 WHERE id = 18;
UPDATE usuarios SET endereco_id = 19 WHERE id = 19;
UPDATE usuarios SET endereco_id = 20 WHERE id = 20;
UPDATE usuarios SET endereco_id = 21 WHERE id = 21;

