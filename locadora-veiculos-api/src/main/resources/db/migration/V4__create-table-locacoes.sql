create table locacoes(
    id bigint not null auto_increment,
    data datetime not null,
    locatario_id bigint not null,
    veiculo_id bigint not null,
    status varchar(100) not null,
    justificativa_status varchar(255),
    primary key(id),
    constraint fk_locacoes_locatario_id foreign key(locatario_id) references locatarios(id),
    constraint fk_locacoes_veiculo_id foreign key(veiculo_id) references veiculos(id)
);