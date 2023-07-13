/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-06 AM 11:47
 */

package com.example.auth.config;

//@Configuration
//public class WebSecurityConfig {
//    private final JwtTokenFilter jwtTokenFilter;
//    private final OAuth2SuccessHandler oAuth2SuccessHandler;
//    private final OAuth2UserServiceImpl oAuth2UserService;
//
//    public WebSecurityConfig(
//            JwtTokenFilter jwtTokenFilter,
//            OAuth2SuccessHandler oAuth2SuccessHandler,
//            OAuth2UserServiceImpl oAuth2UserService
//    ) {
//        this.jwtTokenFilter = jwtTokenFilter;
//        this.oAuth2SuccessHandler = oAuth2SuccessHandler;
//        this.oAuth2UserService = oAuth2UserService;
//    }
//
//    @Bean   //  메소드의 결과를 Bean 객체로 등록해주는 어노테이션
//    public SecurityFilterChain securityFilterChain(
//            //  DI 자동으로 설정됨
//            HttpSecurity http) throws Exception {
//        //  1. requestMathcers를 통해 설정할 URL 지정
//        //  2. permitAll(), authenticated() 등을 통해 어떤 사용자가 접근 가능한지 설정
//
//        http
//                //  CSRF: Cross Site Request Forgery
//                .csrf(AbstractHttpConfigurer::disable)
////                .authorizeHttpRequests(authHttp -> authHttp
////                        //  requestMatchers == 어떤 URL로 오는 요청에 대하여 설정하는지
////                        .requestMatchers("/no-auth", "/token/issue")
////                        //  permitAll() == 누가 요청해도 허가한다.
////                        .permitAll()
////                        .requestMatchers("/re-auth", "/users/my-profile")
////                        //  인증이 된 사용자만 허가
////                        .authenticated()
////                        .requestMatchers("/", "/users/register")
////                        //  인증이 되지 않은 사용자만 허가
////                        .anonymous())           //  HTTP 요청 허가 관련 설정을 하고 싶다.
//                .authorizeHttpRequests(
//                        authHttp -> authHttp
//                                .requestMatchers("/no-auth", "/users/login", "token/issue")
//                                .permitAll()
////                                .requestMatchers("/", "users/register")
////                                .anonymous()
//                                .anyRequest()
//                                .authenticated()
//                )
//                .oauth2Login(oauth2Login -> oauth2Login
//                        .loginPage("/view/login")
//                        .successHandler(oAuth2SuccessHandler)
//                        .userInfoEndpoint(userInfo -> userInfo
//                                .userService(oAuth2UserService)
//                        )
//                )
//                .sessionManagement(
//                        sessionManagement -> sessionManagement
//                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .addFilterBefore(
//                        jwtTokenFilter, AuthorizationFilter.class
//                )
//        ;
////                //  form을 이용한 로그인 관련 설정
////                .formLogin(formLogin -> formLogin
////                        //  로그인 하는 페이지(경로)를 지정
////                        .loginPage("/users/login")
////                        //  로그인 성공시 이동하는 페이지(경로)
////                        .defaultSuccessUrl("/users/my-profile")
////                        //  로그인 실패시 이동하는 페이지(경로)
////                        .failureUrl("/users/login?fail")
////                        //  로그인 과정에서 필요한 경로들을
////                        //  모든 사용자가 사용할 수 있게끔 권한설정
////                        .permitAll())
////                //  로그아웃 관련 설정
////                //  로그인 -> 쿠키를 통해 세션을 설정
////                //          아이디와 비밀번호
////                //  로그아웃 -> 세션을 제거
////                //         -> 세션 정보만 있으면 제거 가능
////                .logout(logout -> logout
////                        //  로그아웃 요청을 보낼 URL
////                        //  어떤 UI에 로그아웃 기능을 연결하고 싶으면
////                        //  해당 UI가 /users/logout으로 POST 요청을 보내게끔
////                        .logoutUrl("/users/logout")
////                        //  로그아웃 성공시 이동할 URL 설정
////                        .logoutSuccessUrl("/users/login")
////                )
////        ;
//
//        return http.build();
//    }
//
////    @Bean
////    //  사용자 관리를 위한 인터페이스 구현체 Bean
////    public UserDetailsManager userDetailsManager(
////            PasswordEncoder passwordEncoder
////    ) {
////        UserDetails user1 = User.withUsername("user1")
////                .password(passwordEncoder.encode("password"))
////                .build();
////        //  spring에서 미리 만들어놓은 사용자 인증 서비스
////        return new InMemoryUserDetailsManager(user1);
////    }
//
//    @Bean
//    //  3. 비밀번호 암호화를 위한 Bean
//    public PasswordEncoder passwordEncoder() {
//        //  기본적으로 사용자 비밀번호는 해독가능한 형태로 데이터베이스에 저장되면 안된다.
//        //  그래서 기본적으로 비밀번호를 단방향 암호화하는 인코더를 사용한다.
//        return new BCryptPasswordEncoder();
//    }
//}

import com.example.auth.jwt.JwtTokenFilter;
import com.example.auth.oauth.OAuth2SuccessHandler;
import com.example.auth.oauth.OAuth2UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class WebSecurityConfig {
    private final JwtTokenFilter jwtTokenFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final OAuth2UserServiceImpl oAuth2UserService;

    public WebSecurityConfig(
            JwtTokenFilter jwtTokenFilter,
            OAuth2SuccessHandler oAuth2SuccessHandler,
            OAuth2UserServiceImpl oAuth2UserService
    ) {
        this.jwtTokenFilter = jwtTokenFilter;
        this.oAuth2SuccessHandler = oAuth2SuccessHandler;
        this.oAuth2UserService = oAuth2UserService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authHttp -> authHttp
                        .requestMatchers("/token/**", "/views/**")
                        .permitAll()
                )
                .oauth2Login(oauth2Login -> oauth2Login
                        .loginPage("/views/login")
                        .successHandler(oAuth2SuccessHandler)
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(oAuth2UserService)
                        )
                )
                .sessionManagement(
                        sessionManagement -> sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtTokenFilter, AuthorizationFilter.class);


        return http.build();
    }

    //  1. OAuth2SuccessHandler는 UserDetailsManager를 필요하게 바뀌었다.
    //  2. UserDetailsManager는 WebSecurityConfig에 정의해둔 PasswordEncoder Bean 객체가 필요했다.
    //  3. WebSecurityConfig는 OAuth2SuccessHandler가 필요했다. (Circular Dependency)
    //  4. WebSecurityConfig에서 PasswordEncoder를 분리했다.
    //      -> UserDetailsManager는 더이상 WebSecurityConfig를 필요로 하지 않게 된다.
    //  5. Circular Dependency가 해소된다.
//    @Bean
//    // 비밀번호 암호화를 위한 Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}