use m3_case_study_database;
select month(hd.ngay_lam_hop_dong) as thang, count(kh.ma_khach_hang) as so_luong_khach_hang
from hop_dong hd 
inner join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
where year(hd.ngay_lam_hop_dong) = 2021
group by thang
order by thang;