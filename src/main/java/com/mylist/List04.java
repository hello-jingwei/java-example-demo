package com.mylist;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class List04 {

    public static void main(String[] args) {
        List<String> locationFormMaps = new ArrayList<>();
        locationFormMaps.add("a");
        locationFormMaps.add("b");
        locationFormMaps.add("c");
        locationFormMaps.add("d");
        locationFormMaps.add("e");
        locationFormMaps.add("f");
        List<List<String>> partitionDatas  = Lists.partition(locationFormMaps,10);
        for (List<String> partitionData : partitionDatas) {
            System.out.println(partitionData);
        }
    }
}
