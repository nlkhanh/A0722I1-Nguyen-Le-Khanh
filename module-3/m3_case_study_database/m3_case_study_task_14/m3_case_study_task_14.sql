use m3_case_study_database;
select hdct.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, hdct.ma_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong_chi_tiet hdct
inner join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
inner join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
inner join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where hdct.ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from hop_dong_chi_tiet group by ma_dich_vu_di_kem having count(ma_dich_vu_di_kem) = 1)
group by hdct.ma_dich_vu_di_kem, hdct.ma_hop_dong
order by hdct.ma_hop_dong;