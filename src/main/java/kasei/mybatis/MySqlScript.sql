
create table mybatis_student(
	id int(2),
    name varchar(20),
    teacher_id int(2),
    constraint student_pk primary key(id)
);
INSERT INTO `kaseidb`.`mybatis_student` (`id`, `name`, `teacher_id`) VALUES ('1', 'Miku', '1');
INSERT INTO `kaseidb`.`mybatis_student` (`id`, `name`, `teacher_id`) VALUES ('2', 'Haku', '1');
INSERT INTO `kaseidb`.`mybatis_student` (`id`, `name`, `teacher_id`) VALUES ('3', 'Luka', '1');


create table mybatis_teacher(
	id int(2),
    name varchar(20),
    constraint teacher_pk primary key(id)
);
INSERT INTO `kaseidb`.`mybatis_teacher` (`id`, `name`) VALUES ('1', 'Kasei');
