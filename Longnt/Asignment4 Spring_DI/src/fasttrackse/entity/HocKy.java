package fasttrackse.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Prototype")
public interface HocKy {
public String getHocKy();
}
