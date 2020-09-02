//  1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT * FROM product AS p
INNER JOIN type AS t ON p.type_id = t.id
WHERE t.name = 'Cheese';

// 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT * FROM product
WHERE name like '%Ice Cream%';

// 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM product
WHERE expired_date BETWEEN '2020-09-02' AND '2020-10-01';

// 4. Написать запрос, который выводит самый дорогой продукт.
SELECT * FROM product
WHERE price = (SELECT MAX(price) FROM product);

// 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT t.name, count(p.type_id) FROM product as p
INNER JOIN type as t ON p.type_id = t.id
GROUP BY t.name;

// 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT * FROM product AS p
INNER JOIN type AS t ON p.type_id = t.id
WHERE t.name = 'Cheese' OR t.name = 'Milk';

// 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT t.name FROM product as p
INNER JOIN type as t ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(p.name) < 10;

// 8. Вывести все продукты и их тип.
SELECT p.name, t.name FROM product AS p
INNER JOIN type AS t ON p.type_id = t.id;