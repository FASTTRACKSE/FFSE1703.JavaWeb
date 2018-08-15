package com.jsf.crud;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class LanguageBean {
	private String locale;

	private final static Locale LOCALE_EN = new Locale("en", "US");
	private final static Locale LOCALE_VI = new Locale("vi", "VN");
	private final static Locale LOCALE_JP = new Locale("ja", "JP");

	private static Map<String, Object> countries;

	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", LOCALE_EN);
		countries.put("Vietnamese", LOCALE_VI);
		countries.put("Japanese", LOCALE_JP);
	}

	public void setLanguage(String theLocale) {
		for (Map.Entry<String, Object> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(theLocale)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
			}
		}
	}

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale().toString();
		setLanguage(locale);
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

	// value change event listener
	public void localeChanged(ValueChangeEvent e) {
		String newLocaleValue = e.getNewValue().toString();
		setLanguage(newLocaleValue);
	}
}