package edu.fullerton.ecs.cpsc476.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User 
{
  @Id
  @Size(min = 2, max = 255)
  @NotNull
  @Column(name = "username", nullable = false, length = 255)
  private String userName;
  
  @Size(min = 2, max = 255)
  @NotNull
  @Column(name = "password", nullable = false, length = 255)
  private String passWord;
  
  @OneToMany(mappedBy = "user")
  private List<Link> link;
  
  @OneToMany(mappedBy = "user")
  private List<UserLinkVote> ulv;
  
  public List<UserLinkVote> getUlv() {
	return ulv;
  }
  public void setUlv(List<UserLinkVote> ulv) {
	this.ulv = ulv;
	}
  public String getUserName()
  {
	return userName;
  }
  public void setUserName(String userName) 
  {
	this.userName = userName;
  }
  
  public String getPassWord() 
  {
	return passWord;
  }
  public void setPassWord(String passWord)
  {
	this.passWord = passWord;
  }
  
  public List<Link> getLink() {
	return link;
  }
  public void setLink(List<Link> link) {
	this.link = link;
  }
  
}
