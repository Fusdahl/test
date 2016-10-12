-- create database travel;
-- use travel;
-- drop table travel;
-- Miniature mapping table: 1 - warcaster, 2 - warjack, 3 - solo, 4 - unit, 5 - unitAttachment
create table miniature(miniatureId bigint not null primary key, miniatureName VARCHAR(50), miniatureType INTEGER);

insert into miniature(miniatureId, miniatureName, miniatureType) values(1, 'Haley1', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(2, 'Haley2', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(3, 'Haley3', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(4, 'Stryker1', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(5, 'Stryker2', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(6, 'Stryker3', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(7, 'Nemo1', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(8, 'Nemo2', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(9, 'Nemo3', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(10, 'Caine1', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(11, 'Caine2', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(12, 'Siege', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(13, 'Maddox', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(14, 'Blaize', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(15, 'Sturgis', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(16, 'Sloan', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(17, 'Kraye', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(18, 'Jakes', 1);
insert into miniature(miniatureId, miniatureName, miniatureType) values(19, 'Darius', 1);

insert into miniature(miniatureId, miniatureName, miniatureType) values(20, 'Ironclad', 2);
insert into miniature(miniatureId, miniatureName, miniatureType) values(21, 'Stormclad', 2);
insert into miniature(miniatureId, miniatureName, miniatureType) values(22, 'Ragman', 3);
insert into miniature(miniatureId, miniatureName, miniatureType) values(23, 'ATGM', 4);
insert into miniature(miniatureId, miniatureName, miniatureType) values(24, 'ATGM Officer', 5);
--
create table army(caseId bigint not null primary key, totalPointCost INTEGER);

insert into army(caseId, totalPointCost) values(1, 0);
insert into army(caseId, totalPointCost) values(2, 0);
insert into army(caseId, totalPointCost) values(3, 0);
insert into army(caseId, totalPointCost) values(4, 0);
insert into army(caseId, totalPointCost) values(5, 0);
insert into army(caseId, totalPointCost) values(6, 0);
insert into army(caseId, totalPointCost) values(7, 0);
--
create table armyMiniatureMapping(caseId INTEGER, miniatureId INTEGER, quantity INTEGER);

insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(1, 1, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(1, 20, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(1, 21, 2);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(1, 22, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(1, 23, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(1, 24, 1);

insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(2, 2, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(2, 2, 2);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(2, 2, 3);

insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(3, 3, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(3, 20, 2);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(3, 21, 3);

insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(4, 4, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(4, 20, 2);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(4, 21, 3);

insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(5, 5, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(5, 20, 2);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(5, 21, 3);

insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(6, 6, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(6, 20, 2);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(6, 21, 3);

insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(7, 7, 1);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(7, 20, 2);
insert into armyMiniatureMapping(caseId, miniatureId, quantity) values(7, 21, 3);
