package com.pwc.secimpl;

import com.pwc.SecLevel;

public class H1 implements SecLevel {
	private final int level;

	public H1() {
		this.level = 1;
	}

	public int getLevel() {
		return level;
	}

	public String toString() {
		return "High1";
	}
}
