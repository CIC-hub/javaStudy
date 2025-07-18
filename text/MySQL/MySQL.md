### 1 基础知识

#### 1.1 使用

windows中启动、关闭MySQL服务：net stop 服务名称；net start 服务名称;

本地登陆（显示密码）

```mysql
mysql -uroot -p123456
```

本地登陆（隐藏密码）

```mysql
mysql -uroot -p
```

查看数据库

```mysql
show databases;
```

使用数据库

```mysql
use 数据库名
```

创建数据库

```mysql
create database 数据库名;
```

查看数据库

```mysql
select database();
```

查看版本号

```mysql
select version();
```

退出sql

```mysql
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

```mysql
show tables;
```

导入数据

```mysql
source 文件名（不能中文、\\）;
```

```mysql
source G:\\StudySoftware\\EclipseWorkspace\\clone\\javaStudy\\text\\MySQL\\bjpowernode.sql;
```

查看表中数据

```mysql
select * from 表名;	//查询表中所有数据
```

```mysql
desc 表名;	//查询表的结构，describe
```

调用sql文件

```mysql
source 文件路径
```



#### 1.2 SQL语句分类

DQL：数据查询语言

```mysql
带select关键字
```

DML：数据操作语言，对表中数据进行增删改

```mysql
insert、delete、update
```

DDL：数据定义语言，对表的结构进行增删改

```mysql
create、drop、alter
```

TCL： 事务控制语言

```mysql
事务提交：commit、事务回滚：rollback
```

DCL：数据控制语言

```mysql
授权：grant、撤销权限：revoke
```



### 2 DQL

#### 2.1 简单查询

查询一个字段

```mysql
select 字段名 from 表名;
```

 查询多个字段	使用逗号隔开

```mysql
select 字段名1,字段名2 from 表名;
```

查询所有字段

```mysql
select * from 表名;	//效率低，可读性差，开发不建议
select 字段名1,字段名2,字段名3 from 表名;
```

给查询的列起 `别名`

```mysql
select 字段名1,字段名2 as 字段名3 from 表名;
select 字段名1,字段名2 字段名3 from 表名;	//as可省
select 字段名1,字段名2 '字段名3' from 表名;
//字段名3中有空格，用单/双引号，单引号标准
```

使用`as`关键字，字段名2显示为字段名3，原表列名不变

**select不会修改，只查询**

```mysql
select ename,sal*12 as '年薪' from emp;
```

select后要跟字面量/字面值时，生成from后列个数的值

#### 2.2 条件查询

```mysql
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

```mysql
select job from emp where job in(具体值1,具体值2);
select job from emp where job = 具体值1 or job = 具体值2;
```

`like`（模糊查询，支持%或_）

```mysql
select job from emp where ename like '%a%';//名字里含有a
select job from emp where ename like '%a';//名字以a结尾
select job from emp where ename like 'a%';//名字以a开头
select job from emp where ename like '_a% ';//名字第2个字母为a
select job from emp where ename like '__a%';//名字第3个字母为a
```

```mysql
select job from emp where ename like '%\_%';//名字里含有_，用\
```



#### 2.3 排序

`order`，在最后执行

**单项排序**

 ```mysql
 select ename,sal from emp order by sal;//默认升序或加asc
 select ename,sal from emp order by sal desc;//降序
 ```

**多项排序**

```mysql
select ename,sal from emp order by sal asc,ename asc;
//sal主导，ename次之
```

**格式**

`select`...`from`...`where`...`order by`...



#### 2.4 数据处理函数

又叫单行处理函数，一个输入对应一个输出

`lower(字段名)`转小写

```mysql
select lower(ename) from emp;
```

`upper(字段名)`转大写

```mysql
select upper(name) from t_student;
```

`substr(字符串,起始下标,截取长度)`取子串，从1开始

```mysql
select substr(ename,1,1) from emp;
```

```mysql
 select ename from emp where substr(ename,1,1) = 'A';//A开头
```

`concat(内容1，内容2)`字符串拼接

```mysql
select concat(upper(substr(name,1,1)),substr(name,2,length(name)-1))
as result from t_student;	//首字母大写
```

`length()`取长度

```mysql
select length(ename) enamelength from emp;
```

`trim()`去空格

```mysql
select * from emp where ename = trim('  KING');
```

`round(数,保留的位数)`四舍五入

```mysql
select round(123.456,1) from emp;	//123.5
select round(123.456,-1) from emp;	//120
```

`rand()`生成随机数

```mysql
select round(rand()*100,0) from emp;	//100内随机数
```

`ifnull(字段,值)`空处理函数，该字段为空则以给定值替代

```mysql
select ename,sal+comm as salcom from emp;
//有空参与的数学运算结果为空
select ename,sal+ifnull(comm,0) as salcom from emp;
```

`str_to_date`字符串转日期

`date_format`格式化日期

`format`设置千分位

`case..when..then..when..then..else..end`

```mysql
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

```mysql
select count(sal) from emp;
```

`sum`

```mysql
select sum(sal) from emp;
```

`avg`

```mysql
select avg(sal) from emp;
```

`max`

```mysql
select max(sal) from emp;
```

`min`

```mysql
select min(sal) from emp;
```



**注意点：**

**1. 自动忽略null**

```mysql
select sum(comm) from emp;
```

**2.count(*)与count(字段)**

count(*)：行数，所有列为null的数据不存在

count(字段)：字段不为null的元素总数

**3.分组函数不能用在where中**

```mysql
select ename,sal from emp where sal > min(sal);
//error
```

**4.所有分组函数可以组合在一起使用**

```mysql
select sum(sal),min(sal),max(sal),avg(sal),count(*) from emp;
```



#### 2.6 分组查询（重要）

**格式**

```mysql
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

```mysql
select ename,sal from emp where sal > min(sal);
//where执行时还未分组
//error
```

```mysql
select sum(sal) from emp;
//select时已经分完组，默认为整张表
```

**在select语句中，如果有group，select后面只能跟参与分组的字段、分组函数**

```mysql
select job,sum(sal) from emp group by job;
select deptno,max(sal) from emp group by deptno;
```

**两个字段可以看成一个字段（联合分组）**

```mysql
select deptno,job,max(sal) from emp group by deptno,job;
//每个部门，不同岗位的薪资
```

**having可以对分组后的数据进行过滤，必须与group by一起用，不可替代where**

```mysql
select deptno,max(sal) from emp 
	group by deptno having max(sal)>3000;
//找出每个部门最高薪资大于3000的
select deptno,max(sal) from emp where sal>3000 group by deptno;
```

```mysql
//where用不了，找出每个部门平均薪资高于2500的
select deptno,avg(sal) from emp group by deptno
									having avg(sal)>2500;
```

**where和having优先选择where**

 #### 2.7 单表查询总结

**格式**

```mysql
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

```mysql
//找出每个岗位平均薪资，
//要求显示平均薪资大于1500，除manager岗位以外，按平均薪资降序排
select job,avg(sal) as avgsal from emp where job <> 'manager'
	group by job having avg(sal)>1500 order by avgsal desc;
```

#### 2.8 去重

`distinct`，只能用在所有字段的最前方

```mysql
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

```mysql
select ename,dname from emp,dept;
```

加条件限制：

```mysql
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

```mysql
select ... from a inner join b on a和b的连接条件 where 筛选条件
```

`等值连接`，连接条件为等量关系

```mysql
//显示员工名和部门名
select  e.ename,d.dname 
from emp e join dept d on e.deptno = d.deptno;
```

`非等值连接`

```mysql
//显示员工名、工资、工资等级
select e.ename,e.sal,s.grade 
from emp e join salgrade s on e.sal between s.losal and s.hisal;
```

`自连接`

```mysql
//显示员工名、其领导名
select a.ename '员工名',b.ename '领导名'
from emp a join emp b on a.mgr = b.empno;
//只有13条，King的领导为null
```

#### 2.11 外连接

**有主次关系**

`右（外）连接`，把`join`右边的表当主表，把这张表的数据全部查询，左边顺带查询

```mysql
select e.ename,d.dname
from emp e right join dept d on e.deptno = d.deptno;
```

`左（外）连接`，把`join`左边的表当主表

```mysql
select e.ename,d.dname
from dept d left join emp e on e.deptno = d.deptno;
```

左连接和右连接可以互换，`right`/`left`后面可以省略`outer`

区分内/外连接：`right`/`left`

外连接查询结果条数 >= 内连接查询结果条数

```mysql
//显示员工名、其领导名
select a.ename '员工名',b.ename '领导名'
from emp a left join emp b on a.mgr = b.empno;
//14条，King的领导写为null
```

#### 2.12 多张表连接

`格式`

```mysql
select ... from a join b on a和b的连接条件
				  join c on a和c的连接条件
				  join d on a和d的连接条件
```

内外连接可以混合

```mysql
//显示员工名、部门名、薪资、薪资等级、领导名
select e.ename,d.dname,e.sal,s.grade,l.ename
from emp e join dept d on e.deptno = d.deptno
		   join salgrade s on e.sal between s.losal and s.hisal
		   left join emp l on e.mgr = l.empno;
```

#### 2.13 子查询

`select`语句中嵌套`select`语句

```mysql
select 	..(select).
from	..(select).
where	..(select).
```

`where`子句中的子查询

```mysql
//找出比最低工资高的员工名、工资
select min(sal) from emp;
select ename,sal from emp where sal > 800;
//子查询要加()
select ename,sal from emp 
	where sal > (select min(sal) from emp);
```

`from`子句中的子查询，可以把子查询的查询结果当做一张临时表

```mysql
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

```mysql
//找出员工名、部门
select e.ename,e.deptno,
(select d.dname from dept d where e.deptno = d.deptno) as dname
from emp e;
//不需要用到连接，子查询一次只能查一个结果，否则报错
```

#### 2.14 union

**合并查询结果集**

```mysql
//查询结果是manager和salesman的员工
select ename,job from emp where job = 'manager' or job = 'salesman';
select ename,job from emp where job in ('manager','salesman');
```

```mysql
select ename,job from emp where job = 'manager' union
select ename,job from emp where job = 'salesman';
```

`union`的效率高。对于表连接，每连接一次新表，匹配的次数满足笛卡尔积，使用`union`匹配次数为两表数据之和。（`union`把乘法变成了加法）

**union在进行结果集合并时，查询的列及其数据类型应保持一致。**

#### 2.15 limit

**把查询结果集的一部分取出来**

```mysql
limit startIndex,length//从0开始，0 1 2 3 4 5 ...
limit 5//前5个
```

```mysql
select ename,sal from emp order by sal desc limit 5;
select ename,sal from emp order by sal desc limit 2,5;
```

**`limit`要在`order by`后执行**

**分页**：`limit = (pageNo-1)*pageSize,pageSize`	

#### 2.16 DQL总结

格式：

```mysql
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

```mysql
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

```mysql
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

```mysql
update t_user set name = 'jack',birth = '2000-10-11' where id = 2;
```

**没有条件限制时所有数据全部更新**

```mysql
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

**检查约束：check（MySQL不支持，oracle支持）**

#### 5.1 非空约束

**非空约束not null的字段不能为null**

**只有列级约束，没有表级约束**

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

**列级约束：约束直接添加在列后**

```mysql
drop table if exists t_vip;
create table t_vip(
	id int,
    name varchar(255) unique,
    email varchar(255)
);
insert into t_vip(id,name,email) values(1,'zs','zs@123.com');
insert into t_vip(id,name,email) values(2,'lisi','lisi@123.com');
insert into t_vip(id) values(3);
//报错
insert into t_vip(id,name,email) values(4,'zs','zs@sira.com');
```

**联合唯一**

**表级约束：约束没有添加在列后**

```mysql
drop table if exists t_vip;
create table t_vip(
	id int,
	name varchar(255),
	email varchar(255),
	unique(name,email)
);
insert into t_vip(id,name,email) values(1,'zs','zs@123.com');
insert into t_vip(id,name,email) values(1,'zs','zs@sira.com');
select * from t_vip;
```

#### 5.3 主键约束

**mysql中字段被`not null`和`unique`同时约束时，该字段自动成为主键字段，oracle中不会**

```mysql
drop table if exists t_vip;
create table t_vip(
	id int,
    name varchar(255) not null unique
);
desc t_vip;
```

```mysql
insert into t_vip(id,name) values(1,'zs');
//报错
insert into t_vip(id,name) values(2,'zs');
//报错
insert into t_vip(id) values(3);
```

主键约束、主键字段、主键值

**主键值为该记录的唯一标识**

**任何一张表都应有主键，没有主键，表无效**

**主键不能为null，不能重复**

**单一主键：一个字段做主键**

**列级约束**

```mysql
drop table if exists t_vip;
create table t_vip(
	id int primary key,
    name varchar(255)
);
desc t_vip;
```

**表级约束**

```mysql
drop table if exists t_vip;
create table t_vip(
	id int,
    name varchar(255),
    primary key(id)
);
desc t_vip;
```

```mysql
insert into t_vip(id,name) values(1,'zs');
insert into t_vip(id,name) values(2,'zs');
//报错
insert into t_vip(id,name) values(2,'wangwu');
//报错
insert into t_vip(name) values('wangwu');
```

**复合主键：多个字段联合起来做主键**

```mysql
drop table if exists t_vip;
create table t_vip(
	id int,
    name varchar(255),
    primary key(id,name)
);
desc t_vip;
```

```mysql
insert into t_vip(id,name) values(1,'zs');
insert into t_vip(id,name) values(2,'zs');
insert into t_vip(id,name) values(2,'wangwu');
//报错
insert into t_vip(id,name) values(2,'wangwu');
```

**实际开发使用单一主键**

**一张表中主键只能有一个**

**一般用int、bigint、char**

**mysql中自动维护主键值：auto_increment**

```mysql
drop table if exists t_vip;
create table t_vip(
    id int primary key auto_increment,
    name varchar(255)
);
desc t_vip;
```

```mysql
insert into t_vip(name) values('zs');
insert into t_vip(name) values('zs');
insert into t_vip(name) values('zs');
select * from t_vip;
```

#### 5.4 外键约束（重要）

`foreign key`，简称`FK`，外键约束、外键字段、外键值

**子表中的字段引用父表中的字段，子表字段被约束，保证数据安全，子表字段值只能来自父表字段值**

**建表先建父表，删表先删子表**

```mysql
foreign key(子表字段) references 父表名(父表字段)
```

**子表中外键引用父表的字段，父表的字段    不一定为主键，但至少有unique约束**

**外键值可以为NULL**

```mysql
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
```

```
source D:\\StudySoftware\\Eclipse\\w2\\javaStudy\\text\\MySQL\\t_student.sql;
```

```mysql
//报错
insert into t_student(name,cno) values('t5',102);
```

### 6 存储引擎（了解）

mysql中的一个表存储/组织数据的方式

```mysql
//查看存储引擎
show create table 表名;
```

mysql默认的存储引擎：InnoDB

​	  默认的字符编码方式：utf8

```mysql
//建表指定存储引擎	在最后小括号外面engine，charset指定存储引擎，字符集
create table t_product(
	id int primary key,
    name varchar(255)
)engine=InnoDB default charset=gbk;
```

**常用存储引擎**

```mysql
//查看mysql支持的存储引擎
show engines \G
```

`MyISAM`

​	使用三个文件表示一张表：

​		格式文件：存储表结构的定义	mytable.fim

​		数据文件：存储表行的内容	mytable.MYD

​		索引文件：存储表上索引，缩小扫描范围	mytable.MYI

​	可被转换为压缩、只读表来节省空间

​	主键、加有unique约束的字段会自动创建索引

特点：可被转换为压缩、只读表来节省空间；不支持事务，安全性低

`InnoDB`

​	mysql默认的存储引擎

​	表格式存在.fim文件

​	支持事务，支持数据库崩溃后自动恢复机制

​	InnoDB表空间tablespace用于存储表内容和索引

特点：支持事务，以保证数据安全；不能压缩，不能转换成只读

`MEMORY`

​	数据和索引存在内存中，查询快

​	表格式存在.fim文件

​	不能包含TEXT或BLOB字段

​	以前叫做HEAP引擎

特点：查询效率高；不安全，关机后数据消失

### 7 事务（重要）

一个完整的业务逻辑，最小的工作单元，不可再分

为了保证多条DML语句同时成功/失败

只有DML语句才有事务，其他语句与事务无关	`insert`、`delete`、`update`

单条语句无需事务

#### 7.1 实现

在事务的执行过程中，每一条DML操作都会记录到“事务性活动的日志文件”

可以提交/回滚事务

提交事务：清空事务性活动的日志文件，将数据全部彻底持久化到数据库表中，标志着全部成功的事务结束

回滚事务：将之前的DML操作全部撤销，并清空事务性活动的日志文件，标志着全部失败的事务结束

mysql默认自动提交事务，每执行一条DML语句，提交一次

```mysql
start transaction;
insert/delete/update;...
commit/rollback;
```

#### 7.2 特性

A：原子性，事务是最小的工作单元

C：一致性，在同一个事务中，所有操作必须同时成功/失败，以保证数据的一致性

I：隔离性，A事务与B事务之间有一定的隔离

D：持久性，事务提交后，数据保存到硬盘上

#### 7.3 隔离级别

**读未提交 read uncommitted（最低的隔离级别）**

​	事务A可读取到事务B未提交的数据，会导致脏读现象(dirty read)

**读已提交 read committed**

​	事务A只能读到事务B提交之后的数据，解决了脏读现象，会导致不可重复读取数据，即事务开启后，第一次读到数据为3条，当前事务未结束，第二次再读取时，可能读到4条。

​	读到的为比较真实的数据，每一次读到的数据绝对真实，oracle数据库默认该隔离级别

**可重复读 repeatable read**

​	提交了也读不到，永远是开启事务时的数据

​	事务A开启后，即使事务B改变数据提交后，读到的数据也不变，解决了不可重复读，会导致幻影读，即每次读到的数据都是幻象，不够真实，mysql默认该隔离级别

**序列化/串行化 serializable（最高的隔离级别）**

​	效率最低，解决了所有问题，每次读到的数据都是真实的

​	表示事务排队，不能并发

#### 7.4 验证隔离级别

```mysql
//查看当前会话隔离级别
select @@transaction_isolation;
//设置隔离级别
set global transaction isolation level read uncommitted;
```

### 8 索引

#### 8.1 定义

索引是在数据库表的字段上添加的，是为了提高查询效率存在的一种机制。
一张表的一个字段可以添加一个索引，当然，多个字段联合起来也可以添加索引。
索引相当于一本书的目录，是为了缩小扫描范围而存在的一种机制。



```mysql
select * from t_user where name = 'jack';
```

以上的这条SQL语句会去name字段上扫描，因为查询条件是：name='jack'

如果name字段上没有添加索引（目录），或者说没有给name字段创建索引，MySQL会进行全扫描，会将name字段上的每一个值都比对一遍。效率比较低。



MySQL在查询方面主要就是两种方式：
	第一种方式：全表扫描
	第二种方式：根据索引检索。

**提醒：**

​	**1.在任何数据库当中主键上都会自动添加索引对象；在mysql中，字段被unique约束，会自动创建索引对象。**

​	**2.在任何数据库当中，任何一张表的任何一条记录在硬盘存储上都有一个硬盘的物理存储编号。**

​	**3.在mysql当中，索引是一个单独的对象，不同的存储引擎以不同的形式存在，在MyISAM存储引擎中，索引存储在一个.MYI文件中。在InnoDB存储引擎中索引存储在一个逻辑名称叫做tablespace的当中。在MEMORY存储引擎当中索引被存储在内存当中。不管索引存储在哪里，索引在mysql当中都是一个树的形式存在。（自平衡二叉树：B-Tree）**

#### 8.2 实现原理

在mysql数据库当中索引也是需要排序的，并且这个所以的排序和TreeSet数据结构相同。TreeSet（TreeMap）底层是一个自平衡的二叉树！在mysql当中索引是一个B-Tree数据结构。

遵循左小又大原则存放。采用中序遍历方式遍历取数据。

<img src="G:\StudySoftware\EclipseWorkspace\clone\javaStudy\text\MySQL\assets\索引的实现原理-17482640194892.png" alt="索引的实现原理"  width="13590" height="549"/>

#### 8.3 使用场景

1. 数据量庞大
2. 该字段经常出现在where的后面，以条件的形式存在，也就是说这个字段总是被扫描。
3. 该字段很少的DML(insert delete update)操作。（因为DML之后，索引需要重新排序）

建议不要随意添加索引，因为索引也是需要维护的，太多的话反而会降低系统的性能。建议通过主键查询，建议通过unique约束的字段进行查询，效率是比较高的。

#### 8.4 语法

`创建索引：`

```mysql
create index 取的索引名 on 表名(字段名);
create index emp_ename_index on emp;
```

`删除索引：`

```mysql
drop index 取的索引名 on 表名;
drop index emp_ename_index on emp;
```

`查看SQL语句是否用索引：`

```mysql
explain select * from emp where ename = 'KING';
```

结果里`type`为`ALL`，表示未使用索引，扫描的记录数`rows`为所有记录；

结果里`type`为`ref`，表示使用索引。

#### 8.5 索引失效

1.模糊查询以`%`开头

```mysql
select * from emp where ename like '%T';
```

2.使用`or`时，`or`两边的条件字段都要有索引，否则不走索引

```mysql
explain select * from emp 
	where ename='KING' or job=`MANAGER';
```

3.使用复合索引（多个字段联合起来添加索引）时，未使用左面的列查找

```mysql
create index emp_job_sal_index on emp(job,sal);
//使用索引
explain select * from emp where job = 'MANAGER';
//未使用索引
explain select * from emp where sal = 800;
```

4.在`where`中索引列参加了运算

```mysql
create index emp_sal_index on emp(sal);
explain select * from emp where sal = 800;
explain select * from emp where sal+1 = 800;
```

5.在`where`中索引列使用了函数

```mysql
explain select * from emp where lower(ename)='smith';
```

#### 8.6 分类

索引是各种数据库进行优化的重要手段。优化的时候优先考虑的因素就是索引。

索引在数据库当中分了很多类

`单一索引`：一个字段上添加索引。
`复合索引`：两个字段或者更多的字段上添加索引。
`主键索引`：主键上添加索引。
`唯一性索引`：具有unique约束的字段上添加索引。
.....

`注意：`唯一性比较弱的字段上添加索引用处不大。



### 9 视图

#### 9.1 定义

`view:`站在不同的角度去看待同一份数据。

#### 9.2 语法

`创建视图：`

```mysql
create view 取视图名 as DQL语句;
create view dept2_view as select * from dept2;
```

`删除视图：`

```mysql
drop view 视图名;
drop view dept2_view;
```

**注意：只有DQL语句才能以view的形式创建，即创建时as后只能为DQL语句**




面向视图对象进行增删改查，对视图对象的增删改查，会导致原表被操作

**视图的特点：通过对视图的操作，会影响到原表数据。**

`面向视图查询：`

```mysql
select * from dept2_view;
```

`面向视图插入：`

```mysql
insert into dept2_view(deptno,dname,loc) values(60,'SALES','bj');
```

`面向视图删除：`

```mysql
delete from dept2_view;
select * from dept2_view;
select * from dept2;
//查询均为空
```

`面向视图更新：`

```mysql
create view 
	emp_dept_view as
	select e.ename,e.sal,d.dname
	from emp e join dept d on e.deptno = d.deptno;
```

```mysql
update emp_dept_view set sal = 5000 where dname = 'ACCOUNTING';
```



#### 9.3 作用

​	在实际开发中，假设有一条非常复杂的SQL语句，而这条SQL语句需要在不同的位置上反复使用。每一次使用这个sql语句的时候都需要重新编写，很长，很麻烦，则可以把这条复杂的SQL语句以视图对象的形式新建。
​	在需要编写这条SQL语句的位置直接使用视图对象，可以大大简化开发。并且利于后期的维护，因为修改的时候也只需要修改一个位置就行，只需要修改视图对象所映射的SQL语句。
​	我们以后面向视图开发的时候，使用视图的时候可以像使用table一样。可以对视图进行增删改查等操作。视图不是在内存当中，视图对象也是存储在硬盘上的，不会消失。



```
视图对应的语句只能是DQL语句。
但是视图对象创建完成之后，可以对视图进行增删改查等操作。
```

	小插曲：
	增删改查，又叫做：CRUD。
	
	C:Create（增）
	R:Retrive（查：检索）
	U:Update（改）
	D:Delete（删）



### 10 DBA常用命令

重点掌握：
		数据的导入和导出（数据的备份）
		其它命令了解一下即可。

`数据导出：`

```
注意：在windows的dos命令窗口中：
mysqldump bjpowernode>D:\bjpowernode.sql -uroot -p123456

可以导出指定的表
mysqldump bjpowernode emp>D:\bjpowernode.sql -uroot -p123456
```

`数据导入：`

```
注意：需要先登录到mysql数据库服务器上。
然后创建数据库：create database bjpowernode;

使用数据库：use bjpowernode
然后初始化数据库：source D:\bjpowernode.sql
```



### 11 数据库设计三范式

#### 11.1 内容

数据库表的设计依据。教你怎么进行数据库表的设计。

共有3个：

**第一范式：要求任何一张表必须有主键，每一个字段原子性不可再分。**

**第二范式：建立在第一范式的基础之上，要求所有非主键字段完全依赖主键，**
**不要产生部分依赖。**

**第三范式：建立在第二范式的基础之上，要求所有非主键字段直接依赖主键，**
**不要产生传递依赖。**

设计数据库表时，按照以上范式进行，可以避免表中数据的冗余、空间的浪费。

#### 11.2 第一范式

**最核心，最重要的范式，所有表的设计都需要满足。**

**必须有主键，并且每一个字段都是原子性不可再分。**

	学生编号 	学生姓名 	联系方式
	------------------------------------------
	1001		张三		zs@gmail.com,1359999999
	1002		李四		ls@gmail.com,13699999999
	1001		王五		ww@163.net,13488888888

上表不满足第一范式，第一：没有主键。第二：联系方式可以分为邮箱地址和电话

```
学生编号(pk) 		学生姓名	邮箱地址			联系电话
----------------------------------------------------
1001				张三		zs@gmail.com	1359999999
1002				李四		ls@gmail.com	13699999999
1003				王五		ww@163.net		13488888888
```

#### 11.3 第二范式

**建立在第一范式的基础之上**

**要求所有非主键字段必须完全依赖主键，不要产生部分依赖。**

```
学生编号 		学生姓名 	教师编号 教师姓名
----------------------------------------------------
1001			张三		001		王老师
1002			李四		002		赵老师
1003			王五		001		王老师
1001			张三		002		赵老师
```

这张表描述了学生和老师的关系：1个学生可能有多个老师，1个老师有多个学生
这是非常典型的：多对多关系！不满足第一范式。

```
学生编号+教师编号(pk)		  学生姓名  	 教师姓名
----------------------------------------------------
1001		001				张三			王老师
1002		002				李四			赵老师
1003		001				王五			王老师
1001		002				张三			赵老师
```

学生编号 教师编号，两个字段联合做主键，复合主键（PK: 学生编号+教师编号）
经过修改之后，以上的表满足了第一范式。但不满足第二范式
“张三”依赖1001，“王老师”依赖001，显然产生了部分依赖。
导致数据冗余、空间浪费。“张三”重复了，“王老师”重复了。

应使用三张表来表示多对多的关系

```
学生表
学生编号(pk)		学生名字
------------------------------------
1001					张三
1002					李四
1003					王五
		
教师表
教师编号(pk)		教师姓名
--------------------------------------
001					王老师
002					赵老师

学生教师关系表
id(pk)			学生编号(fk)			教师编号(fk)
------------------------------------------------------
1				1001					001
2				1002					002
3				1003					001
4				1001					002
```

口诀：多对多怎么设计？
			**多对多，三张表，关系表两个外键**

#### 11.4 第三范式

**第三范式建立在第二范式的基础之上**

**要求所有非主键字典必须直接依赖主键，不要产生传递依赖。**

```
学生编号（PK） 学生姓名 	班级编号  		班级名称
---------------------------------------------------------
1001	 		张三		01			一年一班
1002			李四		02			一年二班
1003			王五		03			一年三班
1004			赵六		03			一年三班
```

班级和学生的关系。很显然是1对多关系！一个教室中有多个学生。

满足第一范式，有主键。

满足第二范式，因为主键不是复合主键，没有产生部分依赖。主键是单一主键。

一年一班依赖01，01依赖1001，产生了传递依赖。
不符合第三范式的要求。产生了数据的冗余。

```
班级表：一
班级编号(pk)				班级名称
----------------------------------------
01							一年一班
02							一年二班
03							一年三班

学生表：多
学生编号（PK） 学生姓名 班级编号(fk)
-------------------------------------------
1001			张三			01			
1002			李四			02			
1003			王五			03			
1004			赵六			03		
```

口诀：
			**一对多，两张表，多的表加外键**

#### 11.5 总结

**一对多：一对多，两张表，多的表加外键**

**多对多：多对多，三张表，关系表两个外键**

**一对一：一对一，外键唯一**

在实际的开发中，可能存在一张表字段太多，太庞大。这个时候要拆分表。
一对一怎么设计？
没有拆分表之前：一张表

```
t_user
id	login_name	login_pwd	real_name	email	address	...

-------------------------------------------------------------

1	zhangsan	123			张三		zhangsan@xxx
2	lisi		123			李四		lisi@xxx
...
```

这种庞大的表建议拆分为两张：

	t_login 登录信息表
	id(pk)		login_name		login_pwd	
	---------------------------------
	1			zhangsan		123			
	2			lisi			123			
	
	t_user 用户详细信息表
	id(pk)		real_name	email	address	login_id(fk+unique)
	------------------------------------------------------------
	100			张三		zhangsan@xxx	...			1
	200			李四		lisi@xxx		...			2



数据库设计三范式是理论上的。

	实践和理论有的时候有偏差。
	
	最终的目的都是为了满足客户的需求，有的时候会拿冗余换执行速度。
	
	因为在sql当中，表和表之间连接次数越多，效率越低。（笛卡尔积）
	
	有的时候可能会存在冗余，但是为了减少表的连接次数，这样做也是合理的，
	并且对于开发人员来说，sql语句的编写难度也会降低。
