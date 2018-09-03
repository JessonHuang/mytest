package com.itheima.bos.dao.base;

import java.util.List;

import com.itheima.bos.dao.BaseDao;
import com.itheima.bos.domain.base.Area;

public interface AreaDao extends BaseDao<Area> {
	/**
	 * 查询数据是否存在
	 * @param areacode
	 * @return List<Area>
	 */
	List<Area> findByAreacode(String areacode);
}
