

---INSERINDO DADOS NA TABELA TB_PRODUTO---

INSERT INTO tb_cliente (nome, cnpj, contato, telefone, email) VALUES ('Alpha Tech Solutions', '12.345.678/0001-10', 'Ana Costa', '(11) 98888-0001', 'ana@alphatech.com');
INSERT INTO tb_cliente (nome, cnpj, contato, telefone, email) VALUES ('Beta Engenharia', '23.456.789/0001-20', 'Carlos Lima', '(21) 97777-0002', 'carlos@betaeng.com');
INSERT INTO tb_cliente (nome, cnpj, contato, telefone, email) VALUES ('Gamma Construções', '34.567.890/0001-30', 'Marina Souza', '(31) 96666-0003', 'marina@gammaconst.com');
INSERT INTO tb_cliente (nome, cnpj, contato, telefone, email) VALUES ('Delta Projetos', '45.678.901/0001-40', 'Paulo Mendes', '(41) 95555-0004', 'paulo@deltaproj.com');
INSERT INTO tb_cliente (nome, cnpj, contato, telefone, email) VALUES ('Epsilon Instalações', '56.789.012/0001-50', 'Fernanda Rocha', '(51) 94444-0005', 'fernanda@epsilon.com');

---INSERINDO DADOS NA TABELA TB-CLIENTE---

INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa A', '00.000.000/0001-01', 'João Silva', 'contato@empresaA.com', '(11) 99999-0001');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa B', '00.000.000/0001-02', 'Maria Oliveira', 'contato@empresaB.com', '(11) 99999-0002');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa C', '00.000.000/0001-03', 'Carlos Souza', 'contato@empresaC.com', '(11) 99999-0003');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa D', '00.000.000/0001-04', 'Ana Costa', 'contato@empresaD.com', '(11) 99999-0004');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa E', '00.000.000/0001-05', 'Pedro Lima', 'contato@empresaE.com', '(11) 99999-0005');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa F', '00.000.000/0001-06', 'Luciana Rocha', 'contato@empresaF.com', '(11) 99999-0006');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa G', '00.000.000/0001-07', 'Felipe Martins', 'contato@empresaG.com', '(11) 99999-0007');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa H', '00.000.000/0001-08', 'Camila Barbosa', 'contato@empresaH.com', '(11) 99999-0008');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa I', '00.000.000/0001-09', 'Thiago Almeida', 'contato@empresaI.com', '(11) 99999-0009');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa J', '00.000.000/0001-10', 'Juliana Melo', 'contato@empresaJ.com', '(11) 99999-0010');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa K', '00.000.000/0001-11', 'Bruno Fernandes', 'contato@empresaK.com', '(11) 99999-0011');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa L', '00.000.000/0001-12', 'Paula Reis', 'contato@empresaL.com', '(11) 99999-0012');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa M', '00.000.000/0001-13', 'Renato Cunha', 'contato@empresaM.com', '(11) 99999-0013');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa N', '00.000.000/0001-14', 'Simone Teixeira', 'contato@empresaN.com', '(11) 99999-0014');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa O', '00.000.000/0001-15', 'Gustavo Lopes', 'contato@empresaO.com', '(11) 99999-0015');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa P', '00.000.000/0001-16', 'Fernanda Dias', 'contato@empresaP.com', '(11) 99999-0016');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa Q', '00.000.000/0001-17', 'Daniel Vieira', 'contato@empresaQ.com', '(11) 99999-0017');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa R', '00.000.000/0001-18', 'Patrícia Moura', 'contato@empresaR.com', '(11) 99999-0018');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa S', '00.000.000/0001-19', 'Leonardo Nunes', 'contato@empresaS.com', '(11) 99999-0019');
INSERT INTO tb_cliente (NOME, CNPJ, CONTATO, EMAIL, TELEFONE) VALUES ('Empresa T', '00.000.000/0001-20', 'Adriana Gomes', 'contato@empresaT.com', '(11) 99999-0020');

--INSERINDO DADOS NA TABELA TB_PROJETO---

INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, quantidade, observacao, PRJ_DATA) VALUES (1001, 'Projeto Segurança Industrial', 'Segurança', 'Rua A, 123', 1, 10, 'Projeto piloto para teste de sensores', '2024-12-01');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, quantidade, observacao, PRJ_DATA) VALUES (1002, 'Sistema de Monitoramento Remoto', 'Tecnologia', 'Av. Central, 456', 1, 8, 'Cliente solicitou câmera com acesso via app', '2024-12-15');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, quantidade, observacao, PRJ_DATA) VALUES (1003, 'Controle de Acesso', 'Automação', 'Rua do Comércio, 89', 1, 5, 'Instalação de leitor biométrico', '2025-01-10');


