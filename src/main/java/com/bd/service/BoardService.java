package com.bd.service;

import com.bd.model.common.CommonResponse;
import com.bd.model.req.BoardSearchDTO;

public interface BoardService {
	
	//public List<BoardDTO> selectBoardList(BoardSearchDTO boardSearchDTO);
	//public ResponseEntity<Map<String, Object>> selectBoardList(BoardSearchDTO boardSearchDTO);
	public CommonResponse selectBoardList(BoardSearchDTO boardSearchDTO);
	
	//public ResponseEntity<Map<String, Object>> selectBoard(Long BoardNo);
	public CommonResponse selectBoard(Long BoardNo);
}
