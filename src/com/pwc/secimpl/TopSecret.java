package com.pwc.secimpl;

import com.pwc.SecLevel;

public class TopSecret implements SecLevel {
	private final int level;

	public TopSecret() {
		this.level = 4;
	}

	public int getLevel() {
		return level;
	}

}
