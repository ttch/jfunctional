package functional.tools;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

@SuppressWarnings("unchecked")

public class f {
	private static String GetName(Class c){
		if (c.isArray() ){
			return c.getComponentType().getSimpleName().toLowerCase();
		}else if (c.isPrimitive()){
			return c.getSimpleName().toLowerCase();
		}else{
			return c.getSimpleName().toLowerCase();
		}
	}
	private static boolean isPair(Class<?> [] mp, ArrayList<Class> tp , boolean isEquaLength){
		String s = "";
		String d = "";
		
		if (isEquaLength){
			for (int i = 0 ; i< mp.length; i++ ){
				s = f.GetName(mp[i]);
				d = f.GetName(tp.get(i));
				
				if (! (s.equals(d) || pToR(s).equals(pToR(d)) ) ){
					return false;
				}
			}
		}else{
			s = f.GetName(mp[0]);
			d = f.GetName(tp.get(0));
			if (! (s.equals(d) || pToR(s).equals(pToR(d)) ) ){
				return false;
			}
		}
		return true;
		
	}
	private static <T> T[] pack( Class<?> [] tp, T...objects ){
		 T [] t = (T[]) new Object[1];
		ArrayList<T> a = new ArrayList<T>();
		if ( (tp.length == 1) && (objects.length>1) ){
			t[0] = (T) Arrays.asList(objects).toArray();
			return t;
			
		}
		return (T[]) objects;
	}
	
	private static TreeMap<String,String> PrimToRef = new TreeMap(){

	{
		put( "int","Integer" );
		put( "char","Character" );
	}}; 
	
	private static <T> T invoke(Method m ,T obj, T... args){
		try {
			m.setAccessible(true);
			return (T) m.invoke(obj, args);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static<T> ArrayList<Class> getClassList(T...objects){
		ArrayList<Class> l = new ArrayList<Class>();
		for (T a : objects){
			l.add(a.getClass());
		}
		return l;
		
	}
	public static String pToR(String name){
		return ( PrimToRef.get(name) == null ? name : PrimToRef.get(name).toLowerCase() );
	}
	
	public static <T> T reduce(Class<?> c , String m , T ... objects  ) {
		T [] para = (T[]) new Object[objects.length];
		ArrayList<Class> tp = getClassList(objects);
		List<Method> mlist = new ArrayList<Method>();
		
		for (Method tm :c.getDeclaredMethods()){
			if (tm.getName().equals(m) ){ mlist.add(tm); }
		}
		Method lm = null;
		boolean execabled = true;
		
		for ( Method tm : mlist){
			int pl = tm.getParameterTypes().length;
			int ol = objects.length;
			
			if ( pl == ol ){
				if ( f.isPair( tm.getParameterTypes(),tp ,true )){
					execabled = true;
					para = (T[]) f.pack(tm.getParameterTypes(),objects);
					lm = tm;
					break;
				}else{ execabled = false;continue;}
			}else{
				if ( f.isPair(tm.getParameterTypes(), tp ,false )){
					execabled = true;
					para = (T[]) f.pack(tm.getParameterTypes(),objects);
					lm = tm;
					break;
				}else{ execabled = false;continue;}
			}
		}
		if (execabled == true)
			return (T) f.invoke(lm,null,para);
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double b = f.reduce(Math.class,"max",1,3);
		System.out.println(b);
		
		Double a = f.reduce(Math.class,"abs",-2.2);
		System.out.println(a);

		List<Integer> x = Arrays.asList(1,2,3,4,5,6,7);
		
		Integer c = (Integer) f.reduce(operator.class, "add", x.toArray());
		System.out.println(c);

		Integer d = (Integer) f.reduce(operator.class, "mul",x.toArray(),2);
		System.out.println(d);


	}

}