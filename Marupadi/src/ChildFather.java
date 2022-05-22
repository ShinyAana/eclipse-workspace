 
 import java.util.*;
 public class ChildFather {

		public static void main(String[] args) {

  Scanner scan=new Scanner(System.in);
  System.out.println("Enter number of rows ");
  int n=scan.nextInt();
  scan.nextLine();
  ArrayList< String > arr=new  ArrayList<>();
  int i,j,flag;
  String[] input=new String[n];
  String[] father=new String[n];
  String[] child=new String[n];
   for(i=0;i<n;i++)
  {
	   System.out.println("Enter child father name ");
    input[i]=scan.nextLine();
    father[i]="";
    child[i]="";
    flag=0;
    for(j=0;j<input[i].length();j++)
    {
    if(input[i].charAt(j)==',')
       flag=1;
    if(((input[i].charAt(j)>='a'&&input[i].charAt(j)<='z')||(input[i].charAt(j)>='A' &&
                input[i].charAt(j)<='Z'))&&flag==0)
        child[i]=child[i]+input[i].charAt(j);  

    else  if(((input[i].charAt(j)>='a'&&input[i].charAt(j)<='z')||
                 (input[i].charAt(j)>='A'&&input[i].charAt(j)<='Z'))&&flag==1)
        father[i]=father[i]+input[i].charAt(j);
    }
  }
   System.out.println("Enther the name to find number of grand children");
  String search=scan.nextLine();
  for(i=0;i<n;i++)
  {
     if(father[i].equals(search))
     {
         arr.add(child[i]);
     }
  }
  flag=0;
  for(i=0;i<arr.size();i++)
  {
     for(j=0;j<n;j++)
     {
       if(father[j].equals(arr.get(i)))
        flag++;  
     }
   }
  System.out.println(flag);
 }
}

