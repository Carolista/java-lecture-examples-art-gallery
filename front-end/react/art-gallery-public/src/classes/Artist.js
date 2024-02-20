export default class Artist {

  constructor(id, firstName, lastName, location) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.location = location;
  }

  getFullName() {
    return `${this.firstName} ${this.lastName}`;
  }
}