package bk.gwtproj.client.gwtwidgets;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

public class GwtLabel {

	private Label label;
	private String title = null;
	private String text = null;
	
	public GwtLabel(String text) {
		this.text = text;
		label = new Label(text);
		label.getElement().getStyle().setProperty("fontFamily", "Open Sans");
		label.getElement().getStyle().setFontSize(16, Unit.PX);
	}
	
	public GwtLabel(String label, String value) {
		this.title = label;
		this.text = value;
		this.label = new Label("");
		this.label.getElement().getStyle().setProperty("fontFamily", "Open Sans");
		this.label.getElement().setInnerHTML("<font style=\"color:#777; font-size:12px\">" + title + ": </font><font style=\"color:#000; font-size:14px\">" + text + "</font>");
	}
	
	public Label getLabel() {
		return label;
	}
	
	public GwtLabel withWidth(int widthInPx) {
		label.setWidth(widthInPx + "px");
		return this;
	}
	
	public GwtLabel withHeight(int heightInPx) {
		label.setHeight(heightInPx + "px");
		return this;
	}
	
	public GwtLabel withMargin(int top, int right, int bottom, int left) {
		label.getElement().getStyle().setProperty("margin", top + "px " + right + "px " + bottom + "px " + left + "px");
		return this;
	}
	
	public GwtLabel withPadding(int top, int right, int bottom, int left) {
		label.getElement().getStyle().setProperty("padding", top + "px " + right + "px " + bottom + "px " + left + "px");
		return this;
	}

	public GwtLabel withFontSize(int sizeInPx) {
		label.getElement().getStyle().setFontSize(sizeInPx, Unit.PX);
		return this;
	}
	
	public GwtLabel withText(String text) {
		label.setText(text);
		return this;
	}
	
	public GwtLabel withTextAlign(TextAlign textAlign) {
		label.getElement().getStyle().setTextAlign(textAlign);
		return this;
	}
	
	public GwtLabel withColor(String color) {
		label.getElement().getStyle().setColor(color);
		return this;
	}
	
	public GwtLabel withCursor(Cursor cursor) {
		label.getElement().getStyle().setCursor(cursor);
		return this;
	}
	
	public GwtLabel withBackground(String rgb) {
		label.getElement().getStyle().setBackgroundColor(rgb);
		return this;
	}
	
	public GwtLabel withFloat(Float floatVal) {
		label.getElement().getStyle().setFloat(floatVal);
		return this;
	}
	
	public GwtLabel inBold() {
		label.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		return this;
	}
	
	public GwtLabel inNormalWeight() {
		label.getElement().getStyle().setFontWeight(FontWeight.NORMAL);
		return this;
	}
	
	public GwtLabel withVisibility(boolean visibility) {
		label.setVisible(visibility);
		return this;
	}
	
	public GwtLabel withToolTip(String toolTip) {
		label.setTitle(toolTip);
		return this;
	}
	
	public GwtLabel withProperty(String propertyName, String propertyValue) {
		label.getElement().getStyle().setProperty(propertyName, propertyValue);
		return this;
	}
	
	public GwtLabel withNoWrap() {
		withProperty("overflow", "hidden");
		return this;
	}
	
	public GwtLabel withHTML(HTML html) {
		label.getElement().setInnerHTML(html.getHTML());
		return this;
	}
}
