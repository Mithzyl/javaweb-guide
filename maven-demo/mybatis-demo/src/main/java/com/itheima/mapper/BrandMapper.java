package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
//    查询所有
    public List<Brand> selectAll();

//    查看详情
    public Brand selectById(int id);

//    条件查询
//    1.散装参数
//    2.对象参数 属性名称和占位符名称一致
//    3.map集合参数
//    Param 告诉哪一个参数传到哪个变量中

//    List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName, @Param("brandName")String brandName);

    List<Brand> selectByCondition(Brand brand);

//    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    // 添加
    void add(Brand brand);

}
