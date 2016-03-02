package com.pwc.secimpl;

import com.pwc.SecLevel;

public class H implements SecLevel {
	private final int level;

	public H() {
		this.level = 1;
	}

	public int getLevel() {
		return level;
	}
}
