import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainViewComponent } from './main-view.component';
import { RouterModule } from '@angular/router';
import { NavBarModule } from '@angular-spotify/web/shell/ui/nav-bar';

@NgModule({
  imports: [CommonModule, RouterModule, NavBarModule],
  declarations: [MainViewComponent],
  exports: [MainViewComponent]
})
export class MainViewModule {}
