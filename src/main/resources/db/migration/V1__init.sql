create table if not exists spectacles
(
    id          bigint not null
        constraint spectacles_pkey primary key,
    static_id   varchar(255),
    "name"      varchar(255),
    subject     varchar,
    country     varchar(255),
    city        varchar(255),
    place       varchar,
    address     varchar,
    description varchar,
    year        varchar(255)
);

create table if not exists photos
(
    id           bigint not null
        constraint photos_pkey primary key,
    url          varchar,
    spectacle_id bigint
        constraint photos_spectacles_id_fk references spectacles (id)
);

create table if not exists videos
(
    id           bigint not null
        constraint videos_pkey primary key,
    url          varchar,
    spectacle_id bigint
        constraint videos_spectacles_id_fk references spectacles (id)
);

create table if not exists audios
(
    id           bigint not null
        constraint audios_pkey primary key,
    url          varchar,
    spectacle_id bigint
        constraint audios_spectacles_id_fk references spectacles (id)
);

create table if not exists markers
(
    id           bigint not null
        constraint markers_pkey primary key,
    "order"      int,
    lat          double precision,
    lng          double precision,
    spectacle_id bigint
        constraint markers_spectacles_id_fk references spectacles (id)
);
