package com.mylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class List01 {
    public static void main(String[] args) {
        List<String> deliveryIds = new ArrayList<>();
//        deliveryIds.add("112B51A747134551AE58F5E235B8B1FC");
        List<String> deliveryIDs = new ArrayList<>();
        deliveryIDs.add("112B51A747134551AE58F5E235B8B1FA");
        deliveryIDs.add("112B51A747134551AE58F5E235B8B1FB");
        System.out.println(deliveryIDs.containsAll(deliveryIds));
        System.out.println(deliveryIds.isEmpty());
    }
}
