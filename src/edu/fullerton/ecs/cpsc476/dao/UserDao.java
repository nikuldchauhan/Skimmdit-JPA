package edu.fullerton.ecs.cpsc476.dao;

import java.util.List;

import edu.fullerton.ecs.cpsc476.entity.User;

public interface UserDao 
{
	public String createUser(User user);
	public String isAuthenticate(User user);
	public List<String> getListUsers();
	public boolean isExistUser(User user);
}
