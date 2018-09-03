package com.itheima.bos.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.domain.base.Courier;
import com.itheima.bos.service.base.CourierService;
import com.itheima.bos.service.impl.BaseServiceImpl;

@Service("CourierService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class CourierServiceImpl extends BaseServiceImpl<Courier> implements CourierService {

}
