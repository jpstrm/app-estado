package br.com.estado.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author João Paulo Santarém
 */
@ApiIgnore
@Controller
public class HomeController {

  @Value("${app.homepage}")
  private String homePageFile;

  @GetMapping("/")
  public String homePage() {

    return homePageFile;
  }

}
