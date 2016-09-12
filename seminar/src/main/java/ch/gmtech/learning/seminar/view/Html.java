package ch.gmtech.learning.seminar.view;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

public class Html extends AbstractView {

	private String _name;
	private String _value = "";
	
	private List<Html> _children = new ArrayList<Html>();
	
	String renderImpl() {
		String result = "";
		result += "<" + _name + ">";
		
		result += _value;
		
		for (Html tag : _children) {
			result += tag.render();
		}
		
		return result += "</" + _name + ">";
	}
	
	public Html html(Html... content) {
		return withTags("html", content);
	}
	
	public Html ul(Html... content) {
		return withTags("ul", content);
	}
	
	public Html head(Html... content) {
		return withTags("head", content);
	}
	
	public Html body(Html... content) {
		return withTags("body", content);
	}

	public Html title(String text) {
		return withText("title", text);
	}
	
	public Html div(String text) {
		return withText("div", text);
	}
	
	public Html li(String text) {
		return withText("li", text);
	}
	
	private Html withText(String name, String text) {
		_name = name;
		
		_value = text;
		
		return this;
	}
	
	private Html withTags(String name, Html... content) {
		_name = name;
		
		_children.addAll(asList(content));
		
		return this;
	}
}