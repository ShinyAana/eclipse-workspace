package connectingFolksWeb;

//import java.util.HashSet;
import java.util.LinkedHashMap;

public class PostDetails 
{
	 String userName;
     String shareTo;
     String subject;
     String message;
     int postId;
     LinkedHashMap<String,String> comments=new LinkedHashMap<>();
     LinkedHashMap<String,String> likes=new LinkedHashMap<>();
    


	PostDetails(String userName,String shareTo,String subject,String message,int postId,LinkedHashMap<String,String> comments,LinkedHashMap<String,String> likes)
	{
	this.userName=userName;
	this.shareTo=shareTo;
	this.subject=subject;
	this.message=message;
	this.postId=postId;
	this.comments=comments;
	this.likes=likes;

	
	}
	/*
	 * PostDetails(LinkedHashMap<String,String>
	 * comments,LinkedHashMap<String,String> likes) { this.comments=comments;
	 * this.likes=likes;
	 * 
	 * }
	 */
	
}


