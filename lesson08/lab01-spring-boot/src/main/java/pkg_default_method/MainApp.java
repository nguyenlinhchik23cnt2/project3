package pkg_default_method;

public class MainApp {
    public static void main(String[] args) {
        MultiInheritance obj = new MultiInheritance();

        obj.method1();  // sẽ in ra từ class MultiInheritance
        obj.method2();  // gọi từ Interface1
        obj.method3();  // gọi từ Interface2
    }
}
