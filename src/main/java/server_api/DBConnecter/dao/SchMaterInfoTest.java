package server_api.DBConnecter.dao;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/*
 * Created by aiden on 2017-06-29.
 * 참조 http://blog.naver.com/PostView.nhn?blogId=ddraemon1&logNo=220444202520
 */
public class SchMaterInfoTest {
    public static void main(String[] args){
        SchMaterInfoTest s = new SchMaterInfoTest();
        SchMasterInfo requestedSchMasterInfo = new SchMasterInfo();
        requestedSchMasterInfo.setSch_seq(1);
        System.out.println(requestedSchMasterInfo.getSch_seq());
        System.out.println("객체:"+s.getwithSeq(requestedSchMasterInfo));
        s.mybatis(requestedSchMasterInfo);
    }
    public  void mybatis(SchMasterInfo requestedSchMasterInfo){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext/*-context.xml");

        SchMasterInfoDAOImpl d = (SchMasterInfoDAOImpl)ctx.getBean("schMasterInfoDAO");

/*
        SchoolMasterInfoDAOService d = (SchoolMasterInfoDAOService)ctx.getBean("schoolMasterInfoDAO");
*/
        System.out.println(requestedSchMasterInfo.getSch_seq());
        List<SchMasterInfo> schList = (List<SchMasterInfo>) d.list("server_api.SchMasterInfo.getAllSchMasterInfos",requestedSchMasterInfo);//객체명.메소드명
             System.out.println("결과값: " + schList);

/*        String s = (String)d.select("server_api.SchMasterInfo",requestedSchMasterInfo);
        System.out.println("결과값: " + s);*/


        System.out.println("종료");
    }
    public @ResponseBody
    List<SchMasterInfo> getwithSeq(SchMasterInfo requestedSchMasterInfo){

        List<SchMasterInfo> schList = null;
        System.out.println("실행");
        //SchoolParaTest[] emp = new ObjectMapper().readValue(empJson, SchoolParaTest[].class); // 배열로 받기
            SchMasterInfo requestedSchMasterInfos = requestedSchMasterInfo;//list로받기
            if (requestedSchMasterInfos != null) {

                    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext/*-context.xml");

                    SchMasterInfoDAOImpl d = (SchMasterInfoDAOImpl)ctx.getBean("schMasterInfoDAO");

                    schList = (java.util.List<SchMasterInfo>) d.list("server_api.SchMasterInfo.getSchMasterInfos",requestedSchMasterInfo);//db커넥션 정의, requestedSchMasterInfo 질문. 질문항목




            }


        return schList;
    }

}
