package stackjava.service;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloService {
  public String convert(String input) {
    return input.toUpperCase();
  }
}
