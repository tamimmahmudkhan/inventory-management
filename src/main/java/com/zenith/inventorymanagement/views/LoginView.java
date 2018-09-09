package com.zenith.inventorymanagement.views;

import javax.annotation.PostConstruct;

import com.sun.javafx.css.Style;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.ui.themes.ValoTheme;
import com.zenith.inventorymanagement.domain.Designation;

@UIScope
@Route(value="")
public class LoginView extends VerticalLayout
{

	private static final long serialVersionUID = 8398816963887429648L;

//	public static final String VIEW_NAME = "login";
	 
	TextField username;
	PasswordField password;
	Button loginButton;
	Label loginLabel;

	ComboBox<Designation> designation;

	@PostConstruct
	public void init () {
		
		setClassName(ValoTheme.MENU_ROOT);

		loginLabel = new Label("Login");

		username = new TextField("Username");
		password = new PasswordField("Password");

		designation = new ComboBox<>("Select Position");
		designation.setItems(Designation.values());


		loginButton = new Button("Login");
		loginButton.addClickListener(click -> {
			UI ui = loginButton.getUI().get();
			System.out.printf("", ui.getRouter().getRoutes());
			ui.navigate("employeeDisplay");
		});

		add(loginLabel, username, password, designation, loginButton);
	}
}
