package edu.hitwh.cdms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.hitwh.cdms.model.CoursesInfo;

@Repository
public interface CoursesInfoDao {
	public List<CoursesInfo> selectAllCoursesInfo();
}
