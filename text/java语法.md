### 一、数据类型

#### 1.char

 \u0000到\uFFFF	![image-20240923145012808](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923145012808.png)

![image-20240923144936274](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923144936274.png)

#### 2.boolean布尔

​	True/False	没有整型0、1的对于概念

#### 3.var

​	关键字	根据初始值定义推断类型

#### 4.final

常量

类常量：static final，可以在一个类的多个方法中使用。

类常量的定义位于main方法的外部。

因此，在同一个类的其他方法中也可以使用这个常量。

而且，如果一个常量被声明为public, 那么其他类的方法也可以使用这个常量。

![image-20240923151321046](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923151321046.png)

#### 5.枚举类型![image-20240923151444383](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923151444383.png)

![image-20240923151512091](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923151512091.png)

### 二、运算符

#### 1.整除：/

#### 2.Math函数

​							 Math.sqrt(x)	Math.pow(x,a)

​							Math.sin/cos/tan/atan/atan2/exp/log/log10/PI/E

![image-20240923152133948](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923152133948.png)

#### 3.类型转换

 四舍五入：(int)Math.round(x)	返回long类型，故转换	![image-20240923152455009](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923152455009.png)

#### 4.三元操作符

​	如果条件为true，表达式为第一个表达式的值， 否则为第二个表达式的值。

   ![image-20240923152653588](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923152653588.png)

#### 5.位运算符

​	&	|	^(xor)	~(not)	移位：>>，<<，>>>(用0填充高位)

![image-20240923153920124](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923153920124.png)

### 三、字符串

#### 1.定义

##### 		（1）String e = "";

#####			（2）String.format

![image-20240924212154143](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924212154143.png)

#### 2.子串

​	s2 = s1.substring(a,b)	//从a开始截，长度b

![image-20240923154354133](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240923154354133.png)

#### 3.拼接

#####			（1）两个：+

##### 	（2）多个：静态join方法![image-20240924160131640](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924160131640.png)

#####  	（3）repeat

#####  			![image-20240924160210648](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924160210648.png)

#### 4.不可变

​	字符串中的单个字符不可变，String类对象称为是不可变的，引用另外一个字符串。

​	通过拼接来创建一个新字符串。

​	缺点：效率不高。

​	优点：编译器可以让字符串共享。

#### 5.检测相等

​	s.equals(t)	相/不等：返回true/false

​	不区分大小写：	s.equalsIgnoreCase(t)

​	注意：不能用==![image-20240924161343605](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924161343605.png)

#### 6.空串和Null串

​	空串：str.length()=0，str.equals("")=True

​		Null用==/!=，不能调用方法。

#### 7.码点与代码单元

![image-20240924162753286](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924162753286.png)	

![image-20240924162950922](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924162950922.png)

#### 8.String API

![image-20240924163054811](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924163054811.png)

![image-20240924163124616](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924163124616.png)		![image-20240924163249269](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924163249269.png)

#### 9.构建字符串

​	![image-20240924164033379](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924164033379.png)

​	好处：多个短字符串构建时，无需构建一个新String对象，节约时间、空间。

![image-20240924164212487](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924164212487.png)

![image-20240924164219536](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924164219536.png)

### 四、输入输出

#### 1.输入

​	标准输入流：System.in

​	Scanner in = new Scanner(System.in);	//输入可见

##### 		（1）nextLine方法	
​			String str= in.nextLine();	//输入行可以包含空格

##### （2）next方法

​			 String str = in.next();	//以空格为分隔符

##### （3）nextInt方法

​			int age = in.nextInt();	//读整数，浮点数用nextDouble

​	注：Scanner要import java.util.*;	使用的类不定义在java.lang包中时，要import

##### （4）Console方法

​	Console cons = System.console();	//输入不可见

​	String username =cons.readLine("User name:");

​	char[] password = cons.readPassword("Password:");

​	注：import  java.io.Console.*;

为安全起见，返回的密码存放在一个字符数组中，而不是字符串中。在对密码处
理完成之后，应该马上用一个填充值覆盖数组元素。
采用Console对象处理输入不如采用Scanner 方便。必须每次读取一行输入，而没
有能够读取单个单词或数值的方法。

##### （5）API

![image-20240924211615151](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924211615151.png)

![image-20240924211634858](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924211634858.png)

#### 2.格式化输出

##### （1）System.out.print(x);

##### （2）System.out.printf();![image-20240924212011784](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924212011784.png)

![image-20240924212101359](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924212101359.png)

#### 3.文件输入与输出

##### （1）读取	

​		Scanner in = new Scanner(Path.of("myfile.txt"),StandardCharsets.UTF_8);

​		省略字符编码会按照机器的默认编码，可能回不一样。

##### （2）写入

​		PrintWriter out = new PrintWriter("myfile.txt",StandardCharsets.UTF_8);

​		如果文件不存在，创建该文件。可以像输出到System.out--样使用print、println以		及printf命令。![image-20240924214118214](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924214118214.png)

##### （3）位置![image-20240924214055028](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924214055028.png)

![image-20240924214108451](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924214108451.png)

##### （4）API

![image-20240924214155875](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240924214155875.png)

### 五、控制流程

​		if/while/do while/for/switch

#### 1.switch

​		case类型为：char、byte、short、int的常量表达式

​								枚举常量

​								字符串字面量

#### 2. break

​		不带标签、带标签

​		带标签的break可用在选择、块{}、循环（ 类似goto）

​		![image-20240926144525403](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926144525403.png)

​	注意：只能跳出语句块，不能跳入语句块

### 六、大数

#### 1.使用

![image-20240926150312924](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926150312924.png)

![image-20240926150335056](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926150335056.png)

#### 2.API

![image-20240926150410711](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926150410711.png)

![image-20240926150431479](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926150431479.png)

### 七、数组

#### 1.声明

​		int[] a = new int[100];

​		int[] a = {1,2,3,4,5,};	最后一个值后面允许有逗号，方便为数组增加值。

![image-20240926151234741](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926151234741.png)

#### 2.访问

![image-20240926151649763](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926151649763.png)

​		array.length	数组中元素个数

#### 3.for each循环

![image-20240926153229866](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926153229866.png)

![image-20240926153327907](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926153327907.png)

#### 4.拷贝

![image-20240926153908460](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926153908460.png)

#### 5.命令行参数

![image-20240926155011879](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926155011879.png)

![image-20240926155020884](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926155020884.png)

#### 6.排序

​		对数值型数组排序	Array.sort(a)

![image-20240926155320822](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926155320822.png)![image-20240926155329043](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926155329043.png)

#### 7.多维数组

![image-20240926161913547](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926161913547.png)

![image-20240926161923457](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926161923457.png)

![image-20240926162106299](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926162106299.png)

#### 8.不规则数组

​		Java实际上没有多维数组，只有一维数组。多维数组被解释为“数组的数组“
![image-20240926162453492](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926162453492.png)

