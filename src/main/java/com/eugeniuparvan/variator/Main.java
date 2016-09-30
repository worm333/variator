package com.eugeniuparvan.variator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by eugeniuparvan on 4/5/16.
 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> allPossibleVariations = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            List<Integer> variation = new ArrayList<>();
            for (int j = 0; j < 100; ++j) {
                variation.add(j);
            }
            allPossibleVariations.add(variation);
        }
        VariationBuilder<Integer> variationBuilder = new VariationBuilder<>();
        Variation<Integer> variation = variationBuilder.withFileStorePath("/Users/eugeniuparvan/Documents/Desktop/Hello/").withStoreInFilesBy(100000).build();
        Set<List<Integer>> result = variation.getAllVariations(allPossibleVariations);
        System.out.print(result.size());
    }
}
