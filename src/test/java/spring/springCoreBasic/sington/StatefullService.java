package spring.springCoreBasic.sington;

public class StatefullService {
    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name " + name + "Price " + price);
        //this.price = price; //여기가 문제!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
