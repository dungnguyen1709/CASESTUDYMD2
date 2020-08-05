package case_study.storeage;


import case_study.controller.Control;
import case_study.controller.Setting;
import case_study.product.Sneaker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SneakerManager  {
    Setting c = (Setting) new Control();
    Scanner sc = new Scanner(System.in);
    ArrayList<Sneaker> list = new ArrayList<>();

    private static String choice;
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String ZERO = "0";

    SneakerManager(){
        setDefaultData();
    }

    public void startMenu(){
        while (true) {
            int index = 0;
            String choice;

            System.out.println("-------");
            System.out.println(" MENU : ");
            System.out.println("1. Hiển thị danh sách sản phẩm : ");
            System.out.println("2. Thêm sản phẩm : ");
            System.out.println("3. Sửa sản phẩm : ");
            System.out.println("4. Xóa sản phẩm : ");
            System.out.println("5. Sắp xếp sản phẩm : ");
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
                    System.out.println(" Input edit index : ");
                    index = Integer.parseInt(sc.nextLine());
                    c.edit(list,index);
                    break;
                case FOUR:
                    System.out.println(" Input remove index : ");
                    index = Integer.parseInt(sc.nextLine());
                    c.remove(list,index);
                case FIVE:
                   sort();
                   break;
                case ZERO:
                    System.exit(0);
                default:
                    startMenu();

            }
        }
    }
    private void setDefaultData() {
        list.add(new Sneaker("066","StanSmith","White","36-43",2300000,"Adidas"));
        list.add(new Sneaker("099","Jordan4OffWhtie","White","38-40",18500000,"Jordan&OffWhite"));
        list.add(new Sneaker("029","Presto","Black","38.5-41",15000000,"Nike&OffWhite"));
        list.add(new Sneaker("179","Jordan4TravisScott","Blue","38-43",10800000,"Jordan"));
        list.add(new Sneaker("097","BalenciagaTrackv3","White","36-43",23000000,"Balenciaga"));
    }

    void sort() {
        System.out.println(" Chọn kiểu sắp xếp : ");
        System.out.println("1. Sắp xếp theo tên : ");
        System.out.println("2. Sắp xếp theo id : ");
        System.out.println("3. Sắp xếp theo giá : ");
        System.out.println("4. Set Default : ");

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
                setDefaultData();
                break;
            default:
                sort();
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


}
