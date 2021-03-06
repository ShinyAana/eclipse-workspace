package connectingFolksWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CreatePost {

	public void Option(String userName) {
		Scanner input = new Scanner(System.in);
		System.out.println("..............Choose One Option.............");
		System.out.println(" 1.Post  \n 2.View own post \n 3.View tagged post \n 4.Exit ");
		int ch = input.nextInt();
		switch (ch) {
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

		case 4: {
			UserIdHome obj = new UserIdHome();
			obj.userAccount();

			break;
		}

		}
		

	}
	


	private void viewTaggedPost(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("  [       -----> Tagged Posts <-------  ]");
		System.out.println();
		LinkedHashMap<String, PostDetails> receivedPost = new LogInPage().database.get(userName).receivedPost;
		LinkedHashMap<String, String> comments = new LinkedHashMap<>();
		LinkedHashMap<String, String> likes = new LinkedHashMap<>();

		boolean checkReceived = receivedPost.isEmpty();

		if (checkReceived == true) {
			System.out.println();
			System.out.println("   [ *Tagged posts are empty ]   ");
			System.out.println("--------------------------------------------------------------");
			System.out.println();

			Option(userName);
		}
		Iterator<String> itr1 = receivedPost.keySet().iterator();
		while (itr1.hasNext()) {
			String key = itr1.next();
			System.out.println(key);
			PostDetails robej = receivedPost.get(key);
			System.out.println("******************");
			System.out.println("[ Message ID ]    ::  " + robej.postId);
			System.out.println("[   Post By    ]  ::  " + robej.userName);
			System.out.println("[   Subject  ]    ::  " + robej.subject);
			System.out.println("[   Message  ]    ::  " + robej.message);
			System.out.println("[   Comment ]      ::  " + robej.comments);
			System.out.println("[   Likes  ]       ::  " + robej.likes);
		}
		Scanner input = new Scanner(System.in);

		System.out.println("Enter post id you want to comment ");
		int id = input.nextInt();

		Iterator<String> itr = receivedPost.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			// System.out.println(key);
			PostDetails robej = receivedPost.get(key);
			// System.out.println("******************");
			// System.out.println("[ Message ID ] :: "+robej.postId);
			// System.out.println("[ Post By ] :: "+robej.userName);
			// System.out.println("[ Subject ] :: "+robej.subject);
			// System.out.println("[ Message ] :: "+robej.message);

			input.nextLine();
			if (key.equals(String.valueOf(id))) {
                
				System.out.println("Enter Comment ");
				String comment1 = input.nextLine();
				comments.put(userName, comment1);

				System.out.println("Do you want to like press 'Y' ");
				String l = input.next();
				String like = " Liked the  post";
				likes.put(userName, like);

				String postBy = robej.userName;
				String sub = robej.subject;
				String msg = robej.message;
				// LinkedHashMap<String,PostDetails>
				// toReceivePost=LogInPage.database.get(userName).ownPost;

				/*
				 * String userName1=receivedPost.get(userName).userName; String
				 * shareTo1=receivedPost.get(userName).shareTo; String
				 * subject1=receivedPost.get(userName).subject; String
				 * message1=receivedPost.get(userName).message; int
				 * postId1=receivedPost.get(userName).postId;
				 */
				PostDetails details = new PostDetails(postBy, userName, sub, msg, id, comments, likes);

				receivedPost.put(String.valueOf(id), details);

				LinkedHashMap<String, PostDetails> toOwnPost = LogInPage.database.get(postBy).ownPost;
				toOwnPost.put(String.valueOf(id), details);

				break;
			}

		}
		Iterator<String> it = receivedPost.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			PostDetails robej = receivedPost.get(key);
			System.out.println("******************");
			System.out.println("[  Message ID ]    ::  " + robej.postId);
			System.out.println("[  Post By  ]      ::  " + robej.userName);
			System.out.println("[  Subject  ]      ::  " + robej.subject);
			System.out.println("[  Message  ]      ::  " + robej.message);
			System.out.println("[  Comment  ]       ::  ");

			for (Entry<String, String> entry : robej.comments.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
			System.out.println("[   Likes  ]  ::  ");
			for (Entry<String, String> entry : robej.likes.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}

		}

		/*
		 * LinkedHashMap<String, PostDetails>
		 * toOwnPost=LogInPage.database.get(userName).receivedPost; String
		 * userName1=toReceivePost.get(userName).userName; String
		 * shareTo1=toReceivePost.get(userName).shareTo; String
		 * subject1=toReceivePost.get(userName).subject; String
		 * message1=toReceivePost.get(userName).message; int
		 * postId1=toReceivePost.get(userName).postId;
		 * 
		 * 
		 * toOwnPost.put(userName, details);
		 */
		/*
		 * Iterator<String> itr1=receivedPost.keySet().iterator(); while(itr1.hasNext())
		 * { String key=itr1.next(); System.out.println(key); PostDetails
		 * robej=receivedPost.get(key); System.out.println("******************");
		 * System.out.println("[ Message ID ]  ::  "+robej.postId);
		 * System.out.println("[   Post By    ]  ::  "+robej.userName);
		 * System.out.println("[   Subject  ]  ::  "+robej.subject);
		 * System.out.println("[   Message  ]  ::  "+robej.message);
		 * System.out.println("[   Comment ]  ::  "+robej.comments);
		 * System.out.println("[   Likes  ]  ::  "+robej.likes);
		 * 
		 * 
		 * }
		 * 
		 */
		Option(userName);
	}

	private void viewOwnPost(String userName)
	{
		LinkedHashMap<String, PostDetails> ownPost = new LogInPage().database.get(userName).ownPost;

		System.out.println();
		System.out.println();
		System.out.println("           [--------> Created posts <----------]     ");
		System.out.println();

		boolean checkPostBox = ownPost.isEmpty();
		if (checkPostBox == true) {
			System.out.println();
			System.out.println("    [ You won't create any post yet ]   ");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println();
			Option(userName);
		}

		Iterator<String> itr = ownPost.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			System.out.println(key);
			PostDetails object = ownPost.get(key);
			System.out.println("******************");
			System.out.println("[ Message ID ]  ::  " + object.postId);
			System.out.println("[    From    ]  ::  " + object.userName);
			System.out.println("[     To     ]  ::  " + object.shareTo);
			System.out.println("[   Subject  ]  ::  " + object.subject);
			System.out.println("[   Message  ]  ::  " + object.message);
			// System.out.println("[ Comments ] :: "+object.comments);
			// System.out.println("[ Liked by ] :: "+object.likes);
			System.out.println("[   Comment  ]      ::  ");

			for (Entry<String, String> entry : object.comments.entrySet())
					{
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
			System.out.println("[   Likes  ]  ::  ");
			for (Entry<String, String> entry : object.likes.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}

		}

		Option(userName);

	}

	private void createAPost(String userName) {
		LinkedHashMap<String, String> comments = new LinkedHashMap<>();
		LinkedHashMap<String, String> likes = new LinkedHashMap<>();

		System.out.println();
		System.out.println("........Share your Knowledge Section.......");
		Scanner input = new Scanner(System.in);

		System.out.println("From : " + userName);
		System.out.println("TO : ");
		String shareTo1 = input.nextLine();
		String shareTo2 = input.nextLine();

		boolean checkToaddress = LogInPage.database.containsKey(shareTo1);

		if (checkToaddress == false) {
			System.out.println("        [   *This username [ " + shareTo1 + " ] cannot found  ]     ");
			Option(userName);
		}
		boolean checkToaddress2 = LogInPage.database.containsKey(shareTo2);

		if (checkToaddress2 == false) {
			System.out.println("        [   *This username [ " + shareTo2 + " ] cannot found  ]     ");
			Option(userName);
		}

		String shareTo=shareTo1 + " " + shareTo2;
 
		System.out.println("Subject : ");
		String subject = input.nextLine();
		System.out.println("Message : ");
		String message = input.nextLine();
		int postID = (int) (Math.random() * 100 + 100);
		PostDetails details= new PostDetails(userName, shareTo, subject, message, postID, comments, likes);
		
		PostDetails details1= new PostDetails(userName, shareTo1, subject, message, postID, comments, likes);
		PostDetails details2 = new PostDetails(userName, shareTo2, subject, message, postID, comments, likes);

		boolean msgSendOrNot = SendorNot(shareTo1, details1, postID);
		boolean msgSendOrNot2 = SendorNot(shareTo2, details2, postID);

		if (msgSendOrNot && msgSendOrNot2) {
			new LogInPage();
			LinkedHashMap<String, PostDetails> toOwnPost = LogInPage.database.get(userName).ownPost;
			toOwnPost.put(String.valueOf(postID), details);
			System.out.println("     [  Message Added mailbox  ]   ");
		}
		Option(userName);
	}

	private boolean SendorNot(String shareTo, PostDetails details, int postID) {
		new LogInPage();
		LinkedHashMap<String, PostDetails> toReceivedPost = LogInPage.database.get(shareTo).receivedPost;
		toReceivedPost.put(String.valueOf(postID), details);
		System.out.println();
		System.out.println("        [  Message Succesfully Send to  " + shareTo + "       ]");
		System.out.println();
		return true;
	}

}
