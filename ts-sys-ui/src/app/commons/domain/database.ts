import { DatabaseType } from '../enums/database.type';
import { User } from './user';

export interface Database {
    code: string;
    name: string;
    host: string;
    port: number;
    user: User;
    dataBaseType: DatabaseType;
}
