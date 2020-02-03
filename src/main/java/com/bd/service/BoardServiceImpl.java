package com.bd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bd.dao.BoardMapper;
import com.bd.model.common.PageInfo;
import com.bd.model.req.BoardSearchDTO;
import com.bd.model.res.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public ResponseEntity<Map<String, Object>> selectBoardList(BoardSearchDTO boardSearchDTO) {
		
		int boardListCnt = boardMapper.selectBoardListCount(boardSearchDTO);
		List<BoardDTO> boardList = boardMapper.selectBoardList(boardSearchDTO);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("list", boardList);
		
		PageInfo pageInfo = boardSearchDTO.getPageInfo();
		pageInfo.setResultCount(boardList.size());
		pageInfo.setTotalCount(boardListCnt);
		body.put("pageInfo", pageInfo);
		
		
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.OK);
	}

	@Override
	public BoardDTO selectBoard(Long boardNo) {
		return boardMapper.selectBoardByBoardNo(boardNo);
	}

}
