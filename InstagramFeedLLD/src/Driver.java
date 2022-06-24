import java.util.HashMap;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AccountManager account = AccountManager.getInstance();
		PostManager postManager = PostManager.getInstance();

		account.addUser(new User("U1","Karan"));
		account.addUser(new User("U2","Sumit"));
		account.addUser(new User("U3","Inter"));
		account.addUser(new User("U4","Messi"));
		
		HashMap<String,User> map = account.getUsers();
		
		System.out.println("Welcome to Instagram Feed");
		Scanner scanner = new Scanner(System.in);

		while(true) {
			String command = scanner.nextLine();
			String[] commands = command.split(" ",4);
			String commandType = commands[0];
			
			switch(commandType) {
			
			case "makePost":{
				String user = commands[1];
				String postTitle=commands[2];
				String postContent=commands[3];
				postManager.makePost(user, new Post(postTitle,postContent));
				break;
			}
			
			case "getLatestPost":{
				String user = commands[1];
				System.out.println("Posts by user " + user + postManager.getInstance().getSelfPost(user));
				break;
			}
			
			case "getfollowerPosts":{
				String user = commands[1];
				System.out.println(postManager.getFollowerPosts(user));
				break;
			}

			case "doFollow":	
				String user1 = commands[1];
				String user2 = commands[2];
				account.getInstance().followUser(user1, user2);
				break;
				
			case "getFeed": {
				String user = commands[1];
				System.out.println("\nSelfPost\n"+postManager.getInstance().getSelfPost(user)+"\nFollowers Post\n"+postManager.getFollowerPosts(user) );
				break;
			}
			
			case "exit": return;
			}
			
		}	
	}
}
