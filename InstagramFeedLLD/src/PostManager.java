import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostManager {
	
	private static PostManager instance;
	private static HashMap<String,List<Post>> postUsers;
	
	public static HashMap<String, List<Post>> getPostUsers() {
		return postUsers;
	}

	private PostManager() {}

	public static PostManager getInstance() {
		if(instance==null) {
			instance = new PostManager();
			postUsers = new HashMap<>();
		}	
		return instance;
	}

	public boolean makePost(String userID,Post post) {
		if(userID==null || post==null)
			return false;
		if(postUsers.get(userID)==null)
			postUsers.put(userID, new ArrayList<>());
		List<Post> userPosts = postUsers.get(userID); 
		if(userPosts==null)
			userPosts = new ArrayList<>();
		userPosts.add(post);
		
		return true;
	}
		
	public List<Post> getSelfPost(String userID) {
		
		if(postUsers.get(userID)==null) {
			System.out.print("No Posts Found by "+userID);
			return new ArrayList<>();  //how to handle this case
		}
		return postUsers.get(userID);
	}
	
	public Map<String,List<Post>> getFollowerPosts(String userID) {
		
		Map<String, List<Post>> res  = new HashMap<>();
		List<String> follows = AccountManager.getFollowers().get(userID);
		
		if(follows == null || follows.size()==0) {
			System.out.print("Users Follows no one");
			return null;
		}
		
		for(String u: follows) {
			res.put(u,postUsers.get(u));
		}
		return res;
	}
}
