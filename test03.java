package object01;

public class test03 {

	public static void main(String[] args) {
		//  다중 for문
		int i, j ;
		
		for(i=1 ; i<=9 ; i++)
		{
			for(j=1 ; j<=i ; j++)
			{
				System.out.print("*");
			}
			System.out.println(); // 오른쪽 정삼각형
		}
		System.out.println();
		
		for(i=9 ; i>=1 ; i--)
		{
			for(j=1 ; j<=i ; j++)
			{
				System.out.print("*");
			}
			System.out.println(); // 오른쪽 역삼각형
		}

	}

}
