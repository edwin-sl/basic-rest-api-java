package com.clase.miapi.data.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edwin on May, 2019
 */
public abstract class Resource<T extends Resource.Model> {
    public List<T> data = new ArrayList<>();

    public static class Model {
        public int id;
    }
}
