package server_api.DBConnecter.dao;

import java.util.List;


public interface SchDetailInfoDAO {

	public SchDetailInfo select(String sqlId);
	public SchDetailInfo select(String sqlId, SchDetailInfo param);
	public int    mod(String sqlId, SchDetailInfo param);
	public int    mod(String sqlId);
	public int    add(String sqlId, SchDetailInfo param);
	public int    del(String sqlId, SchDetailInfo param);
	
	public <SchDetailInfo> List<SchDetailInfo> list(String sqlId);
	public <SchDetailInfo> List<SchDetailInfo> list(String sqlId, SchDetailInfo param);
	
	public void transactionStart();
	public void transactionCommit();
	public void transactionRollback();
	public void transactionEnd();
}
