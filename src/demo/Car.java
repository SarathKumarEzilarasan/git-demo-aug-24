package demo;

public interface Car {
    void tyres();

    void breaks();

    default void add() {
        System.out.println("hello");
    }


}
