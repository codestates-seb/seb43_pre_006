package com.codestates.PreProject.helper.event;

import com.codestates.PreProject.member.entity.Member;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MemberRegistrationApplicationEvent extends ApplicationEvent {

    private Member member;
    public MemberRegistrationApplicationEvent(Object source,Member member){
        super(source);
        this.member = member;
    }
}
