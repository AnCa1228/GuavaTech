package com.quark.guavatech.employee.service;

import com.quark.guavatech.employee.dto.EmployeeRequest;
import com.quark.guavatech.employee.dto.EmployeeResponse;
import com.quark.guavatech.employee.mapper.EmployeeMapper;
import com.quark.guavatech.employee.model.Employee;
import com.quark.guavatech.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    //Metodo para crear empleados
    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.firstName() == null) {
            throw new IllegalArgumentException("el nombre no puede ser nulo");
        }
        if (employeeRequest.lastName() == null) {
            throw new IllegalArgumentException("El apellido no puede ser nulo");
        }

        //Se verifica que no exista un empleado con el mismo nombre y apellido
        if(employeeRepository.existsByFirstNameAndLastNameIgnoreCase(employeeRequest.firstName(), employeeRequest.lastName())){
            throw new IllegalArgumentException("Ya existe un empleado con el mismo nombre y apellido");
        }

        Employee employee = employeeMapper.toEntity(employeeRequest);
        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toResponse(savedEmployee);
    }

    //Metodo para obtener un empleado por Id
    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        if(id == null){
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        return employeeRepository.findById(id).
                map(employeeMapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Empleado no encontrado con ID: " + id));
    }

    //Metodo para mostrar todos los empleados
    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toResponse)
                .collect(Collectors.toList());
    }

    //Metodo para actualizar empleados
    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del empleado no puede ser nulo");
        }
        if (employeeRequest == null) {
            throw new IllegalArgumentException("Los datos de actualización no pueden ser nulos");
        }

        EmployeeResponse existingEmployeeResponse = getEmployeeById(id);

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Empleado no encontrado al recuperar entidad"));

        //Si se realizan cambios se verifica que no exista un empleado con el mismo nombre y apellido
        if(employeeRepository.existsByFirstNameAndLastNameIgnoreCase(employeeRequest.firstName(), employeeRequest.lastName())){
            throw new IllegalArgumentException("Ya existe un empleado con el mismo nombre y apellido");
        }

        //Actualizacion de datos
        existingEmployee.setFirstName(employeeRequest.firstName());
        existingEmployee.setLastName(employeeRequest.lastName());

        //Guardar cambios
        Employee updateEmployee = employeeRepository.save(existingEmployee);

        return employeeMapper.toResponse(updateEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new NoSuchElementException("Empleado no encontrado con ID: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
