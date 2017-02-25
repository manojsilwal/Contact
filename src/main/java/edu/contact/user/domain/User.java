package edu.contact.user.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import edu.contact.post.domain.Post;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	private UserProfile profile;
	Role role=Role.USER;
	
	@OneToMany(mappedBy = "user")
	List<Post> posts;
	
	private String imageUrl;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public UserProfile getProfile() {
		return profile;
	}
	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}	
	@Override
	public String toString() {
		return "User [profile=" + profile + ", role=" + role + ", posts=" + posts + "]";
	}
	
	
	
}
