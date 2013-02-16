#java functional tools 教程

包的下载地址：[戳进][1]

##感谢
感谢图灵社区的@2gua 老师 在<<[java可以像python中的函数式工具里的reduce那样调用吗？](http://www.ituring.com.cn/article/details/28306)>>的提醒！


##前言

如果你玩过`pythonic`样式的代码，如果你写过`函数式`程序。那么你却在`java阵营`搞开发，整天需要写很多的代码行来完成工作。你是不是感觉到很~很~很那个，`你懂的`！

那么这个工具会帮助你完成java的函数式代码。


首先我们先来了解一下如何使用和为什么使用这个包。

## 章节 1

样例代码 1

	package demo;
	
	import java.util.Arrays;
	import java.util.List;
	
	import functional.tools.f;
	import functional.tools.operator;
	
	
	public class demo1 {
	
		public static void main(String[] args) {
			//场景0
			double b = f.reduce(Math.class,"max",1,3);
			System.out.println(b);
			
			Double a = f.reduce(Math.class,"abs",-2.2);
			System.out.println(a);
	
			List<Integer> x = Arrays.asList(1,2,3,4,5,6,7);
			
			//场景1
			Integer e = (Integer) f.reduce(operator.class, "max", x.toArray());
			System.out.println(e);
			
			//场景2
			Integer c = (Integer) f.reduce(operator.class, "add", x.toArray());
			System.out.println(c);
			//场景3
			Integer d = (Integer) f.reduce(operator.class, "mul",x.toArray(),2);
			System.out.println(d);
			
			List<String> strs = Arrays.asList("1","hello","test","nihao");
			//场景4
			String r = (String) f.reduce(operator.class, "concat", strs.toArray());
			System.out.println(r);
		}
	
	}

---


> 场景0提供了一些函数的回调的方式的调用方法。

---

> 场景1 ：找出列表中的最大值

一般情况下，我们求一个列表的max值，大部分都是这样写的。

	List<Integer> x = Arrays.asList(1,2,3,4,5,6,7);
	Integer t = 0 ;
	for ( Integer i : x ){
		if (t <= i){
			t = i;
		}
	}
	System.out.println(t);
	
	//使用排序的话是这样
	Integer [] arys = x.toArray();
	Arrays.sort(arys);
	System.out.println(arys[arys.length-1]);
	

首先我们不考虑和争论算法问题。仅仅从代码的行数就可以看到。上面的代码行数不够精简。那么我们有足够的理由让他变成一句话。


	Integer e = (Integer) f.reduce(operator.class, "max", x.toArray());
	system.out.println(e);


---

> 场景2：对列表的数值进行求和

场景2和场景1情况差不多。同样的java非函数式的代码如下：

	List<Integer> x = Arrays.asList(1,2,3,4,5,6,7);
	Integer t = 0 ;
	for ( Integer i : x ){
		t += i;
	}
	System.out.println(t);

那么我们的改善方案是这样：

	Integer c = (Integer) f.reduce(operator.class, "add", x.toArray());
	System.out.println(c);

这样写不但十分好处理，当你需要分布对x的结果统计的时候也十分好处理，因为你只需要对x拆分，然后分别调用如上代码，再汇总就可以。而不用考虑任何同步问题。

---


>场景3：对列表中的数值进行求乘积

场景3和场景2几乎一样。这里不给出非函数式代码。

那么我们的改善方案是这样：


	Integer d = (Integer) f.reduce(operator.class, "mul",x.toArray(),2);
	System.out.println(d);

***注意：mul 这个函数只支持2个参数，第一个是数组，第二个是一个数值***

>>场景4：对列表中字符串进行拼接

场景4给出的方案如下：

	List<String> strs = Arrays.asList("1","hello","test","nihao");
	//场景4
	String r = (String) f.reduce(operator.class, "concat", strs.toArray());
	System.out.println(r);

以上4个场景主要是为了让代码看上去更整洁和在并发处理的时候，不会考虑同步问题。

以后java functional tools这个程序包还会增加更多的`有用的`、`简洁的`工具函数和样例代码。


  [1]: https://github.com/ttch/jfunctional