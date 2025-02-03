# GWT-Widget-Helpers

The following code sample shows how the GWT Widget Helper classes can be used
to create a login page using declarative format.

```Java
public class GWTProject implements EntryPoint, ButtonClickHandler {

	public void onModuleLoad() {
		GwtLabel headerLabel = new GwtLabel("GWT Widgets Demo")
				.withFontSize(24)
				.withColor("#333");
		
		GwtTextBox userName = new GwtTextBox()
				.withWidth(200)
				.withCenterAlignText()
				.withPlaceholder("User name")
				.withMargin(20, 0, 0, 0);
		
		GwtTextBox password = new GwtTextBox()
				.withWidth(200)
				.withCenterAlignText()
				.withPlaceholder("Password")
				.asPasswordField()
				.withMargin(10, 0, 0, 0);
		
		GwtButton loginButton = new GwtButton("Login", null, 0, this)
				.withWidth(200)
				.withCenteredText()
				.withMargin(20, 0, 0, 0)
				.withStyle(ButtonStyle.PUSH_BUTTON);
		
		GwtVerticalPanel vPanel = new GwtVerticalPanel()
				.withWidth(500)
				.withCenterAlignContent()
				.add(
						headerLabel.getLabel(),
						userName.getTextBox(),
						password.getTextBox(),
						loginButton.getButton()
				);
		
		RootPanel.get().add(vPanel.getPanel());
	}

	@Override
	public void buttonClicked(int requestCode, String buttonData) {
		// Callback when Login button is clicked
	}
}
 ```
