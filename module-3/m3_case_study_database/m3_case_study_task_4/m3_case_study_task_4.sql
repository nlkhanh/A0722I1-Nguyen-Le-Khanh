use m3_case_study_database;
select khach_hang.ma_khach_hang, ho_ten, count(ma_hop_dong) as so_lan_dat_phong
from khach_hang
inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where ten_loai_khach like 'Diamond'
group by hop_dong.ma_khach_hang
order by so_lan_dat_phong asc;
