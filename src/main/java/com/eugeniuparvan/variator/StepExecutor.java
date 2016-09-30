package com.eugeniuparvan.variator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eugeniuparvan on 4/8/16.
 */
public interface StepExecutor<T extends Serializable> {
    void execute();

    void setVariation(Variation<T> variation);

    void setAllPossibleVariations(List<List<T>> allPossibleVariations);

    void setAllCursors(List<Integer> allCursors);
}
