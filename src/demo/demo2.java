package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import functional.tools.f;
import functional.tools.function;
import functional.tools.operator;

public class demo2 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Integer> x = Arrays.asList(1,2,3,4,5,6,7);
		
		//场景1
		function<Integer> func =  new function<Integer>(){
			//这里客户代码应该知道有几个对象
			@Override
			public <T> T lambda(T... t) {
				System.out.println(t[0]);
				return null;
			}
		};
		//loop 不需要返回值
		f.loop( func , x,9,8,9);
		
		//如下代码和如上代码是等价的
		
		List<Integer> t = new ArrayList<Integer>();
		t.addAll(x);
		t.add(9);
		t.add(8);
		t.add(9);
		
		for ( Integer a : t){
			System.out.println(a);
		}
		
		//场景2
		final ArrayList<Integer> less2 = new ArrayList<Integer>();
		
		//对 x,9,8,9,2,1,2,3,12,2,2,2 拼接后的list进行循环，先遍历x然后遍历后面的个体数字
		f.loop( new function<Integer>(){
			@Override
			public <T> T lambda(T... t) {
				//把小于2的整数加到less2里面
				less2.add( (Integer) f.reduce(Math.class,"max", t[0],2) );
				return null;
			}
		} , x,9,8,9,2,1,2,3,12,2,2,2);
		//循环打印less2中的内容
		for ( Integer i : less2){
			System.out.println(i);
		}
		//场景2
		System.out.println(
			new function(){
				@Override
				public Object lambda(Object... t) {
					return f.reduce(operator.class, "add", ( (Collection)t[0] ).toArray() );
				}
		}.lambda(x) );
		System.out.println(
			new function(){
				@Override
				public Object lambda(Object... t) {
					return f.reduce(operator.class, "mul", ( (Collection)t[0] ).toArray() , 2 );
				}	
		}.lambda(x) );
	}

}
