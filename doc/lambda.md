#java functional tools 教程

jfunctional 代码下载地址的下载地址：[戳进][1]

##章节3

这一节我们来讲一下如何使用lambda，没听错。老版本的jdk依然可以使用匿名函数模仿lambda，其实我们在章节2中已经使用了lambda表达式的写法。

>场景1，求一个列表和，并打印出他们.
	
	System.out.println(
		new function(){
			@Override
			public Object lambda(Object... t) {
				return f.reduce(operator.class, "add", ( (Collection)t[0] ).toArray() );
			}
	}.lambda(x) );

如果一行内写出来。也是可能的。

	System.out.println( f.reduce(operator.class, "add", x.toArray() ) );

这里用到了我们前面讲解的`f.reduce`和`operator.add`这两个`static class method`

>场景2 ， 求一个列表乘积再乘2，并打印出他们


	System.out.println(
		new function(){
			@Override
			public Object lambda(Object... t) {
				return f.reduce(operator.class, "mul", ( (Collection)t[0] ).toArray() , 2 );
			}	
	}.lambda(x) );

一行代码写出的方法同上调用mul。

>增加lambda元素是为了以后更好的在一段长表达式中增加传值过程，这样确保以后更多的类似loop这样的`static class method`可以更好的，更优美的调用其他函数。