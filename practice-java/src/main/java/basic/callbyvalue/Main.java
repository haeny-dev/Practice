package basic.callbyvalue;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");

        System.out.println("Before Login Method: item1.name = " + item1.name + ", item2.name = " + item2.name);
        logic(item1, item2);
        System.out.println("After Login Method: item1.name = " + item1.name + ", item2.name = " + item2.name);
    }

    static void logic(Item arg1, Item arg2) {
        arg1.name = "(None)";
        arg2 = arg1;

        System.out.println("Inside Logic Method: arg1.name = " + arg1.name + ", arg2.name = " + arg2.name);
    }

    static class Item {
        String name;

        public Item(String name) {
            this.name = name;
        }
    }

}
