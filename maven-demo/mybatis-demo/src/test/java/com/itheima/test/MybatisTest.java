package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testSelectAll() throws IOException {
//        1. SessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3. 获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

//        4. 执行方法
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

//        5.释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {
//        1. SessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3. 获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

//        4. 执行方法
        int id = 1;
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

//        处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //Brand brand = mapper.selectById(id);
//        List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
        Brand brand = new Brand();
        //brand.setStatus(status);
        brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);
        List<Brand> brands = mapper.selectByCondition(brand);


        System.out.println(brands);

//        5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
//        1. SessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3. 获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

//        4. 执行方法
        int id = 1;
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

//        处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //Brand brand = mapper.selectById(id);
//        List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
        Brand brand = new Brand();
        //brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);
        List<Brand> brands = mapper.selectByConditionSingle(brand);


        System.out.println(brands);

//        5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
//        1. SessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3. 获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

//        4. 执行方法
        int id = 1;
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        mapper.add(brand);
        //System.out.println(brands);

        // 提交事务
        sqlSession.commit();

//        5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {
//        1. SessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3. 获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

//        4. 执行方法
//        int id = 1;
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        mapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //System.out.println(brands);

        // 提交事务
        sqlSession.commit();

//        5.释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
//        1. SessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3. 获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

//        4. 执行方法
        int id = 5;
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 200;

        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        int count = mapper.update(brand);

        System.out.println(count);

        //System.out.println(brands);

        // 提交事务
        sqlSession.commit();

//        5.释放资源
        sqlSession.close();
    }
}
