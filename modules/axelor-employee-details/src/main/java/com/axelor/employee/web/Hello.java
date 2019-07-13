package com.axelor.employee.web;

import com.axelor.app.AppSettings;
import com.axelor.employee.service.HelloService;
import com.axelor.employeeDetails.db.Employee;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Hello {
	@Inject
	private HelloService service;

	
	public void say(ActionRequest request, ActionResponse response) {

		Employee employee = request.getContext().asType(Employee.class);
		String message = service.hello(employee.getFirstName());
		response.setFlash(message);
	}

	public void check_context(ActionRequest request, ActionResponse response) {

		
		Context context = request.getContext();
		//Locale locale = Locale.getDefault();
		
		Locale locale = new Locale.Builder().setLanguage("en").build();  
		String filePath = AppSettings.get().get("file.upload.dir");	
		List<String> list = (List<String>) context.get("_ids");
		if(list!=null) {
		String lists = list.toString();
		context.put("listId", lists.substring(1, lists.length() - 1));
		}
		else {
		Long ids=(Long) context.get("id");
		context.put("listId", ids.toString());		
		}
		
		
		context.put("filePath", filePath);
		System.out.println(locale.getLanguage());
		System.out.println(locale.getCountry());
		/* context.put("locale",locale.getLanguage().toString()); */
		context.put("locale",locale.toString());
		System.err.println(context.entrySet());
		
			
			
	}
}
