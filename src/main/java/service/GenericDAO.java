package service;

import java.io.Serializable;

/**
 *
 * @param <T>
 * @param <PK>
 */

public interface GenericDAO<T, PK extends Serializable> {
        T create(T t);
        T read(PK id);
        T update(T t);
        void delete(T t);
}
