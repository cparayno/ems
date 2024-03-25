import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1/";

class EmployeeService {

    getEmployees() {
        return axios.get(EMPLOYEE_API_BASE_URL + '/employees')
    }

    createEmployee(employee) {
        return axios.get(EMPLOYEE_API_BASE_URL + '/employee', employee)
    }

    updateEmployee(employee_id, employee) {
        return axios.get(EMPLOYEE_API_BASE_URL + '/employee/' +employee_id, employee)
    }

    deleteEmployee(employee_id) {
        return axios.get(EMPLOYEE_API_BASE_URL + '/employee/' +employee_id)
    }

    employeeDetails(employee_id) {
        return axios.get(EMPLOYEE_API_BASE_URL + '/employee/' +employee_id)
    }
}

export default new EmployeeService();