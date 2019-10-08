package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {
    private List<Classmate> classmateArray = new ArrayList<Classmate>();

    public void add(Classmate listItem) {
        classmateArray.add(listItem);
    }

    public Classmate get(Integer index) {
        return classmateArray.get(index);
    }

    public List<Classmate> getAll() {
        return classmateArray;
    }
}
