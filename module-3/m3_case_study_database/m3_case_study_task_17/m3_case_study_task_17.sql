use m3_case_study_database;
update khach_hang 
set ma_loai_khach = (select ma_loai_khach from loai_khach where ten_loai_khach like 'Diamond')
where 
	ma_loai_khach = (select ma_loai_khach from loai_khach where ten_loai_khach like 'Platinium') and 
    ma_khach_hang in (select tong_tien_theo_hop_dong.ma_khach_hang from
							(select ma_khach_hang, if (hop_dong_chi_tiet.ma_hop_dong is null, dich_vu.chi_phi_thue, dich_vu.chi_phi_thue + sum(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia)) as tong_tien_hop_dong
							from khach_hang 
							inner join loai_khach using(ma_loai_khach) 
							inner join hop_dong using(ma_khach_hang) 
							inner join dich_vu using (ma_dich_vu)
							left join hop_dong_chi_tiet using (ma_hop_dong)
							left join dich_vu_di_kem using (ma_dich_vu_di_kem)
							where year(hop_dong.ngay_lam_hop_dong) = 2021
							group by khach_hang.ma_khach_hang, hop_dong.ma_hop_dong) as tong_tien_theo_hop_dong
						group by tong_tien_theo_hop_dong.ma_khach_hang
						having sum(tong_tien_theo_hop_dong.tong_tien_hop_dong) > 10000000);