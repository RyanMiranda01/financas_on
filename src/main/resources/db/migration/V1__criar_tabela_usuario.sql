CREATE table usuario(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(150) not null,
    senha varchar(20) not null,
    data_criacao DATE not null,

        primary key(id)

)