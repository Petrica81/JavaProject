# PAO
Project for advanced oriented programing.

Object classes:

1. Models.House:
  - garden area(int)
2. Models.Apartment:
  - floor(int)
3. Models.Penthouse:
  - poolSize(int)
4. Models.Residence (Base class for 1,2,3):
  - name(string)
  - area(int)
  - price(float)
5. Models.Agent:
  - lastName(string)
  - firstName(string)
  - email(string)
  - salary(int)
6. Agency(singleton):
  - Agents (List)
  - Contracts (Set)
  - Clients (List)
  - Unoccupied Residences List
7. Models.Contract:
  - Buyer (client)
  - Seller (agent)
  - Item (residence)
  - buyingDate (date years)
8. Models.Client:
  - last name (string)
  - first name (string)
  - email (string)

