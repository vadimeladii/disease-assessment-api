create table profile
(
    id          varchar          not null
        constraint profile_pk
            primary key,
    first_name varchar not null,
    last_name varchar not null,
    email       varchar          not null,
    age int not null,
    sex int not null default 0,
    resting_BP int not null default 0,
    cholesterol int not null default 0,
    fasting_BS int not null default 0,
    max_HR int not null default 0,
    exercise_Angina int not null default 0,
    oldpeak float not null default 0,
    chest_Pain_Type_ATA int not null default 0,
    chest_Pain_Type_NAP int not null default 0,
    chest_Pain_Type_TA int not null default 0,
    resting_ECG_Normal int not null default 0,
    resting_ECG_ST int not null default 0,
    ST_Slope_Flat int not null default 0,
    ST_Slope_Up int not null default 0
);