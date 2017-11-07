package stepic.flatmap;

import deitel.examples.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 The flatMap operation is used to transform each element from a stream into another stream and concatenates all streams into one.
 For instance, to obtain elements of an internal collection in a class.
 */
public class FlatMap {
    List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

    // [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
    List<Integer> generated1 = numbers.stream()
            .flatMap(n -> Stream.generate(() -> n).limit(n))
            .collect(Collectors.toList());

    // [1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5]
    List<Integer> generated2 = numbers.stream()
            .flatMapToInt(n -> IntStream.rangeClosed(1, n))
            .boxed()
            .collect(Collectors.toList());

    // [1, 2, 3, 3, 4, 5, 4, 5, 6, 7, 5, 6, 7, 8, 9]
    List<Integer> generated3 = numbers.stream()
            .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
            .boxed()
            .collect(Collectors.toList());

    // [1, 2, 3, 4, 5]
    List<Integer> generated4 = numbers.stream()
            .flatMap(Stream::of)
            .collect(Collectors.toList());



    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        long numberOfEmployeea = departments.stream()
                .filter(departemnt -> departemnt.getCode().startsWith("111-"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
        return numberOfEmployeea;
    }

    public static void main(String[] args) {

        List<Department> departments = generateDepartments();
        System.out.println(calcNumberOfEmployees(departments, 20000));
        System.out.println("1111".startsWith("111-"));
    }

    public static List<Department> generateDepartments() {

        List<Employee> employeesList1 = new ArrayList<>();
        employeesList1.add(new Employee("William", 20000L));
        employeesList1.add(new Employee("Sophia", 10000L));

        List<Employee> employeesList2 = new ArrayList<>();
        employeesList2.add(new Employee("John", 50000L));

        List<Department> departments = new ArrayList<>();
        departments.add(new Department("dep-1", "111-1", employeesList1));
        departments.add(new Department("dep-2", "222-1", employeesList2));

        return departments;
    }

    public static class Department {
        private String name;
        private String code;
        private List<Employee> employees;

        public Department(String name, String code, List<Employee> employees) {
            this.name = name;
            this.code = code;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }

    public static class Employee {
        private String name;
        private Long salary;

        public Employee(String name, Long salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getSalary() {
            return salary;
        }

        public void setSalary(Long salary) {
            this.salary = salary;
        }
    }
}
