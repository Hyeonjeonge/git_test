package object01;

public class test02 {

	public static void main(String[] args) {
		//  다중 for문 - 1~9단까지 한꺼번에 나오게
		int i, j, k ;
		
		for(i=1 ; i<=9 ; i++)
		{
				for(j=1 ; j<=9 ; j++)
				{
					k = i * j ;
					System.out.println(i+" * "+j+" = "+k);
				}
			{
				System.out.print(" * "); // System.out.println에서 ln을 뺄 경우 아래로 출력이 아닌 옆으로 출력(행이 아닌 열 단위로)
			}
			System.out.println();
		}

	}

}
