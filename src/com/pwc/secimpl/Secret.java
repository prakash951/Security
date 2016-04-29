package com.pwc.secimpl;

import com.pwc.SecLevel;

public class Secret implements SecLevel {
	private final int level;

	public Secret() {
		this.level = 3;
	}

	public int getLevel() {
		return level;
	}

	public String toString() {
		return "Secret";
	}
}
