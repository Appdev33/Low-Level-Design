import java.util.UUID;

public class Post {

	private String postID;
	private String postTitle;
	private String postContent;
//	private int createdAt;
	
	
	public Post(String postTitle, String postContent) {
		this.postID = UUID.randomUUID().toString();
		this.postTitle = postTitle;
		this.postContent = postContent;
//		this.createdAt = createdAt;
	}
	
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
//	public int getCreatedAt() {
//		return createdAt;
//	}
//	public void setCreatedAt(int createdAt) {
//		this.createdAt = createdAt;
//	}

}
