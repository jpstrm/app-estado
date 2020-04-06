export * from './cityApi.service';
import { CityApiService } from './cityApi.service';
export * from './stateApi.service';
import { StateApiService } from './stateApi.service';
export const APIS = [CityApiService, StateApiService];
