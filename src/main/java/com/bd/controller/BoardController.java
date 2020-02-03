package com.bd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bd.model.common.CommonResponse;
import com.bd.model.req.BoardSearchDTO;
import com.bd.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/boards", method = RequestMethod.GET)
	public CommonResponse getBoardList(BoardSearchDTO boardSearchDTO){
		return boardService.selectBoardList(boardSearchDTO);
	}
	
	@RequestMapping(value = "/boards/{boardNo}", method = RequestMethod.GET)
	public CommonResponse getBoard(@PathVariable(name = "boardNo")Long boardNo){
		return boardService.selectBoard(boardNo);
	}
}
