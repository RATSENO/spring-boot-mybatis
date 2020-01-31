package com.bd.service;

import java.util.List;

import com.bd.model.req.BoardSearchDTO;
import com.bd.model.res.BoardDTO;

public interface BoardService {
	
	public List<BoardDTO> selectBoardList(BoardSearchDTO boardSearchDTO);
	
	public BoardDTO selectBoard(Long BoardNo);

}
