package com.haeny.spock.api.member.service

import com.haeny.spock.api.member.entity.Member
import com.haeny.spock.api.member.repository.MemberRepository
import com.haeny.spock.api.member.repository.MemberRepositoryTest
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.any
import static org.mockito.BDDMockito.given

@DataJpaTest
class MemberServiceTest extends Specification {

    /**
     * Mockito 사용
     */
    @Mock
    MemberRepository memberRepository

    @InjectMocks
    MemberService memberService

    def "Member ID로 회원이름 조회"() {
        given:
        long id = 1L
        given(this.memberRepository.findById(any()))
                .willReturn(Optional.ofNullable(new Member("haeny")))

        when:
        String name = memberService.getMemberName(id)

        then:
        name == "haeny"
    }

    /**
     * Spock Mock 사용
     */
    def "MemberService의 find 호출 시 mockMemberRepository.findById 호출"() {
        given:
        long id = 1L
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberService = new MemberService(mockMemberRepository)

        when:
        memberService.find(id)

        then:
        1 * mockMemberRepository.findById(_)
    }

    def "mockMemberRepository.findById 호출 회수 검증"() {
        given:
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberService = new MemberService(mockMemberRepository)

        when:
        memberService.find(1L)
        memberService.find(2L)
        memberService.find(3L)

        then:
        (1..3) * mockMemberRepository.findById(_)
        (_..2) * mockMemberRepository.findById(_)
    }

    def "mockMemberRepository 메소드 실행순서 상관없이 검증이 된다"() {
        given:
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberService = new MemberService(mockMemberRepository)

        when:
        memberService.save(new Member("첫째"))

//        then:
//        1 * mockMemberRepository.save(_)
//        1 * mockMemberRepository.findById(_)

        // then 블록이 하나의 경우 순서에 상관없이 검증이 된다.
        then:
        1 * mockMemberRepository.findById(_)
        1 * mockMemberRepository.save(_)
    }

    def "mockMemberRepository 메소드 실행 순서대로 검증할 수 있다"() {
        given:
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberService = new MemberService(mockMemberRepository)

        when:
        memberService.save(new Member("첫째"))

        then:
        1 * mockMemberRepository.save(_)

        then:
        1 * mockMemberRepository.findById(_)
    }

    def "mockMemberRepository 를 통한 Stubbing 시 실패"() {
        given:
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberService = new MemberService(mockMemberRepository)

        mockMemberRepository.findById(_) >> Optional.ofNullable(new Member("첫째"))

        when:
        Member findMember = memberService.find(1L).get()

        then:
        thrown(NullPointerException.class)
        1 * mockMemberRepository.findById(_)
    }

    def "mockMemberRepository 를 통한 Stubbing 시 성공"() {
        given:
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberService = new MemberService(mockMemberRepository)

        when:
        Member findMember = memberService.find(1L).get()

        then:
        findMember.getName() == "첫째"
        1 * mockMemberRepository.findById(_) >> Optional.ofNullable(new Member("첫째"))
    }

    /* Mock vs Stub */
    def "Mock 사용 시 반환값 + 호출횟수 확인 정상실행 되지않음"() {
        given:
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberSevice = new MemberService(mockMemberRepository)
        mockMemberRepository.findById(_) >> Optional.ofNullable(new Member("첫째"))

        when:
        Member findMember = memberSevice.find(1L).get()

        then:
        findMember.getName() == "첫째"
        1 * mockMemberRepository.findById(_)
    }

    def "Mock 사용 시 반환값만 확인 정상실행"() {
        given:
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberSevice = new MemberService(mockMemberRepository)
        mockMemberRepository.findById(_) >> Optional.ofNullable(new Member("첫째"))

        when:
        Member findMember = memberSevice.find(1L).get()

        then:
        findMember.getName() == "첫째"
    }

    def "Mock 사용 시 호출횟수만 확인 정상실행"() {
        given:
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberSevice = new MemberService(mockMemberRepository)

        when:
        memberSevice.find(1L)

        then:
        1 * mockMemberRepository.findById(_)
    }

    def "Stub 사용 시 반환값 + 호출횟수 확인 정상실행 되지않음"() {
        given:
        MemberService stubMemberService = Stub(MemberService.class)
        stubMemberService.find(_) >> Optional.ofNullable(new Member("첫째"))

        when:
        Member findMember = stubMemberService.find(1L).get()

        then:
        findMember.getName() == "첫째"
        1 * stubMemberService.find(_)
    }

    def "Stub 사용 시 반환값 확인 정상실행"() {
        given:
        MemberService stubMemberService = Stub(MemberService.class)
        stubMemberService.find(_) >> Optional.ofNullable(new Member("첫째"))

        when:
        Member findMember = stubMemberService.find(1L).get()

        then:
        findMember.getName() == "첫째"
    }

    def "Spy는 래퍼이므로 interface를 이용하여 생성하지 않는다"() {
        given:
        List spy = Spy(List.class)

        expect:
        spy.isEmpty()
    }

    def "Spy는 실제 존재하는 객체를 이용해서 생성한다"() {
        given:
        List list = new ArrayList()
        List spy = Spy(list)
        spy.isEmpty() >> false

        expect:
        !spy.isEmpty()
    }


}
