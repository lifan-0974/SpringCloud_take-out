package com.lllfff.mapper;

import com.lllfff.entity.Type;

import java.util.List;

public interface TypeMapper {
    public Type findById(long id);
    public List<Type> findAll();
}
