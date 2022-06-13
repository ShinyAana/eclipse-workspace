package hashMap;

public class NestedHashMap
{
	
	for(Entry<String, HashMap<String, Double>> entry : MobileList.mobileData.entrySet())
	{
			for(Entry<String, Double> entry2 : entry.getValue().entrySet())
			{
				System.out.printf(num++ +". "+"%-20s %s\n",entry2.getKey(),entry2.getValue());
		}
	
	}
}
}
