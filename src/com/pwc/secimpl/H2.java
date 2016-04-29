package com.pwc.secimpl;

import com.pwc.SecLevel;

public class H2 implements SecLevel {
	private final int level;

	public H2() {
		this.level = 1;
	}

	public int getLevel() {
		return level;
	}

	public String toString() {
		return "High2";
	}
}
