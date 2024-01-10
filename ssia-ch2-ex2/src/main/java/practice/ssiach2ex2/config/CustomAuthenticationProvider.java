package practice.ssiach2ex2.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //인증 논리를 추가할 위치
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        if ("dolong".equals(username) && "1234".equals(password)/* 실제 사용할땐 passwordEncoder로 검증 */)
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        else
            throw new AuthenticationCredentialsNotFoundException("Error in authentication");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }
}
