package com.bd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bd.dao.BoardMapper;
import com.bd.model.common.CommonHeader;
import com.bd.model.common.CommonResponse;
import com.bd.model.common.PageInfo;
import com.bd.model.req.BoardSearchDTO;
import com.bd.model.res.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public CommonResponse selectBoardList(BoardSearchDTO boardSearchDTO) {
		
		//header 영역
		CommonHeader header = new CommonHeader("200", "ok", "");
		
		//response 영역
		int boardListCnt = boardMapper.selectBoardListCount(boardSearchDTO);
		List<BoardDTO> boardList = boardMapper.selectBoardList(boardSearchDTO);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("list", boardList);

		PageInfo pageInfo = boardSearchDTO.getPageInfo();
		pageInfo.setResultCount(boardList.size());
		pageInfo.setTotalCount(boardListCnt);
		body.put("pageInfo", pageInfo);
		
		return new CommonResponse(header, body);
	}

	@Override
	public CommonResponse selectBoard(Long boardNo) {
		//header 영역
		CommonHeader header = new CommonHeader("200", "ok", "");
		
		//response 영역
		BoardDTO boardDTO = boardMapper.selectBoardByBoardNo(boardNo);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("value", boardDTO);
		
		return new CommonResponse(header, body);
	}

}
