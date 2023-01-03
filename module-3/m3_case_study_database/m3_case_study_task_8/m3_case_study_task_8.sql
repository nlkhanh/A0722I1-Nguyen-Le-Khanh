use m3_case_study_database;
-- Cách 1:
select ho_ten from khach_hang group by ho_ten;
-- Cách 2:
select ho_ten from khach_hang union select ho_ten from khach_hang;
-- Cách 3:
select distinct ho_ten from khach_hang;