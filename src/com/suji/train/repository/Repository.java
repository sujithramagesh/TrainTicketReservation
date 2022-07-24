package com.suji.train.repository;

public interface Repository<T> {
	public void add(T t);
	public T get(String Name);
	public void update(String Name,T t);
	public void delete(String Name);

	
}
