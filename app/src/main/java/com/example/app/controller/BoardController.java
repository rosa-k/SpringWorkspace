package com.example.app.controller;

import com.example.app.aspect.annotation.LogStatus;
import com.example.app.domain.vo.BoardVO;
import com.example.app.domain.vo.Criteria;
import com.example.app.domain.vo.PageDTO;
import com.example.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;

/*//    게시글 목록
    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("boards", boardService.show());
    }*/

    //    게시글 목록
    @LogStatus
    @GetMapping("/list")
    public void list(Criteria criteria, Model model){
        PageDTO pageDTO = new PageDTO();
        if(criteria.getPage() == 0){
            criteria.createCriteria();
        }
        pageDTO.createPageDTO(criteria, boardService.getTotal(criteria));
        model.addAttribute("boards", boardService.show(criteria));
        model.addAttribute("pagination", pageDTO);
    }

//    게시글 등록
    @LogStatus
    @GetMapping("/write")
    public void write(Criteria criteria, Model model){
        model.addAttribute("board", new BoardVO());
    }

    @LogStatus
    @PostMapping("/write")
    public RedirectView write(BoardVO boardVO, RedirectAttributes redirectAttributes){
        boardService.add(boardVO);
        redirectAttributes.addFlashAttribute("boardNumber",boardVO.getBoardNumber());
        return new RedirectView("list");
    }

//    게시글 수정
//    게시글 상세보기
    @LogStatus
    @GetMapping(value = {"read", "update"})
    public void read(Long boardNumber, Criteria criteria, Model model){
        model.addAttribute("board", boardService.find(boardNumber));
    }

    @PostMapping("/update")
    public RedirectView update(BoardVO boardVO, Criteria criteria, RedirectAttributes redirectAttributes){
        boardService.update(boardVO);
//        알아서 쿼리스트링을 경로 뒤에 만들어준다(컨트롤러에서 사용할때)
//        다른 컨트롤러로 이동할 때에는 쿼리스트링으로 전달해야 한다.
        redirectAttributes.addAttribute("boardNumber", boardVO.getBoardNumber());
        redirectAttributes.addAttribute("page", criteria.getPage());
        redirectAttributes.addAttribute("amount", criteria.getAmount());
//        화면에서만 사용할때에는 Flash영역을 사용하여 전달해야한다다
//        rediectAttributes.addFlashAttribute("board", boardVO.getBoardNumber());
//        controller에서 controller에서 이동 할 때
//        RedirectView를 사용한다
        return new RedirectView("/board/read");
    }

//    게시글 삭제
    @LogStatus
    @PostMapping("/delete")
    public RedirectView delete(Long boardNumber){
        boardService.delete(boardNumber);
        return new RedirectView("/board/list");
    }




}
