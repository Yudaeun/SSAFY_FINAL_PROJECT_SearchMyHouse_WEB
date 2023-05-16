package com.ssafy.myhouse.security;

import com.ssafy.myhouse.vo.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class SecurityMember implements UserDetails {
    private final Member member;

    public SecurityMember(Member member) {
        this.member = member;
    }

    //해당 User의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add((GrantedAuthority) () -> member.getRole());
        return collect;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }



    @Override
    public String getUsername() {
        return member.getUserId();
    }

    public int getId(){
        return member.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
