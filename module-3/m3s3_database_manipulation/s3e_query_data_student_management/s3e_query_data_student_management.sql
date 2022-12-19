use s2p_student_management;
select *
from student
where student_name like 'h%';
select *
from class
where month(start_date) = 12;
select *
from `subject`
where credit between 3 and 5;
update student
set class_id = 2
where student_id = 1;
select student_name, sub_name, mark
from student
inner join mark on student.student_id = mark.student_id
inner join `subject` on mark.sub_id = `subject`.sub_id
order by mark desc, student_name;