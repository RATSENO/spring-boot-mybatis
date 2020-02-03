package com.bd.service;

import com.bd.model.common.CommonResponse;
import com.bd.model.req.BoardSearchDTO;
import com.bd.model.req.BoardUpdateDTO;

public interface BoardService {

	// public List<BoardDTO> selectBoardList(BoardSearchDTO boardSearchDTO);
	// public ResponseEntity<Map<String, Object>> selectBoardList(BoardSearchDTO
	// boardSearchDTO);
	public CommonResponse getBoardList(BoardSearchDTO boardSearchDTO);

	// public ResponseEntity<Map<String, Object>> selectBoard(Long BoardNo);
	public CommonResponse getBoard(Long BoardNo);

	public CommonResponse modifyBoard(BoardUpdateDTO boardUpdateDTO);
}
