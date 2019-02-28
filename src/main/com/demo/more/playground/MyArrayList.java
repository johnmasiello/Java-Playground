package com.demo.more.playground;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList<T> extends ArrayList<T> {
	private static final long serialVersionUID = 1L;

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {

			int index = 0;
			final int size = size();
			@Override
			public boolean hasNext() {
				if (size != size())
					throw new IllegalStateException(
							"Iterator failed: The list does not have the same number of elements");
				return index < size;
			}

			@Override
			public T next() {
				if (size != size())
					throw new IllegalStateException(
							"Iterator failed: The list does not have the same number of elements");
				return index < size ? get(index++) : null;
			}
			
		};
	}

	
}
