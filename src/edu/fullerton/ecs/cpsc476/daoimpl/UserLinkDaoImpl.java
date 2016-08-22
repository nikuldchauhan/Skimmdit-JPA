package edu.fullerton.ecs.cpsc476.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import edu.fullerton.ecs.cpsc476.dao.UserLinkDao;
import edu.fullerton.ecs.cpsc476.entity.Link;
import edu.fullerton.ecs.cpsc476.entity.User;

public class UserLinkDaoImpl implements UserLinkDao
{
private EntityManager em;
	
	public UserLinkDaoImpl(EntityManager em)
	{
		this.em = em;
	}
	
	@Override
	public List<Link> listLinksGivenUser(User user)
	{
		List<Link> ListLinksUser = em.createQuery("SELECT l  FROM Link as l where user= :userName").setParameter("userName", user).getResultList();
		return ListLinksUser;
	}

	@Override
	public List<Link> ListlinksVotedByUser(User user) 
	{
		// TODO Auto-generated method stub
		List<Link> listlinksVotedUser = em.createQuery("SELECT l  FROM Link as l JOIN l.ulv u where u.user= :userName").setParameter("userName", user).getResultList();
		return listlinksVotedUser;
		//SELECT c.name, p.name FROM Country c JOIN c.capital p l.linkDescription, l.linkAddress, l.user, l.vote
	}

}
