package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findByID(ID id){
        return map.get(id);
    }

    T save(T object) {
        if( object != null){
            if(object.getId() == null){
                object.setId(getNexId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null.");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object){
        //TODO implement equals method for every entity extend this abstract class.
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Long getNexId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return  nextId;
    }
}
