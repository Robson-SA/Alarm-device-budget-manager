

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

INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1001, 'Projeto Segurança Industrial', 'Segurança', 'Rua A, 123', 1, '2024-12-01');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1002, 'Sistema de Monitoramento Remoto', 'Tecnologia', 'Av. Central, 456', 1, '2024-12-15');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1003, 'Controle de Acesso', 'Automação', 'Rua do Comércio, 89', 1, '2025-01-10');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1004, 'Sistema de Iluminação', 'Elétrica', 'Rua das Laranjeiras, 200', 2, '2025-02-15');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1005, 'CFTV Empresarial', 'Segurança', 'Avenida Central, 1200', 3, '2025-03-01');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1006, 'Sistema de Incêndio', 'Prevenção', 'Rua Nova, 45', 1, '2025-03-22');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1007, 'Integração de Alarmes', 'Automação', 'Travessa da Paz, 18', 2, '2025-04-05');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1008, 'Portaria Remota', 'Tecnologia', 'Alameda Azul, 77', 4, '2025-04-12');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1009, 'Monitoramento 24h', 'Segurança', 'Rua Verde, 88', 3, '2025-04-20');
INSERT INTO tb_projeto (PRJ_NUMERO, PRJ_NOME, PRJ_AREA, endereco, cliente_id, PRJ_DATA) VALUES (1010, 'Controle de Clima', 'Automação', 'Rua das Árvores, 99', 5, '2025-04-25');

--INSERIDO DADOS NA TABELA TB_PRODUTO---

INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210011', 'Sensor de movimento infravermelho');
INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210012', 'Sirene com luz estroboscópica');
INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210013', 'Detector de fumaça sem fio');
INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210014', 'Painel de alarme digital');
INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210015', 'Controle remoto para alarme');
INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210016', 'Módulo GSM para alarme');
INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210017', 'Sensor de abertura magnético');
INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210018', 'Câmera IP com infravermelho');
INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210019', 'Fonte de alimentação 12V');
INSERT INTO tb_produto (PRO_COD, PRO_NOME) VALUES ('210020', 'Teclado de acesso touch');

--- INSERINDO DADOS NA TABELA TB_ITEM_PROJETO----

INSERT INTO tb_item_projeto (quantidade, produto_id, projeto_id, observacao) VALUES (10, 1, 1, 'Observação A');
INSERT INTO tb_item_projeto (quantidade, produto_id, projeto_id, observacao) VALUES (15, 2, 1, 'Observação B');
INSERT INTO tb_item_projeto (quantidade, produto_id, projeto_id, observacao) VALUES (20, 1, 2, 'Observação C');
INSERT INTO tb_item_projeto (quantidade, produto_id, projeto_id, observacao) VALUES (8, 3, 2, 'Observação D');
INSERT INTO tb_item_projeto (quantidade, produto_id, projeto_id, observacao) VALUES (12, 2, 3, 'Observação E');
INSERT INTO tb_item_projeto (quantidade, produto_id, projeto_id, observacao) VALUES (5, 3, 1, 'Observação F');

