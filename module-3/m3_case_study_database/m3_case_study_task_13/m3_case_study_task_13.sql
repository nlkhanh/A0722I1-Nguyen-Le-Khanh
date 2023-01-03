use m3_case_study_database;
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_lan_su_dung
from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having so_lan_su_dung = (select max(temp.so_luong_toi_da) from (select sum(hdct.so_luong) as so_luong_toi_da from hop_dong_chi_tiet hdct group by hdct.ma_dich_vu_di_kem) as temp);