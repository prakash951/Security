package com.pwc.test;

import java.util.Scanner;

import com.pwc.SecOperand;
import com.pwc.SecRelationOperator;
import com.pwc.secimpl.Evaluator;
import com.pwc.secimpl.H;
import com.pwc.secimpl.IntOperator;
import com.pwc.secimpl.Intr2;
import com.pwc.secimpl.L;
import com.pwc.secimpl.RelationOperator;
import com.pwc.secimpl.SecAssign;
import com.pwc.secimpl.SecCondition;
import com.pwc.secimpl.SecFloat;
import com.pwc.secimpl.SecInt;
import com.pwc.secimpl.TopSecret;

/**
 * @author prakash Examples of typed programs are [low] h := l+4; l := l−5 and
 *         [high] if h = 1 then h := h + 4 else skip. As expected, the example
 *         programs with explicit and implicit insecure flows l := h and if h =
 *         1 then l := 1 else skip are not typed.
 */

public class SecTester {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		// test31();
		// test4();
		test5();
	}

	public static void test1() {
		SecInt s1 = new SecInt(40, new L());
		SecInt s2 = new SecInt(20, new H());
		SecAssign sc = new SecAssign();
		sc.secAssign(s1, 30);
		IntOperator op = new IntOperator('*');
		Evaluator ev = new Evaluator();
		System.out.println(ev.evaluate(s1, ev.evaluate(s1, s2, op), op));
	}

	public static void test2() {
		SecFloat f1 = new SecFloat(10.0f, new H());
		SecFloat f2 = new SecFloat(20.000056f, new H());
		SecFloat f3 = new SecFloat(10.1f, new H());
		IntOperator op1 = new IntOperator('*');
		Evaluator ev = new Evaluator();
		System.out.println(ev.evaluate(f1, ev.evaluate(f1, f2, op1), op1));
		SecRelationOperator rel = new RelationOperator("<=");
		System.out.println(ev.evaluate(f1, f3, rel));
	}

	public static void test3() {
		SecInt s1 = new SecInt(40, new L());
		SecInt s2 = new SecInt(20, new H());
		int level = -1;
		SecInt s3 = new SecInt(30);
		SecInt s4 = new SecInt(40, new TopSecret());
		SecAssign sc = new SecAssign();
		SecRelationOperator rel = new RelationOperator("<=");
		level = Math.max(s1.getSecLevel().getLevel(), s2.getSecLevel().getLevel());
		if (SecCondition.check(s1, s2, rel, level)) {
			sc.secAssign(s3, 50, level);
		} else {
			sc.secAssign(s4, 70, level);
		}
	}

	public static void test31() {
		SecInt s1 = new SecInt(10, new L());
		SecInt s2 = new SecInt(20, new H());
		int level = -1;
		SecInt s3 = new SecInt(30);
		SecInt s4 = new SecInt(40, new L());
		SecAssign sc = new SecAssign();
		SecRelationOperator rel = new RelationOperator("<=");
		level = Math.max(s1.getSecLevel().getLevel(), s2.getSecLevel().getLevel());
		if (SecCondition.check(s1, s2, rel, level)) {
			if (SecCondition.check(s3, s4, rel, level)) {
				sc.secAssign(s3, 50, level);
			}
		} else {
			sc.secAssign(s4, 70, level);
		}
	}

	public static void test4() {
		Scanner sc = new Scanner(System.in);
		SecInt[] ints = new SecInt[10];
		boolean b = true;
		for (int i = 0; i < 10; i++) {
			if (b == true) {
				ints[i] = new SecInt(sc.nextInt(), new L());
				b = false;
			} else {
				ints[i] = new SecInt(sc.nextInt(), new H());
				b = true;
			}
		}
		Intr2 in = new Intr2();
		in.sortByValue(ints);
		in.sortBySecurityLevel(ints);
		sc.close();
	}

	public static void test5() {
		Scanner sc = new Scanner(System.in);
		sc.next();
		SecOperand[] ints = new SecOperand[10];
		System.out.println();
		boolean b = true;
		for (int i = 0; i < 10; i++) {
			if (b == true) {
				ints[i] = new SecInt(sc.nextInt(), new L());
				b = false;
			} else {
				ints[i] = new SecFloat(sc.nextFloat(), new H());
				b = true;
			}
		}
		Intr2 in = new Intr2();
		in.sortByValue(ints);
		in.sortBySecurityLevel(ints);
		sc.close();
	}

}
