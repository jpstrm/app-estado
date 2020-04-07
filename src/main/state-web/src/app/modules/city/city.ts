import { State } from '../state/state';

export interface City {
  name: string;
  population?: number;
  state: State;
}
