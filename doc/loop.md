#java functional tools 教程

jfunctional 代码下载地址的下载地址：[戳进][1]

##章节2

这一节，不贴大段的代码了。直接讲应用场景吧。

***首先给定一个列表 x***
	
	List<Integer> x = Arrays.asList(1,2,3,4,5,6,7);

>场景1：需求代码，增加一个列表和若干常量，并打印出他们。

	List<Integer> t = new ArrayList<Integer>();
	t.addAll(x);
	t.add(9);
	t.add(8);
	t.add(9);
	
	for ( Integer a : t){
		System.out.println(a);
	}

如上代码，我们可以看到首先建立一个新列表t，然后把 x,9,8,9 这些变量和常量增加到列表t中。

那么我们使用jfunctional怎么来解决呢？

	final ArrayList<Integer> less2 = new ArrayList<Integer>();
	f.loop( new function<Integer>(){
		@Override
		public <T> T lambda(T... t) {
			System.out.println(t[0]);
			return null;
		}
	} , x,9,8,9);

我们可以这样来解决.这样还看不出来优美与否。那么我们如果是不止9,8,9这3个常量呢？

比如一共要增加：

	x,9,8,9,2,1,2,3,12,2,2,2

那么`需求代码`会变的非常大，非常长！

如果使用jfunctional只需要这样：


	final ArrayList<Integer> less2 = new ArrayList<Integer>();
	f.loop( new function<Integer>(){
		@Override
		public <T> T lambda(T... t) {
			System.out.println(t[0]);
			return null;
		}
	} , x,9,8,9,2,1,2,3,12,2,2,2);


  [1]: https://github.com/ttch/jfunctional