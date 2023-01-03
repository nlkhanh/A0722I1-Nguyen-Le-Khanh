use m3_case_study_database;
select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
from nhan_vien nv
inner join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do
inner join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
where nv.ma_nhan_vien in (select ma_nhan_vien from hop_dong where year(ngay_lam_hop_dong) in (2020, 2021) group by ma_nhan_vien having count(ma_hop_dong) <= 3)