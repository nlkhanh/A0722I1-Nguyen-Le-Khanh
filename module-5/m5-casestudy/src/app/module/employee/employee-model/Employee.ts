import {ObjectLookUp} from '../../../model/ObjectLookUp';

export interface Employee {
  id?: number;
  name: string;
  position: ObjectLookUp;
  division: ObjectLookUp;
  educationDegree: ObjectLookUp;
  birthday: string;
  idCard: string;
  salary: number;
  phone: string;
  email: string;
  address: string;
  isCheck?: boolean;
}
