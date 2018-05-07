package server_api.DBConnecter.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/*
 * Created by aiden on 2017-06-29.
 * 참조 http://blog.naver.com/PostView.nhn?blogId=ddraemon1&logNo=220444202520
 */
public class SchDetailInfoTest {
    public static void main(String[] args){
        SchDetailInfoTest s = new SchDetailInfoTest();
        SchDetailInfo requestedSchDetailInfo = new SchDetailInfo();
        requestedSchDetailInfo.setSch_seq(1);
        System.out.println(requestedSchDetailInfo.getSch_seq());

        s.mybatis(requestedSchDetailInfo);
    }
    public  void mybatis(SchDetailInfo requestedSchDetailInfo){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext/*-context.xml");

        SchDetailInfoDAOImpl d = (SchDetailInfoDAOImpl)ctx.getBean("schDetailInfoDAO");

/*
        SchoolMasterInfoDAOService d = (SchoolMasterInfoDAOService)ctx.getBean("schoolMasterInfoDAO");
*/
        System.out.println(requestedSchDetailInfo.getSch_seq());
        List<SchDetailInfo> schList = (List<SchDetailInfo>) d.list("server_api.SchDetailInfo.getSchDetailInfos",requestedSchDetailInfo);//객체명.메소드명
             System.out.println("결과값: " + schList);

/*        String s = (String)d.select("server_api.SchMasterInfo",requestedSchMasterInfo);
        System.out.println("결과값: " + s);*/


        System.out.println("종료");
    }
}
