use m3_case_study_database;
create view v_nhan_vien as
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.ngay_sinh, nhan_vien.so_cmnd, 
		nhan_vien.luong, nhan_vien.so_dien_thoai, nhan_vien.email, nhan_vien.dia_chi, 
        nhan_vien.ma_vi_tri, nhan_vien.ma_trinh_do, nhan_vien.ma_bo_phan
from nhan_vien
inner join hop_dong using(ma_nhan_vien)
where nhan_vien.dia_chi like '%Hải Châu%' and hop_dong.ngay_lam_hop_dong like '12/12/2019';