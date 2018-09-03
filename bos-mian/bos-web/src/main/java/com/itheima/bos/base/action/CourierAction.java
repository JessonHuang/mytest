package com.itheima.bos.base.action;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.base.Courier;
import com.itheima.bos.web.action.BaseAction;

@Controller
@Scope("prototype")
@ParentPackage("struts-default") 
@Namespace("/courier")
public class CourierAction extends BaseAction<Courier> {
	//从父类中获得model
	Courier model = super.getModel();
	
	@Override
	protected Specification<Courier> buildSpecification() {
		
		
		Specification<Courier> spec = new Specification<Courier>() {
			//定义集合存储条件
			List<Predicate> predList = new ArrayList<>();

				@Override
				public Predicate toPredicate(Root<Courier> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					
					Predicate [] preds = new Predicate[predList.size()];
					return cb.and(predList.toArray(preds));
				}
			};
		return spec;
	}
	
}
