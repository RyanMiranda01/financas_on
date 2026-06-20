CREATE table transicoes(

    id bigint not null auto_increment,
    descricao varchar(255) not null,
    valor DECIMAL(10, 2) not null,
    tipo varchar(100) not null,
    data DATE not null,
    usuario_id bigint not null,
    categoria_id bigint not null,

     primary key(id),


   constraint fk_transicoes_usuario
              foreign key(usuario_id)
              references usuario(id),

   constraint fk_transicoes_categorias
              foreign key(categoria_id)
              references categorias(id)

)