package edu.hitwh.cdms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.hitwh.cdms.model.ScoresInfo;

@Repository
public interface ScoresInfoDao {
	public List<ScoresInfo> selectAllScoresInfo();
}
