package com.example.repository;

public class Generated {
    private static Long sequence = 0L;

    public static synchronized Long incrementId(){
        return sequence += 1L;
    }
}

