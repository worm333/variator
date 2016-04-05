package com.eugeniuparvan.variator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eugeniuparvan on 4/5/16.
 */
public class Variation<T extends Serializable> {
    private Set<List<T>> allVariations;
    private List<List<T>> allPossibleVariations;
    private List<Integer> allCursors;

    private String fileStorePath;
    private boolean separateFiles;
    private List<List<Integer>> cursorVariations;
    private Condition<T> condition;

    private boolean end;
    private int cursorVariationsIndex;

    public void setFileStorePath(String fileStorePath) {
        this.fileStorePath = fileStorePath;
    }

    public void setSeparateFiles(boolean separateFiles) {
        this.separateFiles = separateFiles;
    }

    public void setCursorVariations(List<List<Integer>> cursorVariations) {
        this.cursorVariations = cursorVariations;
    }

    public void setCondition(Condition<T> condition) {
        this.condition = condition;
    }

    public Set<List<T>> getAllVariations(List<List<T>> allPossibleVariations) {
        this.allPossibleVariations = allPossibleVariations;
        this.allVariations = new HashSet<>();
        this.end = false;

        initCursors();

        startSearch();

        return allVariations;
    }

    private void initCursors() {
        this.allCursors = new ArrayList<>();
        for (int i = 0; i < allPossibleVariations.size(); ++i) {
            allCursors.add(0);
        }
    }

    private void startSearch() {
        while (true) {
            List<T> variation = new ArrayList<>();
            for (int i = 0; i < allCursors.size(); ++i) {
                variation.add(allPossibleVariations.get(i).get(allCursors.get(i)));
            }

            if (condition == null)
                allVariations.add(variation);
            else if (condition.isMeetingCondition(variation))
                allVariations.add(variation);

            if (fileStorePath != null && separateFiles)
                writeVariationToFile(variation, allVariations.size() + "");

            updateCursors();

            if (cursorVariations == null) {
                if (end)
                    break;
            } else {
                if (end) {
                    end = false;
                    ++cursorVariationsIndex;
                    if (cursorVariationsIndex >= cursorVariations.size())
                        break;
                }
            }
        }
    }

    private void updateCursors() {
        for (int i = allCursors.size() - 1; i >= 0; --i) {
            if (cursorVariations != null && !cursorVariations.get(cursorVariationsIndex).contains(i))
                continue;
            boolean carryValue = false;
            Integer cursorValue = allCursors.get(i);
            ++cursorValue;
            if (cursorValue >= allPossibleVariations.get(i).size()) {
                carryValue = true;
                cursorValue = 0;
            }
            allCursors.set(i, cursorValue);

            if (!carryValue) {
                break;
            } else {
                if (cursorVariations == null) {
                    if (i == 0)
                        end = true;
                } else {
                    if (i == cursorVariations.get(cursorVariationsIndex).stream().min(Integer::compare).get())
                        end = true;
                }
            }
        }
    }


    private void writeVariationToFile(List<T> variation, String fileName) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(fileStorePath + fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(variation);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
