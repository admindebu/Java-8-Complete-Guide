package com.learner.workshop.examples.session2.stream;

/*
 * @Author Debu Paul
 */

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Examples on how to use Optional to avoid null checks and workarounds
 *
 */
public class OptionalExamples {

	static class Outer {
		Nested nested = new Nested();

		public Nested getNested() {
			return nested;
		}
	}

	static class Nested {
		Inner inner = new Inner();

		public Inner getInner() {
			return inner;
		}
	}

	static class Inner {
		String foo = "boo";

		public String getFoo() {
			return foo;
		}
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
	}

	public static <T> Optional<T> resolve(Supplier<T> resolver) {
		try {
			T result = resolver.get();
			return Optional.ofNullable(result);
		} catch (NullPointerException e) {
			return Optional.empty();
		}
	}

	private static void test1() {
		Optional<String> optional = Optional.of("bam");

		optional.isPresent(); // true
		optional.get(); // "bam"
		optional.orElse("fallback"); // "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"
	}

	private static void test2() {
		Optional.of(new Outer()).flatMap(o -> Optional.ofNullable(o.nested)).flatMap(n -> Optional.ofNullable(n.inner))
				.flatMap(i -> Optional.ofNullable(i.foo)).ifPresent(System.out::println);
	}

	private static void test3() {
		Optional.of(new Outer()).map(Outer::getNested).map(Nested::getInner).map(Inner::getFoo)
				.ifPresent(System.out::println);
	}

	private static void test4() {
		Outer outer = new Outer();
		resolve(() -> outer.getNested().getInner().getFoo()).ifPresent(System.out::println);
	}

	private static void test5() {
		String s = "Imaginea";
		String s1 = null;

		Optional<String> opt = Optional.ofNullable(s);
		opt.ifPresent(n -> System.out.println(n));

		// Not Get any Exception
		Optional<String> opt1 = Optional.ofNullable(s1);
		opt1.ifPresent(n -> System.out.println(n));

		// Exception
		try {
			Optional<String> opt2 = Optional.of(s1);
			opt2.ifPresent(n -> System.out.println(n));
		} catch (NullPointerException npe) {
			System.out.println("Null pointer exception ::: " + npe);
		}
	}

	private static void test6() {
		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();

		if (gender.isPresent()) {
			System.out.println("Value available.");
		} else {
			System.out.println("Value not available.");
		}

		gender.ifPresent(g -> System.out.println("In gender Option, value available."));

		// condition failed, no output print
		emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));
	}

	private static void test7() {

		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();

		System.out.println(gender.orElse("<N/A>")); // MALE
		System.out.println(emptyGender.orElse("<N/A>")); // <N/A>

		System.out.println(gender.orElseGet(() -> "<N/A>")); // MALE
		System.out.println(emptyGender.orElseGet(() -> "<N/A>")); // <N/A>
	}

	private static void test8() {
		String nullName = null;
		String name;
		try {
			name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);

			System.out.println(name);
		} catch (IllegalArgumentException iae) {
			System.out.println("Illegal argument exception ::: " + iae);
		}

		name = Optional.ofNullable(nullName).orElseGet(() -> "john");
		System.out.println(name);
	}

}
