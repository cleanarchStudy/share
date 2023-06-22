package com.example.adpexamplebanservice.interactor;

import com.example.adpexamplebanservice.authorizer.SessionConst;
import com.example.adpexamplebanservice.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final HttpSession session;
    private final UserRepository userRepository;

    @Autowired
    public LoginService(HttpSession session, UserRepository userRepository) {
        this.session = session;
        this.userRepository = userRepository;
    }

    public Long login(LoginCommand command){
        User user = userRepository.findByEmail(command.email())
                .orElseThrow(RuntimeException::new);

        if (!user.getPassword().equals(command.password())) throw new RuntimeException();

        AuthorizedUser authorizedUser = AuthorizedUser.from(user);
        session.setAttribute(SessionConst.LOGIN_MEMBER, authorizedUser);

        return user.getId();
    }
}
