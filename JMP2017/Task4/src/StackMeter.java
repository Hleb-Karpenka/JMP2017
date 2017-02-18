import java.util.ArrayList;
import java.util.Random;

public class StackMeter {
	static int counter0 = 0;
	static int counterList = 0;
	static int counter10 = 0;
	
	public static void main(String[] agr){				
		
		try{
			testHeap();
		}
		catch(OutOfMemoryError err){
			System.out.println("0 = "+ counter0);	
		}
		
		try{
			test0();
		}
		catch(StackOverflowError err){
			System.out.println("0 = "+ counter0);	
		}
		try{
			test10();
		}
		catch(StackOverflowError err){
			System.out.println("10 = "+ counter10);
		}				
	}

	private static void test0() {
		counter0++;
		test0();
		
	}
	
	private static void test10() {
		long l1=0;long l4=0;long l7=0;long l10=0;
		long l2=0;long l5=0;long l8=0;
		long l3=0;long l6=0;long l9=0;
		
		counter10++;
		test10();
		
	}
	
	private static void testHeap(){
		String str = "asfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasaasfsadfasasfsadfasasfsadfasasfsadfasasfsadfasasfsadfasasfsadfasasfsadfasdfasdfasdfasdfasdfasdfadrferffrfrffrfrf";
		ArrayList<String> list = new ArrayList<String>();
		Random rnd = new Random(1000);		
		while (true){
			counterList++;			
			list.add(str.substring(rnd.nextInt(100)));	
			System.out.println("added element: "+ counterList);
		}
		
	}
	

}
