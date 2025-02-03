package bk.gwtproj.client.gwtwidgets;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;

public class GwtButton {

	public interface ButtonClickHandler {
		public void buttonClicked(int requestCode, String buttonData);
	}

	public enum ButtonStyle { PUSH_BUTTON, LINK, MDC }
	
	private String textHtml;
	private HTML iconHtml;
	private String buttonText;
	private String iconName;
	private GwtHorizontalPanel container;
	private int requestCode;
	private Object caller;
	private int width = 0;
	private int height = 20; 
	private boolean isEnabled = true;
	private boolean isReversedColors = false;
	private String iconColor = null;
	private String buttonData = null;
	
	private ButtonStyle buttonStyle = ButtonStyle.MDC;
	
	public GwtButton(String text, String iconName, final int requestCode, final Object caller) {
		this.buttonText = text;
		this.iconName = iconName;
		this.requestCode = requestCode;
		this.caller = caller;
		container = new GwtHorizontalPanel();
	}
	
	private void setText() {
		if (buttonText == null || "".equals(buttonText)) {
			textHtml = null;
		}
		else {
			int fontSize = 14;
			String fontWeight = "500";
			double letterSpacing = 1.25;
			
			String floatVal = iconName == null || "".equals(iconName) ? "" : "float: left;";
			String marginVal = iconName == null || "".equals(iconName) ? "" : "margin: 2px 0px 0px 10px;";
			
			textHtml = "<span style=\"font-family:Open Sans; "
					+ "font-size:" + fontSize + "px; "
					+ "font-weight: " + fontWeight + "; "
					+ "letter-spacing: " + letterSpacing + "px; "
					+ "vertical-align:middle; " + floatVal + marginVal + "\">" + buttonText + "</span>";
		}
	}
		
	private void createPushButton() {
		PushButton button = new PushButton();
		button.getElement().getStyle().setProperty("borderRadius", "5px");
		button.getElement().getStyle().setProperty("fontFamily", "Open Sans");
		button.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		button.getElement().getStyle().setFloat(Float.LEFT);
		button.setEnabled(isEnabled);
		
		if (width != 0) {
			button.setWidth(width + "px");
		}
		
		if (height != 0) {
			button.setHeight(height + "px");
		}
		
		button.getElement().setInnerHTML("");
		setText();
				
		String html = "<span>";
		html += iconHtml != null ? iconHtml.getHTML() : "";
		html += textHtml != null ? textHtml : "";
		html += "</span>";
		
		button.getElement().setInnerHTML(html);

		container.getPanel().clear();
		container.add(button);
		
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				((ButtonClickHandler) caller).buttonClicked(requestCode, buttonData);
			}
		});
	}
	
	private void createLinkButton() {
		int containerHeight = 20;
		int labelHeight = 18; 	// containerHeight - padding

		container.getPanel().clear();
		container.withHeight(containerHeight);
		container.withPadding(1, 5, 1, 5);
		container.withBackground("#FFF");
		Label buttonLabel = new GwtLabel(buttonText)
				.withHeight(labelHeight)
				.withColor("#00F")
				.inBold()
				.withCursor(Cursor.POINTER)
				.getLabel();
		container.add(buttonLabel);

		buttonLabel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				((ButtonClickHandler) caller).buttonClicked(requestCode, buttonData);
			}
		});
	}
	
	private void createMDCButton() {
		container.getPanel().clear();
		String state = isEnabled ? "" : "disabled";
		
		String bgColor = isReversedColors ? "#FFF" : "#033A6D";
		bgColor += isEnabled ? "" : "05";
		
		String color = isReversedColors ? "#033A6D" : "#FFF";
		String fontWeight = isReversedColors ? "bold" : "normal";
		
		String htmlStr = "<button class=\"mdc-button\" " + state;
		htmlStr += " style=\"background-color:" + bgColor + "; color: " + color + "; font-weight: " + fontWeight + "; cursor: pointer; ";
		
		width = height = 16;
		
		if (width != 0) {
			htmlStr += " width: " + width + "px;";
		}
		
		if (height != 0) {
			htmlStr += " height: " + height + "px;";
		}
				
		htmlStr += "\">";
		htmlStr += "<div class=\"mdc-button__ripple\"></div>";
		
		if (iconName != null) {
			htmlStr += "<i class=\"material-icons-outlined mdc-button_icon\" aria-hidden=\"true\">" + iconName + "</i>";
		}
		
		if (buttonText != null && ! buttonText.isEmpty()) {
			String marginStr = iconName == null ? "" : "style='margin-left:5px;'";
			htmlStr += "<span class=\"mdc-button__label\"" + marginStr + ">" + buttonText + "</span>";
		}
		
		htmlStr += "</button>";
		
		String colorAttr = iconColor != null ? "color: " + iconColor : "";
		htmlStr = "<span class='material-icons-outlined' style='cursor: pointer; " + colorAttr + "'>"
				+ iconName
				+ "</span>";
		
		HTML buttonHtml = new HTML(htmlStr);
		buttonHtml.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (isEnabled) {
					((ButtonClickHandler) caller).buttonClicked(requestCode, buttonData);
				}
			}
		});
		
		container.add(buttonHtml);
	}
		
	public HorizontalPanel getButton() {
		switch(buttonStyle) {
		case PUSH_BUTTON:
			createPushButton();
			break;
			
		case LINK:
			createLinkButton();
			break;
			
		case MDC:
			createMDCButton();
			break;
		}

		return container.getPanel();
	}
	
	public GwtButton withStyle(ButtonStyle buttonStyle) {
		this.buttonStyle = buttonStyle;
		return this;
	}
	
	public GwtButton withWidth(int widthInPx) {
		width = widthInPx;
		return this;
	}
	
	@Deprecated
	public GwtButton withHeight(int heightInPx) {
		height = heightInPx;
		return this;
	}
	
	public GwtButton withText(String text) {
		buttonText = text;
		return this;
	}
	
	/**
	 * Removes icon and centers the label in the button
	 */
	public GwtButton withCenteredText() {
		iconName = null;
		return this;
	}
		
	public GwtButton withFloat(Float value) {
		container.withFloat(value);
		return this;
	}
	
	public GwtButton asEnabled(boolean enabledState) {
		isEnabled = enabledState;
		getButton();
		return this;
	}
	
	public GwtButton withMargin(int top, int right, int bottom, int left) {
		container.withMargin(top, right, bottom, left);
		return this;
	}
	
	public GwtButton withToolTip(String toolTip) {
		container.getPanel().setTitle(toolTip);
		return this;
	}
	
	public GwtButton withVisibility(boolean visible) {
		container.withVisibility(visible);
		return this;
	}
	
	public GwtButton withReversedColors(boolean value) {
		isReversedColors = value;
		return this;
	}
	
	public GwtButton withColor(String color) {
		iconColor = color;
		return this;
	}
	
	public GwtButton withButtonData(String data) {
		buttonData = data;
		return this;
	}
}
