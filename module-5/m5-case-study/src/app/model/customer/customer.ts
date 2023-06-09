import {CustomerType} from '../customer-type/customerType';

export interface Customer {
  id?: number;
  customerType: CustomerType;
  fullName: string;
  birthday: Date;
  idCard: string;
  phone: string;
  email: string;
  address: string;
}
