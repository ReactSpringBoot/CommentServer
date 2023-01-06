package Pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Pack.dto.CommentDTO;
import Pack.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	@Autowired
	CommentService service;
	
	@PostMapping("/newComment")
	public void newComment(@RequestBody CommentDTO dto) {
		service.newComment(dto);
	}
	
	@GetMapping("/commentList/{boardNo}")
	public Object commentList(@PathVariable int boardNo) {
		System.out.println("test" + boardNo);
		return service.commentList(boardNo);
	}
	
	@PostMapping("/commentDelete/{commentNo}")
	public void commentDelete(@PathVariable int commentNo) {
		System.out.println("제발 되라 "+commentNo);
		service.commentDelete(commentNo);
	}
	
}
