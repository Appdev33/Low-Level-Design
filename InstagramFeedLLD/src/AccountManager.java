import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AccountManager {
	
	private static AccountManager instance;
	private static HashMap<String,User> users;
	private static HashMap<String,List<String>> followers;
	
	private AccountManager() {}
	
	public static AccountManager getInstance() {
		if(instance==null) {
			instance = new AccountManager();
			users = new HashMap<>();
			followers = new HashMap<String,List<String>>();
		}
		return instance;
	}
	
	public static HashMap<String,List<String>> getFollowers() {
		return followers;
	}

	public static HashMap<String, User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		users.put(user.getUserID(),user);
	}
	
	public boolean followUser(String follower, String following) {
		
		if(follower == null || following==null)
			return false;
		List<String> follows = followers.get(follower);
		if(follows==null)
			follows= new ArrayList<>();
		follows.add(following);
		followers.put(follower,follows );

		return true;
	}
	
	
	public List<String> getFollowerList(String followee) {
		return new ArrayList<>(followers.get(followee));
	}
	
	
}
