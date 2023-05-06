package org.koreait.board.controllers.commons;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @Autowired
    private HttpServletResponse response;

    @RequestMapping("/401")
    public String error401() throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"접근 권한이 없습니다.");

        return "error/401";
    }
}
