package case_study.storeage;


public class SneakerTest {
    public static void main(String[] args) {
        SneakerManager sneakerManager = new SneakerManager();
//        sneakerManager.startMenu();
     //   sneakerManager.writeObject();
        sneakerManager.readObject();
        System.out.println(sneakerManager.list);

    }
}
