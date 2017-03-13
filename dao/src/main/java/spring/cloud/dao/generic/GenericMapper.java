package spring.cloud.dao.generic;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 通用Mapper
 * 
 * @author liuluming
 *
 * @param <T>
 *            Model
 * @param <TE>
 *            ModelExample
 * @param <PK>
 *            Model主键类型
 */
public interface GenericMapper<T, TE, PK> {

	/**
	 * 根据自定义条件，批量物理删除。
	 * 
	 * @param example
	 * @return
	 */
	int deleteByExamplePhysically(TE example);

	/**
	 * 根据主键，物理删除。
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKeyPhysically(PK id);

	/**
	 * 根据主键，批量物理删除。
	 * 
	 * @param ids
	 * @return
	 */
	int deleteByPrimaryKeysPhysically(@Param(value = "ids") PK[] ids);

	/**
	 * 根据主键，逻辑删除。
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKeyLogically(PK id);

	/**
	 * 根据主键，批量逻辑删除。
	 * 
	 * @param ids
	 * @return
	 */
	int deleteByPrimaryKeysLogically(@Param(value = "ids") PK[] ids);

	/**
	 * 完全插入数据（如果对象中的属性为null，则插入的字段数据为null）
	 * 
	 * @param record
	 * @return
	 */
	int insert(T record);

	/**
	 * 选择性插入数据（如果对象中的属性为null，则插入的字段数据为默认值）
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(T record);

	/**
	 * 根据自定义条件查询。
	 * 
	 * @param example
	 * @return
	 */
	List<T> selectByExample(TE example);

	/**
	 * 根据自定义条件统计记录数量。
	 * 
	 * @param example
	 * @return
	 */
	int countByExample(TE example);

	/**
	 * 根据主键查询。
	 * 
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(PK id);

	/**
	 * 根据主键批量查询。
	 * 
	 * @param ids
	 * @return
	 */
	List<T> selectByPrimaryKeys(@Param(value = "ids") PK[] ids);

	/**
	 * 根据自定义条件，批量选择性更新（如果对象中的属性为null，则不更新）。
	 * 
	 * @param record
	 * @param example
	 * @return
	 */
    int updateByExampleSelective(@Param("record") T record, @Param("example") TE example);

	/**
	 * 根据自定义条件，批量完全更新（如果对象中的属性为null，则更新后的字段数据为null）。
	 * 
	 * @param record
	 * @param example
	 * @return
	 */
	int updateByExample(T record, TE example);

	/**
	 * 根据主键，选择性更新（如果对象中的属性为null，则不更新）。
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(T record);

	/**
	 * 根据主键，完全更新（如果对象中的属性为null，则更新后的字段数据为null）。
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(T record);

}
