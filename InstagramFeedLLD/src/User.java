import java.util.ArrayList;
import java.util.List;

public class User {
		
	private String userID;
	private String userName;
//	private List<Post> userPosts;
//	private List<User> follows;
//	private List<User> followers;
	
	
	public User(String userID, String userName) {
//		super();
		this.userID = userID;
		this.userName = userName;
//		userPosts = new ArrayList<>();
//		follows = new ArrayList<>();
//		followers = new ArrayList<>();
	}
	
//	public List<User> getFollowers() {
//		return followers;
//	}
//	public void setFollowers(List<User> followers) {
//		this.followers = followers;
//	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
//	public List<Post> getUserPosts() {
//		return userPosts;
//	}
//	public void setUserPosts(List<Post> userPosts) {
//		this.userPosts = userPosts;
//	}
//	public List<User> getFollows() {
//		return follows;
//	}
//	public void setFollows(List<User> follows) {
//		this.follows = follows;
//	}

}
