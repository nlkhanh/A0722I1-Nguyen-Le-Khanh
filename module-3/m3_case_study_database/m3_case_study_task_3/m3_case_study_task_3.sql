use m3_case_study_database;
select * 
from khach_hang
where (timestampdiff(year,ngay_sinh, now()) between 18 and 50) and (dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');