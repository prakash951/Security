package com.pwc.secimpl;

import com.pwc.SecOperator;

public class IntOperator implements SecOperator {

	private char operator;

	public IntOperator(char operator) {
		this.operator = operator;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

}
