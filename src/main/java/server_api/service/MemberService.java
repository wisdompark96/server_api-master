/*

        package server_api.service;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import org.springframework.transaction.annotation.Transactional;
        import server_api.commons.Constant;
        import server_api.dao.IMemberDao;

@Service
public abstract class MemberService */
/*implements IMemberDao*//*
{
    @Autowired
    private IMemberDao memberDao;

    @Transactional
    public String getData(){
        return "I am a boy";
    }
    @Transactional
    public List<HashMap<String, Object>> selectAll() {
        return memberDao.selectAll();
    }

//    public void joinMember(String id, String pwd, String pwd_Check, String name, String email, String phone, String admin){
//        HashMap<String, Object> params = new HashMap<String,Object>();
//        
//        if(pwd.equals(pwd_Check))
//        {
//            params.put(Constant.Member.USERID, id);
//            params.put(Constant.Member.PWD, pwd);
//            params.put(Constant.Member.NAME, name);
//            params.put(Constant.Member.EMAIL, email);
//            params.put(Constant.Member.PHONE, phone);
//            params.put(Constant.Member.ADMIN, admin);
//            memberDao.insertMember(params);
//        }
//        
//    }
    @Transactional
    public void joinMember(HashMap<String, Object> params){

        if(params.get("pwd").equals(params.get("pwd_CHECK")))
        {
            memberDao.insertMember(params);
        }
    }

    @Transactional
    public boolean login(String id, String pwd){
        HashMap<String, Object> result = memberDao.selectOne(id);
        if(result == null)
            return false;
        else
        {
            String oPwd = (String) result.get(Constant.Member.PWD);
            if(oPwd==null)
                return false;
            else{
                if(oPwd.equals(pwd))
                    return true;
                else
                    return false;
            }

        }
    }

    //회원 한명의 정보를 가져다주는
    @Transactional
    public HashMap<String, Object> getMemberInfo(String id){
        return memberDao.selectOne(id);
    }
    @Transactional
    public void memberUpdate(HashMap<String, Object> params){

        if(params.get("pwd").equals(params.get("pwd_CHECK")))
        {
            HashMap<String, Object> record = memberDao.selectOne((String)params.get(Constant.Member.USERID));
            record.putAll(params); //원래있던거에 내가 받은걸로 수정
            memberDao.updateMember(record);
        }
    }
}
 


*/
