package edu.fullerton.ecs.cpsc476.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "link")
public class Link 
{
	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @Size(min = 2, max = 255)
	  @NotNull
	  @Column(name = "linkDescription", nullable = false, length = 255)
	  private String linkDescription;
	  
	  @Size(min = 2, max = 255)
	  @NotNull
	  @Column(name = "linkAddress", nullable = false, length = 255)
	  private String linkAddress;
	  
	  @Column(name = "vote")
	  private int vote;
	  
	  @ManyToOne
	  @JoinColumn(name="userName")
	  private User user;
	  
	  @OneToMany(mappedBy = "link")
	  private List<UserLinkVote> ulv;
	  
	public List<UserLinkVote> getUlv() {
		return ulv;
	}
	public void setUlv(List<UserLinkVote> ulv) {
		this.ulv = ulv;
	}
	
	public Link()
	  {
		  vote = 1;
	  }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLinkDescription() {
		return linkDescription;
	}

	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	
	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
