/*type localhost:8080/h2-console on browser for db visualization, check a line similar to the following
HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:4af53fce-8dc5-4d4a-a24d-1f775aefc504 user=SA 
during the run application*/
DELETE FROM Taco_Order_Tacos;
DELETE FROM Taco_Ingredients;
DELETE FROM Taco;
DELETE FROM Taco_Order;

delete from Ingredient;
insert into Ingredient (id, name, type)
                values('FLTO','Flour Tortilla','WRAP');
insert into Ingredient (id, name, type)
                values('COTO','Corn Tortilla','WRAP');
insert into Ingredient (id, name, type)
                values('GRBF','Ground Beef','PROTEIN');
insert into Ingredient (id, name, type)
                values('CARN','Carnitas','PROTEIN');
insert into Ingredient (id, name, type)
                values('TMTO','Diced Tomatoes','VEGGIES');
insert into Ingredient (id, name, type)
                values('LETC','Lettuce','VEGGIES');
insert into Ingredient (id, name, type)
                values('CHED','Cheddar','CHEESE');
insert into Ingredient (id, name, type)
                values('JACK','Monterrey Jack','CHEESE');
insert into Ingredient (id, name, type)
                values('SLSA','Salsa','SAUCE');
insert into Ingredient (id, name, type)
                values('SRCR','Sour Cream','SAUCE');