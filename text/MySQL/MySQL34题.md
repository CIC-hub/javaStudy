##### 1、取得每个部门最高薪水的人员名称

```mysql
select max(sal) from emp group by deptno;
select ename,deptno,sal from emp where sal in (select max(sal) from emp group by deptno) ;

select e.ename,d.dname,e.sal from emp e join dept d on e.deptno = d.deptno where e.sal in (select max(sal) from emp group by deptno);
```

```mysql
select deptno,max(sal) maxsal from emp group by deptno;
select e.ename,e.deptno,t.maxsal from emp e join (select deptno,max(sal) maxsal from emp group by deptno) t on e.deptno=t.deptno and e.sal=t.maxsal;
```



##### 2、哪些人的薪水在部门的平均薪水之上

```mysql
select deptno,avg(sal) avgsal from emp group by deptno;

select e.ename,e.sal,e.deptno from emp e join (select deptno,avg(sal) avgsal from emp group by deptno) t on (e.deptno=t.deptno) and (e.sal>t.avgsal);
```



##### 3、取得部门中（所有人的）平均的薪水等级

```mysql
select deptno,avg(sal) avgsal from emp group by deptno;

select t.deptno,s.grade from (select deptno,avg(sal) avgsal from emp group by deptno) t join salgrade s on t.avgsal between s.losal and s.hisal;
```

```mysql
select e.ename,e.deptno,s.grade from emp e join salgrade s on e.sal between s.losal and hisal;

select e.deptno,avg(s.grade) from emp e join salgrade s on e.sal between s.losal and hisal group by e.deptno;
```



##### 4、不准用组函数（Max ），取得最高薪水

```mysql
select sal from emp group by sal order by sal desc limit 0,1;
```

```mysql
select sal from emp group by sal order by sal desc limit 1;
```



```mysql
//表的自连接
select distinct a.sal from emp a join emp b on a.sal<b.sal;

select sal from emp where sal not in(select distinct a.sal from emp a join emp b on a.sal<b.sal);
```



##### 5、取得平均薪水最高的部门的部门编号

```mysql
select deptno,avg(sal) avgsal from emp group by deptno;

select deptno from (select deptno,avg(sal) avgsal from emp group by deptno) t order by avgsal desc limit 0,1;
```

```mysql
select deptno,avg(sal) avgsal from emp group by deptno order by avgsal desc limit 1;
```

```mysql
select avg(sal) avgsal from emp group by deptno;
select max(avgsal) from (select avg(sal) avgsal from emp group by deptno) t;

select deptno,avg(sal) avgsal from emp group by deptno having avgsal=(select max(avgsal) from (select avg(sal) avgsal from emp group by deptno) t);
```



##### 6、取得平均薪水最高的部门的部门名称

```mysql
select deptno,avg(sal) avgsal from emp group by deptno;

select d.dname from dept d join (select deptno,avg(sal) avgsal from emp group by deptno) t on d.deptno=t.deptno order by avgsal desc limit 0,1;
```

```mysql
select d.dname,avg(e.sal) avgsal from emp e join dept d on e.deptno=d.deptno group by d.dname order by avgsal desc limit 1;
```



##### 7、求平均薪水的等级最低的部门的部门名称

```mysql
select deptno,avg(sal) avgsal from emp group by deptno;

select d.dname from dept d join (select deptno,avg(sal) avgsal from emp group by deptno) t on d.deptno=t.deptno order by avgsal asc limit 0,1;
```

```mysql
select avg(sal) avgsal from emp group by deptno order by avgsal asc limit 1;

select grade from salgrade where (select avg(sal) avgsal from emp group by deptno order by avgsal asc limit 1) between losal and hisal;

select d.dname,avg(sal) avgsal from emp e join dept d on e.deptno=d.deptno group by dname;

select t.*,s.grade from (select d.dname,avg(sal) avgsal from emp e join dept d on e.deptno=d.deptno group by dname) t join salgrade s on t.avgsal between s.losal and s.hisal where s.grade=(select grade from salgrade where (select avg(sal) avgsal from emp group by deptno order by avgsal asc limit 1) between losal and hisal);
```



##### 8、取得比普通员工(员工代码没有在 mgr 字段上出现的) 的最高薪水还要高的领导人姓名

```mysql

```

```mysql
select distinct mgr from emp where mgr is not null;
//in后面的值不能为null
select max(sal) from emp where empno not in (select distinct mgr from emp where mgr is not null);

select ename,sal from emp where sal>(select max(sal) from emp where empno not in (select distinct mgr from emp where mgr is not null));
```



##### 9、取得薪水最高的前五名员工

```mysql
select ename from emp order by sal desc limit 5;
```



##### 10、取得薪水最高的第六到第十名员工

```mysql
select ename from emp order by sal desc limit 5,5;
```



##### 11、取得最后入职的 5 名员工

```mysql
//日期可以升降序排
select ename from emp order by hiredate desc limit 5;
```




##### 12、取得每个薪水等级有多少员工

```mysql
select e.ename,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal;

select s.grade,count(s.grade) from emp e join salgrade s on e.sal between s.losal and s.hisal group by s.grade order by s.grade asc;
```



##### 13、面试题：

有 3 个表 S(学生表)，C（课程表），SC（学生选课表）
S（SNO，SNAME）代表（学号，姓名）
C（CNO，CNAME，CTEACHER）代表（课号，课名，教师）
SC（SNO，CNO，SCGRADE）代表（学号，课号，成绩）
问题：
1，找出没选过“黎明”老师的所有学生姓名。
2，列出 2 门以上（含2 门）不及格学生姓名及平均成绩。
3，即学过 1 号课程又学过 2 号课所有学生的姓名。

```mysql
1.
select s.sname from s join sc on s.sno=sc.sno join c on sc.cno=c.cno where c.cteacher='黎明';

select s.sname from (select s.sname from s join sc on s.sno=sc.sno join c on sc.cno=c.cno where c.cteacher='黎明') t where s.sname not in t.sname;
2.
select sc.* from sc where sc.scgrade<60;

select sc.sno,count(sc.cno) num from sc where sc.scgrade<60 group by sc.sno having num>1;

select s.sname from s join (select sc.sno,count(sc.cno) num from sc where sc.scgrade<60 group by sc.sno having num>1) t on s.sno=t.sno;
3.

```

```mysql
JDBC
```



##### 14、列出所有员工及领导的姓名

```mysql
select e.ename,t.ename leadername from emp e left join emp t on e.mgr = t.empno;
```



##### 15、列出受雇日期早于其直接上级的所有员工的编号,姓名,部门名称

```mysql
select e.empno,e.ename,d.dname from emp e join emp t on e.mgr = t.empno join dept d on e.deptno = d.deptno where e.hiredate<t.hiredate;
```



##### 16、 列出部门名称和这些部门的员工信息, 同时列出那些没有员工的部门

```mysql
select d.dname,e.* from dept d left join emp e on d.deptno=e.deptno;
```



##### 17、列出至少有 5 个员工的所有部门

```mysql
select d.dname from emp e join dept d on e.deptno=d.deptno group by d.deptno having count(*)>=5;
```



##### 18、列出薪金比"SMITH" 多的所有员工信息

```mysql
select sal from emp where ename ='SMITH';

select * from emp where sal>(select sal from emp where ename ='SMITH');
```



##### 19、 列出所有"CLERK"( 办事员) 的姓名及其部门名称, 部门的人数

```mysql
select e.ename,d.dname from emp e join dept d on e.deptno=d.deptno where e.job='CLERK';

select deptno,count(*) num from emp group by deptno;

select e.ename,d.dname,t.num num from emp e join dept d on e.deptno=d.deptno join (select deptno,count(*) num from emp group by deptno) t on e.deptno=t.deptno where e.job='CLERK' ;
```



##### 20、列出最低薪金大于 1500 的各种工作及从事此工作的全部雇员人数

```mysql
select job from emp group by job having min(sal)>1500;

select job,count(*) num from emp group by job;

select e.job,t.num from emp e join (select job,count(*) num from emp group by job) t on e.job=t.job group by e.job having min(e.sal)>1500;
```

```mysql
select job,count(*) from emp group by job having min(sal)>1500;
```



##### 21、列出在部门"SALES"< 销售部> 工作的员工的姓名, 假定不知道销售部的部门编号.

```mysql
select deptno from dept where dname='SALES';

select e.ename from emp e join dept d on e.deptno=d.deptno where d.dname='SALES';
```



##### 22、列出薪金高于公司平均薪金的所有员工, 所在部门, 上级领导, 雇员的工资等级.

```mysql
select avg(sal) avgsal from emp;

select * from emp where sal>(select avg(sal) avgsal from emp);

select e.ename,d.dname,m.ename,s.grade from emp e join dept d on e.deptno=d.deptno left join emp m on e.mgr=m.empno join salgrade s on e.sal between s.losal and s.hisal where e.sal>(select avg(sal) avgsal from emp);
```



##### 23、 列出与"SCOTT" 从事相同工作的所有员工及部门名称

```mysql
select job from emp where ename='SCOTT';

select ename from emp where job=(select job from emp where ename='SCOTT');

select e.ename,d.dname from emp e join dept d on e.deptno=d.deptno where e.job=(select job from emp where ename='SCOTT');
```



##### 24、列出薪金等于部门 30 中员工的薪金的其他员工的姓名和薪金.

```mysql
select sal from emp where deptno=30;

select e.ename,e.sal from emp e join (select sal from emp where deptno=30) t on e.sal=t.sal where e.deptno<>30;
```

```mysql
select e.ename,e.sal 
from emp e 
where sal in (select sal from emp where deptno=30)
and deptno<>30;
```



##### 25、列出薪金高于在部门 30 工作的所有员工的薪金的员工姓名和薪金. 部门名称

```mysql
select max(sal) from emp where deptno=30;

select e.ename,e.sal,d.dname from emp e join dept d on e.deptno=d.deptno where e.sal>(select max(sal) from emp where deptno=30);
```



##### 26、列出在每个部门工作的员工数量, 平均工资和平均服务期限

```mysql
select deptno,count(*),avg(sal) from emp group by deptno;
```

```mysql
select d.dname,count(e.ename) num,ifnull(avg(e.sal),0) sal,ifnull(avg(timestampdiff(YEAR,hiredate,now())),0) time
from emp e
right join dept d
on e.deptno=d.deptno
group by d.dname;
```



##### 27、 列出所有员工的姓名、部门名称和工资。

```mysql
select e.ename,d.dname,e.sal from emp e join dept d on e.deptno=d.deptno;
```



##### 28、列出所有部门的详细信息和人数

```mysql
select deptno,count(*) num from emp group by deptno;

select d.*,t.num from dept d join (select deptno,count(*) num from emp group by deptno) t on d.deptno=t.deptno;
```

```mysql
select d.*,count(e.ename)
from emp e
right join dept d
on e.deptno=d.deptno
group by d.deptno,d.dname,d.loc;
```



##### 29、列出各种工作的最低工资及从事此工作的雇员姓名

```mysql
select job,min(sal) minsal from emp group by job;

select t.job,t.minsal,e.ename from emp e join (select job,min(sal) minsal from emp group by job) t on e.sal=t.minsal;
```

```mysql
select t.job,t.minsal,e.ename 
from emp e 
join (select job,min(sal) minsal from emp group by job) t 
on e.job=t.job and e.sal=t.minsal;
```





##### 30、列出各个部门的 MANAGER( 领导) 的最低薪金

```mysql
select ename,sal,deptno from emp where job = 'MANAGER';

select deptno,min(sal) from (select ename,sal,deptno from emp where job = 'MANAGER') t group by deptno;
```

```mysql
select deptno,min(sal)
from emp
where job='MANAGER'
group by deptno;
```



##### 31、列出所有员工的 年工资, 按 年薪从低到高排序

```mysql
select ename,(sal+ifnull(comm,0))*12 annual_salary from emp order by annual_salary asc;
```



##### 32、求出员工领导的薪水超过3000的员工名称与领导

```mysql
select e.ename,t.ename from emp e join emp t on e.mgr=t.empno;

select e.ename,t.ename from emp e join emp t on e.mgr=t.empno where t.sal>3000;
```



##### 33、求出部门名称中, 带'S'字符的部门员工的工资合计、部门人数

```mysql
select sum(e.sal) sumsal,count(*) num from emp e join dept d on e.deptno=d.deptno where d.dname like '%S%';
```

```mysql
select d.deptno,d.dname,d.loc,count(e.ename),ifnull(sum(e.sal),0)
from emp e
right join dept d
on e.deptno=d.deptno
where d.dname like '%S%'
group by d.deptno,d.dname,d.loc;
```



##### 34、给任职日期超过 30 年的员工加薪 10%.

```mysql
update emp set sal=sal*1.1 
where timestampdiff(YEAR,hiredate,now())>40;
```
