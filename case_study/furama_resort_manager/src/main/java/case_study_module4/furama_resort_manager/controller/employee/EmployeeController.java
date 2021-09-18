package case_study_module4.furama_resort_manager.controller.employee;

import case_study_module4.furama_resort_manager.dto.EmployeeDto;
import case_study_module4.furama_resort_manager.model.entity.employee.Degree;
import case_study_module4.furama_resort_manager.model.entity.employee.Division;
import case_study_module4.furama_resort_manager.model.entity.employee.Employee;
import case_study_module4.furama_resort_manager.model.entity.employee.Position;
import case_study_module4.furama_resort_manager.model.service.employee.DegreeService;
import case_study_module4.furama_resort_manager.model.service.employee.DivisionService;
import case_study_module4.furama_resort_manager.model.service.employee.EmployeeService;
import case_study_module4.furama_resort_manager.model.service.employee.PositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DegreeService degreeService;
    @Autowired
    DivisionService divisionService;
    @RequestMapping(value = "/list")
    public ModelAndView viewAll(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView
                ("employee/list","employeeList",employeeService.findAll(pageable));
    }

    @RequestMapping(value = "/create")
    public String showCreateForm(Model model){
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<Degree> degreeList = degreeService.findAll();
        model.addAttribute("positionList",positionList);
        model.addAttribute("divisionList",divisionList);
        model.addAttribute("degreeList",degreeList);
        model.addAttribute("newEmployeeDto",new EmployeeDto());
        return ("employee/create");
    }

    @PostMapping(value = "/create")
    public ModelAndView create (@Validated @ModelAttribute("newEmployeeDto") EmployeeDto newEmployeeDto , BindingResult bindingResult,Model model){
        new EmployeeDto().validate(newEmployeeDto,bindingResult);
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<Degree> degreeList = degreeService.findAll();
        model.addAttribute("positionList",positionList);
        model.addAttribute("divisionList",divisionList);
        model.addAttribute("degreeList",degreeList);
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("employee/create");
        }else {
            Employee newEmployee = new Employee();
            BeanUtils.copyProperties(newEmployeeDto,newEmployee);
            employeeService.save(newEmployee);
            return new ModelAndView("redirect:/employee/list");
        }
    }

    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        employeeService.remove(employee);
        return new ModelAndView("redirect:/employee/list");
    }

    @RequestMapping(value = "/edit/{id}")
    public String showEditForm(@PathVariable int id,Model model){
        Employee editEmployee = employeeService.findById(id);
        EmployeeDto newEmployeeDto = new EmployeeDto();
        BeanUtils.copyProperties(editEmployee,newEmployeeDto);
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<Degree> degreeList = degreeService.findAll();
        model.addAttribute("positionList",positionList);
        model.addAttribute("divisionList",divisionList);
        model.addAttribute("degreeList",degreeList);
        model.addAttribute("newEmployeeDto",newEmployeeDto);
        return ("employee/edit");

    }

    @PostMapping(value = "/edit")
    public ModelAndView edit ( @Validated @ModelAttribute("newEmployeeDto") EmployeeDto newEmployeeDto , BindingResult bindingResult,Model model){
        new EmployeeDto().validate(newEmployeeDto,bindingResult);
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<Degree> degreeList = degreeService.findAll();
        model.addAttribute("positionList",positionList);
        model.addAttribute("divisionList",divisionList);
        model.addAttribute("degreeList",degreeList);
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("employee/edit");
        }else {
            Employee editEmployee = new Employee();
            BeanUtils.copyProperties(newEmployeeDto,editEmployee);
            employeeService.save(editEmployee);
            return new ModelAndView("redirect:/employee/list");
        }
    }

    @PostMapping(value = "/searchByName")
    public ModelAndView showListByDes(@RequestParam("employeeName") String name, @PageableDefault(value = 2)Pageable pageable){
        return new ModelAndView("employee/listBySearchName","employeeList",employeeService.findByNameContains(name, pageable));
    }
}
