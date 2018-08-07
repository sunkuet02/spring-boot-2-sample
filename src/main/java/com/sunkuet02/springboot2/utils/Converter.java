package com.sunkuet02.springboot2.utils;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private final static Logger logger = Logger.getLogger(Converter.class);

    private static ModelMapper modelMapper = new ModelMapper();

    public static <U, V> V convertClass(U mapperObject, Class<V> targetClass) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(mapperObject, targetClass);
    }

    public static <U,V> List<V> toDtoList(List<U> mapperObjects, Class<V> targetClass) {
        List<V> dtoObjects = mapperObjects
                .stream()
                .map(u -> convertClass(u, targetClass))
                .collect(Collectors.toList());

        return dtoObjects;
    }

    public static <U,V> List<V> toDtoList(Iterable<U> mapperObjects, Class<V> targetClass) {
        List<V> dtoObjects = new ArrayList<>();

        mapperObjects.forEach(object -> {
            dtoObjects.add(convertClass(object, targetClass));
        });

        return dtoObjects;
    }

    public static <U,V> Page<V> toDtoPage(Page<U> mapperObjects, Class<V> targetClass) {
        Page<V> dtoObjects = mapperObjects
                .map(u -> convertClass(u, targetClass));
        return dtoObjects;
    }
}
