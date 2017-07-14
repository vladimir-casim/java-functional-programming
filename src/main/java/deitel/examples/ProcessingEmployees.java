package deitel.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing")
        };

        List<Employee> list = Arrays.asList(employees);
        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);

        Predicate<Employee> fourToSixThousand =
                e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        System.out.printf("%nEmployees earning $4000-$6000 per month sorted by salary:%n");
        list.stream().filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                list.stream().filter(fourToSixThousand).findFirst().get());

        System.out.printf("%nEmployees by department:%n");
        Map<String, List<Employee>> groupedByDepartment =
                list.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDepartment.forEach((department, employeesInDepartment) ->
            {
                System.out.println(department);
                employeesInDepartment.forEach(
                        employee -> System.out.printf(" %s%n", employee));
            }
        );

        System.out.printf("%nCount of Employees by department:%n");
        Map<String, List<Employee>> employeeCountByDepartment =
                list.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Long> employeeCountByDepartments =
                list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        employeeCountByDepartment.forEach((department, count) -> System.out.printf(
                "%s has %d employee(s)%n", department, count));

        System.out.printf("%nSum of Employees' salaries (via sum method): %.2f%n",
                list.stream().mapToDouble(Employee::getSalary).sum());

        System.out.printf("Sum of Employees' salaries (via reduce method): %.2f%n",
                list.stream().mapToDouble(Employee::getSalary)
                .reduce(0, (value1, value2) -> value1 + value2));

        System.out.printf("Average of Employees' salaries: %.2f%n",
                list.stream().mapToDouble(Employee::getSalary).average().getAsDouble());
    }

}
