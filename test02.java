package object01;

public class test02 {

	public static void main(String[] args) {
		//  ���� for�� - 1~9�ܱ��� �Ѳ����� ������
		int i, j, k ;
		
		for(i=1 ; i<=9 ; i++)
		{
				for(j=1 ; j<=9 ; j++)
				{
					k = i * j ;
					System.out.println(i+" * "+j+" = "+k);
				}
			{
				System.out.print(" * "); // System.out.println���� ln�� �� ��� �Ʒ��� ����� �ƴ� ������ ���(���� �ƴ� �� ������)
			}
			System.out.println();
		}

	}

}
