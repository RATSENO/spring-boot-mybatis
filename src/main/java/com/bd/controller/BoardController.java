package com.bd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bd.model.req.BoardSearchDTO;
import com.bd.model.res.BoardDTO;
import com.bd.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/boards", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getBoardList(BoardSearchDTO boardSearchDTO){
		return boardService.selectBoardList(boardSearchDTO);
	}
	
	@RequestMapping(value = "/boards/{boardNo}", method = RequestMethod.GET)
	public BoardDTO getBoard(@PathVariable(name = "boardNo")Long boardNo){
		return boardService.selectBoard(boardNo);
	}
}
