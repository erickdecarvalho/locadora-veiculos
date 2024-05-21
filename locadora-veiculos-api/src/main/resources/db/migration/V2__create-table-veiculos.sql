create table veiculos(
    id bigint not null auto_increment,
    tipo varchar(100) not null,
    nome varchar(100) not null,
    chassi varchar(100) not null,
    ano int not null,
    cor varchar(100) not null,
    peso decimal(4,2) not null,
    locadora_id bigint not null,
    alugado boolean not null,
    primary key(id),
    constraint fk_veiculos_locadora_id foreign key(locadora_id) references locadoras(id)
);