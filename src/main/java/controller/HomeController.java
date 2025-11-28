package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/author"; // Khi truy cập localhost:8080 sẽ vào danh sách tác giả
    }
}
