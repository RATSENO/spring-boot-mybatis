package com.bd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.dao.BoardMapper;
import com.bd.model.req.BoardSearchDTO;
import com.bd.model.res.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<BoardDTO> selectBoardList(BoardSearchDTO boardSearchDTO) {
		return boardMapper.selectBoardList(boardSearchDTO);
	}

	@Override
	public BoardDTO selectBoard(Long boardNo) {
		return boardMapper.selectBoardByBoardNo(boardNo);
	}

}
