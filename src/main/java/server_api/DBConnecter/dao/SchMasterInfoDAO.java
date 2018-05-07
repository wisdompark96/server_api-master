package server_api.DBConnecter.dao;

import java.util.List;


public interface SchMasterInfoDAO {

	public SchMasterInfo select(String sqlId);
	public SchMasterInfo select(String sqlId, SchMasterInfo param);
	public int    mod(String sqlId, SchMasterInfo param);
	public int    mod(String sqlId);
	public int    add(String sqlId, SchMasterInfo param);
	public int    del(String sqlId, SchMasterInfo param);
	
	public <SchMasterInfo> List<SchMasterInfo> list(String sqlId);
	public <SchMasterInfo> List<SchMasterInfo> list(String sqlId, SchMasterInfo param);
	
	public void transactionStart();
	public void transactionCommit();
	public void transactionRollback();
	public void transactionEnd();
}
