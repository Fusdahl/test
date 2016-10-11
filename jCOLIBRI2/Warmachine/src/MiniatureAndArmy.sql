-- create database travel;
-- use travel;
-- drop table travel;
-- Miniature mapping table: 1 - warcaster, 2 - warjack, 3 - solo, 4 - unit, 5 - unitAttachment
create table miniature(miniatureId bigint not null primary key, miniatureName VARCHAR(50), miniatureType INTEGER, pointCost INTEGER, spd INTEGER, str INTEGER, mat INTEGER, rat INTEGER, def INTEGER, arm INTEGER, cmd INTEGER, fieldAllowance INTEGER);

insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(1, 'Haley1', 1, -28, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(2, 'Haley2', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(3, 'Haley3', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(4, 'Stryker1', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(5, 'Stryker2', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(6, 'Stryker3', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(7, 'Nemo1', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(8, 'Nemo2', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(9, 'Nemo3', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(10, 'Caine1', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(11, 'Caine2', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(12, 'Siege', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(13, 'Maddox', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(14, 'Blaize', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(15, 'Sturgis', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(16, 'Sloan', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(17, 'Kraye', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(18, 'Jakes', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(19, 'Darius', 1, -25, 6, 6, 6, 5, 16, 14, 9, 1);

insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(20, 'Ironclad', 2, 12, 5, 11, 7, 3, 12, 18, 8, 100);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(21, 'Stormclad', 2, 18, 5, 11, 7, 3, 12, 19, 8, 100);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(22, 'Ragman', 3, 4, 5, 11, 7, 3, 12, 19, 8, 100);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(23, 'ATGM', 4, 11, 5, 11, 7, 3, 12, 19, 8, 100);
insert into miniature(miniatureId, miniatureName, miniatureType, pointCost, spd, str, mat, rat, def, arm, cmd, fieldAllowance) values(24, 'ATGM Officer', 5, 4, 5, 11, 7, 3, 12, 19, 8, 2);
--
create table army(caseId bigint not null primary key, totalPointCost INTEGER);

insert into army(caseId, totalPointCost) values(1, 20);
insert into army(caseId, totalPointCost) values(2, 30);
insert into army(caseId, totalPointCost) values(3, 40);
insert into army(caseId, totalPointCost) values(4, 40);
insert into army(caseId, totalPointCost) values(5, 40);
insert into army(caseId, totalPointCost) values(6, 40);
insert into army(caseId, totalPointCost) values(7, 40);
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
