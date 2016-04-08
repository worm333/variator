package com.eugeniuparvan.variator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eugeniuparvan on 4/5/16.
 */
public class VariationBuilder<T extends Serializable> {
    private String fileStorePath;
    private int numberOfVariationsInFile;
    private List<List<Integer>> cursorVariations;
    private Condition<T> condition;
    private StepExecutor stepExecutor;

    public VariationBuilder<T> withFileStorePath(String fileStorePath) {
        this.fileStorePath = fileStorePath;
        return this;
    }

    public VariationBuilder<T> withStoreInFilesBy(int numberOfVariationsInFile) {
        this.numberOfVariationsInFile = numberOfVariationsInFile;
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

    public VariationBuilder<T> withStepExecutor(StepExecutor stepExecutor) {
        this.stepExecutor = stepExecutor;
        return this;
    }

    public Variation<T> build() {
        Variation<T> variation = new Variation<>();
        variation.setFileStorePath(fileStorePath);
        variation.setNumberOfVariationsInFile(numberOfVariationsInFile);
        variation.setCursorVariations(cursorVariations);
        variation.setCondition(condition);
        variation.setStepExecutor(stepExecutor);
        return variation;
    }


}
