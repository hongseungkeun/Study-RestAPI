package com.example.repository;

import java.util.concurrent.atomic.AtomicLong;

public class Generated {
    private static final AtomicLong sequence = new AtomicLong();

    public static Long incrementId(){
        return sequence.addAndGet(1);
    }
}

