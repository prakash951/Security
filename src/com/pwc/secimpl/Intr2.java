package com.pwc.secimpl;

import java.util.Arrays;
import java.util.Comparator;

import com.pwc.SecLevel;
import com.pwc.SecOperand;

public class Intr2 implements SecOperand {
	private final SecLevel secLevel;

	public Intr2() {
		secLevel = new L();
	}

	public Intr2(SecLevel secLevel) {
		this.secLevel = secLevel;
	}

	public SecOperand[] sortByValue(SecOperand... opers) {
		TypeSystem.typeCheck(opers);
		Arrays.sort(opers);
		toString(opers);
		return opers;
	}

	public SecOperand[] sortBySecurityLevel(SecOperand... opers) {
		TypeSystem.typeCheck(opers);
		Arrays.sort(opers, new Comparator<SecOperand>() {
			public int compare(SecOperand op1, SecOperand op2) {
				return op1.getSecLevel().getLevel() - op2.getSecLevel().getLevel();
			}
		});
		toString(opers);
		return opers;
	}

	@Override
	public SecLevel getSecLevel() {
		return secLevel;
	}

	@Override
	public int getType() {
		return 5;
	}

	public void toString(Object... obj) {
		System.out.println(Arrays.deepToString(obj));
	}
}
