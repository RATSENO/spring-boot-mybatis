package com.bd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bd.model.req.BoardSearchDTO;
import com.bd.model.res.BoardDTO;

@Mapper
public interface BoardMapper {
	
	public List<BoardDTO> selectBoardList(BoardSearchDTO boardSearchDTO);
	
	public int selectBoardListCount(BoardSearchDTO boardSearchDTO);
	
	public BoardDTO selectBoardByBoardNo(Long boardNo);
	
}
