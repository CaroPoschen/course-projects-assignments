/* 
if tables exist already, drop all for a fresh start

drop view overviewInstrument;
drop view overviewMaterial;

drop table surgery_material;
drop table surgery_instrument;
drop table medical_personal;
drop table surgery;
*/


/* Create Tables */

create table medical_personal (
    person_id integer,
    person_name varchar(50) not null,
    constraint m_p_pk primary key (person_id)
);

create table surgery (
    surgery_id integer,
    surgery_name varchar(50),
    patient_id integer not null,
    constraint surgery_pk primary key (surgery_id)
);

create table surgery_material (
    s_m_id integer,
    person integer not null,
    surgery integer not null unique,
    swab integer,
    bandage integer,
    sutureMaterial integer,
    surgicalMask integer,
    surgicalGlove integer,
    constraint s_m_pk primary key (s_m_id),
    constraint m_person foreign key (person) references medical_personal (person_id),
    constraint mat_surg foreign key (surgery) references surgery (surgery_id),
    constraint swab0 check (swab >= 0),
    constraint bandage0 check (bandage >=0),
    constraint sutureMaterial0 check (sutureMaterial>=0),
    constraint surgicalMask0 check (surgicalMask>=0),
    constraint surgicalGlove0 check (surgicalGlove>=0)
);

create table surgery_instrument (
    s_i_id integer,
    person integer not null,
    surgery integer not null unique,
    scalpel integer,
    scissors integer,
    clamps integer,
    surgicalTweezer integer,
    constraint s_i_pk primary key (s_i_id),
    constraint si_m_person foreign key (person) references medical_personal (person_id),
    constraint ins_surg foreign key (surgery) references surgery (surgery_id),
    constraint scalpel0 check (scalpel>=0),
    constraint scissors0 check (scissors>=0),
    constraint clamps0 check (clamps>=0),
    constraint surgicalTweezer0 check (surgicalTweezer>=0)
);

/* Views containing the total amount of materials and instruments used so far */

create view overviewMaterial as
select sum(swab)  SWAP, sum(bandage) bandage, sum(sutureMaterial) sutureMaterial, 
    sum(surgicalMask) surgicalMask, sum(surgicalGlove) surgicalGlove, count(*) numberSurgeries
from surgery_material;

create view overviewInstrument as
select sum(scalpel) scalpel, sum(scissors) scissors, sum(clamps) clamps, sum(surgicalTweezer) surgicalTweezer, count(*) numberSurgeries
from surgery_instrument;

