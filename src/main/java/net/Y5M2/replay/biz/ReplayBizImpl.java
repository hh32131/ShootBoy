package net.Y5M2.replay.biz;

import java.util.List;

import net.Y5M2.replay.dao.ReplayDao;
import net.Y5M2.replay.dao.ReplayDaoImpl;
import net.Y5M2.replay.vo.ReplayVO;

public class ReplayBizImpl implements ReplayBiz {

	private ReplayDao replayDao;

	public ReplayBizImpl() {
		replayDao = new ReplayDaoImpl();
	}

	@Override
	public boolean writeReplay(ReplayVO replays) {
		replayDao.replayHitCount();
		return replayDao.writeReplay(replays) > 0;
	}

	@Override
	public List<ReplayVO> getListReplays(String boardId) {
		return replayDao.getListReplays(boardId);
	}

	@Override
	public boolean deleteOneReplay(String replayId) {
		return replayDao.deleteOneReplay(replayId) > 0 ;
	}

}
