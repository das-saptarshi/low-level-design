package com.saptarshi.das.lowleveldesigns.cachedesign.algorithms;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class DoublyLinkedNode<T> {
    private DoublyLinkedNode<T> prev;
    private DoublyLinkedNode<T> next;
    private T value;

    public DoublyLinkedNode(T value) {
        this.value = value;
    }
}
