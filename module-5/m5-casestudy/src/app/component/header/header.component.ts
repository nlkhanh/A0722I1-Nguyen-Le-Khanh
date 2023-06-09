import {Component, DoCheck, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, DoCheck {

  // tslint:disable-next-line:variable-name
  constructor(private _router: Router) {
  }

  ngOnInit(): void {
  }

  ngDoCheck(): void {
    const navItems = Array.from(document.getElementsByClassName('nav-link'));
    navItems.forEach(e => e.classList.remove('active'));
    if (this._router.url.includes('home') || (this._router.url === '/')) {
      document.getElementById('nav-home').classList.add('active');
    } else if (this._router.url.includes('customers')) {
      document.getElementById('nav-customers').classList.add('active');
    } else if (this._router.url.includes('employees')) {
      document.getElementById('nav-employees').classList.add('active');
    } else if (this._router.url.includes('facilities')) {
      document.getElementById('nav-facilities').classList.add('active');
    }
  }

  reload(navLink: string) {
    const currentUrl = this._router.url;
    if (currentUrl === navLink) {
      this._router.navigateByUrl('', {skipLocationChange: true}).then(() => this._router.navigateByUrl(currentUrl));
    }

  }
}
