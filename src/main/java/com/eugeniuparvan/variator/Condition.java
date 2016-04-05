package com.eugeniuparvan.variator;

import java.util.List;

/**
 * Created by eugeniuparvan on 4/5/16.
 */
public interface Condition<T> {
    boolean isMeetingCondition(List<T> variation);
}