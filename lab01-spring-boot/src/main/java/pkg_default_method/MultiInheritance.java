package pkg_default_method;

public class MultiInheritance implements interface1, Interface2 {

    // Bắt buộc override method1 vì cả hai interface đều có method1
    @Override
    public void method1() {
        System.out.println("MultiInheritance.method1 (ghi đè để giải quyết xung đột)");
    }
}
