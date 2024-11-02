## 一、基本结构

### Ⅰ. 数据类型

#### 1.char

 \u0000到\uFFFF	![image-20240923145012808]( assets\image-20240923145012808.png)

![image-20240923144936274]( assets\image-20240923144936274.png)

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

![image-20240923151321046]( assets\image-20240923151321046.png)

#### 5.枚举类型![image-20240923151444383]( assets\image-20240923151444383.png)

![image-20240923151512091]( assets\image-20240923151512091.png)

### Ⅱ. 运算符

#### 1.整除：/

#### 2.Math函数

​							 Math.sqrt(x)	Math.pow(x,a)

​							Math.sin/cos/tan/atan/atan2/exp/log/log10/PI/E

![image-20240923152133948]( assets\image-20240923152133948.png)

#### 3.类型转换

 四舍五入：(int)Math.round(x)	返回long类型，故转换	![image-20240923152455009]( assets\image-20240923152455009.png)

#### 4.三元操作符

​	如果条件为true，表达式为第一个表达式的值， 否则为第二个表达式的值。

   ![image-20240923152653588]( assets\image-20240923152653588.png)

#### 5.位运算符

​	&	|	^(xor)	~(not)	移位：>>，<<，>>>(用0填充高位)

![image-20240923153920124]( assets\image-20240923153920124.png)

### Ⅲ. 字符串

#### 1.定义

##### 		（1）String e = "";

#####			（2）String.format

![image-20240924212154143]( assets\image-20240924212154143.png)

#### 2.子串

​	s2 = s1.substring(a,b)	//从a开始截，长度b

![image-20240923154354133]( assets\image-20240923154354133.png)

#### 3.拼接

#####			（1）两个：+

##### 	（2）多个：静态join方法![image-20240924160131640]( assets\image-20240924160131640.png)

#####  	（3）repeat

#####  			![image-20240924160210648]( assets\image-20240924160210648.png)

#### 4.不可变

​	字符串中的单个字符不可变，String类对象称为是不可变的，引用另外一个字符串。

​	通过拼接来创建一个新字符串。

​	缺点：效率不高。

​	优点：编译器可以让字符串共享。

#### 5.检测相等

​	s.equals(t)	相/不等：返回true/false

​	不区分大小写：	s.equalsIgnoreCase(t)

​	注意：不能用==![image-20240924161343605]( assets\image-20240924161343605.png)

#### 6.空串和Null串

​	空串：str.length()=0，str.equals("")=True

​		Null用==/!=，不能调用方法。

#### 7.码点与代码单元

![image-20240924162753286]( assets\image-20240924162753286.png)	

![image-20240924162950922]( assets\image-20240924162950922.png)

#### 8.String API

![image-20240924163054811]( assets\image-20240924163054811.png)

![image-20240924163124616]( assets\image-20240924163124616.png)		![image-20240924163249269]( assets\image-20240924163249269.png)

#### 9.构建字符串

​	![image-20240924164033379]( assets\image-20240924164033379.png)

​	好处：多个短字符串构建时，无需构建一个新String对象，节约时间、空间。

![image-20240924164212487]( assets\image-20240924164212487.png)

![image-20240924164219536]( assets\image-20240924164219536.png)

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

![image-20240924211615151]( assets\image-20240924211615151.png)

![image-20240924211634858]( assets\image-20240924211634858.png)

#### 2.格式化输出

##### （1）System.out.print(x);

##### （2）System.out.printf();![image-20240924212011784]( assets\image-20240924212011784.png)

![image-20240924212101359]( assets\image-20240924212101359.png)

#### 3.文件输入与输出

##### （1）读取	

​		Scanner in = new Scanner(Path.of("myfile.txt"),StandardCharsets.UTF_8);

​		省略字符编码会按照机器的默认编码，可能回不一样。

##### （2）写入

​		PrintWriter out = new PrintWriter("myfile.txt",StandardCharsets.UTF_8);

​		如果文件不存在，创建该文件。可以像输出到System.out--样使用print、println以		及printf命令。![image-20240924214118214]( assets\image-20240924214118214.png)

##### （3）位置![image-20240924214055028]( assets\image-20240924214055028.png)

![image-20240924214108451]( assets\image-20240924214108451.png)

##### （4）API

![image-20240924214155875]( assets\image-20240924214155875.png)

### Ⅴ. 控制流程

​		if/while/do while/for/switch

#### 1.switch

​		case类型为：char、byte、short、int的常量表达式

​								枚举常量

​								字符串字面量

#### 2. break

​		不带标签、带标签

​		带标签的break可用在选择、块{}、循环（ 类似goto）

​		![image-20240926144525403]( assets\image-20240926144525403.png)

​	注意：只能跳出语句块，不能跳入语句块

### Ⅵ. 大数

#### 1.使用

![image-20240926150312924]( assets\image-20240926150312924.png)

![image-20240926150335056]( assets\image-20240926150335056.png)

#### 2.API

![image-20240926150410711]( assets\image-20240926150410711.png)

![image-20240926150431479]( assets\image-20240926150431479.png)

### Ⅶ. 数组

#### 1.声明

​		int[] a = new int[100];

​		int[] a = {1,2,3,4,5,};	最后一个值后面允许有逗号，方便为数组增加值。

![image-20240926151234741]( assets\image-20240926151234741.png)

#### 2.访问

![image-20240926151649763]( assets\image-20240926151649763.png)

​		array.length	数组中元素个数

#### 3.for each循环

![image-20240926153229866]( assets\image-20240926153229866.png)

![image-20240926153327907]( assets\image-20240926153327907.png)

#### 4.拷贝

![image-20240926153908460]( assets\image-20240926153908460.png)

#### 5.命令行参数

![image-20240926155011879]( assets\image-20240926155011879.png)

![image-20240926155020884]( assets\image-20240926155020884.png)

#### 6.排序

​		对数值型数组排序	Array.sort(a)

![image-20240926155320822]( assets\image-20240926155320822.png)![image-20240926155329043]( assets\image-20240926155329043.png)

#### 7.多维数组

![image-20240926161913547]( assets\image-20240926161913547.png)

![image-20240926161923457]( assets\image-20240926161923457.png)

![image-20240926162106299]( assets\image-20240926162106299.png)

#### 8.不规则数组

​		Java实际上没有多维数组，只有一维数组。多维数组被解释为“数组的数组“
![image-20240926162453492]( assets\image-20240926162453492.png)

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

如果子类和父类在同一个包下，那么对于父类的成员修饰符只要不是私有的private，那就都可以使用

如果子类和父类不在同一个包下， 子类只能使用父类中protected和public修饰的成员



Java还提供了一个`final`修饰符。`final`与访问权限不冲突，它有很多作用。

用`final`修饰`class`可以阻止被继承：

```java
package abc;

// 无法被继承:
public final class Hello {
    private int n = 0;
    protected void hi(int t) {
        long i = t;
    }
}
```

用`final`修饰`method`可以阻止被子类覆写：

```java
package abc;

public class Hello {
    // 无法被覆写:
    protected final void hi() {
    }
}
```

用`final`修饰`field`可以阻止被重新赋值：

```java
package abc;

public class Hello {
    private final int n = 0;
    protected void hi() {
        this.n = 1; // error!
    }
}
```

用`final`修饰局部变量可以阻止被重新赋值：

```java
package abc;

public class Hello {
    protected void hi(final int t) {
        t = 1; // error!
    }
}
```

小结：

Java内建的访问权限包括`public`、`protected`、`private`和`package`权限；

Java在方法内部定义的变量是局部变量，局部变量的作用域从变量声明开始，到一个块结束；

`final`修饰符不是访问权限，它可以修饰`class`、`field`和`method`；

一个`.java`文件只能包含一个`public`类，但可以包含多个非`public`类。

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
➢有属性，属性一般是私有的，且有对应的get、set方法
●用户可以使用JavaBean将功能、处理、值、数据库访问和其他任何可以用java代
码创造的对象进行打包，并且其他的开发者可以通过内部的JSP页面、Servlet、 其
他JavaBean、applet程序或 者应用来使用这些对象。用户可以认为JavaBean提供了一
种随时随地的复制和粘贴的功能，而不用关心任何改变。



使用方法：

​	类里变量为private，写完后，选中右键->Source->Generate Getters and Setters...，生成set和get方法。

## 三、继承

### Ⅰ. 类的继承

​	父类：共性	子类：个性

​	通过继承省略共性部分，子类只要写自己特有的代码

#### 1.语法

    class Subclass extends Superclass{ }

#### 2.作用

​	继承的出现提高了代码的复用性。
​	继承的出现让类与类之间产生了关系，提供了多态的前提。
​	不要仅为了获取其他类中某个功能而去继承。继承有逻辑关系，不能随意继承。

 注意：

​	子类继承了父类，就继承了父类的方法和属性。
​	在子类中，可以使用父类中定义的方法和属性，也可以创建新的数据和方法。
​	继承的关键字用的是“extends"，即子类不是父类的子集，而是对父类的“扩展”。

​	子类不能直接访问父类中私有的(private)的成员变量和方法。

​	一个子类只能有一个父类

#### 3.方法的重写override

​	Alt + /

​	子类重写父类的方法，只是重写编写方法体的代码

要求：

​	重写方法必须和被重写方法具有相同的方法名称、参数列表和返回值类型。
​	重写方法不能使用比被重写方法更严格的访问权限。
​	重写和被重写的方法须同时为static的，或同时为非static的
​	子类方法抛出的异常不能大于父类被重写方法的异常

#### 4.关键字super

作用：

​	super可用于访问父类中定义的属性
​	super可用于调用父类中定义的成员方法
​	super可用于在子类构造方法中调用父类的构造器
注意:
​	尤其当子父类出现同名成员时，可以用super进行区分
​	super的追溯不仅限于直接父类

使用：

​	子类中所有的构造器默认都会访问父类中空参数的构造器
​	当父类中没有空参数的构造器时，子类的构造器必须通过this(参数列表)或者super(参数列表)语句指定调用本类或者父类中相应的构造器，且必须放在构造器的第一行
​	如果子类构造器中既未显式调用父类或本类的构造器，且父类中又没有无参的构造器，则编译出错



 this与super区别

|    区别    |                             this                             |                         super                         |
| :--------: | :----------------------------------------------------------: | :---------------------------------------------------: |
|  访问属性  | 访问本类中的属性，如果本类访问父类中的属性没有此属性则从父类中继续查找 |                   访问父类中的属性                    |
|  调用方法  |                       访问本类中的方法                       | 直接访问父级中的方法(多层继承，super访问的父级的方法) |
| 调用构造器 |             调用本类构造器，必须放在构造器的首行             |       调用父类构造器，必须放在子类构造器的首行        |
|    特殊    |                         表示当前对象                         |                       无此概念                        |

在子类中，通过this或者是super调用构造器，只能使用一个，因为都要占据第一行

#### 5.简单类对象的实例化过程

简单类对象的实例化过程

![image-20241025111330659](assets\image-20241025111330659.png)

子类对象的实例化过程

![image-20241025111247946](assets\image-20241025111247946.png)

### Ⅱ.多态

#### 1.方法的多态

​	方法的重载(overload)和重写(overwrite)。

​	重载：本类中的同名方法	相同名称方法实现不同的逻辑
​	重写：子类对父类方法的覆盖	子类使用和父类相同的方法名，覆盖父类的逻辑。对				于父类的方法，想修改逻辑，但是有别的代码在调用父类的方法，可以考虑用				子类继承父类,重写父类的方法。

#### 2.对象的多态

##### （1）定义

​	对象的多态性：可以直接应用在抽象类和接口上。

​	Java引用变量有两个类型:编译时类型和运行时类型。编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给该变量的对象决定。
​	若编译时类型和运行时类型不一致，就出现多态(Polymorphism)

##### （2）使用

​	子类的对象可以替代父类的对象使用

1.一个变量只能有一种确定的数据类型

2.一个引用类型变量可能指向(引用)多种不同类型的对象

3.子类可看做是特殊的父类，所以父类类型的引用可以指向子类的对象：向上转型
(upcasting)。	//把子类的对象给父类的类型的变量引用

```java
Person e = new Student(); // Person类型的变量e,指向Student类型的对象

Person p = new Person();
p =	new Student();//p先指向new Person()，后指向new Student()
```
4.一个引用类型变量如果声明为父类的类型，但实际引用的是子类对象，那么该变量就不能再访问子类中添加的属性和方法。
属性是在编译时确定的，编译时为父类的类型， 没有子类的成员变量，因而编译错误。

5.虚拟方法调用(virtual Method Invocation)

```java
Person e = new Student();
e.getInfo(); // 调用student类的getinfo()方法
//编译时类型和运行时类型
//编译时e为Person类型，而方法的调用是在运行时确定的，所以调用的是Student类的getInfo()方法。-- -动态绑定
```

##### （3）总结

1.前提
	需要存在继承或者实现关系
	要有覆盖操作

2.成员方法
	编译时:要查看引用变量所属的类中是否有所调用的方法。
	运行时:调用实际对象所属的类中的重写方法。

成员方法的多态性，也就是动态绑定，必须得存在于方法的重写之上。

3.成员变量
	不具备多态性，只看引用变量所属的类。

4.子类继承父类
	若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，子类使用重写后的方法。若子类未重写父类方法，则使用父类方法。

​	对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，这个实例变量依然不可能覆盖父类中定义的实例变量。

5.方法声明的形参类型为父类类型，可以使用子类的对象作为实参调用该方法

#### 3.instanceof操作符

​	x instanceof A：检验x是否为类A的对象，返回值为boolean型。

​	要求x所属的类与类A必须是子类和父类的关系，否则编译错误。

​	如果x属于类A的子类B，x instanceof A值也为true。

#### 4.Object类

##### （1）说明

​	Object类是所有Java类的根父类。
​	如果在类的声明中未使用extends关键字指明其父类，则默认父类为Object类。

##### （2）使用

​	确定函数参数为类变量时，但不清楚为何种类时，可使用Object类型。

##### （3）主要方法

|              方法名               | 类型 |                    描述                     |
| :-------------------------------: | :--: | :-----------------------------------------: |
|          public Object()          | 构造 |                  构造方法                   |
| public boolean equals(Object obj) | 普通 | 对象比较，指向同一个对象时为true，其余false |
|       public int hashCode()       | 普通 |                 取得Hash码                  |
|     public String toString()      | 普通 |     对象打印时调用，打印对象的内存地址      |

​	所有类均可使用Object的方法



### 四、面向对象基础

#### 4.1抽象类

##### 4.1.1 概念

如果父类的方法本身不需要实现任何功能，仅仅是为了定义方法签名，目的是让子类去覆写它，那么，可以把父类的方法声明为抽象方法：

```java
class Person {
    public abstract void run();
}
```

把一个方法声明为`abstract`，表示它是一个抽象方法，本身没有实现任何方法语句。因为这个抽象方法本身是无法执行的，所以，`Person`类也无法被实例化。编译器会告诉我们，无法编译`Person`类，因为它包含抽象方法。

必须把`Person`类本身也声明为`abstract`，才能正确编译它：

```java
abstract class Person {
    public abstract void run();
}
```

因为抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。因此，抽象方法实际上相当于定义了“规范”。

##### 4.1.2 面向抽象编程

当我们定义了抽象类`Person`，以及具体的`Student`、`Teacher`子类的时候，我们可以通过抽象类`Person`类型去引用具体的子类的实例：

```java
Person s = new Student();
Person t = new Teacher();
```

这种引用抽象类的好处在于，我们对其进行方法调用，并不关心`Person`类型变量的具体子类型：

```java
// 不关心Person变量的具体子类型:
s.run();
t.run();
```

同样的代码，如果引用的是一个新的子类，我们仍然不关心具体类型：

```java
// 同样不关心新的子类是如何实现run()方法的：
Person e = new Employee();
e.run();
```

这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程。

面向抽象编程的本质就是：

- 上层代码只定义规范（例如：`abstract class Person`）；
- 不需要子类就可以实现业务逻辑（正常编译）；
- 具体的业务逻辑由不同的子类实现，调用者并不关心。

##### 4.1.3 总结

通过`abstract`定义的方法是抽象方法，它只有定义，没有实现。抽象方法定义了子类必须实现的接口规范；

定义了抽象方法的class必须被定义为抽象类，从抽象类继承的子类必须实现抽象方法；

如果不实现抽象方法，则该子类仍是一个抽象类；

面向抽象编程使得调用者只关心抽象方法的定义，不关心子类的具体实现。



#### 4.2 接口

##### 4.2.1 概念

在抽象类中，抽象方法本质上是定义接口规范：即规定高层类的接口，从而保证所有子类都有相同的接口实现，这样，多态就能发挥出威力。

如果一个抽象类没有字段，所有方法全部都是抽象方法，

就可以把该抽象类改写为接口：`interface`。

```java
interface Person {
    void run();
    String getName();
}
```

所谓`interface`，就是比抽象类还要抽象的纯抽象接口，因为它连字段都不能有。因为接口定义的所有方法默认都是`public abstract`的，所以这两个修饰符不需要写出来（写不写效果都一样）。

当一个具体的`class`去实现一个`interface`时，需要使用`implements`关键字。举个例子：

```java
class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " run");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
```

我们知道，在Java中，一个类只能继承自另一个类，不能从多个类继承。但是，一个类可以实现多个`interface`，例如：

```java
class Student implements Person, Hello { // 实现了两个interface
    ...
}
```

##### 4.2.2 术语

注意区分术语：

Java的接口特指`interface`的定义，表示一个接口类型和一组方法签名，而编程接口泛指接口规范，如方法签名，数据格式，网络协议等。

抽象类和接口的对比如下：

|            |    abstract class    |          interface          |
| :--------: | :------------------: | :-------------------------: |
|    继承    | 只能extends一个class | 可以implements多个interface |
|    字段    |   可以定义实例字段   |      不能定义实例字段       |
|  抽象方法  |   可以定义抽象方法   |      可以定义抽象方法       |
| 非抽象方法 |  可以定义非抽象方法  |     可以定义default方法     |

##### 4.2.3 接口继承

一个`interface`可以继承自另一个`interface`。`interface`继承自`interface`使用`extends`，它相当于扩展了接口的方法。例如：

```java
interface Hello {
    void hello();
}

interface Person extends Hello {
    void run();
    String getName();
}
```

##### 4.2.4 继承关系

合理设计`interface`和`abstract class`的继承关系，可以充分复用代码。一般来说，公共逻辑适合放在`abstract class`中，具体逻辑放到各个子类，而接口层次代表抽象程度。可以参考Java的集合类定义的一组接口、抽象类以及具体子类的继承关系：

```
┌───────────────┐
│   Iterable    │
└───────────────┘
        ▲                ┌───────────────────┐
        │                │      Object       │
┌───────────────┐        └───────────────────┘
│  Collection   │                  ▲
└───────────────┘                  │
        ▲     ▲          ┌───────────────────┐
        │     └──────────│AbstractCollection │
┌───────────────┐        └───────────────────┘
│     List      │                  ▲
└───────────────┘                  │
              ▲          ┌───────────────────┐
              └──────────│   AbstractList    │
                         └───────────────────┘
                                ▲     ▲
                                │     │
                                │     │
                     ┌────────────┐ ┌────────────┐
                     │ ArrayList  │ │ LinkedList │
                     └────────────┘ └────────────┘
```

在使用的时候，实例化的对象永远只能是某个具体的子类，但总是通过接口去引用它，因为接口比抽象类更抽象：

```java
List list = new ArrayList(); // 用List接口引用具体子类的实例
Collection coll = list; // 向上转型为Collection接口
Iterable it = coll; // 向上转型为Iterable接口
```

##### 4.2.5 default方法

在接口中，可以定义`default`方法。例如，把`Person`接口的`run()`方法改为`default`方法：

```java
// interface
public class Main {
    public static void main(String[] args) {
        Person p = new Student("Xiao Ming");
        p.run();
    }
}

interface Person {
    String getName();
    default void run() {
        System.out.println(getName() + " run");
    }
}

class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
```

实现类可以不必覆写`default`方法。`default`方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。如果新增的是`default`方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。

`default`方法和抽象类的普通方法是有所不同的。因为`interface`没有字段，`default`方法无法访问字段，而抽象类的普通方法可以访问实例字段。

##### 4.2.6 小结

Java的接口（interface）定义了纯抽象规范，一个类可以实现多个接口；

接口也是数据类型，适用于向上转型和向下转型；

接口的所有方法都是抽象方法，接口不能定义实例字段；

接口可以定义`default`方法（JDK>=1.8）。

#### 4.3 静态字段和静态方法

##### 4.3.1 静态字段

在一个`class`中定义的字段，我们称之为实例字段。实例字段的特点是，每个实例都有独立的字段，各个实例的同名字段互不影响。

还有一种字段，是用`static`修饰的字段，称为静态字段：`static field`。

实例字段在每个实例中都有自己的一个独立“空间”，但是静态字段只有一个共享“空间”，所有实例都会共享该字段。

对于静态字段，无论修改哪个实例的静态字段，效果都是一样的：所有实例的静态字段都被修改了，原因是静态字段并不属于实例：

```
        ┌──────────────────┐
ming ──▶│Person instance   │
        ├──────────────────┤
        │name = "Xiao Ming"│
        │age = 12          │
        │number ───────────┼──┐    ┌─────────────┐
        └──────────────────┘  │    │Person class │
                              │    ├─────────────┤
                              ├───▶│number = 99  │
        ┌──────────────────┐  │    └─────────────┘
hong ──▶│Person instance   │  │
        ├──────────────────┤  │
        │name = "Xiao Hong"│  │
        │age = 15          │  │
        │number ───────────┼──┘
        └──────────────────┘
```

虽然实例可以访问静态字段，但是它们指向的其实都是`Person class`的静态字段。所以，所有实例共享一个静态字段。

因此，不推荐用`实例变量.静态字段`去访问静态字段，因为在Java程序中，实例对象并没有静态字段。在代码中，实例对象能访问静态字段只是因为编译器可以根据实例类型自动转换为`类名.静态字段`来访问静态对象。

推荐用类名来访问静态字段。可以把静态字段理解为描述`class`本身的字段。对于上面的代码，更好的写法是：

```java
Person.number = 99;
System.out.println(Person.number);
```

##### 4.3.2 静态方法

有静态字段，就有静态方法。用`static`修饰的方法称为静态方法。

调用实例方法必须通过一个实例变量，而调用静态方法则不需要实例变量，通过类名就可以调用。静态方法类似其它编程语言的函数。例如：

```java
// static method
public class Main {
    public static void main(String[] args) {
        Person.setNumber(99);
        System.out.println(Person.number);
    }
}

class Person {
    public static int number;

    public static void setNumber(int value) {
        number = value;
    }
}
```

因为静态方法属于`class`而不属于实例，因此，静态方法内部，无法访问`this`变量，也无法访问实例字段，它只能访问静态字段。

通过实例变量也可以调用静态方法，但这只是编译器自动帮我们把实例改写成类名而已。

通常情况下，通过实例变量访问静态字段和静态方法，会得到一个编译警告。

静态方法经常用于工具类。例如：

- Arrays.sort()
- Math.random()

静态方法也经常用于辅助方法。注意到Java程序的入口`main()`也是静态方法。

##### 4.3.3 接口的静态字段

因为`interface`是一个纯抽象类，所以它不能定义实例字段。但是，`interface`是可以有静态字段的，并且静态字段必须为`final`类型：

```java
public interface Person {
    public static final int MALE = 1;
    public static final int FEMALE = 2;
}
```

实际上，因为`interface`的字段只能是`public static final`类型，所以我们可以把这些修饰符都去掉，上述代码可以简写为：

```java
public interface Person {
    // 编译器会自动加上public static final:
    int MALE = 1;
    int FEMALE = 2;
}
```

编译器会自动把该字段变为`public static final`类型。

##### 4.3.4 小结

静态字段属于所有实例“共享”的字段，实际上是属于`class`的字段；

调用静态方法不需要实例，无法访问`this`，但可以访问静态字段和其他静态方法；

静态方法常用于工具类和辅助方法。

#### 4.4 内部类

##### 4.4.1Inner Class

```java
class Outer {
    class Inner {
        // 定义了一个Inner Class
    }
}
```

上述定义的`Outer`是一个普通类，而`Inner`是一个Inner Class，它与普通类有个最大的不同，就是Inner Class的实例不能单独存在，必须依附于一个Outer Class的实例。示例代码如下：

```java
// inner class
public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer("Nested"); // 实例化一个Outer
        Outer.Inner inner = outer.new Inner(); // 实例化一个Inner
        inner.hello();
    }
}

class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    class Inner {
        void hello() {
            System.out.println("Hello, " + Outer.this.name);
        }
    }
}
```

观察上述代码，要实例化一个`Inner`，我们必须首先创建一个`Outer`的实例，然后，调用`Outer`实例的`new`来创建`Inner`实例：

```java
Outer.Inner inner = outer.new Inner();
```

这是因为Inner Class除了有一个`this`指向它自己，还隐含地持有一个Outer Class实例，可以用`Outer.this`访问这个实例。所以，实例化一个Inner Class不能脱离Outer实例。

Inner Class和普通Class相比，除了能引用Outer实例外，还有一个额外的“特权”，就是可以修改Outer Class的`private`字段，因为Inner Class的作用域在Outer Class内部，所以能访问Outer Class的`private`字段和方法。

观察Java编译器编译后的`.class`文件可以发现，`Outer`类被编译为`Outer.class`，而`Inner`类被编译为`Outer$Inner.class`。

##### 4.4.2 Anonymous Class

还有一种定义Inner Class的方法，它不需要在Outer Class中明确地定义这个Class，而是在方法内部，通过匿名类（Anonymous Class）来定义。示例代码如下：

```java
// Anonymous Class
public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer("Nested");
        outer.asyncHello();
    }
}

class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    void asyncHello() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, " + Outer.this.name);
            }
        };
        new Thread(r).start();
    }
}
```

### 五、Java核心类

#### 5.1 枚举类

##### 5.1.1 常量

在Java中，我们可以通过`static final`来定义常量。例如，我们希望定义周一到周日这7个常量，可以用7个不同的`int`表示：

```java
public class Weekday {
    public static final int SUN = 0;
    public static final int MON = 1;
    public static final int TUE = 2;
    public static final int WED = 3;
    public static final int THU = 4;
    public static final int FRI = 5;
    public static final int SAT = 6;
}
```

使用常量的时候，可以这么引用：

```java
if (day == Weekday.SAT || day == Weekday.SUN) {
    // TODO: work at home
}
```

无论是`int`常量还是`String`常量，使用这些常量来表示一组枚举值的时候，有一个严重的问题就是，编译器无法检查每个值的合理性。例如：

```java
if (weekday == 6 || weekday == 7) {
    if (tasks == Weekday.MON) {
        // TODO:
    }
}
```

上述代码编译和运行均不会报错，但存在两个问题：

- 注意到`Weekday`定义的常量范围是`0`~`6`，并不包含`7`，编译器无法检查不在枚举中的`int`值；
- 定义的常量仍可与其他变量比较，但其用途并非是枚举星期值。

##### 5.1.2 enum

为了让编译器能自动检查某个值在枚举的集合内，并且，不同用途的枚举需要不同的类型来标记，不能混用，我们可以使用`enum`来定义枚举类：

```java
// enum
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }
}

enum Weekday {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}
```

注意到定义枚举类是通过关键字`enum`实现的，我们只需依次列出枚举的常量名。

和`int`定义的常量相比，使用`enum`定义枚举有如下好处：

首先，`enum`常量本身带有类型信息，即`Weekday.SUN`类型是`Weekday`，编译器会自动检查出类型错误。例如，下面的语句不可能编译通过：

```java
int day = 1;
if (day == Weekday.SUN) { // Compile error: bad operand types for binary operator '=='
}
```

其次，不可能引用到非枚举的值，因为无法通过编译。

最后，不同类型的枚举不能互相比较或者赋值，因为类型不符。例如，不能给一个`Weekday`枚举类型的变量赋值为`Color`枚举类型的值：

```java
Weekday x = Weekday.SUN; // ok!
Weekday y = Color.RED; // Compile error: incompatible types
```

这就使得编译器可以在编译期自动检查出所有可能的潜在错误。

##### 5.1.3 enum的比较

使用`enum`定义的枚举类是一种引用类型。前面我们讲到，引用类型比较，要使用`equals()`方法，如果使用`==`比较，它比较的是两个引用类型的变量是否是同一个对象。因此，引用类型比较，要始终使用`equals()`方法，但`enum`类型可以例外。

这是因为`enum`类型的每个常量在JVM中只有一个唯一实例，所以可以直接用`==`比较：

```java
if (day == Weekday.FRI) { // ok!
}
if (day.equals(Weekday.SUN)) { // ok, but more code!
}
```

##### 5.1.4 enum类型

通过`enum`定义的枚举类，和其他的`class`有什么区别？

答案是没有任何区别。`enum`定义的类型就是`class`，只不过它有以下几个特点：

- 定义的`enum`类型总是继承自`java.lang.Enum`，且无法被继承；
- 只能定义出`enum`的实例，而无法通过`new`操作符创建`enum`的实例；
- 定义的每个实例都是引用类型的唯一实例；
- 可以将`enum`类型用于`switch`语句。

例如，我们定义的`Color`枚举类：

```java
public enum Color {
    RED, GREEN, BLUE;
}
```

编译器编译出的`class`大概就像这样：

```java
public final class Color extends Enum { // 继承自Enum，标记为final class
    // 每个实例均为全局唯一:
    public static final Color RED = new Color();
    public static final Color GREEN = new Color();
    public static final Color BLUE = new Color();
    // private构造方法，确保外部无法调用new操作符:
    private Color() {}
}
```

所以，编译后的`enum`类和普通`class`并没有任何区别。但是我们自己无法按定义普通`class`那样来定义`enum`，必须使用`enum`关键字，这是Java语法规定的。

因为`enum`是一个`class`，每个枚举的值都是`class`实例，因此，这些实例有一些方法：

name()

返回常量名，例如：

```java
String s = Weekday.SUN.name(); // "SUN"
```

ordinal()

返回定义的常量的顺序，从0开始计数，例如：

```java
int n = Weekday.MON.ordinal(); // 1
```

改变枚举常量定义的顺序就会导致`ordinal()`返回值发生变化。例如：

```java
public enum Weekday {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}
```

和

```java
public enum Weekday {
    MON, TUE, WED, THU, FRI, SAT, SUN;
}
```

的`ordinal`就是不同的。如果在代码中编写了类似`if(x.ordinal()==1)`这样的语句，就要保证`enum`的枚举顺序不能变。新增的常量必须放在最后。

有些童鞋会想，`Weekday`的枚举常量如果要和`int`转换，使用`ordinal()`不是非常方便？比如这样写：

```java
String task = Weekday.MON.ordinal() + "/ppt";
saveToFile(task);
```

但是，如果不小心修改了枚举的顺序，编译器是无法检查出这种逻辑错误的。要编写健壮的代码，就不要依靠`ordinal()`的返回值。因为`enum`本身是`class`，所以我们可以定义`private`的构造方法，并且，给每个枚举常量添加字段：

```java
// enum
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }
}

enum Weekday {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

    public final int dayValue;

    private Weekday(int dayValue) {
        this.dayValue = dayValue;
    }
}
```

这样就无需担心顺序的变化，新增枚举常量时，也需要指定一个`int`值。

 注意

枚举类的字段也可以是非final类型，即可以在运行期修改，但是不推荐这样做！

默认情况下，对枚举常量调用`toString()`会返回和`name()`一样的字符串。但是，`toString()`可以被覆写，而`name()`则不行。我们可以给`Weekday`添加`toString()`方法：

```java
// enum
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Today is " + day + ". Work at home!");
        } else {
            System.out.println("Today is " + day + ". Work at office!");
        }
    }
}

enum Weekday {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}
```

覆写`toString()`的目的是在输出时更有可读性。

注意

判断枚举常量的名字，要始终使用name()方法，绝不能调用toString()！

switch

最后，枚举类可以应用在`switch`语句中。因为枚举类天生具有类型信息和有限个枚举常量，所以比`int`、`String`类型更适合用在`switch`语句中：

```java
// switch
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        switch(day) {
        case MON:
        case TUE:
        case WED:
        case THU:
        case FRI:
            System.out.println("Today is " + day + ". Work at office!");
            break;
        case SAT:
        case SUN:
            System.out.println("Today is " + day + ". Work at home!");
            break;
        default:
            throw new RuntimeException("cannot process " + day);
        }
    }
}

enum Weekday {
    MON, TUE, WED, THU, FRI, SAT, SUN;
}
```

加上`default`语句，可以在漏写某个枚举常量时自动报错，从而及时发现错误。

##### 5.1.5 小结

Java使用`enum`定义枚举类型，它被编译器编译为`final class Xxx extends Enum { … }`；

通过`name()`获取常量定义的字符串，注意不要使用`toString()`；

通过`ordinal()`返回常量定义的顺序（无实质意义）；

可以为`enum`编写构造方法、字段和方法

`enum`的构造方法要声明为`private`，字段强烈建议声明为`final`；

`enum`适合用在`switch`语句中。

#### 5.2 字符串和编码

##### 5.2.1 String

在Java中，`String`是一个引用类型，它本身也是一个`class`。但是，Java编译器对`String`有特殊处理，即可以直接用`"..."`来表示一个字符串：

```java
String s1 = "Hello!";
```

实际上字符串在`String`内部是通过一个`char[]`数组表示的，因此，按下面的写法也是可以的：

```java
String s2 = new String(new char[] {'H', 'e', 'l', 'l', 'o', '!'});
```

因为`String`太常用了，所以Java提供了`"..."`这种字符串字面量表示方法。

Java字符串的一个重要特点就是字符串*不可变*。这种不可变性是通过内部的`private final char[]`字段，以及没有任何修改`char[]`的方法实现的。

我们来看一个例子：

```java
// String
public class Main {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);
    }
}
```

根据上面代码的输出，试解释字符串内容是否改变。

##### 5.2.2 字符串比较

当我们想要比较两个字符串是否相同时，要特别注意，我们实际上是想比较字符串的内容是否相同。必须使用`equals()`方法而不能用`==`。

我们看下面的例子：

```java
// String
public class Main {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);		//true
        System.out.println(s1.equals(s2));	//true
    }
}
```

从表面上看，两个字符串用`==`和`equals()`比较都为`true`，但实际上那只是Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，自然`s1`和`s2`的引用就是相同的。

所以，这种`==`比较返回`true`纯属巧合。换一种写法，`==`比较就会失败：

```java
// String
public class Main {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1 == s2);		//false
        System.out.println(s1.equals(s2));	//true
    }
}
```

结论：两个字符串比较，必须总是使用`equals()`方法。

要忽略大小写比较，使用`equalsIgnoreCase()`方法。

`String`类还提供了多种方法来搜索子串、提取子串。常用的方法有：

```java
// 是否包含子串:
"Hello".contains("ll"); // true
```

注意到`contains()`方法的参数是`CharSequence`而不是`String`，因为`CharSequence`是`String`实现的一个接口。

搜索子串的更多的例子：

```java
"Hello".indexOf("l"); // 2
"Hello".lastIndexOf("l"); // 3
"Hello".startsWith("He"); // true
"Hello".endsWith("lo"); // true
```

提取子串的例子：

```java
"Hello".substring(2); // "llo"	01234 2到末尾
"Hello".substring(2, 4);// "ll"	01234 2到4
```

注意索引号是从`0`开始的。

##### 5.2.3 去除首尾空白字符

使用`trim()`方法可以移除字符串首尾空白字符。空白字符包括空格，`\t`，`\r`，`\n`：

```java
"  \tHello\r\n ".trim(); // "Hello"
```

注意：`trim()`并没有改变字符串的内容，而是返回了一个新字符串。

另一个`strip()`方法也可以移除字符串首尾空白字符。它和`trim()`不同的是，类似中文的空格字符`\u3000`也会被移除：

```java
"\u3000Hello\u3000".strip(); // "Hello"
" Hello ".stripLeading(); // "Hello "
" Hello ".stripTrailing(); // " Hello"
```

`String`还提供了`isEmpty()`和`isBlank()`来判断字符串是否为空和空白字符串：

```java
"".isEmpty(); // true，因为字符串长度为0
"  ".isEmpty(); // false，因为字符串长度不为0
"  \n".isBlank(); // true，因为只包含空白字符
" Hello ".isBlank(); // false，因为包含非空白字符
```

##### 5.2.4 替换子串

要在字符串中替换子串，有两种方法。一种是根据字符或字符串替换：

```java
String s = "hello";
s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
```

另一种是通过正则表达式替换：

```java
String s = "A,,B;C ,D";
s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
```

上面的代码通过正则表达式，把匹配的子串统一替换为`","`。关于正则表达式的用法我们会在后面详细讲解。

##### 5.2.5 分割与拼接字符串

要分割字符串，使用`split()`方法，并且传入的也是正则表达式：

```java
String s = "A,B,C,D";
String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}
```

拼接字符串使用静态方法`join()`，它用指定的字符串连接字符串数组：

```java
String[] arr = {"A", "B", "C"};
String s = String.join("***", arr); // "A***B***C"
```

##### 5.2.6 格式化字符串

字符串提供了`formatted()`方法和`format()`静态方法，可以传入其他参数，替换占位符，然后生成新的字符串：

```java
// String
public class Main {
    public static void main(String[] args) {
        String s = "Hi %s, your score is %d!";
        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
    }
}
```

有几个占位符，后面就传入几个参数。参数类型要和占位符一致。我们经常用这个方法来格式化信息。常用的占位符有：

- `%s`：显示字符串；
- `%d`：显示整数；
- `%x`：显示十六进制整数；
- `%f`：显示浮点数。

占位符还可以带格式，例如`%.2f`表示显示两位小数。如果你不确定用啥占位符，那就始终用`%s`，因为`%s`可以显示任何数据类型。要查看完整的格式化语法，请参考[JDK文档](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Formatter.html#syntax)。

##### 5.2.7 类型转换

要把任意基本类型或引用类型转换为字符串，可以使用静态方法`valueOf()`。这是一个重载方法，编译器会根据参数自动选择合适的方法：

```java
String.valueOf(123); // "123"
String.valueOf(45.67); // "45.67"
String.valueOf(true); // "true"
String.valueOf(new Object()); // 类似java.lang.Object@636be97c
```

要把字符串转换为其他类型，就需要根据情况。例如，把字符串转换为`int`类型：

```java
int n1 = Integer.parseInt("123"); // 123
int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255
```

把字符串转换为`boolean`类型：

```java
boolean b1 = Boolean.parseBoolean("true"); // true
boolean b2 = Boolean.parseBoolean("FALSE"); // false
```

要特别注意，`Integer`有个`getInteger(String)`方法，它不是将字符串转换为`int`，而是把该字符串对应的系统变量转换为`Integer`：

```java
Integer.getInteger("java.version"); // 版本号，11
```

##### 5.2.8 转换为char[]

`String`和`char[]`类型可以互相转换，方法是：

```java
char[] cs = "Hello".toCharArray(); // String -> char[]
String s = new String(cs); // char[] -> String
```

如果修改了`char[]`数组，`String`并不会改变：

```java
// String <-> char[]
public class Main {
    public static void main(String[] args) {
        char[] cs = "Hello".toCharArray();
        String s = new String(cs);
        System.out.println(s);
        cs[0] = 'X';
        System.out.println(s);
    }
}
```

这是因为通过`new String(char[])`创建新的`String`实例时，它并不会直接引用传入的`char[]`数组，而是会复制一份，所以，修改外部的`char[]`数组不会影响`String`实例内部的`char[]`数组，因为这是两个不同的数组。

从`String`的不变性设计可以看出，如果传入的对象有可能改变，我们需要复制而不是直接引用。

例如，下面的代码设计了一个`Score`类保存一组学生的成绩：

```java
// int[]
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s = new Score(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
    }
}

class Score {
    private int[] scores;
    public Score(int[] scores) {
        this.scores = scores;
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
```

观察两次输出，由于`Score`内部直接引用了外部传入的`int[]`数组，这会造成外部代码对`int[]`数组的修改，影响到`Score`类的字段。如果外部代码不可信，这就会造成安全隐患。

请修复`Score`的构造方法，使得外部代码对数组的修改不影响`Score`实例的`int[]`字段。

##### 5.2.9 字符编码

在Java中，`char`类型实际上就是两个字节的`Unicode`编码。如果我们要手动把字符串转换成其他编码，可以这样做：

```java
byte[] b1 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
byte[] b2 = "Hello".getBytes("GBK"); // 按GBK编码转换
byte[] b3 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
```

注意：转换编码后，就不再是`char`类型，而是`byte`类型表示的数组。

如果要把已知编码的`byte[]`转换为`String`，可以这样做：

```java
byte[] b = ...
String s1 = new String(b, "GBK"); // 按GBK转换
String s2 = new String(b, StandardCharsets.UTF_8); // 按UTF-8转换
```

始终牢记：Java的`String`和`char`在内存中总是以Unicode编码表示。

##### 5.2.10 小结

Java字符串`String`是不可变对象；

字符串操作不改变原字符串内容，而是返回新字符串；

常用的字符串操作：提取子串、查找、替换、大小写转换等；

Java使用Unicode编码表示`String`和`char`；

转换编码就是将`String`和`byte[]`转换，需要指定编码；

转换为`byte[]`时，始终优先考虑`UTF-8`编码。

#### 5.3 StringBuilder

##### 5.3.1 使用

Java编译器对`String`做了特殊处理，使得我们可以直接用`+`拼接字符串。

考察下面的循环代码：

```java
String s = "";
for (int i = 0; i < 1000; i++) {
    s = s + "," + i;
}
```

虽然可以直接拼接字符串，但是，在循环中，每次循环都会创建新的字符串对象，然后扔掉旧的字符串。这样，绝大部分字符串都是临时对象，不但浪费内存，还会影响GC效率。

为了能高效拼接字符串，Java标准库提供了`StringBuilder`，它是一个可变对象，可以预分配缓冲区，这样，往`StringBuilder`中新增字符时，不会创建新的临时对象：

```java
StringBuilder sb = new StringBuilder(1024);
for (int i = 0; i < 1000; i++) {
    sb.append(',');
    sb.append(i);
}
String s = sb.toString();
```

##### 5.3.2 链式操作

```java
// 链式操作
public class Main {
    public static void main(String[] args) {
        var sb = new StringBuilder(1024);
        sb.append("Mr ")
          .append("Bob")
          .append("!")
          .insert(0, "Hello, ");
        System.out.println(sb.toString());
    }
}
```

如果我们查看`StringBuilder`的源码，可以发现，进行链式操作的关键是，定义的`append()`方法会返回`this`，这样，就可以不断调用自身的其他方法。

仿照`StringBuilder`，我们也可以设计支持链式操作的类。例如，一个可以不断增加的计数器：

```java
// 链式操作
public class Main {
    public static void main(String[] args) {
        Adder adder = new Adder();
        adder.add(3)
             .add(5)
             .inc()
             .add(10);
        System.out.println(adder.value());
    }
}

class Adder {
    private int sum = 0;

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum ++;
        return this;
    }

    public int value() {
        return sum;
    }
}
```

##### 5.3.3 注意

对于普通的字符串`+`操作，并不需要我们将其改写为`StringBuilder`，因为Java编译器在编译时就自动把多个连续的`+`操作编码为`StringConcatFactory`的操作。在运行期，`StringConcatFactory`会自动把字符串连接操作优化为数组复制或者`StringBuilder`操作。

你可能还听说过`StringBuffer`，这是Java早期的一个`StringBuilder`的线程安全版本，它通过同步来保证多个线程操作`StringBuffer`也是安全的，但是同步会带来执行速度的下降。

`StringBuilder`和`StringBuffer`接口完全相同，现在完全没有必要使用`StringBuffer`。

##### 5.3.4 小结

`StringBuilder`是可变对象，用来高效拼接字符串；

`StringBuilder`可以支持链式操作，实现链式操作的关键是返回实例本身；

`StringBuffer`是`StringBuilder`的线程安全版本，现在很少使用。

#### 5.4 StringJoiner

##### 5.4.1 StringBuilder对象

```java
// 输出: Hello Bob, Alice, Grace!
import java.util.StringJoiner;
public class Main {
    public static void main(String[] args) {
        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }
}
```

##### 5.4.2 String.join()方法

`String`还提供了一个静态方法`join()`，这个方法在内部使用了`StringJoiner`来拼接字符串，在不需要指定“开头”和“结尾”的时候，用`String.join()`更方便：

```java
String[] names = {"Bob", "Alice", "Grace"};
var s = String.join(", ", names);
```

##### 5.4.3 小结

用指定分隔符拼接字符串数组时，使用`StringJoiner`或者`String.join()`更方便；

用`StringJoiner`拼接字符串时，还可以额外附加一个“开头”和“结尾”。

### 六、日期与时间

#### 6.1 Date和Calendar

##### 6.1.1 标准库API

我们再来看一下Java标准库提供的API。Java标准库有两套处理日期和时间的API：

- 一套定义在`java.util`这个包里面，主要包括`Date`、`Calendar`和`TimeZone`这几个类；
- 一套新的API是在Java 8引入的，定义在`java.time`这个包里面，主要包括`LocalDateTime`、`ZonedDateTime`、`ZoneId`等。

为什么会有新旧两套API呢？因为历史遗留原因，旧的API存在很多问题，所以引入了新的API。

那么我们能不能跳过旧的API直接用新的API呢？如果涉及到遗留代码就不行，因为很多遗留代码仍然使用旧的API，所以目前仍然需要对旧的API有一定了解，很多时候还需要在新旧两种对象之间进行转换。

本节我们快速讲解旧API的常用类型和方法。

##### 6.1.2 Date

`java.util.Date`是用于表示一个日期和时间的对象，注意与`java.sql.Date`区分，后者用在数据库中。如果观察`Date`的源码，可以发现它实际上存储了一个`long`类型的以毫秒表示的时间戳：

```java
public class Date implements Serializable, Cloneable, Comparable<Date> {

    private transient long fastTime;

    ...
}
```

我们来看Date的基本用法：

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 获取当前时间:
        Date date = new Date();
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); // 0~11，必须加上1
        System.out.println(date.getDate()); // 1~31，不能加1
        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());
    }
}
```

注意`getYear()`返回的年份必须加上`1900`，`getMonth()`返回的月份是`0`~`11`分别表示1~12月，所以要加1，而`getDate()`返回的日期范围是`1`~`31`，又不能加1。

打印本地时区表示的日期和时间时，不同的计算机可能会有不同的结果。如果我们想要针对用户的偏好精确地控制日期和时间的格式，就可以使用`SimpleDateFormat`对一个`Date`进行转换。它用预定义的字符串表示格式化：

- yyyy：年
- MM：月
- dd: 日
- HH: 小时
- mm: 分钟
- ss: 秒

我们来看如何以自定义的格式输出：

```java
import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 获取当前时间:
        Date date = new Date();
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
```

上述代码在不同的语言环境会打印出类似`Sun Sep 15, 2019`这样的日期。可以从[JDK文档](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/text/SimpleDateFormat.html)查看详细的格式说明。一般来说，字母越长，输出越长。以`M`为例，假设当前月份是9月：

- `M`：输出`9`
- `MM`：输出`09`
- `MMM`：输出`Sep`
- `MMMM`：输出`September`

`Date`对象有几个严重的问题：它不能转换时区，除了`toGMTString()`可以按`GMT+0:00`输出外，`Date`总是以当前计算机系统的默认时区为基础进行输出。此外，我们也很难对日期和时间进行加减，计算两个日期相差多少天，计算某个月第一个星期一的日期等。

##### 6.1.3 Calendar

`Calendar`可以用于获取并设置年、月、日、时、分、秒，它和`Date`比，主要多了一个可以做简单的日期和时间运算的功能。

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 获取当前时间:
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = 1 + c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int w = c.get(Calendar.DAY_OF_WEEK);
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);
    }
}
```

注意到`Calendar`获取年月日这些信息变成了`get(int field)`，返回的年份不必转换，返回的月份仍然要加1，返回的星期要特别注意，`1`~`7`分别表示周日，周一，……，周六。

`Calendar`只有一种方式获取，即`Calendar.getInstance()`，而且一获取到就是当前时间。如果我们想给它设置成特定的一个日期和时间，就必须先清除所有字段：

```java
import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 当前时间:
        Calendar c = Calendar.getInstance();
        // 清除所有:
        c.clear();
        // 设置2019年:
        c.set(Calendar.YEAR, 2019);
        // 设置9月:注意8表示9月:
        c.set(Calendar.MONTH, 8);
        // 设置2日:
        c.set(Calendar.DATE, 2);
        // 设置时间:
        c.set(Calendar.HOUR_OF_DAY, 21);
        c.set(Calendar.MINUTE, 22);
        c.set(Calendar.SECOND, 23);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
        // 2019-09-02 21:22:23
    }
}
```

利用`Calendar.getTime()`可以将一个`Calendar`对象转换成`Date`对象，然后就可以用`SimpleDateFormat`进行格式化了。

##### 6.1.4 TimeZone

`Calendar`和`Date`相比，它提供了时区转换的功能。时区用`TimeZone`对象表示：

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00"); // GMT+9:00时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York"); // 纽约时区
        System.out.println(tzDefault.getID()); // Asia/Shanghai
        System.out.println(tzGMT9.getID()); // GMT+09:00
        System.out.println(tzNY.getID()); // America/New_York
    }
}
```

时区的唯一标识是以字符串表示的ID，我们获取指定`TimeZone`对象也是以这个ID为参数获取，`GMT+09:00`、`Asia/Shanghai`都是有效的时区ID。要列出系统支持的所有ID，请使用`TimeZone.getAvailableIDs()`。

有了时区，我们就可以对指定时间进行转换。例如，下面的例子演示了如何将北京时间`2019-11-20 8:15:00`转换为纽约时间：

```java
import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 当前时间:
        Calendar c = Calendar.getInstance();
        // 清除所有:
        c.clear();
        // 设置为北京时区:
        c.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 设置年月日时分秒:
        c.set(2019, 10 /* 11月 */, 20, 8, 15, 0);
        // 显示时间:
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(sdf.format(c.getTime()));
        // 2019-11-19 19:15:00
    }
}
```

可见，利用`Calendar`进行时区转换的步骤是：

1. 清除所有字段；
2. 设定指定时区；
3. 设定日期和时间；
4. 创建`SimpleDateFormat`并设定目标时区；
5. 格式化获取的`Date`对象（注意`Date`对象无时区信息，时区信息存储在`SimpleDateFormat`中）。

因此，本质上时区转换只能通过`SimpleDateFormat`在显示的时候完成。

`Calendar`也可以对日期和时间进行简单的加减：

```java
import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 当前时间:
        Calendar c = Calendar.getInstance();
        // 清除所有:
        c.clear();
        // 设置年月日时分秒:
        c.set(2019, 10 /* 11月 */, 20, 8, 15, 0);
        // 加5天并减去2小时:
        c.add(Calendar.DAY_OF_MONTH, 5);
        c.add(Calendar.HOUR_OF_DAY, -2);
        // 显示时间:
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = c.getTime();
        System.out.println(sdf.format(d));
        // 2019-11-25 6:15:00
    }
}
```

##### 6.1.5 小结

计算机表示的时间是以整数表示的时间戳存储的，即Epoch Time，Java使用`long`型来表示以毫秒为单位的时间戳，通过`System.currentTimeMillis()`获取当前时间戳。

Java有两套日期和时间的API：

- 旧的Date、Calendar和TimeZone；
- 新的LocalDateTime、ZonedDateTime、ZoneId等。

分别位于`java.util`和`java.time`包中。

#### 6.2 LocalDateTime

##### 6.2.1 新日期、时间API

从Java 8开始，`java.time`包提供了新的日期和时间API，主要涉及的类型有：

- 本地日期和时间：`LocalDateTime`，`LocalDate`，`LocalTime`；
- 带时区的日期和时间：`ZonedDateTime`；
- 时刻：`Instant`；
- 时区：`ZoneId`，`ZoneOffset`；
- 时间间隔：`Duration`。

以及一套新的用于取代`SimpleDateFormat`的格式化类型`DateTimeFormatter`。

和旧的API相比，新API严格区分了时刻、本地日期、本地时间和带时区的日期时间，并且，对日期和时间进行运算更加方便。

此外，新API修正了旧API不合理的常量设计：

- Month的范围用1~12表示1月到12月；
- Week的范围用1~7表示周一到周日。

最后，新API的类型几乎全部是不变类型（和String类似），可以放心使用不必担心被修改。

##### 6.2.2 LocalDateTime

我们首先来看最常用的`LocalDateTime`，它表示一个本地日期和时间：

```java
import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印
    }
}
```

本地日期和时间通过now()获取到的总是以当前默认时区返回的，和旧API不同，`LocalDateTime`、`LocalDate`和`LocalTime`默认严格按照[ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html)规定的日期和时间格式进行打印。

上述代码其实有一个小问题，在获取3个类型的时候，由于执行一行代码总会消耗一点时间，因此，3个类型的日期和时间很可能对不上（时间的毫秒数基本上不同）。为了保证获取到同一时刻的日期和时间，可以改写如下：

```java
LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
LocalDate d = dt.toLocalDate(); // 转换到当前日期
LocalTime t = dt.toLocalTime(); // 转换到当前时间
```

反过来，通过指定的日期和时间创建`LocalDateTime`可以通过`of()`方法：

```java
// 指定日期和时间:
LocalDate d2 = LocalDate.of(2019, 11, 30); // 2019-11-30, 注意11=11月
LocalTime t2 = LocalTime.of(15, 16, 17); // 15:16:17
LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
LocalDateTime dt3 = LocalDateTime.of(d2, t2);
```

因为严格按照ISO 8601的格式，因此，将字符串转换为`LocalDateTime`就可以传入标准格式：

```java
LocalDateTime dt = LocalDateTime.parse("2019-11-19T15:16:17");
LocalDate d = LocalDate.parse("2019-11-19");
LocalTime t = LocalTime.parse("15:16:17");
```

注意ISO 8601规定的日期和时间分隔符是`T`。标准格式如下：

- 日期：yyyy-MM-dd
- 时间：HH:mm:ss
- 带毫秒的时间：HH:mm:ss.SSS
- 日期和时间：yyyy-MM-dd'T'HH:mm:ss
- 带毫秒的日期和时间：yyyy-MM-dd'T'HH:mm:ss.SSS

##### 6.2.3 DateTimeFormatter

如果要自定义输出的格式，或者要把一个非ISO 8601格式的字符串解析成`LocalDateTime`，可以使用新的`DateTimeFormatter`：

```java
import java.time.*;
import java.time.format.*;

public class Main {
    public static void main(String[] args) {
        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt2);
    }
}
```

`LocalDateTime`提供了对日期和时间进行加减的非常简单的链式调用：

注意到月份加减会自动调整日期，例如从`2019-10-31`减去1个月得到的结果是`2019-09-30`，因为9月没有31日。

```java
import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt);
        // 加5天减3小时:
        LocalDateTime dt2 = dt.plusDays(5).minusHours(3);
        System.out.println(dt2); // 2019-10-31T17:30:59
        // 减1月:
        LocalDateTime dt3 = dt2.minusMonths(1);
        System.out.println(dt3); // 2019-09-30T17:30:59
    }
}
```

对日期和时间进行调整则使用`withXxx()`方法，例如：`withHour(15)`会把`10:11:12`变为`15:11:12`：

- 调整年：withYear()
- 调整月：withMonth()
- 调整日：withDayOfMonth()
- 调整时：withHour()
- 调整分：withMinute()
- 调整秒：withSecond()

示例代码如下：

```java
import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt);
        // 日期变为31日:
        LocalDateTime dt2 = dt.withDayOfMonth(31);
        System.out.println(dt2); // 2019-10-31T20:30:59
        // 月份变为9:
        LocalDateTime dt3 = dt2.withMonth(9);
        System.out.println(dt3); // 2019-09-30T20:30:59
    }
}
```

同样注意到调整月份时，会相应地调整日期，即把`2019-10-31`的月份调整为`9`时，日期也自动变为`30`。

实际上，`LocalDateTime`还有一个通用的`with()`方法允许我们做更复杂的运算。例如：

```java
import java.time.*;
import java.time.temporal.*;

public class Main {
    public static void main(String[] args) {
        // 本月第一天0:00时刻:
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);

        // 本月最后1天:
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);

        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);

        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);
    }
}
```

对于计算某个月第1个周日这样的问题，新的API可以轻松完成。

要判断两个`LocalDateTime`的先后，可以使用`isBefore()`、`isAfter()`方法，对于`LocalDate`和`LocalTime`类似：

```java
import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        System.out.println(now.isBefore(target));
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
        System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));
    }
}
```

注意到`LocalDateTime`无法与时间戳进行转换，因为`LocalDateTime`没有时区，无法确定某一时刻。后面我们要介绍的`ZonedDateTime`相当于`LocalDateTime`加时区的组合，它具有时区，可以与`long`表示的时间戳进行转换。





































