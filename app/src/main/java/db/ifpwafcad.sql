DROP TABLE IF EXISTS counselors;
DROP TABLE IF EXISTS subjects;


CREATE TABLE counselors (
       ID INTEGER PRIMARY KEY AUTOINCREMENT,
       first_name VARCHAR (50),
       nick_name VARCHAR (50),
       last_name VARCHAR (50),
       telephone VARCHAR (25),
       email VARCHAR (50),
       member_since DATE DEFAULT '0000-00-00'
);

CREATE TABLE subjects (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	name VARCHAR (50),
	description TEXT,
	counselor_id INTEGER references Counselor(id)
);

INSERT INTO counselors (first_name, nick_name, last_name, telephone, email, member_since)
       VALUES  	('Jake', 'The Snake', 'Roberts', '412 565-5656', 'snake@ifpwafcad.com', '2003-09-10'),
               	('Andre', 'The Giant', '', '606 443-4567', 'bobo@ifpwafcad.com', '2001-01-12'),
               	('The', '', 'Undertaker', '555 555-4432', 'undertaker@ifpwafcad.com', '2005-03-08'),
               	('Randy', 'Macho Man', 'Savage', '555 317-4444', 'machoman@hotmail.com', '2000-11-10'),
               	('Steve', 'Stone Cold', 'Austen','334 612-5678', 'stonecold@ifpwafcad.com', '1996-01-01'),
               	('Bret', 'The Hitman', 'Hart', '412 565-5656', 'hitman@ifpwafcad.com', date('now')),
               	('Cactus', '', 'Jack', '553 499-8162', 'cactus_jack@ifpwafcad.com', '1999-12-03'),
               	('Dwayne', 'The Rock', 'Johnson', '617 889-5545', 'rock@ifpwafcad.com', '1998-05-07'),
               	('Brutus', '"The Barber"', 'BeefCake', '777 513-3333', 'brutus@ifpwafcad.com', '2002-07-09');

INSERT INTO subjects (name, description, counselor_id)
	VALUES  ('Financial Consultancy', 'Investment advice and financial planning guidance, helping you to maximize your net worth through proper asset allocation. This includes the stocks, bonds, mutual funds, insurance products, and gambling strategies proven to work.', '9'),
		('Existential Psychotherapy', 'Often wonder what the purpose of life is? After learning the basics of Existential Psychotherapy, you''ll understand why you''re happy when you''re feeling happy, and why you''re not feeling happy when you''re not happy, allowing you to transcend to a state of pure bliss.', '7'),
	        ('Temper Management', 'Are your angry outbursts affecting your relationships with loved-ones? Do tantrums at work hinder your ability to perform? Temper management helps you to channel your anger into positive, life-changing productivity.', '4'),
		('Past-Life Regression', 'Past-Life Regression is a journey of the soul, backward and forward through time, like a yo-yo.', '2'),
	       	('Marriage Guidance', 'Even if you share a solid, caring and mutually beneficial relationship with your spouse, you may both still need urgent counseling. There''s only one way to find out. Contact us now!', '1'),
	       	('Crisis Management', 'Whether you''re a fireman, executive CEO, or housewife, applying crisis management techniques at the right moment can be life-saving for you as well as all those around you.', '3'),
	       	('Dream Analysis', 'Dream Analysis will allow you to delve into the depths of your subconcious. Your counselor will put you through a rigorous, disciplined training program, allowing you to remain in a waking state while dreaming. By the end, you''ll be able to analyse your dreams while you are having them!', '8'),
	       	('Hypnosis', 'Contrary to popular belief, hypnosis can be a powerful and effective form of counseling.', '6'),
		('Reiki', 'Need a massage but are afraid to let a stranger touch your body? Reiki could be the perfect solution for you.', '5');