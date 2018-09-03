package com.itheima.bos.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.base.StandardDao;
import com.itheima.bos.domain.base.Standard;
import com.itheima.bos.service.base.StandardService;
import com.itheima.bos.service.impl.BaseServiceImpl;

@Service("StandardService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class StandardServiceImpl extends BaseServiceImpl<Standard> implements StandardService {

}
