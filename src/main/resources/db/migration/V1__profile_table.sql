create table profile
(
    id          varchar          not null
        constraint profile_pk
            primary key,
    email       varchar          not null,
    height      double precision not null,
    sugar_level double precision
);