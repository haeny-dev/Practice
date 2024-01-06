package com.haeny.spock.api.member.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.haeny.spock.api.member.entity.Member;
import com.haeny.spock.api.member.repository.MemberRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberServiceJUnitTest {

    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    MemberService memberService;

    @Test
    void MemberID로_회원이름_조회() {
        // given
        long id = 1L;
        given(memberRepository.findById(any()))
            .willReturn(Optional.ofNullable(new Member("haeny")));

        // when
        String name = memberService.getMemberName(id);

        // then
        assertThat(name).isEqualTo("haeny");
    }

}