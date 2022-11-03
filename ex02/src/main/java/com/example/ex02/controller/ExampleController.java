package com.example.ex02.controller;

import com.example.ex02.domain.vo.MemberVO;
import com.example.ex02.domain.vo.ProductVO;
import com.example.ex02.domain.vo.TaskVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/ex/*")
@RequiredArgsConstructor
public abstract class ExampleController {
    //value 속성값
    @RequestMapping(value = "ex01", method = {RequestMethod.GET, RequestMethod.POST})
    public void ex01(){
        log.info("ex01...........");
    }

    //@GetMapping 페이지 이동, @PostMapping DB crud
    @GetMapping("ex02")
    //주소창에 ex02?name=@@ 입력
    public void ex02(HttpServletRequest request){
        log.info("name: " + request.getParameter("name"));
    }

    @GetMapping("ex03")
    public void ex03(String name){
        log.info("name: " + name);
    }

    @GetMapping("ex04")
    public void ex04(MemberVO memberVO){
        log.info("member: " + memberVO);
    }

    @GetMapping("ex05")
    //주소창(필드명)과 VO가 다르면 동일하게 바꿔줘야함
    public void ex05(@RequestParam("id") String name, int age){
        log.info("name: " + name);
        log.info("age " + age);
    }

    @GetMapping("ex06")
    public void ex06(MemberVO memberVO){
        log.info("ex06..............");
    }

    @GetMapping("ex07")
    //@ModelAttribute("key") value
    //길어지면 Model model로 작성
    public void ex07(@ModelAttribute("gender") String gender, MemberVO memberVO){
        log.info("ex07..............");
        log.info("memberVO: " + memberVO);
        log.info("gender: " + gender);
    }

    //    [실습 1]
    //    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
    //    화면에서 4개 정보 입력 후 form태그로 전송한다

    @GetMapping("ex08")
    public void ex08(ProductVO productVO){
        log.info("ex08..............");
        log.info("ProductVO: " + productVO);
    }

    //    [실습 2]
    //    TaskVO 선언
    //    int num, int kor, int eng, int math 선언
    //    총점과 평균 점수 화면에 출력

    @GetMapping("ex09")
    public void exam09(TaskVO taskVO){
        log.info("exam09..............");
        log.info("TaskVO: " + taskVO);
    }

    //리팩토링
    //메소드 안에서는 로직이 보이지 않음
    //VO에서 get으로 사용해서 바로 total, average로 호출
    //Mapping의 이름이 같아도 앞에 붙는 Get, Post
    //데이터 전송 방식에 따라 구분하여 실행됨
    @GetMapping("/exam")
    //return으로 작성할때는 폴더에 있는 경로로 작성해줘야함
    //그래서 ex/ 가 파일명.html 앞에 붙음
    public String exam(){
        return "ex/exam";
    }

    @PostMapping("/exam")
    public String exam(TaskVO taskVO){
        return "ex/result";
    }

    //    [실습 3]
    //    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
    //    아이디가 user일 경우 user.html로 이동
    //
    //    - login.html : 아이디와 비밀번호 입력 페이지 출력
    //    - admin.html : 관리자 페이지 출력
    //    - user.html : 일반 회원 페이지 출력

    @GetMapping("login")
    public void login(String id, String pw) {
        log.info("login..............");

    }

    @GetMapping("test")
    public String test(String id){
        log.info("test..............");
        if (id.equals("user")) {
            log.info(id);
            return "ex/user";
        } else if (id.equals("admin")) {
            log.info(id);
            return "ex/admin";
        } else {
            return null;
        }
    }

    @GetMapping("admin")
    public void admin(){
        log.info("admin..............");
    }
    @GetMapping("user")
    public void user(){
        log.info("user..............");
    }

    //    [실습 4]
    //    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
    //    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
    //    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
    //    퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
    //    - getToWork.html
    //    - leaveWork.html
    //    - late.html
    //    - work.html

    //현재시간을 비교하여 9시면 출근 이후면 지각
    //17시 이전은 업무시간, 이후면 퇴근
//    @Autowired
//    private final TimeMapper timeMapper;
//    mapper.xml을 만들고 interface 만들고 참조는,?
//    @Select("SELECT SYSDATE FROM DUAL")
//    public abstract String getTimeQuick();
}
