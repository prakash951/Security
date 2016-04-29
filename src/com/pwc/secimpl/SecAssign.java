package com.pwc.secimpl;

import com.pwc.SecOperand;

public class SecAssign {

	public void secAssign(SecOperand op1, SecOperand op2) {
		if (op1.getSecLevel().getLevel() < op2.getSecLevel().getLevel()) {
			throw new RuntimeException("Operation not allowed");
		} else {
			if (op1.getType() != op2.getType()) {
				throw new RuntimeException("Invalid Types");
			} else {
				if (op1.getType() == 1) {
					((SecInt) op1).setVal(((SecInt) op2).getVal());
				} else if (op1.getType() == 2) {
					((SecFloat) op1).setVal(((SecFloat) op2).getVal());
				} else if (op1.getType() == 3) {
					((SecBoolean) op1).setVal(((SecBoolean) op2).isVal());
				}
			}
		}
	}

	public void secAssign(SecOperand op1, boolean b) {

		if (op1.getType() != 3) {
			throw new RuntimeException("Invalid Types");
		} else {
			((SecBoolean) op1).setVal(b);
		}
	}

	public void secAssign(SecOperand op1, int b) {

		if (op1.getType() != 1) {
			throw new RuntimeException("Invalid Types");
		} else {
			((SecInt) op1).setVal(b);
		}
	}

	public void secAssign(SecOperand op1, float b) {

		if (op1.getType() != 2) {
			throw new RuntimeException("Invalid Types");
		} else {
			((SecFloat) op1).setVal(b);
		}
	}

	public void secAssign(SecOperand op1, SecOperand op2, int level) {
		if (op1.getSecLevel().getLevel() < op2.getSecLevel().getLevel()) {
			throw new RuntimeException("Operation not allowed");
		} else if (op1.getSecLevel().getLevel() < level) {
			throw new RuntimeException("Operation not allowed");
		} else {
			if (op1.getType() != op2.getType()) {
				throw new RuntimeException("Invalid Types");
			} else {
				if (op1.getType() == 1) {
					((SecInt) op1).setVal(((SecInt) op2).getVal());
				} else if (op1.getType() == 2) {
					((SecFloat) op1).setVal(((SecFloat) op2).getVal());
				} else if (op1.getType() == 3) {
					((SecBoolean) op1).setVal(((SecBoolean) op2).isVal());
				}
			}
		}
	}

	public void secAssign(SecOperand op1, boolean b, int level) {
		if (op1.getSecLevel().getLevel() < level) {
			throw new RuntimeException("Operation not allowed");
		}
		if (op1.getType() != 3) {
			throw new RuntimeException("Invalid Types");
		} else {
			((SecBoolean) op1).setVal(b);
		}
	}

	public void secAssign(SecOperand op1, int b, int level) {
		if (op1.getSecLevel().getLevel() < level) {
			throw new RuntimeException("Operation not allowed");
		}
		System.out.println(op1.getSecLevel().getLevel());
		System.out.println(level);
		if (op1.getType() != 1) {
			throw new RuntimeException("Invalid Types");
		} else {
			((SecInt) op1).setVal(b);
		}
	}

	public void secAssign(SecOperand op1, float b, int level) {
		if (op1.getSecLevel().getLevel() < level) {
			throw new RuntimeException("Operation not allowed");
		}
		if (op1.getType() != 2) {
			throw new RuntimeException("Invalid Types");
		} else {
			((SecFloat) op1).setVal(b);
		}
	}

}
