package com.javax0.intern;

public class InternPool<T> {
	private final WeakPool<T> pool = new WeakPool<T>();

	public synchronized T intern(T object) {
		T res = pool.get(object);
		if (res == null) {
			pool.put(object);
			res = object;
		}
		return res;
	}
}
