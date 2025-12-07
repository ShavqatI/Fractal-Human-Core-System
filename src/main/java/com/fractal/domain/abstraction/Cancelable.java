package com.fractal.domain.abstraction;

public interface Cancelable<T,R> {
    R cancel(T o);
}
