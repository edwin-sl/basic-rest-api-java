package com.clase.miapi.data;

import com.clase.miapi.data.models.Resource;
import com.clase.miapi.data.models.Resource.Model;

import java.util.List;

/**
 * Created by edwin on May, 2019
 */
public class Database {
    public static List<?> select(Resource<?> resource){
        return resource.data;
    }

    public static Model select(Resource<?> resource, int id){
        return resource.data.stream()
                .filter(e -> e.id == id)
                .findFirst()
                .orElse(null);
    }

    public static <T extends Model> Model create(Resource<T> resource, T element){
        var data = resource.data;
        var lastElement = data.get(data.size() - 1);
        int id = lastElement == null ? 1 : lastElement.id + 1;
        element.id = id;
        data.add(element);

        return element;
    }

    public static <T extends Model> Model update(Resource<T> resource, T element, int id){
        var data = resource.data;
        int index = -1;
        for(int i = 0 ; index < data.size(); index++){
            if(data.get(i).id == id){
                index = i;
                break;
            }
        }
        element.id = id;
        data.set(index, element);

        return element;
    }

    public static Model delete(Resource<?> resource, int id){
        var data = resource.data;
        var element = data.stream()
                .filter(e -> e.id == id)
                .findFirst();
        Model res = element.orElse(null);
        if(element.isPresent()){
            if(!data.remove(element)){
                res = null;
            }
        }

        return res;
    }
}
