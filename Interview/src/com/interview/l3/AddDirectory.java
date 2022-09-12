package com.interview.l3;

import java.io.File;
import java.util.Scanner;

public class AddDirectory {
	public static void main(String args[]) {
		System.out.println("Enter the path to create a directory: ");
		Scanner sc = new Scanner(System.in);
		String path = sc.next();
		System.out.println("Enter the name of the desired a directory: ");
		path = path + sc.next();
		File file = new File(path);
		boolean bool = file.mkdir();
		if (bool) {
			System.out.println("Directory created successfully");
		} else {
			System.out.println("Sorry couldn’t create specified directory");
		}
	}
}
//public abstract class Entry
{
    protected Directory parent;
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name;
  
    public Entry(String n, Directory p)
    {
        name = n;
        parent = p;
        created= System.currentTimeMillis();
        lastUpdated = System.currentTimeMillis();
        lastAccessed = System.currentTimeMillis();
    }
  
    public boolean delete()
    {
        if (parent == null)
            return false;
        return parent.deleteEntry(this);
    }
  
    public abstract int size();
  
    /* Getters and setters. */
    public long getcreationTime()
    {
        return created;
    }
    public long getLastUpdatedTime()
    {
        return lastUpdated;
    }
    public long getLastAccessedTime()
    {
        return lastAccessed;
    }
    public void changeName(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }
}
  
// A class to represent a File (Inherits
// from Entry)
public class File extends Entry
{
    private String content;
    private int size;
  
    public File(String n, Directory p, int sz)
    {
        super(n, p);
        size = sz;
    }
    public int size()
    {
        return size;
    }
    public String getContents()
    {
        return content;
    }
    public void setContents(String c)
    {
        content = c;
    }
}
  
// A class to represent a Directory (Inherits
// from Entry)
public class Directory extends Entry
{
    protected Arraylist<Entry> contents;
  
    public Directory(String n, Directory p)
    {
        super(n, p);
        contents = new Arraylist<Entry>();
    }
    public int size()
    {
        int size = 0;
        for (Entry e : contents)
            size += e.size();
          
        return size;
    }
    public int numberOfFiles()
    {
        int count = 0;
        for (Entry e : contents)
        {
            if (e instanceof Directory)
            {
                count++; // Directory counts as a file
                Directory d = (Directory) e;
                count += d. numberOfFiles ();
            }
            else if (e instanceof File)            
                count++;            
        }
        return count;
    }
  
    public boolean deleteEntry(Entry entry)
    {
        return contents.remove(entry);
    }
  
    public void addEntry(Entry entry)
    {
        contents.add(entry);
    }
  
    protected ArrayList<Entry> getContents()
    {
        return contents;
    }
}
Alternatively, we could have implemented Directory such that it contains separate lists for files and subdirectories. This makes the nurnberOfFiles () method a bit cleaner, since it doesn’t need to use the instanceof operator, but it does prohibit us from cleanly sorting files and directories by dates or names.

For data block allocation, we can use bitmask vector and linear search (see “Practical File System Design”) or B+ trees (see Reference or Wikipedia).

References:
https://www.careercup.com/question?id=13618661
https://stackoverflow.com/questions/14126575/data-structures-used-to-build-file-systems

This a