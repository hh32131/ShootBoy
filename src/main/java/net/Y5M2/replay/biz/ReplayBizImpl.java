package net.Y5M2.replay.biz;

import java.util.List;

import net.Y5M2.article.dao.BoardDao;
import net.Y5M2.article.dao.BoardDaoImpl;
import net.Y5M2.replay.dao.ReplayDao;
import net.Y5M2.replay.dao.ReplayDaoImpl;
import net.Y5M2.replay.vo.ReplayVO;

public class ReplayBizImpl implements ReplayBiz {

	private ReplayDao replayDao;
	private	 BoardDao boardDao;

	public ReplayBizImpl() {
		replayDao = new ReplayDaoImpl();
		boardDao = new BoardDaoImpl();
	}

	@Override
	public boolean writeReplay(ReplayVO replays) {
		replayDao.replayHitCount(1);
		
		return replayDao.writeReplay(replays) > 0;
	}

	@Override
	public List<ReplayVO> getListReplays(String boardId) {
		return replayDao.getListReplays(boardId);
	}

	@Override
	public boolean deleteOneReplay(String replayId) {
		replayDao.replayHitCount(-1);
		
		return replayDao.deleteOneReplay(replayId) > 0 ;
	}

	@Override
	public boolean replayModify(ReplayVO replays) {
		int modifyCount = 1;
		ReplayVO originalReply = replayDao.getReplyAt(replays.getReplayId());
		if(originalReply.getReplayContent().equals(replays.getReplayContent())){
			replays.setReplayContent(null);
			modifyCount--;
		}
		if(modifyCount==0){
			return true;
		}
		
		
		
		return replayDao.replayModify(replays) > 0;
	}
	
	@Override
	public ReplayVO getReplyAt(String replyId) {
		
		return replayDao.getReplyAt(replyId);
	}

}
