package com.pwc.secimpl;

import com.pwc.SecLevel;
import com.pwc.SecOperand;

public class SecInt implements SecOperand {
	public static final int type = 1;
	private int val;
	private SecLevel secLevel;

	public SecInt(int val) {
		this.val = val;
		this.setSecLevel(new L());
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		super.clone();
		return new SecInt(this.getVal(), this.getSecLevel());
	}

	public SecInt(int val, SecLevel level) {
		this.setVal(val);
		this.setSecLevel(level);
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public SecLevel getSecLevel() {
		return secLevel;
	}

	public void setSecLevel(SecLevel secLevel) {
		this.secLevel = secLevel;
	}

	public String toString() {
		return "[ " + this.val + " ]";
	}

	@Override
	public int getType() {
		return type;
	}

}
