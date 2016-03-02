package com.pwc.secimpl;

import com.pwc.SecLevel;

public class L implements SecLevel {
	private final int level;

	public L() {
		this.level = 0;
	}

	public int getLevel() {
		return level;
	}
}
