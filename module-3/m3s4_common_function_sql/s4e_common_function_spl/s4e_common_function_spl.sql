use s2p_student_management;
select *
from `subject`
order by credit desc
limit 1;
select m.sub_id, mark, sub_name, credit, `status`
from mark m
inner join `subject` s on m.sub_id = s.sub_id
order by mark desc
limit 1;
select s.student_id, student_name, address, phone, `status`, class_id, avg(mark) as average_mark
from student s
inner join mark m on s.student_id = m.student_id
group by m.student_id
order by average_mark desc;