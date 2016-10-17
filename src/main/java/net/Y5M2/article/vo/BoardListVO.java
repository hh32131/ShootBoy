package net.Y5M2.article.vo;

import java.util.List;

import net.Y5M2.support.pager.Pager;

public class BoardListVO {

	private List<BoardVO> boards;
	private Pager pager;

	public List<BoardVO> getBoards() {
		return boards;
	}

	public void setBoards(List<BoardVO> boards) {
		this.boards = boards;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
