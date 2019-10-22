import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isTeamCollapsed = false;
  isPartitaCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  teamscollapse() {
    if (this.isTeamCollapsed === false) {
      this.isTeamCollapsed = true;
    } else { this.isTeamCollapsed = false; }
  }

  partitascollapse() {
    if (this.isPartitaCollapsed === false) {
      this.isPartitaCollapsed = true;
    } else { this.isPartitaCollapsed = false; }
  }
  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
