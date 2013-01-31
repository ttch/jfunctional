package functional.tools;

public class operator {
	public static Integer add(Integer[] is){
		Integer result = 0;
		for (Integer a : is ){
			result += a;
		}
		return result;
	}
	public static double add(double[] is){
		double result = 0;
		for (double a : is ){
			result += a;
		}
		return result;
	}
	public static float add(float[] is){
		float result = 0;
		for (float a : is ){
			result += a;
		}
		return result;
	}
	public static long add(long[] is){
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
	public static double mul(double[]s , double d){
		double r = d;
		for ( double a : s){
			r *= a;
		}
		return r;
	}
	public static float mul(float[]s , float d){
		float r = d;
		for ( float a : s){
			r *= a;
		}
		return r;
	}
	public static long mul(long[]s , long d){
		long r = d;
		for ( long a : s){
			r *= a;
		}
		return r;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
