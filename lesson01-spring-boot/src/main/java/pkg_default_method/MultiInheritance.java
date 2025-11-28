package pkg_default_method;

public class MultiInheritance implements Interface1, Interface2{
    public void method1(){
        Interface1.super.method1();
    }
    // Trùng với phương thức default trong Interface2
    public void method2(){
        System.out.println("Interface2.method2");
    }
    public static void main(String[] args) {
        MultiInheritance mi= new MultiInheritance() ;
        mi.method1();
        mi.method2();
    }
}
