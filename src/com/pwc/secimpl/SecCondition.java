package com.pwc.secimpl;

import com.pwc.SecOperand;
import com.pwc.SecRelationOperator;

public class SecCondition {
	public SecCondition() {
	}

	public static boolean check(SecOperand opr1, SecOperand opr2, SecRelationOperator op) {
		SecBoolean bool = (SecBoolean) new Evaluator().evaluate(opr1, opr2, op);
		System.out.println(bool);
		return bool.isVal();
	}

	public static boolean check(SecOperand opr1, int x, SecRelationOperator op) {
		if (opr1.getType() != 1)
			throw new RuntimeException("Invalid Operands");
		else {
			return check(opr1, new SecInt(x), op);
		}
	}

	public static boolean check(SecOperand opr1, float x, SecRelationOperator op) {
		if (opr1.getType() != 2)
			throw new RuntimeException("Invalid Operands");
		else {
			return check(opr1, new SecFloat(x), op);
		}
	}
}
