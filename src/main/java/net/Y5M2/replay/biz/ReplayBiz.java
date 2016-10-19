package net.Y5M2.replay.biz;

import java.util.List;

import net.Y5M2.replay.vo.ReplayVO;

public interface ReplayBiz {

	public boolean writeReplay(ReplayVO replays);
	
	public List<ReplayVO> getListReplays(String boardId);
	
	public boolean deleteOneReplay(ReplayVO replays);
	
	public boolean replayModify(ReplayVO replays);

	public ReplayVO getReplyAt(String replyId);
}
