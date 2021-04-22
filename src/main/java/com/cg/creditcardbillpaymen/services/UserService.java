package com.cg.creditcardbillpaymen.services;

import com.cg.creditcardbillpaymen.entities.User;

public interface UserService {
	public User signIn(User user);

	public User signOut(User user);

	public User changePassword(long id, User user);
}
