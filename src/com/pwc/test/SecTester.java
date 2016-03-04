package com.pwc.test;

import com.pwc.SecRelationOperator;
import com.pwc.secimpl.Evaluator;
import com.pwc.secimpl.H;
import com.pwc.secimpl.IntOperator;
import com.pwc.secimpl.RelationOperator;
import com.pwc.secimpl.SecAssign;
import com.pwc.secimpl.SecCondition;
import com.pwc.secimpl.SecFloat;
import com.pwc.secimpl.SecInt;
import com.pwc.secimpl.TopSecret;

/**
 * @author prakash
 *  Examples of typed programs are [low] 
 	h := l+4; l := l−5
	and [high] 
 	if h = 1 then h := h + 4 else skip. As expected,
	the example programs with explicit and implicit insecure flows
	l := h and if h = 1 then l := 1 else skip are not typed.
 */

public class SecTester {

	public static void main(String[] args) {
		SecInt s1 = new SecInt(10, new H());
		SecInt s2 = new SecInt(20, new H());
		SecAssign sc = new SecAssign();
		sc.secAssign(s1, 30);
		IntOperator op = new IntOperator('*');
		Evaluator ev = new Evaluator();
		System.out.println(ev.evaluate(s1, ev.evaluate(s1, s2, op), op));
		SecFloat f1 = new SecFloat(10.0f, new H());
		SecFloat f2 = new SecFloat(20.000056f, new H());
		SecFloat f3 = new SecFloat(10.1f, new H());
		IntOperator op1 = new IntOperator('*');
		System.out.println(ev.evaluate(f1, ev.evaluate(f1, f2, op1), op1));
		SecRelationOperator rel = new RelationOperator("<=");
		System.out.println(ev.evaluate(f1, f3, rel));
		int level = -1;
		SecInt s3 = new SecInt(30);
		SecInt s4 = new SecInt(40, new TopSecret());
		level = Math.max(s1.getSecLevel().getLevel(), s2.getSecLevel().getLevel());
		if (SecCondition.check(s1, s2, rel)) {
			sc.secAssign(s3, 50, level);
		} else {
			sc.secAssign(s4, 70, level);
		}
	}

	public static void x(long... l) {

	}

}
