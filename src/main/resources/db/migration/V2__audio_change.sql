alter table if exists audios
    add column name varchar;

alter table if exists audios
    add column type varchar;

alter table if exists audios
    add column duration bigint;
