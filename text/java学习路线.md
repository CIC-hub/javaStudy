[人类高质量 Java 学习路线【一条龙版】 - 程序员鱼皮 - 博客园](https://www.cnblogs.com/yupi/p/15166218.html)

## 阶段 3：Java 企业开发基础

### 目标

面向薪资编程，学习实际工作要用的技术，并能 **独立** 做出一个具有完整功能的 Java Web 项目。

### MySQL 数据库（7 天）	17

企业中大部分业务数据都是用关系型数据库存储的，因此数据库是后台开发同学的必备技能，其中 MySQL 数据库是目前的主流，也是面试时的重点。

#### 知识

- 基本概念
- MySQL 搭建
- SQL 语句编写
- 约束
- 索引
- 事务
- 设计数据库表
- 性能优化

#### 学习建议

其中，**SQL 语句编写** 和 **设计数据库表** 这两个能力一定要有！

比如让你做一个学生管理系统，你要能想到需要哪些表，比如学生表、班级表；每个表需要哪些字段、字段类型。

这就要求大家多写 SQL、多根据实际的业务场景去练习设计能力。

#### 资源

- 视频
  - ⭐ 老杜 - mysql入门基础 + 数据库实战：https://www.bilibili.com/video/BV1Vy4y1z7EX（较新、内容相对精炼，有习题）

### 开发框架（60 天）

Java 之所以能成为主流的企业开发语言，很大一部分原因是它完善的框架生态，用好框架，不仅能够大大提升开发效率，还能提高项目的稳定性、减少维护成本。

开发框架是后台开发工作中不可或缺的，也是面试考察的重点，一定要好好学！

不知道 Java 能做什么的朋友们，学完开发框架，就会有答案啦。

下面给大家推荐的都是企业中应用最多的主流开发框架，知识点比较零碎，就放在一起讲了。

#### 知识

##### Java Web	46

- 描述：Java 网页应用开发基础
- 前端基础
- XML
- JSON
- Servlet
- Filter
- Listener
- JSP
- JSTL
- Cookie
- Session

##### Spring 5	15

- 描述：Java 轻量级应用框架
- IOC
- AOP
- 事务

##### SpringMVC	16

- 描述：Java 轻量级 web 开发框架
- 什么是 MVC？
- 请求与响应
- Restful API
- 拦截器
- 配置
- 执行过程

##### MyBatis	14

- 描述：数据访问框架，操作数据库进行增删改查等操作
- 增删改查
- 全局配置
- 动态 SQL
- 缓存
- 和其他框架的整合
- 逆向工程

##### MyBatis Plus	7

- 描述：Mybatis 的增强工具，能够简化开发、提高效率
- 引入
- 通用 CRUD
- 条件构造器
- 代码生成器
- 插件扩展
- 自定义全局操作

##### SpringBoot 2	26

- 描述：简化 Spring 应用的初始搭建以及开发过程，提高效率
- 常用注解
- 资源整合
- 高级特性
- 本地热部署

##### Spring Security	8

- 描述：Spring 的安全管理框架
- 用户认证
- 权限管理

##### Maven / Gradle	5

- 描述：项目管理工具
- 构建
- 依赖管理
- 插件
- 配置
- 子父工程

#### 学习建议

由于技术较多，且框架之间存在一定的联系，因此建议大家看同一系列的视频教程（尚硅谷、狂神说等等都可以），以保证学习内容的连续以及体验上的一致。

学这些技术的时候，**千万不能懒** ！一定要多记笔记，并且跟着老师写代码。原理部分不要太过纠结，先以能跟着敲出代码、写出可运行的项目为主，有些东西做出来也能帮助你更好地理解理论。

学习顺序挺重要的，建议按我推荐的顺序学，不要一上手就学 SpringBoot。只有先学习下自己整合框架的方法，才能帮你理解 SpringBoot 解决的问题，感受到它的方便和高效。

Maven / Gradle 当工具用就好，面试基本不问，跟着框架教程去用就行了，先不用花太多时间去深入学。

#### 资源

- 视频（按顺序看）
  - ⭐ 尚硅谷最新版 JavaWeb 全套教程：https://www.bilibili.com/video/BV1Y7411K7zz（前端部分最好也看下）
  - ⭐ 尚硅谷 - Spring 5 框架最新版教程（idea版）：https://www.bilibili.com/video/BV1Vf4y127N5
  - ⭐ 尚硅谷 - SpringMVC 2021 最新教程：https://www.bilibili.com/video/BV1Ry4y1574R
  - ⭐ 尚硅谷 - MyBatis 实战教程全套完整版：https://www.bilibili.com/video/BV1mW411M737
  - ⭐ 尚硅谷 - MyBatisPlus 教程：https://www.bilibili.com/video/BV1Ds411E76Y
  - Maven 零基础入门教程：https://www.bilibili.com/video/BV1TW411g7hP（搞不懂 Maven 可以看看）
  - ⭐ 雷丰阳 2021 版 SpringBoot2 零基础入门：https://www.bilibili.com/video/BV19K4y1L7MT
  - 尚硅谷 - SpringSecurity 框架教程：https://www.bilibili.com/video/BV15a411A7kP

### 开发规范（3 天）

开发不规范，同事两行泪。

开发规范是团队开发中必须遵守的，有利于提高项目的开发效率、降低维护成本。

#### 知识

- 代码规范
  - 代码风格
  - 命名
  - 其他规则
- 提交规范

#### 学习建议

简单过一遍大厂团队的规范手册就好了，以后做项目的时候能想起来的话就去使用，或者从书中、网上查规范，再去遵守。

项目做得多了，自然会养成好的习惯，不用刻意去记（毕竟每个团队规范也不完全相同，背了也没用）。

#### 资源

- 书籍
  - ⭐ 阿里巴巴 Java 开发手册：https://developer.aliyun.com/graph/java（搜索《Java开发手册》）
- 视频
  - 华山版《Java开发手册》独家讲解：https://developer.aliyun.com/live/1201
- 文档
  - Google Java Style Guide：https://google.github.io/styleguide/javaguide.html（谷歌 Java 代码规范）

### Git（3 天）

此前大家可能听说过 GitHub，一流的代码开源托管平台。

Git 和它可不一样，是一个版本控制工具，可以更好地管理和共享项目代码，比如把自己的代码传到 GitHub 上、或者从远程下载。

无论自己做项目、还是团队开发，Git 都是现在不可或缺的神器。

#### 知识

- 工作区
- 分支
- 代码提交、推送、拉取、回退、重置
- 分支操作
- 代码合并、解决冲突
- 标签
- cherry-pick

#### 学习建议

每个命令跟着敲一遍，有个大致的印象，会用即可，用的多了自然熟悉了。

#### 资源

- 视频
  - ⭐【尚硅谷】5h打通Git全套教程丨2021最新IDEA版 https://www.bilibili.com/video/BV1vy4y1s7k6
- 书籍
  - 猴子都能懂的 Git 入门 https://backlog.com/git-tutorial/cn/
  - ⭐ GitHub 漫游指南 https://github.phodal.com/
- 文档
  - GitHub 官方文档：https://docs.github.com/cn
- 游戏
  - Learning Git Branching：https://learngitbranching.js.org/?locale=zh_CN
