package com.haeny.spock.api.member.repository;

import com.haeny.spock.api.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
