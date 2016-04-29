package com.pwc.secimpl;

import com.pwc.SecLevel;
import com.pwc.SecOperand;

public class SecBoolean implements SecOperand {
	private static final int type = 3;
	private boolean val;
	private SecLevel secLevel;

	public SecBoolean(boolean val) {
		this.val = val;
		this.secLevel = new L();
	}

	public SecBoolean(boolean val, SecLevel secLevel) {
		this.val = val;
		this.secLevel = secLevel;
	}

	@Override
	public SecLevel getSecLevel() {
		return secLevel;
	}

	@Override
	public int getType() {
		return type;
	}

	public void setSecLevel(SecLevel secLevel) {
		this.secLevel = secLevel;
	}

	public boolean isVal() {
		return val;
	}

	public void setVal(boolean val) {
		this.val = val;
	}

	public String toString() {
		return "[ " + this.val + "\t,\t" + this.getSecLevel() + " ]";
	}
}
