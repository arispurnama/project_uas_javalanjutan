package com.neo.sihotel.service.implement;

import com.neo.sihotel.repository.EmployeRepository;
import com.neo.sihotel.dto.EmployeDto;
import com.neo.sihotel.model.Employee;
import com.neo.sihotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImple implements EmployeeService {
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public List<Employee> getAllEmploye(){

        return employeRepository.findAll();
    }

    @Override
    public void saveEmploye(Employee employee) {
        this.employeRepository.save(employee);
    }

    @Override
    public Employee getEmployeById(int id) {
        Optional<Employee> optionalEmployee = employeRepository.findById(id);
        Employee employee = null;
        if (optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        }else{
            throw new RuntimeException("Employed is not found");
        }
        return employee;
    }

    @Override
    public Employee updateEmploye(EmployeDto employeDto) {
        Employee employee = employeRepository.getById(employeDto.getEmployeID());
        Employee result = new Employee();
        try{
            employee.setName(employeDto.getName());
            employee.setGender(employeDto.getGender());
            employee.setAddress(employeDto.getAddres());
            employee.setEmail(employeDto.getEmail());
            employee.setJabatan(employeDto.getJabatan());
            result = employeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteEmploye(int id) {
        employeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Employee> getByKeyword(String keyword){
        return employeRepository.findByKeyword(keyword);
    }
}
