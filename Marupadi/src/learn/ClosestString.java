package learn;

public class ClosestString {

	public static void main(String[] args) 
	{
	String[] arr= {"the","quick","brown","fox","quick"};
	String word1="the";
	String word2="fox";
	int dist=0,mindist=Integer.MAX_VALUE;
	for(int i=0;i<arr.length;i++)
	{
		if(arr[i].equals(word1))
		{
			for(int j=i;j<arr.length;j++)
			{
				if(arr[j].equals(word2))
				{
					dist=j-i;
					if(mindist>dist)
						mindist=dist;
				}
			}
		}
	}
	System.out.println(mindist);
	}

}
