package com.haeny.spock.api.member.repository;

import static org.assertj.core.api.Assertions.*;

import com.haeny.spock.api.member.entity.Member;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryJUnitTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository.save(Member.builder().name("haeny").build());
        memberRepository.save(Member.builder().name("haeny1").build());
        memberRepository.save(Member.builder().name("haeny2").build());
    }

    @AfterEach
    void afterEach() {
        memberRepository.deleteAll();
    }

    @Test
    void findAll_전체_Member가_조회된다 () {
        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members.size()).isEqualTo(3);
        assertThat(members.get(0).getName()).isEqualTo("haeny");
    }

}