package object01;

public class test01 {

	public static void main(String[] args) {
		// for¹®
		int i, sum ;
		
		
		
		for(i=1 ; i<=100 ; i++)
		{
			if( (i%3)==0 && (i%5)==0)
			{
				System.out.println("i = "+i);
			}
		}
		
		/*
		if( (i%3)==0 || (i%5)==0)
		{
			System.out.println("i = "+ i);
		}
			
			System.out.println("*");*/
			
	}
}


