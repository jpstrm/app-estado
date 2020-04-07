package br.com.state.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author João Paulo Santarém
 */
@ApiIgnore
@Controller
public class HomeController {

  @Value("${app.homepage}")
  private String homePageFile;

  @RequestMapping(value = "/**/{[path:[^\\.]*}")
  public String redirect() {
    return "forward:/";
  }

  @GetMapping("/")
  public String homePage() {

    return homePageFile;
  }

}
