package connectingFolksWeb;

//import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class LogInPage{
	protected static LinkedHashMap<String, LogInPage> database = new LinkedHashMap<String, LogInPage>();
	String userName;
	String password;
	// static int postNo=1;
	LinkedHashMap<String, PostDetails> ownPost;
	LinkedHashMap<String, PostDetails> receivedPost;

	public LogInPage(String userName, String password, LinkedHashMap<String, PostDetails> ownPost,
			LinkedHashMap<String, PostDetails> receivedPost) {
		this.userName = userName;
		this.password = password;
		this.ownPost = ownPost;
		this.receivedPost = receivedPost;
		}

	LogInPage() {
		
	}

	public void createNewAccount() {
		ownPost = new LinkedHashMap<String, PostDetails>();
		receivedPost = new LinkedHashMap<String, PostDetails>();

		Scanner input = new Scanner(System.in);
		System.out.println("Enter user Name : ");
		String userName = input.next();
		input.nextLine();

		System.out.println("Enter Password : ");
		String pin = input.nextLine();

		if (!(database.containsKey(userName))) {
			LogInPage loginpageObj = new LogInPage(userName, pin, ownPost, receivedPost);
			database.put(userName, loginpageObj);
			System.out.println();
			System.out.println("      * * Account Created * * ");
			System.out.println();
			UserIdHome obj = new UserIdHome();
			obj.userAccount();
			} else {
			System.out.println("**User name already exist.....");
			createNewAccount();
		}

	}

	public void loginAccount() {
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("              [ login Page ]        ");
		System.out.println();
		System.out.println("Enter user Name : ");
		String userName = input.nextLine();
		// input.nextLine();
		System.out.println("Enter Password : ");
		String pin = input.nextLine();
		String checkPassword = database.get(userName).password;
		if (database.containsKey(userName) && checkPassword.equals(pin)) {
			CreatePost postObj = new CreatePost();
			postObj.Option(userName);
		} else {
			System.out.println("Invalid username or password... Try again ");
			UserIdHome obj = new UserIdHome();
			obj.userAccount();

		}

	}

}
