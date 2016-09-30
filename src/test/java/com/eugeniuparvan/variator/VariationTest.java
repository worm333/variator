package com.eugeniuparvan.variator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by eugeniuparvan on 4/5/16.
 */
public class VariationTest {

    @Test
    public void getAllVariationsTest() {
        Variation<Integer> variation = new Variation<>();

        List<List<Integer>> allVariations = null;

        allVariations = new ArrayList<>();
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2));
        allVariations.add(a);
        allVariations.add(b);
        Set<List<Integer>> result = variation.getAllVariations(allVariations);
        Assert.assertEquals(4, result.size());

        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2, 3));
        b = new ArrayList<>(Arrays.asList(1, 2, 3));
        allVariations.add(a);
        allVariations.add(b);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 9);


        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2, 3));
        b = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3));
        allVariations.add(a);
        allVariations.add(b);
        allVariations.add(c);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 27);

        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        b = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        c = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        allVariations.add(a);
        allVariations.add(b);
        allVariations.add(c);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 1000);
    }

    @Test
    public void getAllVariationsWithConditionTest() {
        VariationBuilder<Integer> variationBuilder = new VariationBuilder<>();
        Variation<Integer> variation = variationBuilder.withCondition((v) -> {
            int sum = 0;
            for (Integer e : v)
                sum += e;
            return sum < 4;
        }).build();

        List<List<Integer>> allVariations = new ArrayList<>();
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2));
        allVariations.add(a);
        allVariations.add(b);
        Set<List<Integer>> result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 3);
    }

    @Test
    public void getAllVariationsWithCursorVariations() {
        VariationBuilder<Integer> variationBuilder = new VariationBuilder<>();

        List<List<Integer>> cursorVariations = new ArrayList<>();
        cursorVariations.add(Arrays.asList(1));
        Variation<Integer> variation = variationBuilder.withCursorVariations(cursorVariations).build();

        List<List<Integer>> allVariations = new ArrayList<>();
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2));
        allVariations.add(a);
        allVariations.add(b);
        Set<List<Integer>> result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 2);


        cursorVariations = new ArrayList<>();
        cursorVariations.add(Arrays.asList(0, 1));
        variation = variationBuilder.withCursorVariations(cursorVariations).build();

        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2));
        b = new ArrayList<>(Arrays.asList(1, 2));
        allVariations.add(a);
        allVariations.add(b);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 4);


        cursorVariations = new ArrayList<>();
        cursorVariations.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        variation = variationBuilder.withCursorVariations(cursorVariations).build();

        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        b = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        List<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        allVariations.add(a);
        allVariations.add(b);
        allVariations.add(c);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 1000);


        cursorVariations = new ArrayList<>();
        cursorVariations.add(Arrays.asList(1));
        variation = variationBuilder.withCursorVariations(cursorVariations).build();

        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        b = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        c = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        allVariations.add(a);
        allVariations.add(b);
        allVariations.add(c);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 10);

        cursorVariations = new ArrayList<>();
        cursorVariations.add(Arrays.asList(1, 2));
        variation = variationBuilder.withCursorVariations(cursorVariations).build();

        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        b = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        c = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        allVariations.add(a);
        allVariations.add(b);
        allVariations.add(c);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 100);

        CursorVariations cursorVariation = new CursorVariations(3, 1);
        variationBuilder = new VariationBuilder<>();
        variation = variationBuilder.withCursorVariations(cursorVariation.get()).build();
        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2, 3));
        b = new ArrayList<>(Arrays.asList(1, 2, 3));
        c = new ArrayList<>(Arrays.asList(1, 2, 3));
        allVariations.add(a);
        allVariations.add(b);
        allVariations.add(c);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 7);


        cursorVariation = new CursorVariations(3, 2);
        variationBuilder = new VariationBuilder<>();
        variation = variationBuilder.withCursorVariations(cursorVariation.get()).build();
        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2, 3));
        b = new ArrayList<>(Arrays.asList(1, 2, 3));
        c = new ArrayList<>(Arrays.asList(1, 2, 3));
        allVariations.add(a);
        allVariations.add(b);
        allVariations.add(c);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 19);

        cursorVariation = new CursorVariations(3, 3);
        variationBuilder = new VariationBuilder<>();
        variation = variationBuilder.withCursorVariations(cursorVariation.get()).build();
        allVariations = new ArrayList<>();
        a = new ArrayList<>(Arrays.asList(1, 2, 3));
        b = new ArrayList<>(Arrays.asList(1, 2, 3));
        c = new ArrayList<>(Arrays.asList(1, 2, 3));
        allVariations.add(a);
        allVariations.add(b);
        allVariations.add(c);
        result = variation.getAllVariations(allVariations);
        Assert.assertEquals(result.size(), 27);
    }
}
