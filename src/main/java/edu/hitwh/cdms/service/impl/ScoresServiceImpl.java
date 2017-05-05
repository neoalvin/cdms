package edu.hitwh.cdms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hitwh.cdms.dao.ScoresInfoDao;
import edu.hitwh.cdms.model.ScoresInfo;
import edu.hitwh.cdms.service.ScoresService;

@Service
public class ScoresServiceImpl implements ScoresService {

	@Resource
	ScoresInfoDao scoresInfoDao;

	public List<ScoresInfo> selectAllScoresInfo() {
		return scoresInfoDao.selectAllScoresInfo();
	}
}
