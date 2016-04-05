package com.eugeniuparvan.variator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by eugeniuparvan on 4/5/16.
 */
public class CursorVariations {

    private int elementsCount;
    private int cursorCount;
    private Set<List<Integer>> result;

    public CursorVariations(int elementsCount, int cursorsCount) {
        this.elementsCount = elementsCount;
        this.cursorCount = cursorsCount;

        VariationBuilder<Integer> variationBuilder = new VariationBuilder<>();
        Variation<Integer> variation = variationBuilder.build();
        List<List<Integer>> allVariations = new ArrayList<>();
        for (int i = 0; i < elementsCount; ++i) {
            allVariations.add(new ArrayList<>(Arrays.asList(0, 1)));
        }
        result = variation.getAllVariations(allVariations);
    }

    public List<List<Integer>> get() {
        return result.stream().filter(e -> {
            int sum = 0;
            for (Integer i : e)
                sum += i;
            return cursorCount == sum;
        }).map(e -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < e.size(); ++i) {
                if (e.get(i) != 0)
                    list.add(i);

            }
            return list;
        }).collect(Collectors.toList());
    }

}
