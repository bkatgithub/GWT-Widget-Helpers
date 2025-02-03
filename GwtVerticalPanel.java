package bk.gwtproj.client.gwtwidgets;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class GwtVerticalPanel {

	private VerticalPanel verticalPanel;
	
	public GwtVerticalPanel() {
		verticalPanel = new VerticalPanel();
		verticalPanel.getElement().getStyle().setProperty("boxSizing", "border-box");
	}
	
	public VerticalPanel getPanel() {
		return verticalPanel;
	}
	
	public GwtVerticalPanel withWidth(int width) {
		verticalPanel.setWidth(width + "px");
		return this;
	}
	
	public GwtVerticalPanel withHeight(int height) {
		verticalPanel.setHeight(height + "px");
		return this;
	}
	
	public GwtVerticalPanel withMargin(int top, int right, int bottom, int left) {
		verticalPanel.getElement().getStyle().setProperty("margin", top + "px " + right + "px " + bottom + "px " + left + "px");
		return this;
	}
	
	public GwtVerticalPanel withPadding(int top, int right, int bottom, int left) {
		verticalPanel.getElement().getStyle().setProperty("padding", top + "px " + right + "px " + bottom + "px " + left + "px");
		return this;
	}
	
	public GwtVerticalPanel withBackground(String rgb) {
		verticalPanel.getElement().getStyle().setBackgroundColor(rgb);
		return this;
	}
	
	public GwtVerticalPanel withVAlignMiddle(int height) {
		verticalPanel.setHeight(height + "px");
		verticalPanel.getElement().getStyle().setLineHeight(height, Unit.PX);
		verticalPanel.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
		return this;
	}
	
	public GwtVerticalPanel withOverflow(Overflow overflow) {
		verticalPanel.getElement().getStyle().setOverflow(overflow);
		return this;
	}
	
	public GwtVerticalPanel withFloat(Float value) {
		verticalPanel.getElement().getStyle().setFloat(value);
		return this;
	}
	
	public GwtVerticalPanel withVisibility(boolean visible) {
		verticalPanel.setVisible(visible);
		return this;
	}
	
	public GwtVerticalPanel withProperty(String propertyName, String propertyVal) {
		verticalPanel.getElement().getStyle().setProperty(propertyName, propertyVal);
		return this;
	}
	
	public GwtVerticalPanel withBorderRadius(int borderRadiusInPx) {
		verticalPanel.getElement().getStyle().setProperty("borderRadius", borderRadiusInPx + "px");
		return this;
	}
	
	public GwtVerticalPanel add(Widget... widgets) {
		for (Widget w : widgets) {
			verticalPanel.add(w);
		}
		return this;
	}
	
	public GwtVerticalPanel withCenterAlignContent() {
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		return this;
	}
	
	public GwtVerticalPanel withCenterAlign() {
		verticalPanel.getElement().getStyle().setMargin(0, Unit.PX);
		verticalPanel.getElement().getStyle().setPosition(Position.ABSOLUTE);
		verticalPanel.getElement().getStyle().setProperty("top", "50%");
		verticalPanel.getElement().getStyle().setProperty("left", "50%");
//		verticalPanel.getElement().getStyle().setProperty("-ms-transform", "translate(-50%, -50%)");
		verticalPanel.getElement().getStyle().setProperty("transform", "translate(-50%, -50%)");
		return this;
	}
}
