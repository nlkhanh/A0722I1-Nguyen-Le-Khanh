use m3_case_study_database;
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
left join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
left join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu and hd.ma_dich_vu 
where dv.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where year(hop_dong.ngay_lam_hop_dong) = 2021 and month(hop_dong.ngay_lam_hop_dong) in (1, 2, 3))
group by dv.ma_dich_vu;