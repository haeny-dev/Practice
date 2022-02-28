package inflearn.thejava.annotationprocessor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void getterSetter() {
        Member member = new Member();
        member.setName("haeny");

        assertThat(member.getName()).isEqualTo("haeny");
    }

}