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
		
		//����1
		function<Integer> func =  new function<Integer>(){
			//����ͻ�����Ӧ��֪���м�������
			@Override
			public <T> T lambda(T... t) {
				System.out.println(t[0]);
				return null;
			}
		};
		//loop ����Ҫ����ֵ
		f.loop( func , x,9,8,9);
		
		//���´�������ϴ����ǵȼ۵�
		
		List<Integer> t = new ArrayList<Integer>();
		t.addAll(x);
		t.add(9);
		t.add(8);
		t.add(9);
		
		for ( Integer a : t){
			System.out.println(a);
		}
		
		//����2
		final ArrayList<Integer> less2 = new ArrayList<Integer>();
		
		//�� x,9,8,9,2,1,2,3,12,2,2,2 ƴ�Ӻ��list����ѭ�����ȱ���xȻ���������ĸ�������
		f.loop( new function<Integer>(){
			@Override
			public <T> T lambda(T... t) {
				//��С��2�������ӵ�less2����
				less2.add( (Integer) f.reduce(Math.class,"max", t[0],2) );
				return null;
			}
		} , x,9,8,9,2,1,2,3,12,2,2,2);
		//ѭ����ӡless2�е�����
		for ( Integer i : less2){
			System.out.println(i);
		}
		//����2
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
