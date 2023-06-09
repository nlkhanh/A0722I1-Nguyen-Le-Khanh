import {ObjectLookUp} from '../../../model/ObjectLookUp';

export interface Customer {
  id?: number;
  customerType: ObjectLookUp;
  name: string;
  birthday: string;
  idCard: string;
  phone: string;
  email: string;
  address: string;
  isCheck?: boolean;
}
