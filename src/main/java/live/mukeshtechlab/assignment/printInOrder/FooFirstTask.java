package live.mukeshtechlab.assignment.printInOrder;

public class FooFirstTask implements Runnable {
    private Foo foo;

    public FooFirstTask(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        foo.first();
    }
}
