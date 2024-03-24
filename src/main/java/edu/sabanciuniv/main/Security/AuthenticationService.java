package edu.sabanciuniv.main.Security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "HEADER_NAME";
    private static final String AUTH_TOKEN = "123123ABCABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);

        String path = request.getRequestURI();
        // Allow unauthenticated access to the /hello path
        if (path.startsWith("/hello") || path.startsWith("/docs")) {
            return new ApiKeyAuthentication(null, AuthorityUtils.NO_AUTHORITIES);
        }

        if (path.startsWith("/swagger-ui.html") || path.startsWith("/v3/api-docs ")) {
            return new ApiKeyAuthentication(null, AuthorityUtils.NO_AUTHORITIES);
        }


        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
