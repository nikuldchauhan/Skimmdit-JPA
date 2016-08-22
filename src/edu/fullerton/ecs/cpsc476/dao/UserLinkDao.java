package edu.fullerton.ecs.cpsc476.dao;

import java.util.List;

import edu.fullerton.ecs.cpsc476.entity.Link;
import edu.fullerton.ecs.cpsc476.entity.User;

public interface UserLinkDao 
{
	public List<Link> listLinksGivenUser(User user);
	public List<Link> ListlinksVotedByUser(User user);

}
