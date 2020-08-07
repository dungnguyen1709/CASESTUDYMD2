package case_study.controller;

import case_study.product.Sneaker;

import java.util.ArrayList;

public interface Setting {
    void display(ArrayList<Sneaker> list);
    void add(ArrayList<Sneaker> list);
    void remove(ArrayList<Sneaker> list,int i);
    void edit(ArrayList<Sneaker> list, int i);
    void search(ArrayList<Sneaker> list);

}
