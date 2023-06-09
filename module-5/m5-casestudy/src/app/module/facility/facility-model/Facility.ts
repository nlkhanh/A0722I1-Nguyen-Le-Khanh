import {ObjectLookUp} from '../../../model/ObjectLookUp';

export interface Facility {
  id?: number;
  facilityType: ObjectLookUp;
  name: string;
  area: number;
  numberOfFloor: number;
  maxPeople: number;
  cost: number;
  rentType: ObjectLookUp;
  status: string;
  isCheck?: boolean;
}
