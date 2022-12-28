package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {

	@Autowired
	private MemberDao memberDao;

	/*
	 * 의존 객체 주입을 위해서 만들었던 setter 메서드는 더 이상 필요가 없음 
	 * public void setMemberDao(MemberDao * memberDao) { this.memberDao = memberDao; }
	 */

	public void changePassword(String email, String oldPassword, String newPassword) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}

		member.changePassword(oldPassword, newPassword);
		memberDao.update(member);
	}
}
