package net.Y5M2.replay.dao;

import java.util.List;

import net.Y5M2.replay.vo.ReplayVO;

public interface ReplayDao {

	public int writeReplay(ReplayVO replays);
	
	public List<ReplayVO> getListReplays(String boardId);
	
	public int replayHitCount();
	
	public int deletAllReplay(String boardId);
}
