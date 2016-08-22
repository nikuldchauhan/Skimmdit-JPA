package edu.fullerton.ecs.cpsc476.dao;

import java.util.List;

import edu.fullerton.ecs.cpsc476.entity.Link;
import edu.fullerton.ecs.cpsc476.entity.User;

public interface UserLinkVoteDao 
{
	public String voteLinkUp(Link link, User user);
	public String voteLinkDown(Link link, User user);
	public List<Link> listAllLinks();
	public List<Link> listTop20LinksByVote();

}
