drop table if exists t_student;
drop table if exists t_class;
create table t_class(
	classno int primary key,
	classname varchar(255)
);
create table t_student(
	no int primary key auto_increment,
	name varchar(255),
	cno int,
	foreign key(cno) references t_class(classno)
);

insert into t_class(classno,classname) values(100,'class one');
insert into t_class(classno,classname) values(101,'class two');

insert into t_student(name,cno) values('t1',100);
insert into t_student(name,cno) values('t2',100);
insert into t_student(name,cno) values('t3',101);
insert into t_student(name,cno) values('t4',101);

select * from t_student;
select * from t_class;