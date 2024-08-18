import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../Service/EmployeeService';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {
  employee: any = { name: '', department: '', position: '', salary: 0 };

  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    if (id) {
      this.employeeService.getEmployee(id).subscribe(
        (data) => {
          this.employee = data;
        },
        (error) => {
          console.error('Error fetching employee:', error);
        }
      );
    }
  }

  onSave() {
    const id = +this.route.snapshot.paramMap.get('id');
    if (id) {
      this.employeeService.updateEmployee(id, this.employee).subscribe(
        () => {
          this.router.navigate(['/employees']);
        },
        (error) => {
          console.error('Error updating employee:', error);
        }
      );
    } else {
      this.employeeService.addEmployee(this.employee).subscribe(
        () => {
          this.router.navigate(['/employees']);
        },
        (error) => {
          console.error('Error adding employee:', error);
        }
      );
    }
  }
}

