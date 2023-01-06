package Pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.dao.CommentDao;
import Pack.dto.CommentDTO;

@Service
public class CommentService {
	@Autowired
	CommentDao dao;
	
	public void newComment(CommentDTO dto) {
		dao.newComment(dto);
	}
	
	public List<CommentDTO> commentList(int boardNo) {
		return dao.commentList(boardNo);
	}
	
	public void commentDelete(int commentNo) {
		dao.commentDelete(commentNo);
	}
}
