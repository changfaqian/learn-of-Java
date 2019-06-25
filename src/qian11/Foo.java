package qian11;

public class Foo {
	int x=12;
	public static void go(final int x) {
		System.out.println(x);
	}
	public static void main(String[] args) {
		Foo a=new Foo();
		Foo.go(13);
	}
}
