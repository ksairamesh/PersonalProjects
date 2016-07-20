public class FizzBuzz1 {

	public static void main(String[] args) {
		
		if (args.length > 0) 
			try {
				 int num = Integer.parseInt(args[0]);
				 printFizzBuzz(num);
			    } 
		catch (NumberFormatException e) {
			System.exit(1);
		}

	}
	
	public static void printFizzBuzz(int num){
		
		for (int i=1;i<=num;i++){
			if (((i % 3) == 0) && ((i % 5) == 0))  {
				 System.out.println("FizzBuzz");  
			}             
		      else if  ((i % 3) == 0) {
		    	  System.out.println("Fizz"); 
		      }
		      else if ((i % 5) == 0) {
		    	  System.out.println("Buzz"); 
		      }
		      else {
		    	  System.out.println(i);  
		      }                      
		}
		
		
	}

}