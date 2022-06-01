package connectingFolksWeb;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CreatePost
{

	public void Option(String userName) 
	{
        Scanner input=new Scanner(System.in);
        System.out.println("..............Choose One Option.............");
        System.out.println(" 1.Post  \n 2.View own post \n 3.View tagged post \n 4.Exit ");
        int ch=input.nextInt();
        switch (ch)
        {
		case 1: {
		    	createAPost(userName);
			break;
		}
		case 2:
			viewOwnPost(userName);
			break;
		case 3:
			viewTaggedPost(userName);
			break;
		
		
		case 4:
		{
			UserIdHome obj=new UserIdHome();
 	       obj.userAccount();
 	    	 
			break;
		}

	}

}

	private void viewTaggedPost(String userName)
	{
	       System.out.println();
	       System.out.println(); 
	       System.out.println("  [       -----> Tagged Posts <-------  ]");
	         System.out.println();
	 		LinkedHashMap<String, PostDetails> receivedPost=new LogInPage().database.get(userName).receivedPost;
	    
	          boolean checkReceived=receivedPost.isEmpty();
	          
	          if(checkReceived==true) 
	          {
	         	   System.out.println();
	         	   System.out.println("   [ *Tagged posts are empty ]   ");
	                System.out.println("--------------------------------------------------------------");
	         	   System.out.println();
	    
	         	   Option(userName);
	          }
	                   
	          Iterator<String> itr=receivedPost.keySet().iterator();
	          while(itr.hasNext())
	          {
	         	 String key=itr.next();
	         	 System.out.println(key);
	         	 PostDetails robej=receivedPost.get(key);
	         	 System.out.println("******************");
	         	 System.out.println("[ Message ID ]  ::  "+robej.postId);
	         	 System.out.println("[   Post By    ]  ::  "+robej.userName);
	         	 System.out.println("[   Subject  ]  ::  "+robej.subject);
	         	 System.out.println("[   Message  ]  ::  "+robej.message);
	         	 
	          }
	          LinkedHashMap<String,String> comments=new LinkedHashMap<>();
	          LinkedHashMap<String,String> likes=new LinkedHashMap<>();
	      	
	          Scanner input=new Scanner(System.in);
	          System.out.println("To comment any post enter the message id ");
	          int commentId=input.nextInt();
	          input.nextLine();
	          System.out.println("Enter Comment ");
	          String comment1=input.nextLine();
	          comments.put(userName, comment1);
	          System.out.println("Do you want to like press 'Y' or 'No' to proceed");
	          String l=input.next();
	          if(l.equals("Y"))
	          {
	        	  likes.put(userName, "Liked your post ");
	          }
	          LinkedHashMap<String,PostDetails> obj2=LogInPage.database.get(userName).ownPost;
	         
	          String userName1=obj2.get(userName).userName;	          
	          String shareTo1=obj2.get(userName).shareTo;
	          String subject1=obj2.get(userName).subject;
	          String message1=obj2.get(userName).message;
	          int postId1=obj2.get(userName).postId;
	          PostDetails details=new PostDetails(userName1,shareTo1,subject1,message1,postId1,comments,likes);
	          LinkedHashMap<String, PostDetails> toOwnPost=LogInPage.database.get(userName).receivedPost;
				toOwnPost.put(userName, details);
				obj2.put(userName, details);
	            
	     
		          Option(userName);
		        
	         
	
	}

	private void viewOwnPost(String userName)
	{
        LinkedHashMap<String, PostDetails> ownPost=new LogInPage().database.get(userName).ownPost;

        System.out.println();
        System.out.println();
        System.out.println("           [--------> Created posts <----------]     ");
        System.out.println();
        
        boolean checkPostBox=ownPost.isEmpty();
                  if(checkPostBox==true) 
         {
        	   System.out.println();
        	   System.out.println("    [ You won't create any post yet ]   ");
System.out.println("---------------------------------------------------------------------------");
        	   System.out.println();
        	   Option(userName);
         }
           
          
         Iterator<String> itr=ownPost.keySet().iterator();
         while(itr.hasNext())
         {
        	 String key=itr.next();
        	 PostDetails object=ownPost.get(userName);
        	 System.out.println("******************");
        	 System.out.println("[ Message ID ]  ::  "+object.postId);
        	 System.out.println("[    From    ]  ::  "+object.userName);
        	 System.out.println("[     To     ]  ::  "+object.shareTo);
        	 System.out.println("[   Subject  ]  ::  "+object.subject);
        	 System.out.println("[   Message  ]  ::  "+object.message);
        	/* System.out.println("[   Comments  ]  ::  "+);
        	 System.out.println("[   Liked by  ]  ::  "+object.message);
            */ 
         
         }
         
         
         Option(userName);

	}

	private void createAPost(String userName)
	{
		LinkedHashMap<String,String> comments=new LinkedHashMap<>();
	     LinkedHashMap<String,String> likes=new LinkedHashMap<>();
	 	
		System.out.println();
		System.out.println("........Share your Knowledge Section.......");
            Scanner input=new Scanner(System.in);

            System.out.println("From : "+userName);
            System.out.println("TO : ");
            String shareTo=input.nextLine();
            
            
                boolean checkToaddress=LogInPage.database.containsKey(shareTo);
            
                if(checkToaddress==false) 
                {
               	 System.out.println("        [   *This username [ "+shareTo+" ] cannot found  ]     ");
                    Option(userName);      
                }
            
            System.out.println("Subject : ");
            String subject=input.nextLine();
            System.out.println("Message : ");
            String message =input.nextLine();
            int postID=(int)(Math.random()*100+100);
            System.out.println("Comment To "+shareTo + " :");
            String com=input.nextLine();
            comments.put(userName, com);
            PostDetails details=new PostDetails(userName,shareTo,subject,message,postID,comments,likes);

            boolean msgSendOrNot=SendorNot(shareTo,details,postID);
            if(msgSendOrNot) {
             new LogInPage();
			LinkedHashMap<String, PostDetails> toOwnPost=LogInPage.database.get(userName).ownPost;
			toOwnPost.put(userName, details);
             System.out.println("     [  Message Added mailbox  ]   ");
            }
            Option(userName);
	}

	private boolean SendorNot(String shareTo,PostDetails details,int postID) {
        new LogInPage();
		LinkedHashMap<String, PostDetails> toReceivedPost=LogInPage.database.get(shareTo).receivedPost;
        toReceivedPost.put(shareTo, details);
        System.out.println();
        System.out.println("        [  Message Succesfully Send to  "+details+"       ]");
        System.out.println();
        return true;
	}

	}
