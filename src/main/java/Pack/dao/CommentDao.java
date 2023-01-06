package Pack.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Pack.dao.util.Delegate;
import Pack.dao.util.JdbcTemplate;
import Pack.dto.CommentDTO;


@Repository
public class CommentDao {
	
	public void newComment(CommentDTO dto) {
		JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.insert("newComment", dto);
			}
		});
	}
	
	public List<CommentDTO> commentList(int boardNo) {
		@SuppressWarnings("unchecked")
		List<CommentDTO> list = (List<CommentDTO>)JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.selectList("commentList", boardNo);
			}
		});
		
		return list;
	}
	
	public void commentDelete(int commentNo) {
		JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.delete("commentDelete", commentNo);
			}
		});
	}
}
