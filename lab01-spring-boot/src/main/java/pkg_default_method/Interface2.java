package pkg_default_method;

public interface Interface2 {

    default void method1() {
        System.out.println("Interface2.method1");
    }

    default void method3() {
        System.out.println("Interface2.method3");
    }
}
