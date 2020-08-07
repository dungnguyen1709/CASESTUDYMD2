package case_study.storeage;


import case_study.controller.Control;
import case_study.controller.Setting;
import case_study.product.Sneaker;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SneakerManager implements Serializable {
    // tính đa hình, biến c thực tế là 1 đối tượng của Control nhưng có kiểu Setting suy ra biến c sử dụng đc phương thức, thuộc tính của Control
    Setting c = (Setting) new Control();
    Scanner sc = new Scanner(System.in);
    ArrayList<Sneaker> list;


    private static String choice;
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String SIX = "6";
    private static final String ZERO = "0";

    public SneakerManager(){
        list = new ArrayList<>();
        list.add(new Sneaker("066","StanSmith",40,"36-43",2300000,"Adidas"));
        list.add(new Sneaker("099","AirJordan4xOffWhtie",22,"38-40",18500000,"Jordan&OffWhite"));
        list.add(new Sneaker("029","Presto",12,"38.5-41",15000000,"Nike&OffWhite"));
        list.add(new Sneaker("179","AirJordan4TravisScott",8,"38-43",10800000,"Jordan"));
        list.add(new Sneaker("097","BalenciagaTrackv3",17,"36-43",23000000,"Balenciaga"));
        list.add(new Sneaker("101","AirJordan1ChicagoxOffWhite",3,"40-43",55000999,"Jordan&OffWhite"));
        list.add(new Sneaker("700","yeezy700",11,"38-42",11999999,"Adidas"));
        list.add(new Sneaker("123","CoverseCocaDenim",7,"40",7000000,"Converse"));
        list.add(new Sneaker("1709","DiorxAirJordan1",222,"39-43",600000000,"Dior&Jordan"));

        for (Sneaker sneaker : list) {
            System.out.println(sneaker);
        }


    }

    public void startMenu(){
        while (true) {
            int index = 0;
            String choice;

            System.out.println("-------");
            System.out.println(" MENU : ");
            System.out.println("1. Hiển thị danh sách sản phẩm : ");
            System.out.println("2. Thêm sản phẩm : ");
            System.out.println("3. Xóa sản phẩm : ");
            System.out.println("4. Sửa sản phẩm : ");
            System.out.println("5. Sắp xếp sản phẩm : ");
            System.out.println("6. Tìm kiếm : ");
            System.out.println("0. Thoát : ");
            System.out.println("-------");

            choice = sc.nextLine();
            switch (choice) {
                case ONE:
                    c.display(list);
                    break;
                case TWO:
                    c.add(list);
                    break;
                case THREE:
                    System.out.println(" Input remove index : ");
                    index = Integer.parseInt(sc.nextLine());
                    c.remove(list,index );
                    break;
                case FOUR:
                    System.out.println(" Input edit index : ");
                    index = Integer.parseInt(sc.nextLine());
                    c.edit(list,index);
                   break;
                case FIVE:
                   sort();
                   break;
                case SIX:
                    System.out.println(" Input search : ");
                    c.search(list);
                    break;
                case ZERO:
                    System.exit(0);
                default:
                    startMenu();

            }
        }
    }

    void sort() {
        System.out.println(" Chọn kiểu sắp xếp : ");
        System.out.println("1. Sắp xếp theo tên : ");
        System.out.println("2. Sắp xếp theo id : ");
        System.out.println("3. Sắp xếp theo giá : ");
        System.out.println("4. Thoát : ");

        choice = sc.nextLine();
        switch (choice) {
            case ONE:
                sortName();
                break;
            case TWO:
                sortId();
                break;
            case THREE:
                sortPrice();
                break;
            case FOUR:
                System.exit(0);
                break;
            default:
        }
    }

   void sortName() {
        list.sort(new Comparator<Sneaker>() {
            @Override
            public int compare(Sneaker o1, Sneaker o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    void sortId() {
        list.sort(new Comparator<Sneaker>() {
            @Override
            public int compare(Sneaker o1, Sneaker o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
    }

   void sortPrice() {
        list.sort(new Comparator<Sneaker>() {
            @Override
            public int compare(Sneaker o1, Sneaker o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
    }

    public void writeObject() {
        try {
            FileOutputStream fos = new FileOutputStream("PRODUCTS/shose.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.list);
            oos.close();;
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readObject() {
        try {
            FileInputStream fis = new FileInputStream("PRODUCTS/shose.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.list = (ArrayList<Sneaker>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
