### 1 Lambda表达式

Lambda表达式的本质：作为接口的实例

#### 1.1 格式

```java
->		  //Lambda操作符
->左边	//接口中抽象方法的形参列表
->右边	//重写的抽象方法的方法体
```

#### 1.2 使用

```java
//1.无参，无返回值
Runnable runnable = () -> {System.out.println("hello");};
//2.一个参数，无返回值 
Consumer<String> consumer = (String s) -> {System.out.println(s);};
//3.数据类型可省略，可有编译器推断，“类型推断”
Consumer<String> consumer = (s) -> {System.out.println(s);};
//4.只要一个参数时，参数的小括号可省略
Consumer<String> consumer = s -> {System.out.println(s);};
//5.可以多参数、多语句、返回值

//6.只有一条语句时，return和大括号都可省
```



