package com.itstudy.studyboot.controller;

import com.itstudy.studyboot.dto.AccessTokenDto;
import com.itstudy.studyboot.dto.GithubUser;
import com.itstudy.studyboot.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(
            @RequestParam(name="code") String code,
            @RequestParam(name="state") String state
    ) {
        //封装相关信息 提交code获取token
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setRedirect_uri(redirectUri);

        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        //提交token获取用户相关信息
        GithubUser githubUser = gitHubProvider.getGithubUser(accessToken);
        System.out.println(githubUser);
        return "index";
    }
}
