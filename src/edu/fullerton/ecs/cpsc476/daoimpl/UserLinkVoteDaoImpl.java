package edu.fullerton.ecs.cpsc476.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.fullerton.ecs.cpsc476.dao.UserLinkVoteDao;
import edu.fullerton.ecs.cpsc476.entity.Link;
import edu.fullerton.ecs.cpsc476.entity.User;
import edu.fullerton.ecs.cpsc476.entity.UserLinkVote;

public class UserLinkVoteDaoImpl implements UserLinkVoteDao
{
	private EntityManager em;
	
	public UserLinkVoteDaoImpl(EntityManager em)
	{
		this.em = em;
	}
	
	@Override
	public String voteLinkUp(Link link, User user) 
	{
		// TODO Auto-generated method stub
		String msg = "";
		Query query = em.createQuery("SELECT ulv FROM UserLinkVote as ulv where ulv.user= :userName and ulv.link= :article_Id");
		query.setParameter("userName", user);
		query.setParameter("article_Id", link);
		
		List<UserLinkVote> l = (List) query.getResultList();
		if(l.isEmpty())
		{
			//
			try{
				UserLinkVote ulv = new UserLinkVote();
				ulv.setUser(user);
				ulv.setLink(link);
				ulv.setVoteType(1);
				em.getTransaction().begin();
				em.persist(ulv);
				Link ln = em.find(Link.class, link.getId());
				int incr = ln.getVote();
				incr++;
				ln.setVote(incr);
				em.getTransaction().commit();
				msg = "You have up voted for Article_Id = "+link.getId()+" and Article Description = "+link.getLinkDescription()+"  by User = "+user.getUserName();
				}catch(Exception e)
					{
						if(em.getTransaction().isActive())
						{
							em.getTransaction().rollback();
						}
							msg = "Something gone wrong";
					}
				finally{
					if(em.getTransaction().isActive())
					{
						em.close();
					}
				}
			//
		}	
		else
		{
			int type = l.get(0).getVoteType();
			if(type == 1)
			{	
				msg = "You have already up voted for Article_Id = "+link.getId()+" and Article Description = "+link.getLinkDescription()+"  by User = "+user.getUserName();
			}
			else
			{
				//
				try{
					em.getTransaction().begin();
					Link ln = em.find(Link.class, link.getId());
					int v = ln.getVote();
					v++;
					v++;
					ln.setVote(v);
					UserLinkVote ulv = em.find(UserLinkVote.class, l.get(0).getId());
					ulv.setVoteType(1);
					em.getTransaction().commit();
					msg = "You have up voted for Article_Id = "+link.getId()+" and Article Description = "+link.getLinkDescription()+" by User = "+user.getUserName();
					}catch(Exception e)
						{
							if(em.getTransaction().isActive())
							{
								em.getTransaction().rollback();
							}
								msg = "Something gone wrong";
						}
					finally{
						if(em.getTransaction().isActive())
						{
							em.close();
						}
					}
				//
			}	
		}	
		return msg;
	}

	@Override
	public String voteLinkDown(Link link, User user) 
	{
		// TODO Auto-generated method stub
		String msg = "";
		Query query = em.createQuery("SELECT ulv FROM UserLinkVote as ulv where ulv.user= :userName and ulv.link= :article_Id");
		query.setParameter("userName", user);
		query.setParameter("article_Id", link);
		
		List<UserLinkVote> l = (List) query.getResultList();
		if(l.isEmpty())
		{
			//
			try{
				UserLinkVote ulv = new UserLinkVote();
				ulv.setUser(user);
				ulv.setLink(link);
				ulv.setVoteType(0);
				em.getTransaction().begin();
				em.persist(ulv);
				Link ln = em.find(Link.class, link.getId());
				int incr = ln.getVote();
				if(incr!=0)
				{
					incr--;
				}	
				ln.setVote(incr);
				em.getTransaction().commit();
				msg = "You have down voted for Article_Id = "+link.getId()+" and Article Description = "+link.getLinkDescription()+"  by User = "+user.getUserName();
				}catch(Exception e)
					{
						if(em.getTransaction().isActive())
						{
							em.getTransaction().rollback();
						}
							msg = "Something gone wrong";
					}
				finally{
					if(em.getTransaction().isActive())
					{
						em.close();
					}
				}
			//
		}	
		else
		{
			int type = l.get(0).getVoteType();
			if(type == 0)
			{	
				msg = "You have already down voted for Article_Id = "+link.getId()+" and Article Description = "+link.getLinkDescription()+"  by User = "+user.getUserName();
			}
			else
			{
				//
				try{
					em.getTransaction().begin();
					Link ln = em.find(Link.class, link.getId());
					int v = ln.getVote();
					if(v!=0)
					{
						v--;
					}	
					if(v!=0)
					{
						v--;
					}
					ln.setVote(v);
					UserLinkVote ulv = em.find(UserLinkVote.class, l.get(0).getId());
					ulv.setVoteType(0);
					em.getTransaction().commit();
					msg = "You have down voted for Article_Id = "+link.getId()+" and Article Description = "+link.getLinkDescription()+" by User = "+user.getUserName();
					}catch(Exception e)
						{
							if(em.getTransaction().isActive())
							{
								em.getTransaction().rollback();
							}
								msg = "Something gone wrong";
						}
					finally{
						if(em.getTransaction().isActive())
						{
							em.close();
						}
					}
				//
			}	
		}	
		return msg;
	}

	@Override
	public List<Link> listAllLinks() 
	{
		List<Link> allLinks = em.createQuery("SELECT l  FROM Link as l").getResultList();
		return allLinks;
	}

	@Override
	public List<Link> listTop20LinksByVote() 
	{
		List<Link> listTop20Links = em.createQuery("SELECT l  FROM Link as l order by vote DESC").setMaxResults(20).getResultList();
		return listTop20Links;
	}

}
