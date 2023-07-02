/* 
insert example data for previously created tables
*/


-- medical personal
insert into medical_personal values(100, 'John Doe');
insert into medical_personal values(101, 'Jane Doe');
insert into medical_personal values(102, 'Peter Smith');
insert into medical_personal values(103, 'Mary Miller');

-- surgery
insert into surgery values(9900, 'Open Heart Surgery', 5000);
insert into surgery values(9901, 'Appendectomy', 5004);
insert into surgery values(9902, 'Cholecystectomy', 5010);
insert into surgery values(9903, 'Meniscus Transplant', 5004);
insert into surgery values(9904, 'vision-corrective laser surgery', 5030);
insert into surgery values(9905, 'Appendectomy', 5013);
insert into surgery values(9906, 'Cholecystectomy', 5012);
insert into surgery values(9907, 'Meniscus Transplant', 5002);

-- surgery material
insert into surgery_material values(10000, 100, 9900, 3, 9, 3, 8, 16);
insert into surgery_material values(10001, 100, 9901, 2, 5, 5, 10, 18);
insert into surgery_material values(10002, 102, 9902, 1, 0, 2, 4, 10);

-- surgery instruments
insert into surgery_instrument values(1000, 100, 9900, 2, 2, 0, 3);
insert into surgery_instrument values(1001, 100, 9901, 1, 1, 2, 1);
insert into surgery_instrument values(1002, 102, 9902, 1, 0, 2, 4);

