/*

        package server_api.controller;

        import java.util.HashMap;
        import java.util.Map;

        import org.apache.log4j.Logger;
        import org.codehaus.jackson.JsonParseException;
        import org.codehaus.jackson.map.JsonMappingException;
        import org.codehaus.jackson.map.ObjectMapper;
        import org.codehaus.jackson.type.TypeReference;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.ResponseBody;

        import javax.servlet.http.HttpSession;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.ModelAndView;

        import server_api.service.MemberService;
        import server_api.dao.IMemberDao;
        import server_api.commons.Constant;

//서비스주입받아서
//받은 리퀘스트를 처리하기에 피룡한 서비스의 메소드를 호출해서 결과 획득 
//결과 데이터랑 적절한 페이지 세팅해서 
//모델엔뷰 리턴

@Controller
public class MemberController {
    @Autowired
    protected Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private MemberService service;

    @RequestMapping("/test.do")
    public ModelAndView dummy(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("attr",service.getData());
        mav.setViewName("test");
        return mav;
    }
    @RequestMapping("/memberList.do")
    public ModelAndView dummy2(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("memberList",service.selectAll());
        mav.setViewName("selectAll");
        return mav;
    }
//Spring MVC컨트롤러에서 사용할 수 있는 반한유형 종류 
//데이터와 패키지의 정보가 둘다 있는 경우
//-ModelAndView()
//데이터에 대한 정보만 있는 경우
//Model or Map
//페이지에 대한 정보만 있는 경우 
//String 
//둘다 없는 ㅕㅇ우
//void 

    @RequestMapping("/loginForm.do")
    public String loginForm(){
        return "loginForm";
    }

    @RequestMapping("/joinForm.do")
    public void joinForm(){

    }


    //응답할페이지에 대한 정보가 없는 경우는 (void, Model, Map 경우)  
    //받은 url에서 . 이하를 제외한 문자열을 페이지 정보로 사용함 
    //    ex)joinForm.do -> joinForm


    //join.do는 회원정보 데이터들을 파라미터로 받아서 
    //디비에 저장하고, loginForm.do로 리다이렉트 해줘야됨
//    @RequestMapping("join.do")
//    public String join(String id, String pwd, String pwd_Check, String name, String email, String phone, String admin){
//        
    //System.out.println("id");
    //파라미터가 잘 들어오는지 확인! ㅋㅋ
    //파라미터 이름이 똑같아야함 uid로 하면 없으니까 null값이 뜸
    //@RequestParam("id") String uid id라는 파라미터의 값을 uid매개변수에 넣어주셈!
    //required, value, defaultValue의 속성값이 있는데
    //required값이 true일 경우 해당 파라미터가 없으면 요청처리 못함
    //defaultValue는 해당 파라미터 값이 들어오지 않았을 경우
    //지정한 디폴트 값으로 변수값 대체
    // id, pwd, pwd_Check, name, email, phone, admin의 파라미터들이 있음

//        service.joinMember(id, pwd, pwd_Check, name, email, phone, admin);
//        return "redirect:loginForm.do";
//        //리다이렉트하는 방법
//    }

    @RequestMapping("/join.do")
    public String join(@RequestParam HashMap<String, Object> params)
    {
        System.out.println(params);
        service.joinMember(params);
        return "redirect:loginForm.do";
    }

//    @RequestMapping("login.do")
//    public String login(HttpSession session,String id, String pwd){
////    성공 실패에 따라 리다이렉트 방향 결정
//        //session사용은 매개변수에 session참조변수를 두면 자동으로 들어옵니다 
//        //login.do처리를 완성하세요 
//        //로그인 성공이면 main.do 리다이렉트
////        //로그인 실패이면 loginForm.do 리다이렉트
//        if(service.login(id, pwd)){
//            session.setAttribute("userid", id);
//            return "redirect:main.do";
//        }
//        else{
//            return "redirect:loginForm.do";
//        }
//    
//    }

    @RequestMapping("/login.do")
    public ModelAndView login(HttpSession session,String id, String pwd){
//    성공 실패에 따라 리다이렉트 방향 결정
        //session사용은 매개변수에 session참조변수를 두면 자동으로 들어옵니다 
        //login.do처리를 완성하세요 
        //로그인 성공이면 main.do 리다이렉트
//        //로그인 실패이면 loginForm.do 리다이렉트
        ModelAndView mav = new ModelAndView();
        if(service.login(id, pwd)){
            session.setAttribute("userid", id);
            mav.setViewName("redirect:main.do");
        }
        else{
            //return "redirect:loginForm.do";
            mav.setViewName("redirect:loginForm.do");
        }
        return mav;

    }

    @RequestMapping("/main.do")
    public String main(Model model,HttpSession session ){
        String userid = (String) session.getAttribute("userid");
        if(userid == null)
            return "redirect:loginForm.do";
        else{
//            model.addAllAttributes(service.getMemberInfo(id))<= Map을 통채로 싣기 
//            model.addAttibute(arg0); <= 모델 객체를 통채로 싣기 
//            model.addAttribute(arg0, arg1); <=키 값 지정 하나의 데이터 싣기 
            model.addAllAttributes(service.getMemberInfo(userid));
            return "main";
        }


    }
    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
//        session.invalidate();
        session.removeAttribute("userid");
        return "redirect:loginForm.do";

    }
    @RequestMapping("/memberUpdateForm.do")
    public String memberUpdateForm(Model model,HttpSession session){
        String userid = (String) session.getAttribute("userid");
        if(userid == null)
            return "redirect:loginForm.do";
        model.addAllAttributes(service.getMemberInfo(userid));
        return "memberUpdateForm";
    }
    @RequestMapping("/memberUpdate.do")
    public String memberUpdate(@RequestParam HashMap<String, Object> params){
        service.memberUpdate(params);
        return "redirect:main.do";
    }



}
 

*/
