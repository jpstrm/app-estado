package br.com.state.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("documentation")
public class DocumentationConfig {

  private Info info = new Info();
  private String version;
  private String basePackage;

  public DocumentationConfig() {}

  Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  String getBasePackage() {
    return basePackage;
  }

  public void setBasePackage(String basePackage) {
    this.basePackage = basePackage;
  }

  public class Info {
    private String title;
    private String description;

    Info() {
    }

    String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

  }
}
