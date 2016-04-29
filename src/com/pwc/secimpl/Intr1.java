package com.pwc.secimpl;

import com.pwc.SecLevel;
import com.pwc.SecOperand;
import com.pwc.SecOperator;

public class Intr1 implements SecOperand {
	private final SecLevel secLevel;

	public Intr1() {
		this.secLevel = new L();
	}

	public Intr1(SecLevel level) {
		this.secLevel = level;
	}

	public SecOperand operate(SecOperand o1, SecOperand o2, SecOperand o3, SecOperator oper1, SecLevel lev) {
		Evaluator ev = new Evaluator();
		o3 = ev.evaluate(o1, o2, oper1);
		int lev1 = Math.max(o1.getSecLevel().getLevel(), o2.getSecLevel().getLevel());
		if (lev1 > lev.getLevel()) {
			throw new RuntimeException("Invalid return label");
		}
		if (TypeSystem.getType(o3).equalsIgnoreCase("SecInt")) {
			((SecInt) o3).setSecLevel(lev);
		}
		if (TypeSystem.getType(o3).equalsIgnoreCase("SecFloat")) {
			((SecFloat) o3).setSecLevel(lev);
		}
		return o3;
	}

	public SecOperand operate1(SecOperand o1, SecOperand o2, SecOperator oper1) {
		if (o1.getSecLevel().getLevel() == o2.getSecLevel().getLevel())
			throw new RuntimeException("No Interference is allowed");
		Evaluator ev = new Evaluator();
		SecOperand o3 = ev.evaluate(o1, o2, oper1);
		return o3;
	}

	@Override
	public SecLevel getSecLevel() {
		return secLevel;
	}

	@Override
	public int getType() {
		return 4;
	}

}
