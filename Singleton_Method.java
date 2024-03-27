class Singleton {
    private static volatile Singleton obj = null;
    private Singleton() {
        System.out.println("Singleton is Instantiated.");
    }

    public static Singleton getInstance()
    {
        if (obj == null) {
            // To make thread safe
            synchronized (Singleton.class)
            {
                // check again as multiple threads
                // can reach above step
                if (obj == null)
                    obj = new Singleton();
            }
        }
        return obj;
    }
    public void doSomething()
    {
        System.out.println("Somethong is Done.");
    }
}

class SingletonMethod {
    public static void main(String[] args)
    {
        Singleton.getInstance().doSomething();
    }
}