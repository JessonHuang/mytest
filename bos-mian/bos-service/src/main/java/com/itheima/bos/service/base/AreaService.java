package com.itheima.bos.service.base;




import java.util.List;

import com.itheima.bos.domain.base.Area;
import com.itheima.bos.service.BaseService;

public interface AreaService extends BaseService<Area> {
	
	/**
	 * 根据区域编码查询记录是否存在
	 * @param areacode
	 * @return
	 */
	boolean findByAreaCode(String areacode);

	void save(List<Area> areaList);
}
