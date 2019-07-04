package com.axelor.employeeDetails.db.repo;



import java.util.Map;

import com.axelor.employeeDetails.db.Employee;

public class MyEmployeeDetails extends EmployeeRepository{
	@Override
	  public Map<String, Object> populate(Map<String, Object> json, Map<String, Object> context) {
	    if (!context.containsKey("json-enhance")) {
	      return json;
	    }
	    try {
	      Long id = (Long) json.get("id");
	      Employee employee = find(id);
	      json.put("address", employee.getAddress());
	      json.put("phone", employee.getPhones().get(0));
	      json.put("hasImage", employee.getImage() != null);
	    } catch (Exception e) {
	    }

	    return json;
	  }
}
