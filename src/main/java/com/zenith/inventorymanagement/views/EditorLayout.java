package com.zenith.inventorymanagement.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.UIScope;
import com.zenith.inventorymanagement.domain.Designation;
import com.zenith.inventorymanagement.domain.Employee;
import com.zenith.inventorymanagement.services.EmployeeManageService;

@UIScope
public class EditorLayout extends FormLayout
{

	private static final long serialVersionUID = 6157994134490605049L;
	private TextField fname;
    private TextField lname;
    private DatePicker dob;
    private TextField email;
    private PasswordField password;
    
    private  Button backButton;
    private Button saveButton;

    private ComboBox<Designation> position;
    
    private Binder<Employee> binder;
    
	private Employee newEmployee;
	
	private EmployeeDisplay display;
	
	public EmployeeManageService employeeManageService;

    public EditorLayout(EmployeeDisplay employeeDisplay, EmployeeManageService employeeManager) {
    
    	display = employeeDisplay;
    	employeeManageService = employeeManager;
    	
        setSizeUndefined();

        fname = new TextField("First Name");
        fname.focus();
        
        lname = new TextField("Last Name");
        
        email = new TextField("Email");
        password = new PasswordField("Password");
        
        dob = new DatePicker("Date of Birth");
        
        position = new ComboBox<>("Position");
        position.setItems(Designation.values());
        position.setValue(Designation.Admin);
        
        binder = new Binder<Employee>(Employee.class);
        newEmployee = new Employee();
        binder.bindInstanceFields(this);
        binder.setBean(newEmployee);
        
        backButton = new Button();
        backButton.addClickListener(click -> {
           getUI().get().navigate("");
        });
        
        saveButton = new Button();
        saveButton.addClickListener((event)-> {
        	try {
				binder.writeBean(newEmployee);
        		employeeManageService.addEmployee(newEmployee);
        		display.refreshTable();
				Notification.show(newEmployee.getFname()+ " entry added successfully!");
			} catch (Exception e) {
				Notification.show("Failed to add "+ newEmployee.getFname());
				e.printStackTrace();
			}
        });
        
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.add(saveButton, backButton);
        buttonLayout.expand(saveButton, backButton);

        add(fname, lname, dob, email, password, position, buttonLayout);
    }
}
