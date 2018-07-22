package service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloService {
  public String xinchao(String input) {
    return "HELLO: " + input.toUpperCase();
  }
}
