package com.pwc.secimpl;

import com.pwc.SecOperand;
import com.pwc.SecOperator;
import com.pwc.SecRelationOperator;

public class Evaluator {

	public Evaluator() {

	}

	public SecOperand evaluate(SecOperand opr1, SecOperand opr2, SecOperator op) throws RuntimeException {
		SecOperand s = null;
		if (!TypeSystem.typeCheck(opr1, opr2))
			throw new RuntimeException("Incompatable Types");
		/**
		 * if (opr1.getSecLevel().getLevel() < opr2.getSecLevel().getLevel() ||
		 * opr1.getSecLevel().getLevel() > opr2.getSecLevel().getLevel()) throw
		 * new UnsupportedOperationException("Operation Not Allowed"); else {
		 */
		if (TypeSystem.getType(opr1).equalsIgnoreCase("SecInt")) {
			s = new SecInt(0);
			((SecInt) s).setSecLevel(opr1.getSecLevel().getLevel() > opr2.getSecLevel().getLevel() ? opr1.getSecLevel()
					: opr2.getSecLevel());
			((SecInt) s).setVal(evalOp(((SecInt) opr1).getVal(), ((SecInt) opr2).getVal(), (char) op.getOperator()));
		}
		if (TypeSystem.getType(opr1).equalsIgnoreCase("SecFloat")) {
			s = new SecFloat(0);
			((SecFloat) s).setSecLevel(opr1.getSecLevel().getLevel() > opr2.getSecLevel().getLevel()
					? opr1.getSecLevel() : opr2.getSecLevel());
			((SecFloat) s)
					.setVal(evalOp(((SecFloat) opr1).getVal(), ((SecFloat) opr2).getVal(), (char) op.getOperator()));
		}
		// }
		return s;
	}

	public SecOperand evaluate(SecOperand opr1, SecOperand opr2, SecRelationOperator op) throws RuntimeException {
		SecOperand s = null;
		if (!TypeSystem.typeCheck(opr1, opr2))
			throw new RuntimeException("Incompatable Types");
		/**
		 * if (opr1.getSecLevel().getLevel() < opr2.getSecLevel().getLevel() ||
		 * opr1.getSecLevel().getLevel() > opr2.getSecLevel().getLevel()) throw
		 * new UnsupportedOperationException("Operation Not Allowed"); else {
		 */
		if (TypeSystem.getType(opr1).equalsIgnoreCase("SecInt")) {
			s = new SecBoolean(true);
			((SecBoolean) s).setSecLevel(opr1.getSecLevel().getLevel() > opr2.getSecLevel().getLevel()
					? opr1.getSecLevel() : opr2.getSecLevel());
			((SecBoolean) s).setVal(evalRelOp(((SecInt) opr1).getVal(), ((SecInt) opr2).getVal(), op.getOperator()));
		}
		if (TypeSystem.getType(opr1).equalsIgnoreCase("SecFloat")) {
			s = new SecBoolean(true);
			((SecBoolean) s).setSecLevel(opr1.getSecLevel().getLevel() > opr2.getSecLevel().getLevel()
					? opr1.getSecLevel() : opr2.getSecLevel());
			((SecBoolean) s)
					.setVal(evalRelOp(((SecFloat) opr1).getVal(), ((SecFloat) opr2).getVal(), op.getOperator()));
		}
		// }
		return s;
	}

	public int evalOp(int t1, int t2, char ch) {
		switch (ch) {
		case '+':
			return t1 + t2;
		case '-':
			return t1 - t2;
		case '*':
			return t1 * t2;
		case '/':
			return t1 / t2;
		case '%':
			return t1 % t2;
		}
		throw new UnsupportedOperationException("Invalid Operand");
	}

	public float evalOp(float t1, float t2, char ch) {
		switch (ch) {
		case '+':
			return t1 + t2;
		case '-':
			return t1 - t2;
		case '*':
			return t1 * t2;
		case '/':
			return t1 / t2;
		case '%':
			return t1 % t2;
		}
		throw new UnsupportedOperationException("Invalid Operand");
	}

	public boolean evalRelOp(int t1, int t2, String ch) {
		if ("==".equals(ch)) {
			return t1 == t2;
		} else if (">=".equals(ch)) {
			return t1 >= t2;
		} else if ("<=".equals(ch)) {
			return t1 <= t2;
		} else if ("!=".equals(ch)) {
			return t1 != t2;
		} else if (">".equals(ch)) {
			return t1 > t2;
		} else if ("<".equals(ch)) {
			return t1 < t2;
		}
		throw new UnsupportedOperationException("Invalid Operand");
	}

	public boolean evalRelOp(float t1, float t2, String ch) {
		if ("==".equals(ch)) {
			return t1 == t2;
		} else if (">=".equals(ch)) {
			return t1 >= t2;
		} else if ("<=".equals(ch)) {
			return t1 <= t2;
		} else if ("!=".equals(ch)) {
			return t1 != t2;
		} else if (">".equals(ch)) {
			return t1 > t2;
		} else if ("<".equals(ch)) {
			return t1 < t2;
		}
		throw new UnsupportedOperationException("Invalid Operator");
	}

}
