import com.axelor.app.AxelorModule;
import com.axelor.employeeDetails.db.repo.EmployeeRepository;

public class EmployeeModule extends AxelorModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(EmployeeRepository.class).to(com.axelor.employeeDetails.db.repo.MyEmployeeDetails.class);
		
	}

}
