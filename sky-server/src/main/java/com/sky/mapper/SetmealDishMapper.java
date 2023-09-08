package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 批量根据id查询菜品
     * @param ids
     * @return
     */
    List<Long> getSetmealIdsByDish(List<Long> dishIds);
}
