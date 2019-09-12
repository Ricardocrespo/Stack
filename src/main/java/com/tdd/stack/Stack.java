package com.tdd.stack;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Stack {

    Element top = null;
    int _size = 0;

    public int size() {
        return _size;
    }

    public Object peek() {
        return top == null? null : top.getItem();
    }

    public void push(Object item){
        Element _new = new Element();
        _new.setItem(item);
        _new.setNext(this.top);
        this.top = _new;
        this._size++;
    }

    public Object pop(){
        if (this._size == 0) return null;
        Object value = this.top.getItem();
        this.top = top.getNext();
        this._size--;
        return value;
    }

    public boolean contains(Object value){
        Element iterator = new Element();
        iterator = this.top;
        while(iterator != null) {
            if(iterator.getItem().equals(value))
                return true;
            else
                iterator = iterator.getNext();
        }
        return false;
    }




}
