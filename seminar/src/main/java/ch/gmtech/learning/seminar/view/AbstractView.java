package ch.gmtech.learning.seminar.view;

public abstract class AbstractView {

	public String render() {
		return renderImpl();
	}
	
	abstract String renderImpl();
	
}
