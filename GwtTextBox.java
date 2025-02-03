package bk.gwtproj.client.gwtwidgets;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtTextBox {

	private TextBox textBox;
	private VerticalPanel titleAndFieldLayout = null;
	private GwtLabel titleLabel = null;
	
	public GwtTextBox() {
		textBox = new TextBox();
		withWidth(100);
		withHeight(20);
		withProperty("borderRadius", "3px");
		withProperty("border", "1px solid #ccc");
	}
	
	public TextBox getTextBox() {
		return textBox;
	}
	
	public VerticalPanel getTextBoxWithTitle() {
		if (titleAndFieldLayout == null) {
			titleAndFieldLayout = new VerticalPanel();
			titleAndFieldLayout.add(textBox);
		}
		return titleAndFieldLayout;
	}
	
	public GwtTextBox withText(String text) {
		textBox.setText(text);
		return this;
	}
	
	public GwtTextBox withWidth(int widthInPx) {
		textBox.setWidth(widthInPx + "px");
		return this;
	}
	
	public GwtTextBox withHeight(int heightInPx) {
		textBox.setHeight(heightInPx + "px");
		return this;
	}
	
	public GwtTextBox withFontSize(int fontSizeInPx) {
		textBox.getElement().getStyle().setFontSize(fontSizeInPx, Unit.PX);
		return this;
	}
	
	public GwtTextBox withPlaceholder(String placeholder) {
		textBox.getElement().setPropertyString("placeholder", placeholder);
		return this;
	}
	
	public GwtTextBox withOutline(String outline) {
		textBox.getElement().getStyle().setProperty("outline", outline);
		return this;
	}
	
	public GwtTextBox withCenterAlignText() {
		textBox.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		return this;
	}
	
	public GwtTextBox asPasswordField() {
		textBox.getElement().setAttribute("type", "password");
		return this;
	}
	
	public GwtTextBox asNumberField(final boolean allowNegativeNumber) {
		textBox.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				String ch = String.valueOf(event.getCharCode());
				if (ch.matches("[0-9]")) {
					;
				}
				else if (allowNegativeNumber && textBox.getText().trim().equals("") && ch.equals("-")) {
					; // allow 
				}
				else {
					textBox.cancelKey();
				}
			}
		});
		return this;
	}
	
	public GwtTextBox withTitle(String title) {
		titleAndFieldLayout = new VerticalPanel();
		titleLabel = new GwtLabel(title).withFontSize(12);
		titleAndFieldLayout.add(titleLabel.getLabel());
		titleAndFieldLayout.add(textBox);
		return this;
	}
	
	public GwtTextBox withTitleColor(String color) {
		titleLabel.withColor(color);
		return this;
	}
	
	public GwtTextBox asEnabled(boolean enabled) {
		textBox.setEnabled(enabled);
		return this;
	}
	
	public GwtTextBox withMargin(int top, int right, int bottom, int left) {
		textBox.getElement().getStyle().setProperty("margin", top + "px " + right + "px " + bottom + "px " + left + "px");
		return this;
	}

	public GwtTextBox withLayoutMargin(int top, int right, int bottom, int left) {
		titleAndFieldLayout.getElement().getStyle().setProperty("margin", top + "px " + right + "px " + bottom + "px " + left + "px");
		return this;
	}
	
	public GwtTextBox withTextBoxFloat(Float value) {
		textBox.getElement().getStyle().setFloat(value);
		return this;
	}
	
	public GwtTextBox withLayoutFloat(Float value) {
		titleAndFieldLayout.getElement().getStyle().setFloat(value);
		return this;
	}
	
	public GwtTextBox withProperty(String propertyName, String propertyValue) {
		textBox.getElement().getStyle().setProperty(propertyName, propertyValue);
		return this;
	}
	
	public GwtTextBox withVisibility(boolean visible) {
		textBox.setVisible(visible);
		
		if (titleAndFieldLayout != null) {
			titleAndFieldLayout.setVisible(visible);
		}
		return this;
	}
	
	public GwtTextBox withLayoutVisibility(boolean visible) {
		titleAndFieldLayout.setVisible(visible);
		return this;
	}
}
