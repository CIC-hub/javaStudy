### 1 基础知识

#### 1.1 使用

windows中启动、关闭MySQL服务：net stop 服务名称；net start 服务名称;

本地登陆（显示密码）

```
C:\Users\11813>mysql -uroot -p123456
```

本地登陆（隐藏密码）

```
C:\Users\11813>mysql -uroot -p
```

查看数据库

```
show databases;
```

使用数据库

```
use 数据库名
```

创建数据库

```
create database 数据库名;
```

查看数据库

```
select database();
```

查看版本号

```
select version();
```

退出sql

```
exit
```

命令不区分大小写，不见分号不执行，`\c`为终止命令输入



数据库中最基本的单元是表：table

每张表都有行和列

行（row）：称为数据/记录

列（column）：称为字段

每个字段都有`字段名`、`数据类型`、`约束`

添加唯一性约束后，该字段的数据不能重复

查看表

```
show tables;
```

导入数据

```
source 文件名（不能中文、\\）;
```

```
source G:\\StudySoftware\\EclipseWorkspace\\clone\\javaStudy\\text\\MySQL\\bjpowernode.sql;
```

查看表中数据

```
select * from 表名;	//查询表中所有数据
```

```
desc 表名;	//查询表的结构，describe
```

调用sql文件

```mysql
source 文件路径
```



#### 1.2 SQL语句分类

DQL：数据查询语言

```
带select关键字
```

DML：数据操作语言，对表中数据进行增删改

```
insert、delete、update
```

DDL：数据定义语言，对表的结构进行增删改

```
create、drop、alter
```

TCL： 事务控制语言

```
事务提交：commit、事务回滚：rollback
```

DCL：数据控制语言

```
授权：grant、撤销权限：revoke
```



### 2 DQL

#### 2.1 简单查询

查询一个字段

```
select 字段名 from 表名;
```

 查询多个字段	使用逗号隔开

```
select 字段名1,字段名2 from 表名;
```

查询所有字段

```
select * from 表名;	//效率低，可读性差，开发不建议
select 字段名1,字段名2,字段名3 from 表名;
```

给查询的列起 `别名`

```
select 字段名1,字段名2 as 字段名3 from 表名;
select 字段名1,字段名2 字段名3 from 表名;	//as可省
select 字段名1,字段名2 '字段名3' from 表名;
//字段名3中有空格，用单/双引号，单引号标准
```

使用`as`关键字，字段名2显示为字段名3，原表列名不变

**select不会修改，只查询**

```
select ename,sal*12 as '年薪' from emp;
```

select后要跟字面量/字面值时，生成from后列个数的值

#### 2.2 条件查询

```
select
	字段1,字段2,字段3
from
	表名
where
	条件;
```



条件：`=`、`!=`/`<>`、`<=`、`>=`、`between ... and ...`（左小右大，闭区间）

`is null`、`is not null`

 `and`、`or`（and优先级较高，通过()改变）

`in`（包含，多个`or`）、`not in`

```
select job from emp where job in(具体值1,具体值2);
select job from emp where job = 具体值1 or job = 具体值2;
```

`like`（模糊查询，支持%或_）

```
select job from emp where ename like '%a%';//名字里含有a
select job from emp where ename like '%a';//名字以a结尾
select job from emp where ename like 'a%';//名字以a开头
select job from emp where ename like '_a% ';//名字第2个字母为a
select job from emp where ename like '__a%';//名字第3个字母为a
```

```
select job from emp where ename like '%\_%';//名字里含有_，用\
```



#### 2.3 排序

`order`，在最后执行

**单项排序**

 ```
 select ename,sal from emp order by sal;//默认升序或加asc
 select ename,sal from emp order by sal desc;//降序
 ```

**多项排序**

```
select ename,sal from emp order by sal asc,ename asc;
//sal主导，ename次之
```

**格式**

`select`...`from`...`where`...`order by`...



#### 2.4 数据处理函数

又叫单行处理函数，一个输入对应一个输出

`lower(字段名)`转小写

```
select lower(ename) from emp;
```

`upper(字段名)`转大写

```
select upper(name) from t_student;
```

`substr(字符串,起始下标,截取长度)`取子串，从1开始

```
select substr(ename,1,1) from emp;
```

```
 select ename from emp where substr(ename,1,1) = 'A';//A开头
```

`concat(内容1，内容2)`字符串拼接

```
select concat(upper(substr(name,1,1)),substr(name,2,length(name)-1))
as result from t_student;	//首字母大写
```

`length()`取长度

```
select length(ename) enamelength from emp;
```

`trim()`去空格

```
select * from emp where ename = trim('  KING');
```

`round(数,保留的位数)`四舍五入

```
select round(123.456,1) from emp;	//123.5
select round(123.456,-1) from emp;	//120
```

`rand()`生成随机数

```
select round(rand()*100,0) from emp;	//100内随机数
```

`ifnull(字段,值)`空处理函数，该字段为空则以给定值替代

```
select ename,sal+comm as salcom from emp;
//有空参与的数学运算结果为空
select ename,sal+ifnull(comm,0) as salcom from emp;
```

`str_to_date`字符串转日期

`date_format`格式化日期

`format`设置千分位

`case..when..then..when..then..else..end`

```
select ename,job,sal as oldsal,
	(case job when 'manager' then sal*1.1
			 when 'salesman' then sal*1.5
    else sal end) as newsal
from emp;
```



#### 2.5 分组函数

又叫多行处理函数，输入多行，输出一行

**先进行分组，再使用，否则整张图为一组**

`count`计数

```
select count(sal) from emp;
```

`sum`

```
select sum(sal) from emp;
```

`avg`

```
select avg(sal) from emp;
```

`max`

```
select max(sal) from emp;
```

`min`

```
select min(sal) from emp;
```



**注意点：**

**1. 自动忽略null**

```
select sum(comm) from emp;
```

**2.count(*)与count(字段)**

count(*)：行数，所有列为null的数据不存在

count(字段)：字段不为null的元素总数

**3.分组函数不能用在where中**

```
select ename,sal from emp where sal > min(sal);
//error
```

**4.所有分组函数可以组合在一起使用**

```
select sum(sal),min(sal),max(sal),avg(sal),count(*) from emp;
```



#### 2.6 分组查询（重要）

**格式**

```
select
	...
from
	...
where
	...
group by
	...
order by
	...
```

**执行顺序**

**from -> where -> group by -> select -> order by**

```
select ename,sal from emp where sal > min(sal);
//where执行时还未分组
```

```
select sum(sal) from emp;
//select时已经分完组，默认为整张表
```

**在select语句中，如果有group，select后面只能跟参与分组的字段、分组函数**

```
select job,sum(sal) from emp group by job;
select deptno,max(sal) from emp group by deptno;
```

**两个字段可以看成一个字段（联合分组）**

```
select deptno,job,max(sal) from emp group by deptno,job;
//每个部门，不同岗位的薪资
```

**having可以对分组后的数据进行过滤，必须与group by一起用，不可替代where**

```
select deptno,max(sal) from emp 
	group by deptno having max(sal)>3000;
//找出每个部门最高薪资大于3000的
select deptno,max(sal) from emp where sal>3000 group by deptno;
```

```
//where用不了，找出每个部门平均薪资高于2500的
select deptno,avg(sal) from emp group by deptno
									having avg(sal)>2500;
```

**where和having优先选择where**

 #### 2.7 单表查询总结

**格式**

```
select		...
from		...
where		...
group by	...
having		...
order by	...
```

**执行顺序**

`from` `->` `where` `->` `group by` `->` `having` `->` `select` `->` `order by`

从某张表中查询数据，

先经过where条件筛选出有价值的数据，

对这些有价值的数据进行分组，

分组之后可以使用having继续筛选，

select查询出来，

最后排序输出

```
//找出每个岗位平均薪资，
//要求显示平均薪资大于1500，除manager岗位以外，按平均薪资降序排
select job,avg(sal) as avgsal from emp where job <> 'manager'
	group by job having avg(sal)>1500 order by avgsal desc;
```

#### 2.8 去重

`distinct`，只能用在所有字段的最前方

```
select distinct job from emp;
//联合去重
select distinct job,deptno from emp;
select count(distinct job) from emp;
```

#### 2.9 链接查询（重要）

分类：

​	内连接：等值连接、非等值连接、自联结

​	外连接：左（外）连接、右（外）连接

​	全连接

笛卡尔积现象：两张表进行连接查询，没有任何条件限制时，查询结果条数为这两张表条数的乘积

```
select ename,dname from emp,dept;
```

加条件限制：

```
//SQL92
//查询次数没有减少
select ename,dname from emp,dept where emp.deptno = dept.deptno;
//ename会在两张表中都去寻找
select emp.ename,dept.dname from emp,dept where emp.deptno = dept.deptno; 
//指定了表
select e.ename,d.dname from emp e,dept d where e.deptno = d.deptno;
//起别名
```

表的连接次数越多，效率越低

99语法比92结构清晰，过滤时92加条件and，99用where

#### 2.10 内连接

**特点：完全匹配条件的数据查询出来**

 `格式`（`inner`可省略）

```
select ... from a inner join b on a和b的连接条件 where 筛选条件
```

`等值连接`，连接条件为等量关系

```
//显示员工名和部门名
select  e.ename,d.dname 
from emp e join dept d on e.deptno = d.deptno;
```

`非等值连接`

```
//显示员工名、工资、工资等级
select e.ename,e.sal,s.grade 
from emp e join salgrade s on e.sal between s.losal and s.hisal;
```

`自连接`

```
//显示员工名、其领导名
select a.ename '员工名',b.ename '领导名'
from emp a join emp b on a.mgr = b.empno;
//只有13条，King的领导为null
```

#### 2.11 外连接

**有主次关系**

`右（外）连接`，把`join`右边的表当主表，把这张表的数据全部查询，左边顺带查询

```
select e.ename,d.dname
from emp e right join dept d on e.deptno = d.deptno;
```

`左（外）连接`，把`join`左边的表当主表

```
select e.ename,d.dname
from dept d left join emp e on e.deptno = d.deptno;
```

左连接和右连接可以互换，`right`/`left`后面可以省略`outer`

区分内/外连接：`right`/`left`

外连接查询结果条数 >= 内连接查询结果条数

```
//显示员工名、其领导名
select a.ename '员工名',b.ename '领导名'
from emp a left join emp b on a.mgr = b.empno;
//14条，King的领导写为null
```

#### 2.12 多张表连接

`格式`

```
select ... from a join b on a和b的连接条件
				  join c on a和c的连接条件
				  join d on a和d的连接条件
```

内外连接可以混合

```
//显示员工名、部门名、薪资、薪资等级、领导名
select e.ename,d.dname,e.sal,s.grade,l.ename
from emp e join dept d on e.deptno = d.deptno
		   join salgrade s on e.sal between s.losal and s.hisal
		   left join emp l on e.mgr = l.empno;
```

#### 2.13 子查询

`select`语句中嵌套`select`语句

```
select 	..(select).
from	..(select).
where	..(select).
```

`where`子句中的子查询

```
//找出比最低工资高的员工名、工资
select min(sal) from emp;
select ename,sal from emp where sal > 800;
//子查询要加()
select ename,sal from emp 
	where sal > (select min(sal) from emp);
```

`from`子句中的子查询，可以把子查询的查询结果当做一张临时表

```
//找出每个岗位平均工资的薪资等级
select job,avg(sal) avgsal from emp group by job;
select t.job,t.avgsal,s.grade 
from t join salgrade s on t.avgsal between s.losal and s.hisal;
//子查询要加()
select t.*,s.grade 
	from (select job,avg(sal) avgsal from emp group by job) t
	join salgrade s on t.avgsal between s.losal and s.hisal;
```

`select`后出现的子查询（了解）

```
//找出员工名、部门
select e.ename,e.deptno,
(select d.dname from dept d where e.deptno = d.deptno) as dname
from emp e;
//不需要用到连接，子查询一次只能查一个结果，否则报错
```

#### 2.14 union

**合并查询结果集**

```
//查询结果是manager和salesman的员工
select ename,job from emp where job = 'manager' or job = 'salesman';
select ename,job from emp where job in ('manager','salesman');
```

```
select ename,job from emp where job = 'manager' union
select ename,job from emp where job = 'salesman';
```

`union`的效率高。对于表连接，每连接一次新表，匹配的次数满足笛卡尔积，使用`union`匹配次数为两表数据之和。（`union`把乘法变成了加法）

**union在进行结果集合并时，查询的列及其数据类型应保持一致。**

#### 2.15 limit

**把查询结果集的一部分取出来**

```
limit startIndex,length//从0开始，0 1 2 3 4 5 ...
limit 5//前5个
```

```
select ename,sal from emp order by sal desc limit 5;
select ename,sal from emp order by sal desc limit 2,5;
```

**`limit`要在`order by`后执行**

**分页**：`limit = (pageNo-1)*pageSize,pageSize`	

#### 2.16 DQL总结

格式：

```
select		... 
from		... 
where		... 
group by	... 
having		... 
order by	...
limit		...

from -> where -> group by -> having -> select -> order by -> limit

from先通过这个地方查，where在经过这个条件筛选，group by分组，having分组后过滤，select过滤后查出来，order by查出来进行排序，limit排序后取段
```



### 3 DDL

#### 3.1 创建表

**格式：**

```
create table 表名(字段名1 数据类型,字段名2 数据类型,字段名3 数据类型);
```

**常见数据类型**

`varchar`（最长255）：可变长度字符串，根据实际数据长度动态分配空间。节省空间，速度慢

`char`（最长255）：定长字符串，不管实际的数据长度。浪费空间，速度快

`int`（最长11）：整数型

`bigint`：长整型

`float`：单精度浮点型

`double`：双精度浮点型

`date`：短日期型

`datetime`：长日期型 

`clob`：字符大对象，最多存储4G字符串，超过255个字符的都要用clob存储

`blob`：二进制大对象，存储图片、声音、视频等流媒体数据，需使用IO流

**创建一个学生表**

```mysql
create table t_student(
	no int,
	name varchar(32),
	sex char(1),
	age int(3),
	email varchar(255)
);
```

**快速创建表（了解）**

```mysql
create table emp2 as select * from emp;
//复制一份emp表
```

```mysql
create table emp3 as select empno,ename from emp where job = 'manager';
//把emp表中的manager拿出作为新表
```

```mysql
create table dept_bak as select * from dept;
insert into dept_bak select * from dept;
//把查出的表插入另一表
```

#### 3.2 删除表

```mysql
drop table 表名;
//表不存在时会报错
```

```mysql
drop table if exists 表名;
```

#### 3.3 修改表

`alter`

通常使用图形化窗口实现

### 4 DML

#### 4.1 插入数据

`insert`

**格式：**

```mysql
insert into 表名(字段名1,字段名2,字段名3) values(值1,值2,值3);
```

**注意：字段名和字段值在数量、数据类型上要一一对应**

```mysql
insert into t_student(no,name,sex,age,email) values(1,'zhangsan','m',20,'zhagnsan@123.com');
insert into t_student(email,name,sex,age,no) values('lisi@123.com','lisi','f',20,2);
```

insert语句执行成功会多一条记录，没给其他字段指定值时，默认值为null，表示没有

```mysql
insert into t_student(no) values(3);
insert into t_student(name) values('wangwu');
```

**指定默认值：**

```mysql
create table t_student(
	no int,
	name varchar(32),
	sex char(1) default 'm',
	age int(3),
	email varchar(255)
);
```

**省略字段名：**

等于按字段名排列顺序写所有值

```
insert into t_student values(2,'lisi','f',22,'lisi@123.com');
```

**插入多条记录：**`values`后用`,`隔开

```mysql
insert into 表名(字段名1,字段名2) values(值1,值2),(值3,值4),(值5,值6);
```

```mysql
insert into t_student(no,name,sex,age,email) values(3,'zs','m',20,'zs@123.com'),(4,'ls','m',21,'ls@123.com'),(5,'wangwu','m',22,'wangwu@123.com');
```

#### 4.2 插入格式数据

`format()`：格式化数字

**格式：**

```mysql
format(数字,'格式')
```

```mysql
select ename,format(sal,'$999,999') as sal from emp;
```

`str_to_date`：将字符串varchar类型转换成date类型

```mysql
drop table if exists t_user;
create table t_user(
	id int,
	name varchar(32),
	birth date
);
```

```mysql
insert into t_user(id,name,birth) values(1,'zhangsan',str_to_date('01-10-1990','%d-%m-%Y'));
```

**日期字符串格式为`%Y-%m-%d`时，可以不用`str_to_date`，MySQL会自动转换**

```mysql
insert into t_user values(2,'lisi','1990-11-01');
```

`date_format`：将date类型转换成一定格式的varchar字符串类型

**格式：**

```mysql
date_format(日期类型数据,'日期格式')
```

```mysql
select id,name,date_format(birth,'%m/%d/%Y') as birth from t_user;
```

  SQL实现了默认的日期格式化，自动把数据库中的date类型转换成varchar类型，采用的格式为MySQL默认的日期格式：`%Y-%m-%d`

```mysql
select id,name,birth from t_user;
```

`date`和`datetime`类型区别：

`date`：短日期，年月日，`%Y-%m-%d`

`datetime`：长日期，年月日时分秒，`%Y-%m-%d %h:%i:%s`

```mysql
drop table if exists t_user;
create table t_user(
	id int,
    name varchar(32),
    birth date,
    create_time datetime
);
```

```mysql
insert into t_user values(2,'zhangsan',now(),now());
```

`now()`：获取系统时间

#### 4.3 修改数据

`update`

**格式：**

```mysql
update 表名 set 字段名1=值1,字段名2=值2,字段名3=值3 where 条件;
```

```
update t_user set name = 'jack',birth = '2000-10-11' where id = 2;
```

**没有条件限制时所有数据全部更新**

```
update t_user set name = 'abc';
```

#### 4.4 删除数据

`delete`

**格式：**

```mysql
delete from 表名 where 条件
```

```mysql
delete from t_user where id = 2;
```

**没有条件时，删除整张表的数据**

```mysql
delete from t_user;
```

**快速删除表中数据**

`delete`：表中数据被删除了，但在磁盘上的空间不会释放，删除慢；支持回滚

`truncate`：物理删除，删除快；不支持回滚，属于DML语句

两者使用后表存在，数据删除了；`drop`把表删除了

```mysql
truncate table 表名;
```



### 5 约束

**非空约束：not null**

**唯一性约束：unique**

**主键约束：primary key（pk）**

**检查约束：check（MySQL不支持，oracel支持）**

#### 5.1 非空约束

**非空约束not null的字段不能为null**

```mysql
drop table if exists t_vip;
create table t_vip(
	id int,
	name varchar(255) not null
);
insert into t_vip(id,name) values(1,'zhangsan');
insert into t_vip(id,name) values(2,'lisi');
//报错
insert into t_vip(id) values(3);
```

#### 5.2 唯一性约束

**`unique`，约束的字段不能重复，但可以为null**

```mysql
drop table if exists t_vip;
create table t_vip(
	id int,
    name varchar(255) unique,
    email varchar(255)
);
insert into t_vip(id,name,email) values(1,'zhangsan','zhangsan@123.com');
insert into t_vip(id,name,email) values(2,'lisi','lisi@123.com');
insert into t_vip(id) values(3);
//报错
insert into t_vip(id,name,email) values(4,'zhangsan','zhangsan@sira.com');
```

