package live.mukeshtechlab.assignment.printInOrder;

public class FooThirdTask implements Runnable {
    private Foo foo;

    public FooThirdTask(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        foo.third();
    }
}
