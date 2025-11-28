package pkg_default_method;

public interface interface1 {

    default void method1() {
        System.out.println("Interface1.method1");
    }

    default void method2() {
        System.out.println("Interface1.method2");
    }
}
