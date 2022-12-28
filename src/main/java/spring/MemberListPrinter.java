package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// 모든 멤버 정보를 조회해서,	=> MemberDao
// 멤버 하나 하나의 정보를 출력	=> MemberPrinter
public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	@Qualifier("printer") 	// 한정값이 printer인 빈을 의존 주입 후보로 사용
							// 자동 주입 대상으로 memberPrinter1을 사용
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	public MemberListPrinter() {

	}

	// 의존 객체를 생성자를 통해서 주입
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}

	// 모든 멤버 정보를 출력하는 메서드를 저으이
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();

		// members.forEach(m -> printer.print(m));
		// ~~~~~~~~~~~~~~~~~~~~~
		// 람다식
		for (Member member : members) {
			printer.print(member);
		}
	}
}
