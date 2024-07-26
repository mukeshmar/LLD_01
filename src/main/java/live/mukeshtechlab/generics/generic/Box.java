package live.mukeshtechlab.generics.generic;

// Generic Class
public class Box<T> {
    private T content;

    public void addContent(T content){
        this.content = content;
    }

    public T getContent(){
        return content;
    }
}


