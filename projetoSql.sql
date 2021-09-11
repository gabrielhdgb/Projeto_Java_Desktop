
--tabela pessoa

CREATE TABLE pessoa(
 idUsuario serial not null primary key,
 nome varchar(40) not null,
 cpf varchar (30) not null,
 telefone varchar(30) not null,
 email varchar(40) not null,
 senha varchar(30) not null,
 tipo int
)

--tabela produto

create table produto(
idProduto serial not null primary key,
nomeProduto varchar(40),
preco float, 
quantidade int,
idFornecedor int,
CONSTRAINT fk_produto_fornecedor FOREIGN KEY (idFornecedor)
REFERENCES fornecedor
)

--tabela pedido
create table pedido(
idPedido serial not null primary key,
dtPedido varchar(30),
formaPagamento varchar(50),
idUsuario int,
status int,
CONSTRAINT fk_pedido_pessoa FOREIGN KEY (idUsuario)
REFERENCES pessoa
)

--tabela fornecedor

create table fornecedor(
idFornecedor serial not null primary key,
nomeFornecedor varchar(30),
cidade varchar(30),
estado varchar(30)
)

--tabela vendas

create table vendas(
idProduto int,
idPedido int,
qtdProduto int,
precoVenda float,
CONSTRAINT pk_vendas PRIMARY KEY (idProduto, idPedido),
CONSTRAINT fk_vendas_produto FOREIGN KEY (idProduto) REFERENCES produto,
CONSTRAINT fk_vendas_pedido FOREIGN KEY (idPedido) REFERENCES pedido
)

select * from vendas where idPedido=3

DELETE FROM vendas WHERE idPedido = 2;


select * from pessoa
select * from produto
select * from pedido
select * from fornecedor
select * from vendas;




