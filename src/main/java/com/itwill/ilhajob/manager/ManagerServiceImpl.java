package com.itwill.ilhajob.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerDao managerDao;
	
	//constructor
    public ManagerServiceImpl(ManagerDao managerDao) {
    	this.managerDao=managerDao;
	}
    
    //getter
	public ManagerDao getManagerDao() {
		return managerDao;
	}
	
	//setter
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public int insertManager(Manager manager) throws Exception {
		return managerDao.insert(manager);
	}

	@Override
	public int updateManager(Manager manager) throws Exception {
		return managerDao.update(manager);
	}

	@Override
	public int deleteManager(String managerEmail) throws Exception {
		return managerDao.delete(managerEmail);
	}

	@Override
	public Manager findManagerByEmail(String managerEmail) throws Exception {
		return managerDao.findManager(managerEmail);
	}
	
	@Override
	public int existedManager(String managerEmail) throws Exception {
		return 0;
	}
	
	
	@Override
	public List<Manager> selectListByCorpId(String corpId) throws Exception {
		return managerDao.listManagerByCorpId(corpId);
	}
	
	

}
