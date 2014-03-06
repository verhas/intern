package com.javax0.intern;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class InternPoolTest {
	private static class TestObject {
		final int a, b;

		private TestObject(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			return result;
		}

		@Override
		public boolean equals(java.lang.Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TestObject other = (TestObject) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			return true;
		}

	}

	@Test
	public void givesTheSameObjectForEqualObjects() {
		final InternPool<TestObject> pool = new InternPool<>();
		final TestObject to1 = new TestObject(1, 2);
		final TestObject to2 = new TestObject(1, 2);
		final TestObject ito1 = pool.intern(to1);
		final TestObject ito2 = pool.intern(to2);
		assertThat(ito1 == ito2, is(true));
	}
	
	@Test
	public void givesDifferentObjectForNonEqualObjects() {
		final InternPool<TestObject> pool = new InternPool<>();
		final TestObject to1 = new TestObject(1, 2);
		final TestObject to2 = new TestObject(3, 4);
		final TestObject ito1 = pool.intern(to1);
		final TestObject ito2 = pool.intern(to2);
		assertThat(ito1 == ito2, is(false));
	}
	
}
