package edu.fullerton.ecs.cpsc476.daoimpl;

import javax.persistence.EntityManager;

import edu.fullerton.ecs.cpsc476.dao.LinkDao;
import edu.fullerton.ecs.cpsc476.entity.Link;

public class LinkDaoImpl implements LinkDao
{
	private EntityManager em;
	
	public LinkDaoImpl(EntityManager em)
	{
		this.em = em;
	}

	@Override
	public String submitLink(Link link) 
	{
		// TODO Auto-generated method stub
		String msg = "";
		try{
			em.getTransaction().begin();
			em.persist(link);
			em.getTransaction().commit();
			msg = "New link submited";
			}catch(Exception e)
			{
				msg = "Something gone wrong";
			}
		finally{
			if(em.getTransaction().isActive())
			{
				em.close();
			}
		}
		return msg;
	}

}
