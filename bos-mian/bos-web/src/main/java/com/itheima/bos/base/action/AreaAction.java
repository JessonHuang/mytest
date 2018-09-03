package com.itheima.bos.base.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.base.Area;
import com.itheima.bos.domain.base.Area;
import com.itheima.bos.service.base.AreaService;
import com.itheima.bos.util.PinYin4jUtils;
import com.itheima.bos.web.action.BaseAction;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/area")
public class AreaAction extends BaseAction<Area> {
	// 模型驱动
	private Area model = super.getModel();

	@Autowired
	private AreaService areaService;

	@Override
	protected Specification<Area> buildSpecification() {

		Specification<Area> spec = new Specification<Area>() {
			// 定义集合存储条件
			List<Predicate> predList = new ArrayList<>();

			@Override
			public Predicate toPredicate(Root<Area> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Predicate[] preds = new Predicate[predList.size()];
				return cb.and(predList.toArray(preds));
			}
		};
		return spec;
	}

	// 接收文件
	private File upload; // 文件内容
	private String uploadFileName; // 文件名
	private String uploadContextType; // 文件类型

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContextType() {
		return uploadContextType;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	@Action("excelImport")
	public void excelImport() throws Exception {
		try {
			// 获取文件后缀名
			String extName = uploadFileName.substring(uploadFileName.lastIndexOf("."));
			// 获得工作簿
			Workbook wb = null;
			// 判断文件后缀名
			if (".xls".equals(extName)) {
				// 使用老版本poi
				wb = new HSSFWorkbook(new FileInputStream(upload));
			}
			if (".xlsx".equals(extName)) {
				// 使用新版本poi
				wb = new XSSFWorkbook(new FileInputStream(upload));
			}
			// 获得sheet
			Sheet sheet = wb.getSheet("area");
			//创建一个集合存储Area对象
			List<Area> areaList = new ArrayList<Area>();
			// 获得row
			for (Row row : sheet) {
				if (row.getRowNum() == 0)
					continue;
				// 获得每一列的值
				String areacode = row.getCell(0).getStringCellValue();
				String province = row.getCell(1).getStringCellValue();
				String city = row.getCell(2).getStringCellValue();
				String district = row.getCell(3).getStringCellValue();
				String postcode = row.getCell(4).getStringCellValue();

				// 创建一个Area对象
				Area area = new Area();
				area.setAreacode(areacode);
				area.setProvince(province);
				area.setCity(city);
				area.setDistrict(district);
				area.setPostcode(postcode);
				
				//剔除最后一个字
				province = province.substring(0,province.length()-1);
				city = city.substring(0, city.length()-1);
				district = district.substring(0, district.length()-1);
				//城市编码
				area.setCitycode(PinYin4jUtils.hanziToPinyin(city,""));
				//获得每个汉字的首字母
				String[] headString = PinYin4jUtils.getHeadByString(province+city+district);
				//简码
				area.setShortcode(PinYin4jUtils.stringArrayToString(headString));
				//判断该数据是否存在
				if(areaService.findByAreaCode(area.getAreacode())) continue;
				//添加到集合
				areaList.add(area);
			}
			areaService.save(areaList);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", e.getMessage());
		} finally {
			// 转为Json
			toJson(result);
		}
	}

}
