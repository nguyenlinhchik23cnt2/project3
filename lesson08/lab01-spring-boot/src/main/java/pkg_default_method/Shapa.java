package pkg_default_method;

public interface Shapa {
            void draw();
            default  void setColor (String color){

                    System.out.println("Ve hinh voi mau"+color);
            }
}
