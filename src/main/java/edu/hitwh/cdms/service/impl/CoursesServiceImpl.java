package edu.hitwh.cdms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hitwh.cdms.dao.CoursesInfoDao;
import edu.hitwh.cdms.model.CoursesInfo;
import edu.hitwh.cdms.service.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Resource
	CoursesInfoDao coursesInfoDao;

	public List<CoursesInfo> selectAllCoursesInfo() {
		return coursesInfoDao.selectAllCoursesInfo();
	}
}
