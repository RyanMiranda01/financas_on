CREATE table categorias(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    tipo varchar(100) not null,
    usuario_id bigint not null,

    primary key(id),

       constraint fk_categoria_usuario
              foreign key(usuario_id)
              references usuario(id)

)