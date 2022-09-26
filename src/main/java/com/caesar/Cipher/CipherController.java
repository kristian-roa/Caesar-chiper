package com.caesar.Cipher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CipherController {

    @GetMapping("/cipher")
    public String cipherForm(Model model) {
        model.addAttribute("cipher", new Cipher());
        return "cipher";
    }

    @PostMapping("/cipher")
    public String cipherSubmit(@ModelAttribute Cipher cipher, Model model) {
        model.addAttribute("cipher", cipher);
        return "result";
    }
}
