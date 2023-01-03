use m3_case_study_database;
select hd.ma_hop_dong, nv.ho_ten as ho_ten_nv, kh.ho_ten as ho_ten_kh, kh.so_dien_thoai, dv.ten_dich_vu, 
if(hdct.ma_hop_dong is null, 0, sum(hdct.so_luong)) as so_luong_dich_vu_di_kem, hd.tien_dat_coc
from hop_dong hd
inner join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
inner join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
inner join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
where (year(hd.ngay_lam_hop_dong) = 2020) and (month(hd.ngay_lam_hop_dong) in (10, 11, 12))
and dv.ma_dich_vu not in 
(select dv.ma_dich_vu
from hop_dong hd
inner join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
inner join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
inner join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
where (year(hd.ngay_lam_hop_dong) = 2021) and (month(hd.ngay_lam_hop_dong) between 1 and 6))
group by hd.ma_hop_dong;