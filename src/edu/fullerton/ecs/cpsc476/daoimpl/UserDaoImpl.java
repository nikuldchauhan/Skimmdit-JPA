package edu.fullerton.ecs.cpsc476.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.fullerton.ecs.cpsc476.dao.UserDao;
import edu.fullerton.ecs.cpsc476.entity.User;

public class UserDaoImpl implements UserDao
{
	
	private EntityManager em;
	
	public UserDaoImpl(EntityManager em)
	{
		this.em = em;
	}

	@Override
	public String createUser(User user) 
	{
		
		// TODO Auto-generated method stub
		boolean b = isExistUser(user);
		if(b)
		{
			return "userName is already existed";
		}	
		String msg = "";
		try{
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			msg = "New user created";
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
		return msg;
	}
	
	@Override
	public boolean isExistUser(User user) 
	{
		Query query = em.createQuery("SELECT count(*) FROM User u where u.userName= :userName and u.passWord= :passWord");
		query.setParameter("userName", user.getUserName());
		query.setParameter("passWord", user.getPassWord());
		Long count = (Long) query.getSingleResult();
		if(count == 1)
		{
			return true;
		}	
        return false;
	}
	
	@Override
	public String isAuthenticate(User user)
	{
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT count(*) FROM User u where u.userName= :userName and u.passWord= :passWord");
		query.setParameter("userName", user.getUserName());
		query.setParameter("passWord", user.getPassWord());
		Long count = (Long) query.getSingleResult();
		if(count == 1)
		{
			return "User is Authorised";
		}	
        return "User is not Authorised";
	}

	@Override
	public List<String> getListUsers() 
	{
		// TODO Auto-generated method stub
		List<String> userList = em.createQuery("SELECT userName FROM User").getResultList();
		return userList;
	}

}
