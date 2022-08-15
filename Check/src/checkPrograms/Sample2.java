package checkPrograms;

import java.util.HashMap;
import java.util.Map;

public class Sample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 HashMap<String,String> stationName=new HashMap<String,String>();
		stationName.put("CAPE","Kanyakumari");
		stationName.put("NCJ","Nagercoil Junction");
		//stationName.put("VLY","VALLIYUR");
		stationName.put("TEN", "Tirunelveli");
		stationName.put("MS","Chennai Egmore");

		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-20s|  %-20s|  %-20s\n","Station Name","Station Code","Date");
		System.out.println("--------------------------------------------------------------------");
		for(Map.Entry<String, String> hm: stationName.entrySet())
		{
			
			System.out.printf("%-20s|  %-20s|  %-20s\n",hm.getValue(),hm.getKey() ,hm.getValue()+"             ");
			
		}
		System.out.println("---------------------------------------------------------------------");


	}

}
