package net.Y5M2.replay.dao;

import java.util.List;

import net.Y5M2.replay.vo.ReplayVO;

public interface ReplayDao {

	public int writeReplay(ReplayVO replays);
	
	public List<ReplayVO> getListReplays(String boardId);
	
	public int replayHitCount(int hitCount, ReplayVO replays);
	
	public int deletAllReplay(String boardId);
	
	public int deleteOneReplay(ReplayVO replays);
	
	public int replayModify(ReplayVO replays);

	public ReplayVO getReplyAt(String replyId);

}
