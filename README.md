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
  - salary(int)
6. Models.Client:
  - wallet(int)
7. Models.User (Base class for 5, 6):
  - last name (string)
  - first name (string)
  - email (string)
9. Agency(singleton):
  - Users (List)
  - Contracts (List)
  - Unoccupied Residences (Map)
10. Models.Contract:
  - Buyer (client)
  - Seller (agent)
  - Item (residence)
  - buyingDate (date years)

