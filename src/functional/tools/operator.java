package functional.tools;

public class operator {
	public static Integer add(Integer[] is){
		Integer result = 0;
		for (Integer a : is ){
			result += a;
		}
		return result;
	}
	public static Double add(Double[] is){
		double result = 0;
		for (Double a : is ){
			result += a;
		}
		return result;
	}
	public static Float add(Float[] is){
		float result = 0;
		for (float a : is ){
			result += a;
		}
		return result;
	}
	public static Long add(Long[] is){
		long result = 0;
		for (long a : is ){
			result += a;
		}
		return result;
	}
	public static Integer mul(Integer[] s , Integer d){
		Integer r = d;
		for ( Integer a : s){
			r *= a;
		}
		return r;
	}
	public static Double mul(Double[]s , Double d){
		double r = d;
		for ( double a : s){
			r *= a;
		}
		return r;
	}
	public static Float mul(Float[]s , Float d){
		float r = d;
		for ( float a : s){
			r *= a;
		}
		return r;
	}
	public static Long mul(Long[]s , Long d){
		long r = d;
		for ( long a : s){
			r *= a;
		}
		return r;
	}

}
