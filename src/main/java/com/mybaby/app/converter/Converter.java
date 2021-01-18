package com.mybaby.app.converter;

import com.mybaby.app.domain.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Converter<T extends BaseEntity, R> {

    R convert(T t);

    default List<R> convert(Collection<T> collection) {
        return collection.stream().map(this::convert).collect(Collectors.toList());
    }
}
