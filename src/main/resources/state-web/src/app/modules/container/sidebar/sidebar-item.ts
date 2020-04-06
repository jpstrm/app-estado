import { BehaviorSubject } from 'rxjs';

export interface SidebarItem {
  title: string;
  url?: string;
  icon: string;
  action$?: BehaviorSubject<any>;
}
