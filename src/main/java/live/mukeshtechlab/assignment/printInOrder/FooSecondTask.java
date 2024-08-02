package live.mukeshtechlab.assignment.printInOrder;

public class FooSecondTask implements Runnable {
    private Foo foo;

    public FooSecondTask(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        foo.second();
    }
}
