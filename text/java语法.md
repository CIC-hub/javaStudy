## 一、基本结构

### Ⅰ. 数据类型

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

### Ⅱ. 运算符

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

### Ⅲ. 字符串

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

### Ⅳ. 输入输出

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

### Ⅴ. 控制流程

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

### Ⅵ. 大数

#### 1.使用

![image-20240926150312924](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926150312924.png)

![image-20240926150335056](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926150335056.png)

#### 2.API

![image-20240926150410711](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926150410711.png)

![image-20240926150431479](C:\Users\11813\AppData\Roaming\Typora\typora-user-images\image-20240926150431479.png)

### Ⅶ. 数组

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

## 二、对象与类

### Ⅰ. 类

​	属性/成员变量 + 方法

#### 1.格式

​	修饰符  class  类名{

​		属性声明：	//类的成员变量可以不初始化，有默认值

​		方法声明：	修饰符  数据类型  方法名  参数

​	}

#### 2.类的属性

##### （1）格式

​	修饰符  类型  属性名  =  初值;

​	修饰符：private只能在本类的内部使用，不能在类的外部使用--封装与隐藏s/get

​			public可以在类的外部使用

##### （2）变量的分类

​	成员变量：类里声明的变量，分为实例变量和类变量

​		实例变量：不用static修饰	在类实例化成对象后才能使用

​		类变量：用static修饰，斜体	直接通过类名.属性直接调用

​	特点：

​	①成员变量定义在类中，在整个类中都可以被访问。

​	②成员变量分为类成员变量和实例成员变量，实例变量存在于对象所在的堆内存中。

​	③成员变量有默认初始化值。

​	④成员变量的权限修饰符可以根据需要，选择任意-一个

​	局部变量：方法体内声明的变量，分为形参、方法局部变量和代码块局部变量

​		形参：方法定义的变量

​		方法局部变量：在方法内定义的变量

​		代码块局部变量：类里大括号里定义的变量

​	特点：

​	①局部变量只定义在局部范围内，如:方法内，代码块内等。

​	②局部变量存在于栈内存中。

​	③作用的范围结束，变量空间会自动释放。

​	④局部变量没有默认初始化值，每次必须显式初始化。

​	⑤局部变量声明时不指定权限修饰符。

#### 3.类的方法

注意：同一个类中，所有的方法可以直接调用，不用实例化对象

##### （1）声明

​	修饰符	返回类型	函数名

##### （2）使用

​	声明的类的变量名.类的方法;	//对象方法的调用

##### （3）重载

​	方法名相同，参数类型/个数/顺序不同

##### （4）接收参数

​	可用...来代替未知个数的参数

```java
public void printInfo2(String... str) {
	for(int i=0;i<str.length;i++) {
		System.out.println(str[i]);
	}
}
```

说明：	

​	1.可变参数:方法参数部分指定类型的参数个数是可变多个
​	2.声明方式:方法名(参数的类型名...参数名)
​	3.可变参数方法的使用与方法参数部分使用数组是一-致的
​	4.方法的参数部分有可变形参，需要放在形参声明的最后

##### （5）参数传递

​	实参/形参	Java方法的参数传递方式只有一种：值传递

JVM内存模型：栈stack、堆heap、方法区method

​	栈stack：基础数据类型、对象的引用（对象的地址）

​	堆heap：所有的对象（包括自己定义的对象和字符串对象）

​	方法区method：所有的class和static变量

总结：
	如果方法的形参是基本数据类型，那么实参(实际的数据)向形参传递参数时，就是直接传递值，把实参的值复制给形参。

​	如果方法的形参是对象，那么实参（实际的对象）， 向形参传递参数的时候，也是把值给形参，这个值是实参在栈内存中的值，也就是引用对象在堆内存中的地址。

​	基本数据类型都是保存在栈内存中，引用对象在栈内存中保存的是引用对象的地址，那么方法的参数传递是传递值（是变量在栈内存的当中的值）

#### 4.访问机制

​	类中的方法可以直接访问类中的成员变量，static方法只能访问static的成员变量

​	不同类中先创建类的对象，再用对象访问类中的成员

### Ⅱ. 对象

​	类的实例化	创建一个新的对象

#### 1.格式

​	类名  变量名  =  new  类名();	//声明变量，实例化类并赋值

#### 2.初始化

|     成员变量类型     |        初始值        |
| :------------------: | :------------------: |
|         byte         |          0           |
|        short         |          0           |
|         int          |          0           |
|         long         |          0L          |
|        float         |         0.0F         |
|        double        |         0.0D         |
|         char         | '\u0000'（表示为空） |
|       boolean        |        false         |
| 引用类型（String等） |         null         |

#### 3.匿名对象

​	new Person.showInfo();	//只使用一次，可省略声明对象 或 将匿名对象作为实参传递给方法使用

### Ⅲ.包与引用

#### 1.包

​	java中的包package等同于文件夹的概念， 包和文件夹一样可以有多级，也就是包下可以有包和文件，多级的包使用.分隔，例如com包下的cn包下的test包，写法就是com.cn.test

#### 2.引用

​	import  包名.子包名. 类名;	或	import  包名.子包名.*;

​	包名.子包名.类名  变量  =  new  包名.子包名.类名(); 

### Ⅳ.访问权限修饰符

|  修饰符   | 类内部 | 同一个包 | 子类 | 任何地方 |
| :-------: | :----: | :------: | :--: | :------: |
|  private  |  Yes   |          |      |          |
| （缺省）  |  Yes   |   Yes    |      |          |
| protected |  Yes   |   Yes    | Yes  |          |
|  public   |  Yes   |   Yes    | Yes  |   Yes    |

class只能用public和default（缺省）

public类可以在任意地方被访问，default类只可以被同一个包内部的类访问。

一个class里只能有一个public修饰的。

### Ⅴ.类的构造方法

new对象实际上就是调用类的构造方法

```java
public class Person{
	public Person(){}	//默认
    public Person(int a){}	//构造器重载
}

class Person1{
	Person1(){}	//默认	修饰符与类的统一
}

public class Person2{	
    public Person2(){
        age = 1;
		name = "zhangsan";  
    }
    public int age;
	publicpublic String name;
}
//使用：Person2 p2 = new Person2(); 此时p2.age=1，p2.name="zhangsan"

public class Person3{
    public Person3(int a,String n){
        age = a;
		name = n;  
    }
    public int age;
	publicpublic String name;
}
//使用：Person3 p3 = new Person3(1,"lisi"); 此时p3.age=1，p3.name="lisi"


```

注意：	

​	Java语言中，每个类都至少有一个构造器
​	默认构造器的修饰符与所属类的修饰符一致
​	一旦显式定义了构造器，则系统不再提供默认构造器
​	一个类可以创建多个重载的构造器
​	父类的构造器不可被子类继承

### Ⅵ.this关键字

1.当形参与成员变量重名时，如果在方法内部需要使用成员变量，必须添加this来表明该变量时类成员

2.在任意方法内，如果使用当前类的成员变量或成员方法可以在其前面添加this,增强程序的阅读性

```java
public c1ass Person7 {
	public Person7(int age. String name){
        this.age = age;
        this.name = name;
    }
    int age;
    String name;
    public vo1d setName (String name){
        this.name = name;
    }
    public void setName1 (String name){
    	this.setName(name);
    }
    public void showInto(){
        System.out.println("姓名:”+ this.name); 
        System.out.println("年龄:”+ this.age);
    }
}
```
3.this可以作为一个类中，构造器相互调用的特殊格式

```java
public c1ass Person7 {
    public Person7(){ 
        
    }
     public Person7(int age){
        this.age = age;
    }
	public Person7(String name){
		this();	//等同于Person7();
        this.name = name;
    }
    public Person7(int age,String name){
        this(1);	//等同于Person7(1);
        this.age = age;
        this.name = name;
    }
    int age;
    String name;
}
```

注意：

​	1.使用this()必须放在构造器的首行!
​	2.使用this调用本类中其他的构造器，保证至少有一个构造器是不用this的。（实际上就是不能出现构造器自己调用自己）

```java
public c1ass Person7 {
    public Person7(){
    	this();	//错
或者     this("name");	//错，变相的调用自己
    }
     public Person7(int age){
        this.age = age;
    }
    public Person7(String name){
        this();	//等同于Person7();
        this.name = name;
    }
    public Person7(int age,String name){
        this(1);	//等同于Person7(1);
        this.age = age;
        this.name = name;
    }
    int age;
    String name;
}
```
###  Ⅶ.JavaBean

●JavaBean是一种Java语言写成的可重用组件。
●所谓javaBean，是指符合如下标准的Java类:
➢类是公共的
➢有一个无参的公共的构造器
➢有属性，属性- -般是私有的，且有对应的get、set方法
●用户可以使用JavaBean将功能、处理、值、数据库访问和其他任何可以用java代
码创造的对象进行打包，并且其他的开发者可以通过内部的JSP页面、Servlet、 其
他JavaBean、applet程序或 者应用来使用这些对象。用户可以认为JavaBean提供了一
种随时随地的复制和粘贴的功能，而不用关心任何改变。



使用方法：

​	类里变量为private，写完后，选中右键->Source->Generate Getters and Setters...，生成set和get方法。







