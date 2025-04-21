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



























