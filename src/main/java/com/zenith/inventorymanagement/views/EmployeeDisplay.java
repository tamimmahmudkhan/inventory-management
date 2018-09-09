package com.zenith.inventorymanagement.views;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import com.zenith.inventorymanagement.domain.Designation;
import com.zenith.inventorymanagement.domain.Employee;
import com.zenith.inventorymanagement.services.EmployeeManageService;

@UIScope
@Route(value = "/employeeDisplay")
public class EmployeeDisplay extends HorizontalLayout
{

	private static final long serialVersionUID = 3692395971317371136L;

//	public static final String VIEW_NAME = "employeeDisplay";
	
	EditorLayout editorLayout;
	
	Grid<Employee> employeeTable;
	
	@Autowired
	EmployeeManageService employeeManageService;

	@PostConstruct
	public void init() {
//		setMargin(true);

		employeeTable = new Grid<>(Employee.class);
		employeeTable.setColumns("fname", "lname", "dob", "email");
		
		LocalDate date = LocalDate.now();
		loadTestData(date);
		employeeTable.setItems(employeeManageService.retrieveEmployees());
//		employeeTable.setDataProvider(
//				(sortOrder, offset, limit) ->  employeeManageService.safeSubList(offset, limit).stream()
//				, () -> employeeManageService.count());

		
		employeeTable.setSizeUndefined();
		employeeTable.addSelectionListener(event -> {
			Optional<Employee> employee = event.getFirstSelectedItem();
			Notification.show(employee.get().getId().toString());
		});
		
		editorLayout = new EditorLayout(this, employeeManageService);	
		add(editorLayout, employeeTable);
		expand(employeeTable);
	}
	
//	@Async
	public void loadTestData(LocalDate date) {
//		for (int i = 0; i <5000; i++) {
			employeeManageService.addEmployee(
					new Employee("John", "Doe", Designation.Admin, date, "johndoe@mail.co", "loopy", 3, 5));
			employeeManageService.addEmployee(
					new Employee("Jessie", "Jones", Designation.Employee, date, "johndoe@mail.co", "loopy", 3, 5));
			employeeManageService.addEmployee(
					new Employee("Edgar Alan", "Poe", Designation.Admin, date, "poe@poetry.ryhtm", "poopy", 3, 5));
//		}
	}

	public void refreshTable() {
		
//		employeeTable.getDataProvider().refreshAll();
		
		employeeTable.setItems(Collections.emptyList());
		employeeTable.setItems(employeeManageService.retrieveEmployees());
	}
}
