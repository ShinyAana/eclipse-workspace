package com.priya.train.authenticator;
public class UserAuthenticator implements Authenticator {
	UserRepository uRepo=UserRepository.getInstance();

	public boolean authenticate(String uName) {
		boolean isUNamePresent;
		isUNamePresent=uRepo.isUserNamePresent(uName);
		return isUNamePresent;

	}
	public boolean authenticate(String uName,String Password)
	{
		boolean isPasswordValid;
		isPasswordValid=uRepo.isPasswordValid(uName, Password);
		return isPasswordValid;
	}
}
