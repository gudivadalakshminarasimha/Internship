import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../Service/Userservice';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  user = { username: '', password: '' };

  constructor(private userService: UserService, private router: Router) {}

  onLogin() {
    this.userService.login(this.user).subscribe(
      (response: any) => {
        localStorage.setItem('token', response.token);
        this.router.navigate(['/employees']);
      },
      (error) => {
        console.error('Login error:', error);
      }
    );
  }
}
