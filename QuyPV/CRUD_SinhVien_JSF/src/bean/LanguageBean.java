package bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name= "languageBean")
@SessionScoped

public class LanguageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String locale;
	private final static Locale LOCALE_VI = new Locale("vi", "VN");
	private final static Locale LOCALE_EN = new Locale("en", "US");
	
	private static Map<String, Object> countries;
	
	static {
	    countries = new LinkedHashMap<String, Object>();
	    countries.put("English", LOCALE_EN);
	    countries.put("Vietnamese", LOCALE_VI);   
	  }
	public Map<String, Object> getCountries() {
	    return countries;
	  }

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public void localeChanged(ValueChangeEvent e) {
	    String newLocaleValue = e.getNewValue().toString();
	    for (Map.Entry<String, Object> entry : countries.entrySet()) {
	      if (entry.getValue().toString().equals(newLocaleValue)) {
	        FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
	      }
	    }
	  }
}
