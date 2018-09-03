package com.itheima.bos.base.action;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.base.Standard;
import com.itheima.bos.web.action.BaseAction;

@Controller
@Scope("prototype")
@ParentPackage("struts-default") 
@Namespace("/standard")
public class StandardAction extends BaseAction<Standard> {
	//从父类中获得model
	Standard model = super.getModel();
	
	@Override
	protected Specification<Standard> buildSpecification() {
		
		
		Specification<Standard> spec = new Specification<Standard>() {
			//定义集合存储条件
			List<Predicate> predList = new ArrayList<>();

				@Override
				public Predicate toPredicate(Root<Standard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					
					//判断条件是否为空
					if(StringUtils.isNotBlank(model.getName())) {
						predList.add(cb.like(root.get("name").as(String.class), "%"+model.getName()+"%"));
					}
					if(model.getMinLength()!=null) {
						predList.add(cb.equal(root.get("minLength"), model.getMinLength()));
					}
					if(model.getMinWeight()!=null) {
						predList.add(cb.equal(root.get("minWeight"), model.getMinWeight()));
					}
					Predicate [] preds = new Predicate[predList.size()];
					return cb.and(predList.toArray(preds));
				}
			};
		return spec;
	}
	
}
