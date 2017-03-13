package spring.cloud.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.Cacheable;
import spring.cloud.dao.generic.GenericMapper;
import spring.cloud.dao.model.Hello;
import spring.cloud.dao.model.HelloExample;

import java.util.List;

/**
 *  It's a mybatis mapping file <br>
 * 
 * @created by:  mybatis generator <br>
 * @created at: 2017-03-08 19:28:39 <br>
 */
@Mapper
public interface HelloMapper extends GenericMapper<Hello, HelloExample, Long> {

 @Cacheable
 List<Hello> findByName(@Param("name") String name);

 int insert(@Param("name") String name);

 @Update("update user set name=#{name}, date_modify=now() where id=#{id}")
 int update(@Param("name") String name, @Param("id") Long id);
}