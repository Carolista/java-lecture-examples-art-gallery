export class Artist {

  id: number;
  firstName: string;
  lastName: string;
  location: string;

  constructor(id: number, firstName: string, lastName: string, location: string) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.location = location;
  }

  getFullName(): string {
    return this.firstName + " " + this.lastName;
  }
}
