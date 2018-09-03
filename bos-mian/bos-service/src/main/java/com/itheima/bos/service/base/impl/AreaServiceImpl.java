package com.itheima.bos.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.base.AreaDao;
import com.itheima.bos.domain.base.Area;
import com.itheima.bos.service.base.AreaService;
import com.itheima.bos.service.impl.BaseServiceImpl;

@Service("AreaService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class AreaServiceImpl extends BaseServiceImpl<Area> implements AreaService {
	
	@Autowired
	private AreaDao areaDao;
	
	
	/**
	 * 根据区域编码查询记录是否存在
	 * @param areacode
	 * @return boolean
	 */
	@Override
	public boolean findByAreaCode(String areacode) {
		//查询是否存在
		 List<Area> list = areaDao.findByAreacode(areacode);
		 return list!=null && list.size()>0;
	}

	@Override
	public void save(List<Area> areaList) {
		areaDao.save(areaList);
	}
	

}
