package com.haeny.spock.api.member.repository

import com.haeny.spock.api.member.entity.Member
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class MemberRepositoryTest extends Specification {

    @Autowired
    MemberRepository memberRepository

    MemberRepository memberRepositoryStub = Stub()

    def setup() {
        memberRepository.save(Member.builder().name("haeny").build())
        memberRepository.save(Member.builder().name("haeny1").build())
        memberRepository.save(Member.builder().name("haeny2").build())
    }

    def cleanup() {
        memberRepository.deleteAll()
    }

    def "findAll 전체 Member가 조회된다"() {
        when:
        List<Member> members = memberRepository.findAll()

        then:
        members.size() == 3
        members.get(0).name == "haeny"
    }

    /**
     * Stub 객체 사용
     */
    def "memberRepositoryStub 기본 사용"() {
        given:
        memberRepositoryStub.count() >> 5

        when:
        long count = memberRepositoryStub.count()

        then:
        count == 5
    }

    def "memberRepositoryStub SideEffect 설정"() {
        given:
        memberRepositoryStub.findById(_) >> {
            throw new IllegalArgumentException()
        }

        when:
        memberRepositoryStub.findById(_)

        then:
        thrown(IllegalArgumentException.class)
    }

    def "memberRepositoryStub 호출 횟수에 따른 값 설정"() {
        given:
        memberRepositoryStub.count() >>> [1, 2, 3]

        expect:
        memberRepositoryStub.count() == 1
        memberRepositoryStub.count() == 2
        memberRepositoryStub.count() == 3
    }

    def "memberRepositoryStub 파라미터에 따른 값 설정"() {
        given:
        memberRepositoryStub.findById(1L) >> Optional.ofNullable(new Member("첫째"))
        memberRepositoryStub.findById(2L) >> Optional.ofNullable(new Member("둘째"))
        memberRepositoryStub.findById(3L) >> Optional.ofNullable(new Member("셋째"))

        expect:
        memberRepositoryStub.findById(id).get().getName() == name

        where:
        id | name
        1L | "첫째"
        2L | "둘째"
        3L | "셋째"
    }

    def "memberRepositoryStub 파라미터 검증"() {
        given:
        memberRepositoryStub.findById({ Long id -> id == null }) >> {
            throw new IllegalArgumentException()
        }

        memberRepositoryStub.findById({ Long id -> id >= 1L }) >> {
            return Optional.ofNullable(new Member("첫째"))
        }

        when:
        memberRepositoryStub.findById(null)

        then:
        thrown(IllegalArgumentException.class)

        when:
        String name = memberRepositoryStub.findById(1L).get().getName()

        then:
        name == "첫째"
    }
}
