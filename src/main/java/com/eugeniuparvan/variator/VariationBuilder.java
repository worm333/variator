package com.eugeniuparvan.variator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eugeniuparvan on 4/5/16.
 */
public class VariationBuilder<T extends Serializable> {
    private String fileStorePath;
    private boolean separateFiles;
    private List<List<Integer>> cursorVariations;
    private Condition<T> condition;

    public VariationBuilder<T> withFileStorePath(String fileStorePath) {
        this.fileStorePath = fileStorePath;
        return this;
    }

    public VariationBuilder<T> withStoreInSeparatedFiles(boolean separateFiles) {
        this.separateFiles = separateFiles;
        return this;
    }

    public VariationBuilder<T> withCursorVariations(List<List<Integer>> cursorVariations) {
        this.cursorVariations = cursorVariations;
        return this;
    }

    public VariationBuilder<T> withCondition(Condition<T> condition) {
        this.condition = condition;
        return this;
    }

    public Variation<T> build() {
        Variation<T> variation = new Variation<>();
        variation.setFileStorePath(fileStorePath);
        variation.setSeparateFiles(separateFiles);
        variation.setCursorVariations(cursorVariations);
        variation.setCondition(condition);
        return variation;
    }


}
