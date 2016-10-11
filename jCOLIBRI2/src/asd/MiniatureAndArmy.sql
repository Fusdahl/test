-- create database travel;
-- use travel;
-- drop table travel;
-- Miniature mapping table: 1 - warcaster, 2 - warjack, +++++
create table miniature(miniatureId bigint not null primary key, miniatureType INTEGER, miniatureName VARCHAR(50), spd INTEGER, str INTEGER, mat INTEGER, rat INTEGER, def INTEGER, arm INTEGER, cmd INTEGER, fieldAllowance INTEGER);

insert into miniature(miniatureId, miniatureName, miniatureType, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(1, 'Haley1', 1, 10, 10, 10, 10, 10, 10, 10, 10);
insert into miniature(miniatureId, miniatureName, miniatureType, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(2, 'Haley2', 1, 10, 10, 10, 10, 10, 10, 10, 10);
insert into miniature(miniatureId, miniatureName, miniatureType, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(3, 'Haley3', 1, 10, 10, 10, 10, 10, 10, 10, 10);

--
create table army(caseId bigint not null primary key, totalPointCost INTEGER);

insert into army(caseId, totalPointCost) values(1, 20);
insert into army(caseId, totalPointCost) values(2, 30);
insert into army(caseId, totalPointCost) values(3, 40);
--
create table armyMiniatureMapping(caseId INTEGER, miniatureId INTEGER, quantity INTEGER);

insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(1, 1, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(2, 2, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(3, 3, 1);
--
create table warcaster(miniatureName VARCHAR(50), focus INTEGER, warcasterPoints INTEGER);

insert into warcaster(miniatureName, focus, warcasterPoints) values('Haley1', 7, 28);
insert into warcaster(miniatureName, focus, warcasterPoints) values('Haley2', 8, 25);
insert into warcaster(miniatureName, focus, warcasterPoints) values('Haley3', 8, 25);


