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

}
