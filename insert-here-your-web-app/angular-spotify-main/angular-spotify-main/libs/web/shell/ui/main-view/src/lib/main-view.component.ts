import { ChangeDetectionStrategy, Component } from '@angular/core';
import { UIStore } from '@angular-spotify/web/shared/data-access/store';

@Component({
  selector: 'as-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MainViewComponent {
	
	  readonly navItems$ = this.uiStore.navItems$;

  constructor(private readonly uiStore: UIStore) {}
	
}


