package com.file.io2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StartProcess extends LinkedList
{
protected static HashMap<String,List<File>> repository=new HashMap<>();
	public static void main(String[] args) 
	{
		StartProcess start=new StartProcess();
		start.getUserInput();
		
	}

	private void getUserInput()
	{
		boolean isExit=true;
		while(isExit)
		{
			Scanner input=new Scanner(System.in);
			System.out.println("Enter your choice \n1.Add Directory \n2.Delete Directory \n3.Create File \n4.List Files \n5.Add content to file \n6.Change file mode\n7.Exit");	
			int choice=input.nextInt();
			switch(choice)
			{
			case 1:
				StartProcess.addDirectory();
				break;
			case 2:
				StartProcess.deleteDirectory();
				break;
			case 3:
				StartProcess.createFile();
				break;
			case 4:
				StartProcess.listFiles();
				break;
			case 5:
				StartProcess.addContent();
				break;
			case 6:
				StartProcess.changeMode();
				break;

			case 7:
				isExit=false;
				break;
			}
		}
    	
	}

	private static void changeMode()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter directory name");
		String dir=input.next();
		System.out.println("Enter file  name");
		String fname=input.next();
		for (Map.Entry<String, List<File>> mapEntry : repository.entrySet()) {
			if (mapEntry.getKey().equals(dir)) {
				for (File file : mapEntry.getValue()) 
				{
				if(file.getFname().equals(fname))
				{
					if(file.isReanOnly()==true)
					{
						System.out.println("File is in read only mode \n Do you want to change y/n");
						char ch=input.next().charAt(0);
						if(ch=='y')
						{
							file.setReanOnly(false);
							System.out.println("Changed to read write mode");
						}
					}
					else
					{
						System.out.println("File is in read write mode \n Do you want to change y/n");
						char ch=input.next().charAt(0);
						if(ch=='y')
						{
							file.setReanOnly(true);
							System.out.println("Changed to read only mode");
						}
	
					}
				}
				else
				{
					System.out.println("Can't find file");
				}
				}
			}
			else
			{
				System.out.println("Can't find the directory ");
			}
		}
		

	}

	private static void addContent() 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter directory name");
		String dir=input.next();
		System.out.println("Enter file  name");
		String fname=input.next();
		System.out.println("Enter content to add");
		//String content=input.nextLine();
		String content1=input.nextLine();
		System.out.println();
		for (Map.Entry<String, List<File>> mapEntry : repository.entrySet()) {
			if (mapEntry.getKey().equals(dir)) {
				for (File file : mapEntry.getValue()) 
				{
				if(file.getFname().equals(fname))
				{
					if(file.isReanOnly()==true)
					{
						System.out.println("File is in read only mode");
					}
					else
					{
				file.setContent(content1);
				file.setSize(content1.length());
					}
				}
				else
				{
					System.out.println("Can't find file");
				}
				}
			}
			else
			{
				System.out.println("Can't find the directory ");
			}
		}
		
	}

	private static void listFiles() 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter directory name to list files");
		String dir=input.next();
		
		for (Map.Entry<String, List<File>> mapEntry : repository.entrySet()) {
			if (mapEntry.getKey().equals(dir)) {
				for (File file : mapEntry.getValue()) {
					System.out.println("File Name: " + file.getFname());
					System.out.println("File Content: " + file.getContent());
					System.out.println("File Size :" + file.getSize());
				}
			}
		}
		
	}

	private static void createFile() 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter directory name ");
		String dir=input.next();
		dir=dir.toUpperCase();
		System.out.println("Enter file name");
		String fname=input.next();
		fname=fname.toLowerCase();
		boolean isValidName=StartProcess.isValidfName(fname);
		ArrayList<File> al=new ArrayList<>();
		al.add(new File(fname));
		repository.put(dir, al);
		
		System.out.println("Created Successfully");
	}

	private static boolean isValidfName(String fname)
	{
		String regex = "^[a-zA-Z0-9+_]$";
		Pattern p=Pattern.compile(regex);
		if(fname==null)
		{
			return false;
		}
		Matcher m=p.matcher(fname);
		return m.matches();

	}

	private static void deleteDirectory()
	{
		LinkedList<String> obj=new LinkedList<>();
		Scanner input=new Scanner(System.in);
		
		obj.display();
		
		/*
		 * System.out.println("Enter the directory name"); String dir=input.next();
		 * dir=dir.toUpperCase();
		 */System.out.println("Enter the directory position to delete");
		int pos=input.nextInt();
		obj.deleteAtPos(pos);
		System.out.println("Deleted Successfully");
		obj.display();
		/*
		 * for (Map.Entry<String, List<File>> mapEntry : repository.entrySet()) { if
		 * (mapEntry.getKey().equals(dir)) { repository.remove(dir); } }
		 */
		//System.out.println();
	}

	private static void addDirectory()
	{
		LinkedList<String> obj=new LinkedList<>();
		System.out.println("Existing Directories are ");
		obj.insertAtBeginning("AU");
		obj.insertAtPos(1, "CS");
		//ArrayList<ArrayList<String>> al=new ArrayList<>();
		ArrayList<String> parent=new ArrayList<>();
		ArrayList<String> child=new ArrayList<>();
		//System.out.println("");
		obj.display();
		Scanner input=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the name");
		String name=input.next();
		name=name.toUpperCase();
		System.out.println("Enter the position of the detectory");
		int pos=input.nextInt();
		//System.out.println();
		obj.insertAtPos(pos, name);
		obj.display();
		System.out.println("Created successfully");
		

	}

}
