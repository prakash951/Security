package com.pwc.secimpl;

import com.pwc.SecOperand;

public class TypeSystem {

	public TypeSystem() {

	}

	public static boolean typeCheck(SecOperand opr1, SecOperand opr2) {
		if (opr1.getType() == opr2.getType())
			return true;
		return false;
	}

	public static boolean typeCheck1(SecOperand opr1, SecOperand opr2) {
		if (opr1.getType() >= opr2.getType())
			return true;
		return false;
	}

	public static String getType(SecOperand opr1) {
		String zeta = "";
		if (opr1.getType() == 1)
			zeta = "SecInt";
		else if (opr1.getType() == 2)
			zeta = "SecFloat";
		else if (opr1.getType() == 3)
			zeta = "SecBoolean";
		return zeta;
	}

	public static boolean typeCheck(SecOperand... opers) {
		int type = opers[0].getType();
		for (int i = 1; i < opers.length; i++) {
			if (type != opers[i].getType()) {
				throw new RuntimeException("Invalid types in a collection");
			}
		}
		return true;
	}
}
