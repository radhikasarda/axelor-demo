package com.axelor.employee.module;

import com.axelor.app.AxelorModule;
import com.axelor.employee.service.HelloService;
import com.axelor.employee.service.HelloServiceImpl;

public class EmployeeModule extends AxelorModule{

	@Override
	protected void configure() {
		bind(HelloService.class).to(HelloServiceImpl.class);
		
	}

}
