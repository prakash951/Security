package com.pwc.secimpl;

import com.pwc.SecRelationOperator;

public class RelationOperator implements SecRelationOperator {

	private String operator;

	public RelationOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
