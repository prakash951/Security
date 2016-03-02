package com.pwc.test;

import com.pwc.SecRelationOperator;
import com.pwc.secimpl.Evaluator;
import com.pwc.secimpl.H;
import com.pwc.secimpl.IntOperator;
import com.pwc.secimpl.RelationOperator;
import com.pwc.secimpl.SecFloat;
import com.pwc.secimpl.SecInt;

public class SecTester {

	public static void main(String[] args) {
		SecInt s1 = new SecInt(10, new H());
		SecInt s2 = new SecInt(20, new H());
		IntOperator op = new IntOperator('*');
		Evaluator ev = new Evaluator();
		System.out.println(ev.evaluate(s1, ev.evaluate(s1, s2, op), op));
		SecFloat f1 = new SecFloat(10.0f, new H());
		SecFloat f2 = new SecFloat(20.000056f, new H());
		SecFloat f3 = new SecFloat(10.1f, new H());
		IntOperator op1 = new IntOperator('*');
		System.out.println(ev.evaluate(f1, ev.evaluate(f1, f2, op1), op1));
		SecRelationOperator rel = new RelationOperator(">=");
		System.out.println(ev.evaluate(f1, f3, rel));
	}

	public static void x(long... l) {

	}

}
