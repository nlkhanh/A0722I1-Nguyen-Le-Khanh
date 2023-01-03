use m3_case_study_database;
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dvdk.ten_dich_vu_di_kem
from khach_hang kh
inner join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
inner join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
inner join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
inner join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
where ten_loai_khach = 'Diamond' and (dia_chi like '%Vinh%' or dia_chi like '%Quảng Ngãi%');