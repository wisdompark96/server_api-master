
package server_api.DBConnecter.dao;
/*
 * Created by aiden on 2017-06-29.
 * 참조 http://blog.naver.com/PostView.nhn?blogId=ddraemon1&logNo=220444202520
 */

import java.util.List;

public class SchMasterInfoDAOImpl extends AbstractSchMasterInfoDAO implements SchMasterInfoDAO {

	private static final long serialVersionUID = -2920396419915886645L;

	// 조회
	public SchMasterInfo select(String sqlId) {
		return super.selectOne(sqlId);
	}		
	public SchMasterInfo select(String sqlId, SchMasterInfo param) {
		return super.selectOne(sqlId, param);
	}
	
	// 수정,등록,삭제
	public int    mod(String sqlId, SchMasterInfo param){
		return super.update(sqlId, param);
	}
	public int    mod(String sqlId){
		return super.update(sqlId);
	}
	public int    add(String sqlId, SchMasterInfo param){
		return super.insert(sqlId, param);
	}
	public int    del(String sqlId, SchMasterInfo param){
		return super.delete(sqlId, param);
	}
	
	// 다건조회
	public <SchMasterInfo> List<SchMasterInfo> list(String sqlId){
		return super.selectList(sqlId);
	}
	public <SchMasterInfo> List<SchMasterInfo> list(String sqlId, SchMasterInfo param){
		return super.selectList(sqlId, param);
	}
	
	public void transactionStart() {
		super.start();
	}
	
	public void transactionCommit() {
		super.commit();
	}
	
	public void transactionRollback() {
		super.rollback();
	}
	
	public void transactionEnd() {
		super.end();
	}
}
