package learn;

public class FindSubMat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[][] mat= {{1,2,3},
			{4,5,6},
			{7,8,9}};
	int[][] sub= {{2,3},{5,6}};
	int s=3,t=3,m=2,n=2;
	boolean flag=true;
	for(int i=0;i<=(s-m);i++)
	{
		for(int j=0;j<=(t-n);j++)
		{
			flag=true;
			for(int p=0;p<m;p++)
			{
				for(int q=0;q<n;q++)
				{
					if(mat[i+p][j+q]!=sub[p][q])
					{
						flag=false;
						break;
					}
				}
				
			}
			if(flag==true)
			{
				System.out.println("match found in mat");
				break;
			}
			/*
			 * else { System.out.println("match not found"); }
			 */
		}
		/*
		 * if(flag==true) { System.out.println("match found in mat"); break; }
		 */
	}

	}

}
