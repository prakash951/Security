package com.pwc.secimpl;

import com.pwc.SecLevel;
import com.pwc.SecOperand;

public class SecFloat implements SecOperand, Comparable<SecFloat> {
	public static final int type = 2;
	private Float val;
	private SecLevel secLevel;

	public SecFloat(float val) {
		this.val = val;
		this.setSecLevel(new L());
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		super.clone();
		return new SecFloat(this.getVal(), this.getSecLevel());
	}

	public SecFloat(float val, SecLevel level) {
		this.setVal(val);
		this.setSecLevel(level);
	}

	public float getVal() {
		return val;
	}

	public void setVal(float val) {
		this.val = val;
	}

	public SecLevel getSecLevel() {
		return secLevel;
	}

	public void setSecLevel(SecLevel secLevel) {
		this.secLevel = secLevel;
	}

	public String toString() {
		return "[ " + this.val + "\t,\t" + this.getSecLevel() + " ]";
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public int compareTo(SecFloat flo) {
		return this.val.compareTo(flo.getVal());
	}
}
