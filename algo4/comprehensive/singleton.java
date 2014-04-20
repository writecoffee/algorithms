public class singleton {
    /**
     * The real problem is that Thread A may assign a memory space for instance before it is
     * finished constructing instance. Thread B will see that assignment and try to use it. This
     * results in Thread B failing because it is using a partially constructed version of instance.
     */
    private static volatile singleton _instance;

    public static singleton getInstance() {
        if (_instance == null) {
            synchronized (singleton.class) {
                if (_instance == null) {
                    _instance = new singleton();
                }
            }
        }

        return _instance;
    }

    public static abstract class A {
        A go() {
            System.out.println("A go");
            return this;
        }
    }

    public static class B extends A {
        @Override
        B go() {
            System.out.println("B go");
            return this;
        }
    }

    public static void main(String[] args) {
        B b = new B();
        b.go();
    }

}