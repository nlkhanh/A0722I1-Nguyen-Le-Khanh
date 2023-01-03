use m3_case_study_database;
set foreign_key_checks = 0;
delete khach_hang, hop_dong, hop_dong_chi_tiet
from khach_hang inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where exists (select * where year(hop_dong.ngay_lam_hop_dong) < 2021);
set foreign_key_checks = 1;