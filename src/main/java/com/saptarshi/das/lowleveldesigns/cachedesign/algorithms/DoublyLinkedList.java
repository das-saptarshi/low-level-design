package com.saptarshi.das.lowleveldesigns.cachedesign.algorithms;

import lombok.NonNull;

import java.util.Objects;
import java.util.Optional;

public class DoublyLinkedList<T> {
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;

    public DoublyLinkedNode<T> addToHead(final T value) {
        final DoublyLinkedNode<T> node = new DoublyLinkedNode<>(value);

        if (Objects.isNull(this.head)) {
            this.head = this.tail = node;
        } else {
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        }

        return node;
    }

    public void remove(@NonNull final DoublyLinkedNode<T> node) {
        if (this.head == node &&  this.tail == node) {
            this.head = this.tail = null;
        } else if (this.head == node) {
            this.head = this.head.getNext();
            this.head.getPrev().setNext(null);
            this.head.setPrev(null);
        } else if (this.tail == node) {
            this.tail = this.tail.getPrev();
            this.tail.getNext().setPrev(null);
            this.tail.setNext(null);
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setPrev(null);
            node.setNext(null);
        }
    }

    public T removeFromLast() {
        if (Objects.isNull(this.tail)) {
            return null;
        }
        final DoublyLinkedNode<T> node = this.tail;
        this.remove(node);
        return node.getValue();
    }
}
