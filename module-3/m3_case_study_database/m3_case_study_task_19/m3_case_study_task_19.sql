use m3_case_study_database;
update 
dich_vu_di_kem, 
(select ma_dich_vu_di_kem, sum(so_luong) 
from hop_dong_chi_tiet 
inner join hop_dong using(ma_hop_dong) 
where year(ngay_lam_hop_dong) = 2020 
group by ma_dich_vu_di_kem 
having sum(so_luong) > 10) as temp 
set dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem = temp.ma_dich_vu_di_kem;