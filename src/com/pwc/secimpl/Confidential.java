package com.pwc.secimpl;

import com.pwc.SecLevel;

public class Confidential implements SecLevel {
	private final int level;

	public Confidential() {
		this.level = 2;
	}

	public int getLevel() {
		return level;
	}
}
