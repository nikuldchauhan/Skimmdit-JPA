package edu.fullerton.ecs.cpsc476.java;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.fullerton.ecs.cpsc476.daoimpl.LinkDaoImpl;
import edu.fullerton.ecs.cpsc476.daoimpl.UserDaoImpl;
import edu.fullerton.ecs.cpsc476.daoimpl.UserLinkDaoImpl;
import edu.fullerton.ecs.cpsc476.daoimpl.UserLinkVoteDaoImpl;
import edu.fullerton.ecs.cpsc476.entity.Link;
import edu.fullerton.ecs.cpsc476.entity.User;

public class SkimmditJPA 
{
	public static void main(String[] arg)
	{
		Persistence.generateSchema("skimmditjpa", null);
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("skimmditjpa");
		EntityManager em = emFactory.createEntityManager();
		UserDaoImpl udo = new UserDaoImpl(em);
	
		System.out.println();
		System.out.println();
		
		//(1) *********************** Create a new user *************************
		
		User user1 = new User();
		user1.setUserName("nikul");
		user1.setPassWord("chauhan");
		String createUser = udo.createUser(user1);
		System.out.println("(1) *********************** Create a new user *************************");
	    System.out.println(createUser);
	    
	    System.out.println();
		System.out.println();
	    
	    //(1) *********************** Create a new user *************************
	    
	    User user2 = new User();
	    user2.setUserName("nikul");
	    user2.setPassWord("chauhan");
	    createUser = udo.createUser(user2);
		System.out.println("(1) *********************** Create a new user *************************");
	    System.out.println(createUser);  
	    
	    System.out.println();
		System.out.println();
	    
	  //(1) *********************** Create a new user *************************
	    
	    User user3 = new User();
	    user3.setUserName("John");
	    user3.setPassWord("Dao");
	    createUser = udo.createUser(user3);
		System.out.println("(1) *********************** Create a new user *************************");
	    System.out.println(createUser);

	    System.out.println();
		System.out.println();
	    
	  //(1) *********************** Create a new user *************************
	    
	    User user4 = new User();
	    user4.setUserName("Alice");
	    user4.setPassWord("Bob");
	    createUser = udo.createUser(user4);
		System.out.println("(1) *********************** Create a new user *************************");
	    System.out.println(createUser);
	    
	    System.out.println();
		System.out.println();
	    
	    //(2) *********************** Authenticate a user *************************
	    
		User uA1 = new User();
		uA1.setUserName("nikulchauhan");
		uA1.setPassWord("chauhan");
	    String isAuthenticate  = udo.isAuthenticate(uA1);
	    System.out.println("(2) *********************** Authenticate a user *************************");
	    System.out.println(isAuthenticate);
	    
	    System.out.println();
		System.out.println();
	    
	  //(2) *********************** Authenticate a user *************************
	    
	    User uA2 = new User();
		uA2.setUserName("nikul");
		uA2.setPassWord("chauhan");
	    isAuthenticate  = udo.isAuthenticate(uA2);
	    System.out.println("(2) *********************** Authenticate a user *************************");
	    System.out.println(isAuthenticate);
	    
	    System.out.println();
		System.out.println();
	    
	  //(2) *********************** Authenticate a user *************************
	    
	    User uA3 = new User();
		uA3.setUserName("Alice");
		uA3.setPassWord("Bob");
	    isAuthenticate  = udo.isAuthenticate(uA3);
	    System.out.println("(2) *********************** Authenticate a user *************************");
	    System.out.println(isAuthenticate);
	    
	    System.out.println();
		System.out.println();
	    
	  //(3) *********************** List existing users *************************
	    List<String> userList = udo.getListUsers();
	    System.out.println("(3) *********************** List existing users *************************");
	    char userListCount = 'a';
	    for (String username : userList)
	    {
			System.out.println("("+userListCount+") "+username);
			userListCount++;
		}
	  
	    System.out.println();
		System.out.println();
	    
	    LinkDaoImpl ldo = new LinkDaoImpl(em);
	  //(4) *********************** Submit a new link *************************
	    Link link1 = new Link();
	    link1.setLinkDescription("Welcome to Nikul Chauhan's Blog - Nikul Chauhan");
	    link1.setLinkAddress("http://www.nikulchauhan.com/");
	    link1.setUser(user1);
	    String submitLink = ldo.submitLink(link1);
	    System.out.println("(4) *********************** Submit a new link *************************");
	    System.out.println(submitLink);
	    
	    System.out.println();
		System.out.println();
	    
	  //(4) *********************** Submit a new link *************************
	    Link link2 = new Link();
	    link2.setLinkDescription("Google");
	    link2.setLinkAddress("https://www.google.com/");
	    link2.setUser(user3);
	    submitLink = ldo.submitLink(link2);
	    System.out.println("(4) *********************** Submit a new link *************************");
	    System.out.println(submitLink);
	    
	    System.out.println();
		System.out.println();
	    
	  //(4) *********************** Submit a new link *************************
	    Link link3 = new Link();
	    link3.setLinkDescription("Facebook");
	    link3.setLinkAddress("https://www.facebook.com/");
	    link3.setUser(user4);
	    submitLink = ldo.submitLink(link3);
	    System.out.println("(4) *********************** Submit a new link *************************");
	    System.out.println(submitLink);
	    
	    System.out.println();
		System.out.println();
	    
	  //(4) *********************** Submit a new link *************************
	    Link link4 = new Link();
	    link4.setLinkDescription("Live");
	    link4.setLinkAddress("https://www.live.com/");
	    link4.setUser(user1);
	    submitLink = ldo.submitLink(link4);
	    System.out.println("(4) *********************** Submit a new link *************************");
	    System.out.println(submitLink);

	    System.out.println();
		System.out.println();
	    
	    UserLinkVoteDaoImpl ulv = new UserLinkVoteDaoImpl(em);
	  
	  //(5) *********************** Vote a link up *************************
	    String voteLinkUp = ulv.voteLinkUp(link1, user1);
	    System.out.println("(5) *********************** Vote a link up *************************");
	    System.out.println(voteLinkUp);
	    
	    System.out.println();
		System.out.println();
	    
	  //(5) *********************** Vote a link up *************************
	    voteLinkUp = ulv.voteLinkUp(link1, user1);
	    System.out.println("(5) *********************** Vote a link up *************************");
	    System.out.println(voteLinkUp);
	    
	    System.out.println();
		System.out.println();
	    
	  //(5) *********************** Vote a link up *************************
	    voteLinkUp = ulv.voteLinkUp(link2, user1);
	    System.out.println("(5) *********************** Vote a link up *************************");
	    System.out.println(voteLinkUp);
	    
	    System.out.println();
		System.out.println();
	    
	  //(5) *********************** Vote a link up *************************
	    voteLinkUp = ulv.voteLinkUp(link2, user3);
	    System.out.println("(5) *********************** Vote a link up *************************");
	    System.out.println(voteLinkUp);
	    
	    System.out.println();
		System.out.println();
	    
	  //(6) *********************** Vote a link down *************************
	    String voteLinkDown = ulv.voteLinkDown(link1, user1);
	    System.out.println("(6) *********************** Vote a link down *************************");
	    System.out.println(voteLinkDown);
	    
	    System.out.println();
		System.out.println();
	    
	  //(6) *********************** Vote a link down *************************
	    voteLinkDown = ulv.voteLinkDown(link3, user4);
	    System.out.println("(6) *********************** Vote a link down *************************");
	    System.out.println(voteLinkDown);
	    
	    System.out.println();
		System.out.println();
	    
	  //(7) *********************** List all submitted links *************************
	    List<Link> ln = ulv.listAllLinks();
	    System.out.println("(7) *********************** List all submitted links *************************");
	    char linkCount = 'a';
	    for (Link lnk : ln) 
	    {
			System.out.println("("+linkCount+")"+"Link Description: "+lnk.getLinkDescription()+" ### Link Address: "+lnk.getLinkAddress()+" ### User: "+lnk.getUser().getUserName()+" ### Vote: "+lnk.getVote());
			linkCount++;
		}
	    
	    System.out.println();
		System.out.println();
	    
	  //(8) *********************** List the top 20 links by vote *************************
	    List<Link> ln20 = ulv.listTop20LinksByVote();
	    linkCount = 'a';
	    System.out.println("//(8) *********************** List the top 20 links by vote *************************");
	    for (Link lnk : ln20) 
	    {
			System.out.println("("+linkCount+")"+"Link Description: "+lnk.getLinkDescription()+" ### Link Address: "+lnk.getLinkAddress()+" ### User: "+lnk.getUser().getUserName()+" ### Vote: "+lnk.getVote());
			linkCount++;
		}
	    
	    System.out.println();
		System.out.println();
	    
	    UserLinkDaoImpl ulai = new UserLinkDaoImpl(em);
	 
	  //(9) *********************** List links submitted by a given user *************************
	    List<Link> lnu = ulai.listLinksGivenUser(user1);
	    linkCount = 'a';
	    System.out.println("//(9) *********************** List links submitted by a given user *************************");
	    for (Link lnk : lnu) 
	    {
			System.out.println("("+linkCount+")"+"Link Description: "+lnk.getLinkDescription()+" ### Link Address: "+lnk.getLinkAddress()+" ### User: "+lnk.getUser().getUserName()+" ### Vote: "+lnk.getVote());
			linkCount++;
		}
	    
	    System.out.println();
		System.out.println();
	    
	  //(9) *********************** List links submitted by a given user *************************
	    lnu = ulai.listLinksGivenUser(user4);
	    linkCount = 'a';
	    System.out.println("//(9) *********************** List links submitted by a given user *************************");
	    for (Link lnk : lnu) 
	    {
			System.out.println("("+linkCount+")"+"Link Description: "+lnk.getLinkDescription()+" ### Link Address: "+lnk.getLinkAddress()+" ### User: "+lnk.getUser().getUserName()+" ### Vote: "+lnk.getVote());
			linkCount++;
		}
	    
	    System.out.println();
		System.out.println();
	    
	  //(10) *********************** List links voted on by a user *************************
	    List<Link> l10 = ulai.ListlinksVotedByUser(user1);
	    linkCount = 'a';
	    System.out.println("//(10) *********************** List links voted on by a user *************************");
	    for (Link lnk : l10) 
	    {
			System.out.println("("+linkCount+")"+"Link Description: "+lnk.getLinkDescription()+" ### Link Address: "+lnk.getLinkAddress()+" ### User: "+lnk.getUser().getUserName()+" ### Vote: "+lnk.getVote());
			linkCount++;
		}
	    
	    System.out.println();
		System.out.println();
	    
	  //(10) *********************** List links voted on by a user *************************
	    l10 = ulai.ListlinksVotedByUser(user4);
	    linkCount = 'a';
	    System.out.println("//(10) *********************** List links voted on by a user *************************");
	    for (Link lnk : l10) 
	    {
			System.out.println("("+linkCount+")"+"Link Description: "+lnk.getLinkDescription()+" ### Link Address: "+lnk.getLinkAddress()+" ### User: "+lnk.getUser().getUserName()+" ### Vote: "+lnk.getVote());
			linkCount++;
		}
	}
}
