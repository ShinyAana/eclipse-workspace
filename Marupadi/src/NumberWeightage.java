import java.util.Arrays;
	

public class NumberWeightage {

	public static void main(String[] args) {

		int[] val = new int[] {49,36,8,10,12};
		int len = val.length;
		int[] weight = new int[len];
		Arrays.sort(val);//8,10,12,36,49
		for(int i=0;i<len;i++)
		{
			weight[i] = 0;
			int sqrt = (int)Math.sqrt(val[i]);
			if((sqrt * sqrt) == val[i])
				weight[i] += 5;
			if((val[i] % 6 == 0) && (val[i] % 4 == 0))
				weight[i] +=4;
			if(val[i]%2==0)
				weight[i] +=3;
		}
		for(int j=0;j<weight.length;j++)
		{
			System.out.print(weight[j]+" ");
		}
		int tempForVal,tempForWeight;
		for(int i=0;i<len-1;i++)
		{
			for(int j=0;j<len-i-1;j++)
			{
				if(weight[j]<weight[j+1])
				{
					tempForWeight = weight[j];
					weight[j] = weight[j+1];
					weight[j+1] = tempForWeight;
					
					tempForVal = val[j];
					val[j] = val[j+1];
					val[j+1] = tempForVal;
				}
			}
		}
		for(int i=0;i<len;i++)
		{
			System.out.print("<"+val[i]+","+weight[i]+">"+",");
		}


	}

}
