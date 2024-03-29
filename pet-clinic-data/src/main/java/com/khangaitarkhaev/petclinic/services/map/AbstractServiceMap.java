package com.khangaitarkhaev.petclinic.services.map;

import com.khangaitarkhaev.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractServiceMap <T extends BaseEntity, ID extends  Long> {

    protected Map<Long, T> map = new HashMap<>();

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNewId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object can not be null!");
        }
        return object;
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNewId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
