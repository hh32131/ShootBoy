package net.Y5M2.user.vo;

import java.util.List;

import net.Y5M2.support.pager.Pager;

public class UserListVO {

	private List<UserVO> users;
	private Pager pager;

	public List<UserVO> getUsers() {
		return users;
	}

	public void setUsers(List<UserVO> users) {
		this.users = users;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
