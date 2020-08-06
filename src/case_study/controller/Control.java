package case_study.controller;

import case_study.product.Sneaker;

import java.util.ArrayList;
import java.util.Scanner;


public class Control implements Setting {

    @Override
    public void display(ArrayList<Sneaker> list) {
        for (Sneaker sneaker : list) {
            System.out.println(sneaker);
        }
    }

    @Override
    public void add(ArrayList<Sneaker> list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input id : ");
        String id = sc.nextLine();
        System.out.print("input name : ");
        String name = sc.nextLine();
        System.out.print("input amount : ");
        int amount = Integer.parseInt(sc.nextLine());
        System.out.print("input size : ");
        String size = sc.nextLine();
        System.out.print("input price : ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("input brand : ");
        String brand = sc.nextLine();

        Sneaker sneaker = new Sneaker(id, name, amount, size, price, brand);
        list.add(sneaker);
    }

    @Override
    public void remove(ArrayList<Sneaker> list, int i) {
        for (int j = 0; j < list.size(); j++) {
            if (j == i) {
                list.remove(j);
                break;
            }
        }
    }

    @Override
    public void edit(ArrayList<Sneaker> list, int i) {
        for (int j = 0; j < list.size(); j++) {
            if (i == j) {
                Scanner sc = new Scanner(System.in);
                System.out.print("input id : ");
                String id = sc.nextLine();
                System.out.print("input name : ");
                String name = sc.nextLine();
                System.out.print("input amount : ");
                int amount = Integer.parseInt(sc.nextLine());
                System.out.print("input size : ");
                String size = sc.nextLine();
                System.out.print("input price : ");
                int price = Integer.parseInt(sc.nextLine());
                System.out.print("input brand : ");
                String brand = sc.nextLine();

                list.get(j).setId(id);
                list.get(j).setName(name);
                list.get(j).setAmount(amount);
                list.get(j).setSize(size);
                list.get(j).setPrice(price);
                list.get(j).setBrand(brand);
                break;
            }
        }
    }

    @Override
    public void search(ArrayList<Sneaker> list) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().trim();
        boolean isExit = false;
        for (Sneaker sneaker : list) {
            if (sneaker.getName().equals(name)) {
                System.out.println(" Đôi giày có tên : " + name + " |" + " có mã sản phẩm : " + sneaker.getId() + " |" + " số lượng : " + sneaker.getAmount() + " |" + " có size : " + sneaker.getSize() + " |" + " có giá : " + sneaker.getPrice() + " |" + " sản phẩm thuộc hãng : " + sneaker.getBrand());
                isExit = true;
            }
        }
        if (!isExit) {
            System.out.println(" Không tìm thấy đôi giày có tên " + name);
        }
    }


}
