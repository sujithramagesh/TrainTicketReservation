package com.suji.train.authenticator;

public interface Authenticator {
	public boolean authenticate(String name);
public boolean authenticate(String name,String password);
}
