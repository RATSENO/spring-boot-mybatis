package com.bd.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.bd.model.req.BoardSearchDTO;
import com.bd.model.res.BoardDTO;

public interface BoardService {
	
	//public List<BoardDTO> selectBoardList(BoardSearchDTO boardSearchDTO);
	public ResponseEntity<Map<String, Object>> selectBoardList(BoardSearchDTO boardSearchDTO);
	
	public BoardDTO selectBoard(Long BoardNo);

}
